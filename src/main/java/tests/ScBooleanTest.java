package tests;

import files.ScBoolean;
import org.junit.Before;

public class ScBooleanTest {
    protected ScBoolean bool1;

    @Before
    public void setUp(){
        bool1 = new ScBoolean(true);
    }
}
