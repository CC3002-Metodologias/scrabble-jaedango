package files;

import files.ScString;
import org.junit.Before;

/**
 * @author jaedango
 * ScStringTest : Test para ScString
 */

public class ScStringTest {
    protected ScString str1;

    @Before
    public void setUp(){
        str1 = new ScString("hola");
    }
}
