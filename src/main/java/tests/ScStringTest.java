package tests;

import files.ScString;
import org.junit.Before;

public class ScStringTest {
    protected ScString str1;

    @Before
    public void setUp(){
        str1 = new ScString("hola");
    }
}
