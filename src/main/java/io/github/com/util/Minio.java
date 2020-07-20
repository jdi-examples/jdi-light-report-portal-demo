package io.github.com.util;

import com.epam.jdi.light.logger.LogLevels;
import io.minio.MinioClient;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class Minio {
    private static Minio INSTANCE = null;
    public MinioClient minioClient;

    private Minio() {
        minioClient = new MinioClient.Builder()
                .endpoint(System.getProperty("minio.url"))
                .credentials(System.getProperty("minio.accesskey"), System.getProperty("minio.secretkey"))
                .build();

        logger.toLog(String.format("The %s %s %s are available", System.getProperty("minio.url"),
                System.getProperty("minio.accesskey"),
                System.getProperty("minio.secretkey")), LogLevels.INFO);
    }

    public static Minio getInstance() {
        if (INSTANCE == null) {
            return INSTANCE = new Minio();
        }
        return INSTANCE;
    }
}
