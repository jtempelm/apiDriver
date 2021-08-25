import java.io.IOException;

public class Main {

    public static void main() {
        ApiDriver apiDriver = new ApiDriver();

        try {
            apiDriver.QueryApi();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
