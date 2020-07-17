package io.github.com.util;

import com.epam.jdi.light.logger.LogLevels;
import io.github.com.entities.GenRocketPayload;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.io.InputStream;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class GenRocketUtils {
    private static final String DATA_FOLDER = "gen-data";
    private static final String GEN_ROCKET_API = "https://dev.reportportal.io/genrocket/grRest";

    private GenRocketUtils(){}

    public static void invokeDataScenario(GenRocketPayload payloadScenario){
        try {
            InputStream payload = ClassLoader.getSystemResourceAsStream(DATA_FOLDER + payloadScenario.getName());
            Response execute = Request.Post(GEN_ROCKET_API)
                    .bodyStream(payload, ContentType.APPLICATION_JSON)
                    .execute();
            assert execute.returnResponse().getStatusLine().getStatusCode() == 200 : payloadScenario.getError();
        } catch (IOException e) {
            logger.toLog(e.getMessage(), LogLevels.ERROR);
        }
    }
}
