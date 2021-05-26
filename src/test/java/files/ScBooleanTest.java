package files;

import files.ScBoolean;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author jaedango
 * ScBooleanTest : Test de ScBoolean
 */

public class ScBooleanTest {
    protected ScBoolean bool1;
    protected ScBoolean bool2;
    protected boolean t = true;
    protected boolean f = false;

    @BeforeEach
    void setUp(){
        bool1 = new ScBoolean(t);
        bool2 = new ScBoolean(f);
    }

    @Test
    void constructorTest() {
        var expectedScBool1 = new ScBoolean(t);
        var expectedScBool2 = new ScBoolean(f);
        assertEquals(expectedScBool1, bool1);
        assertEquals(expectedScBool1.hashCode(), bool1.hashCode(), "Hashes don't match");
        assertEquals(expectedScBool2, bool2);
        assertEquals(expectedScBool2.hashCode(), bool2.hashCode(), "Hashes don't match");

        assertNotEquals(expectedScBool2, bool1);
        assertNotEquals(expectedScBool1, bool2);
    }


}
