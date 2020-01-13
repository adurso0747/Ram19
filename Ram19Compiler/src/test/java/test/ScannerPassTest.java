package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


/**
 *
 * @author richardburns
 */
@RunWith(value = Parameterized.class)
public class ScannerPassTest {

    @Parameter
    public String filePath;

    @Parameters(name = "{index}: testFile - {0}")
    public static Object[] data() {
        return new Object[] {
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/pass1.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/pass2.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/pass3.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/pass4.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/pass5.ram19"
        };
    }


    @Test
    public void runPassTests() {
        try {
            String args[] = {filePath};
            frontend.generated.RamParser.main(args);
        } catch (Exception e) {
            fail(e.toString());
        }
    }


}
