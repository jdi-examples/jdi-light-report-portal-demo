package io.github.com.util;

import io.github.com.entities.User;
import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class UserUtils {
    public static User DEFAULT_USER = new User();
    private static final String USER_FILE = "users.json";
    private static final String GENROCKET_BUCKET = "genrocket";
    private static  MinioClient minioClient;

    private UserUtils (){
        minioClient = new MinioClient.Builder()
                .endpoint(System.getProperty("minio.url"))
                .credentials(System.getProperty("minio.accesskey"), System.getProperty("minio.secretkey"))
                .build();
    }

    public static List<User> getUsers() {
        try {
            boolean isExist =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket(GENROCKET_BUCKET).build());
            if (isExist) {
                InputStream object = minioClient.getObject(GetObjectArgs.builder().bucket(GENROCKET_BUCKET).object(USER_FILE).build());
                return JsonUtils.getObject(object, User.class);
            }
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage());
        }
        return Collections.emptyList();
    }
}
