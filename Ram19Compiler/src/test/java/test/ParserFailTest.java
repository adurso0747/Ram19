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
public class ParserFailTest {

    @Parameter
    public String filePath;

    @Parameters(name = "{index}: testFile - {0}")
    public static Object[] data() {
        return new Object[] {
            System.getProperty("TEST_PROGRAMS_DIR")+"/fail/fail1.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/fail/goodcomment.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/fail/Invalid-VarDeclInMain.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/fail/ParseFail1.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/fail/PrintSevenBreaks.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/fail/PrintStegosaurusBreaks.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/fail/return.ram19",
            System.getProperty("TEST_PROGRAMS_DIR")+"/fail/static.ram19"
        };
    }


    @Test
    public void runFailTests() {
        try {
            String args[] = {filePath};
            frontend.generated.RamParser.main(args);
            fail("expected parser to throw an exception and it didn't");
        } catch (frontend.generated.ParseException e) {
            ;  // do nothing
            // System.out.println(e);
        } catch (frontend.generated.TokenMgrError e) {
            ;  // do nothing
            // System.out.println(e);
        } catch (Exception e) {   // fail on an exception that we didn't except
            fail(e.toString());
        }
    }


}
