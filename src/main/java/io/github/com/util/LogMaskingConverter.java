package io.github.com.util;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.jdi.light.settings.WebSettings.logger;

@Plugin(name = "LogMaskingConverter", category = "Converter")
@ConverterKeys({"pass"})
public class LogMaskingConverter extends LogEventPatternConverter {
    private static final String PASSWORD_REGEX = "password *: *(?=.+[A-Za-z])(?=.+\\d)[A-Za-z\\d\\S]{8,}";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
    private static final String PASSWORD_REPLACEMENT_REGEX = "password:****";
    private static final String PASS_REGEX = "pass *: *(?=.+[A-Za-z])(?=.+\\d)[A-Za-z\\d\\S]{8,}";
    private static final Pattern PASS_PATTERN = Pattern.compile(PASS_REGEX);
    private static final String PASS_REPLACEMENT_REGEX = "pass:****";

    protected LogMaskingConverter(final String name, final String style) {
        super(name, style);
    }

    public static LogMaskingConverter newInstance() {
        return new LogMaskingConverter("pass", Thread.currentThread().getName());
    }

    @Override
    public void format(final LogEvent event, final StringBuilder outputMessage) {
        String message = event.getMessage().getFormattedMessage();
        String maskedMessage;
        try {
            maskedMessage = mask(message);
        } catch (Exception e) {
            logger.toLog("Failed while masking");
            maskedMessage = message;
        }
        outputMessage.append(maskedMessage);
    }

    private String mask(final String message) {
        Matcher matcher;
        StringBuffer buffer = new StringBuffer();
        String transformedMessage = message;

        matcher = PASSWORD_PATTERN.matcher(transformedMessage);
        maskMatcher(matcher, buffer, PASSWORD_REPLACEMENT_REGEX);
        transformedMessage = buffer.toString();
        buffer.setLength(0);

        matcher = PASS_PATTERN.matcher(transformedMessage);
        maskMatcher(matcher, buffer, PASS_REPLACEMENT_REGEX);

        return buffer.toString();
    }

    private StringBuffer maskMatcher(final Matcher matcher, final StringBuffer buffer, final String maskStr) {
        while (matcher.find()) {
            matcher.appendReplacement(buffer, maskStr);
        }
        matcher.appendTail(buffer);
        return buffer;
    }
}
