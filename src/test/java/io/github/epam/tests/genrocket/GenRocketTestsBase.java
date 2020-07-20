package io.github.epam.tests.genrocket;

import io.github.com.entities.User;
import io.github.com.util.GenRocketUtils;
import io.github.com.util.UserUtils;
import io.github.epam.TestsInit;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import static io.github.com.entities.GenRocketPayload.USER_PAYLOAD;

@SuppressWarnings("all")
public abstract class GenRocketTestsBase implements TestsInit {

    @DataProvider
    public Object[][] getUser() throws IOException {
        GenRocketUtils.invokeDataScenario(USER_PAYLOAD);
        User user = UserUtils.getUsers(USER_PAYLOAD).stream().findFirst().get();
        return new Object[][]{{user}};
    }

}
