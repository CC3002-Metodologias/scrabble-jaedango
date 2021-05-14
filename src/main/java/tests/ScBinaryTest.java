package tests;

import files.ScBinary;
import org.junit.Before;

public class ScBinaryTest {
    private ScBinary bin1;

    @Before
    public void setUp(){
        bin1 = new ScBinary("1001");
    }

}
