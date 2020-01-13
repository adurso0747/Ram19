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
public class ParserPassTest {

    @Parameter
    public String filePath;

    @Parameters(name = "{index}: testFile - {0}")
    public static Object[] data() {
        return new Object[] {
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/pass1.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/Array.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/Bool.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/InfiniteLoop.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/Logical.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/ParsePass2.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/Program2.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/Sigma.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/pass/smart-tv.ram19"
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
