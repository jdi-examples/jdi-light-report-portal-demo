package io.github.com.util;

import com.epam.jdi.light.logger.LogLevels;
import io.github.com.entities.GenRocketPayload;
import io.github.com.entities.User;
import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class UserUtils {
    public static User DEFAULT_USER = new User();
    private static final String GENROCKET_BUCKET = "genrocket";

    public static List<User> getUsers(GenRocketPayload payload) {
        try {
            boolean isExist = Minio.getInstance()
                    .minioClient
                    .bucketExists(BucketExistsArgs.builder().bucket(GENROCKET_BUCKET).build());

            logger.toLog(String.format("The %s has the following state %s", GENROCKET_BUCKET, isExist), LogLevels.INFO);

            if (isExist) {
                InputStream object = Minio.getInstance()
                        .minioClient.getObject(GetObjectArgs.builder()
                        .bucket(GENROCKET_BUCKET)
                        .object(payload.getOutFile())
                        .build()
                );
                return JsonUtils.getObject(object, User.class);
            }
        } catch (Throwable e) {
            logger.toLog(e.getMessage(), LogLevels.ERROR);
        }
        return Collections.emptyList();
    }
}
