package tests;

import files.ScFloat;
import org.junit.Before;

public class ScFloatTest {
    private ScFloat float1;
    float val = 3.2f;

    @Before
    public void setUp(){
        float1 = new ScFloat(val);
    }

}
