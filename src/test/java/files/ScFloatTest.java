package files;

import files.ScFloat;
import org.junit.Before;

/**
 * @author jaedango
 * ScFloatTest : Test de ScFloat
 */

public class ScFloatTest {
    private ScFloat float1;
    float val = 3.2f;

    @Before
    public void setUp(){
        float1 = new ScFloat(val);
    }

}
