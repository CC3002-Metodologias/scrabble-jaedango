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

    @RepeatedTest(20)
    void constructTest() {
        var ExpectedScFloat1 = new ScFloat(f1);
        var ExpectedScFloat2 = new ScFloat(f2);
        var ExpectedScFloat3 = new ScFloat(f3);
        assertEquals(ExpectedScFloat1, float1);
        assertEquals(ExpectedScFloat2, float2);
        assertEquals(ExpectedScFloat3, float3);
        assertEquals(ExpectedScFloat1.hashCode(), float1.hashCode(), "Hashes don't match");
        assertEquals(ExpectedScFloat2.hashCode(), float2.hashCode(), "Hashes don't match");
        assertEquals(ExpectedScFloat3.hashCode(), float3.hashCode(), "Hashes don't match");

        assertNotEquals(ExpectedScFloat1, float2);
        assertNotEquals(ExpectedScFloat2, float3);
        assertNotEquals(ExpectedScFloat3, float1);
    }

}
