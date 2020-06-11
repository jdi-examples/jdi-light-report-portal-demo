package io.github.com.util;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.jdi.light.settings.WebSettings.logger;

@Plugin(name = "LogMaskingConverter", category = "Converter")
@ConverterKeys({"cred"})
public class LogMaskingConverter extends LogEventPatternConverter {
    private static final String CREDENTIALS_REGEX = ": *(?=.+[A-Za-z])(?=.+\\d)[A-Za-z\\d\\S]{3,14}";
    private static final Pattern CREDENTIALS_PATTERN = Pattern.compile(CREDENTIALS_REGEX);
    private static final String CREDENTIALS_REPLACEMENT_REGEX = ":****";

    protected LogMaskingConverter(final String name, final String style) {
        super(name, style);
    }

    public static LogMaskingConverter newInstance() {
        return new LogMaskingConverter("cred", Thread.currentThread().getName());
    }

    @Override
    public void format(final LogEvent event, final StringBuilder outputMessage) {
        String message = event.getMessage().getFormattedMessage();
        String maskedMessage;
        try {
            maskedMessage = mask(message);
        } catch (Exception e) {
            logger.toLog("Failed While Masking");
            maskedMessage = message;
        }
        outputMessage.append(maskedMessage);
    }

    private String mask(final String message) {
        Matcher matcher;
        StringBuffer buffer = new StringBuffer();

        matcher = CREDENTIALS_PATTERN.matcher(message);
        maskMatcher(matcher, buffer, CREDENTIALS_REPLACEMENT_REGEX);

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
