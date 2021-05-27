package files;

import files.ScBoolean;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

/**
 * @author jaedango
 * ScBooleanTest : Test de ScBoolean
 */

public class ScBooleanTest {
    protected ScBoolean bool1;
    protected ScBoolean bool2;
    protected final boolean t = true;
    protected final boolean f = false;

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

    @Test
    void transformationScString() {
        var expectedScStr1 = new ScString("true");
        var expectedScStr2 = new ScString("false");
        ScString ScStr1 = bool1.toScString();
        ScString ScStr2 = bool2.toScString();
        assertEquals(expectedScStr1, ScStr1);
        assertEquals(expectedScStr2, ScStr2);
        assertEquals(expectedScStr1.hashCode(), ScStr1.hashCode(), "Hashes don't match");
        assertEquals(expectedScStr2.hashCode(), ScStr2.hashCode(), "Hashes don't match");
        assertNotEquals(expectedScStr1, ScStr2);
        assertNotEquals(expectedScStr2, ScStr1);
    }


}
