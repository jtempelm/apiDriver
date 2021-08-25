import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ApiDriverTest {

    ApiDriver apiDriver = new ApiDriver();

    @Test
    public void queryApiTest() throws IOException {
        String responseCode = apiDriver.QueryApi();

        Assertions.assertEquals(responseCode, "200");
    }
}
