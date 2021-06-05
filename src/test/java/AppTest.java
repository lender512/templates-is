import org.testng.Assert;
import org.testng.annotations.Test;
import paquete.App;

import java.io.InputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Logger;
import java.io.ByteArrayInputStream;

public class AppTest {
    @Test
    public void test1() {
        App.main(new String[] {});
    }
}
