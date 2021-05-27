package files;

import files.ScFloat;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author jaedango
 * ScFloatTest : Test de ScFloat
 */

public class ScFloatTest {
    protected ScFloat float1;
    protected ScFloat float2;
    protected ScFloat float3;
    Random r1 = new Random();
    Random r2 = new Random();
    Random r3 = new Random();
    protected final float f1 = r1.nextFloat() * 100;
    protected final float f2 = r2.nextFloat() * 100;
    protected final float f3 = r3.nextFloat() * 100;

    @BeforeEach
    void setUp(){
        float1 = new ScFloat(f1);
        float2 = new ScFloat(f2);
        float3 = new ScFloat(f3);
    }

    @RepeatedTest(200)
    void constructTest() {
        var expectedScFloat1 = new ScFloat(f1);
        var expectedScFloat2 = new ScFloat(f2);
        var expectedScFloat3 = new ScFloat(f3);
        assertEquals(expectedScFloat1, float1);
        assertEquals(expectedScFloat2, float2);
        assertEquals(expectedScFloat3, float3);
        assertEquals(expectedScFloat1.hashCode(), float1.hashCode(), "Hashes don't match");
        assertEquals(expectedScFloat2.hashCode(), float2.hashCode(), "Hashes don't match");
        assertEquals(expectedScFloat3.hashCode(), float3.hashCode(), "Hashes don't match");
        if (f1 != f2) {
            assertNotEquals(expectedScFloat1, float2);
        }
        if (f2 != f3) {
            assertNotEquals(expectedScFloat2, float3);
        }
        if (f3 != f1) {
            assertNotEquals(expectedScFloat3, float1);
        }
    }

    @RepeatedTest(200)
    void transformationScString() {
        var expectedScString1 = new ScString(String.valueOf(f1));
        var expectedScString2 = new ScString(String.valueOf(f2));
        var expectedScString3 = new ScString(String.valueOf(f3));
        ScString scStr1 = float1.toScString();
        ScString scStr2 = float2.toScString();
        ScString scStr3 = float3.toScString();
        assertEquals(expectedScString1, scStr1);
        assertEquals(expectedScString2, scStr2);
        assertEquals(expectedScString3, scStr3);
        assertEquals(expectedScString1.hashCode(), scStr1.hashCode(), "Hashes don't match");
        assertEquals(expectedScString2.hashCode(), scStr2.hashCode(), "Hashes don't match");
        assertEquals(expectedScString3.hashCode(), scStr3.hashCode(), "Hashes don't match");
        if (f1 != f2) {
            assertNotEquals(expectedScString1, scStr2);
        }
        if (f2 != f3) {
            assertNotEquals(expectedScString2, scStr3);
        }
        if (f3 != f1) {
            assertNotEquals(expectedScString3, scStr1);
        }
    }
}
