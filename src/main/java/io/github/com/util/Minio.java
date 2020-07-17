package io.github.com.util;

import io.minio.MinioClient;

public class Minio {
    private static Minio INSTANCE = null;
    public MinioClient minioClient;

    private Minio() {
        minioClient = new MinioClient.Builder()
                .endpoint(System.getProperty("minio.url"))
                .credentials(System.getProperty("minio.accesskey"), System.getProperty("minio.secretkey"))
                .build();
    }

    public static Minio getInstance() {
        if (INSTANCE == null) {
            return new Minio();
        }
        return INSTANCE;
    }
}
