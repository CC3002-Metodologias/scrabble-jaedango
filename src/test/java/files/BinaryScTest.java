package files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static files.BinaryToInt.intToBin;
import static files.BinaryToInt.toInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author jaedango
 * ScBinaryTest : Test para ScBinary
 */

// Hubo un error que desconozco el motivo pero no dejo que el archivo se llamara ScBinaryTest
public class BinaryScTest {
    protected ScBinary bin1;
    protected ScBinary bin2;
    protected ScBinary bin3;
    protected Random r1 = new Random();
    protected Random r2 = new Random();
    protected Random r3 = new Random();
    protected final int p1 = r1.nextInt() % 100;
    protected final int p2 = r2.nextInt() % 100;
    protected final int p3 = r3.nextInt() % 100;
    protected String s1 = intToBin(p1);
    protected String s2 = intToBin(p2);
    protected String s3 = intToBin(p3);


    @BeforeEach
    void setUp(){
        bin1 = new ScBinary(s1);
        bin2 = new ScBinary(s2);
        bin3 = new ScBinary(s3);
    }

    @RepeatedTest(200)
    void constructorTest() {
        var ExpectedScBinary1 = new ScBinary(s1);
        var ExpectedScBinary2 = new ScBinary(s2);
        var ExpectedScBinary3 = new ScBinary(s3);
        assertEquals(ExpectedScBinary1, bin1);
        assertEquals(ExpectedScBinary2, bin2);
        assertEquals(ExpectedScBinary3, bin3);
        assertEquals(ExpectedScBinary1.toString(), bin1.toString());
        assertEquals(ExpectedScBinary2.toString(), bin2.toString());
        assertEquals(ExpectedScBinary3.toString(), bin3.toString());
        assertEquals(ExpectedScBinary1.hashCode(), bin1.hashCode(), "Hashes don't match");
        assertEquals(ExpectedScBinary2.hashCode(), bin2.hashCode(), "Hashes don't match");
        assertEquals(ExpectedScBinary3.hashCode(), bin3.hashCode(), "Hashes don't match");
        if (p1 != p2) {
            assertNotEquals(bin1, bin2);
        }
        if (p2 != p3) {
            assertNotEquals(bin2, bin3);
        }
        if (p3 != p1) {
            assertNotEquals(bin3, bin1);
        }
    }

    @RepeatedTest(200)
    void transformationToScString() {
        var expectedScString1 = new ScString(s1);
        var expectedScString2 = new ScString(s2);
        var expectedScString3 = new ScString(s3);
        ScString ScStr1 = bin1.toScString();
        ScString ScStr2 = bin2.toScString();
        ScString ScStr3 = bin3.toScString();
        assertEquals(expectedScString1, ScStr1);
        assertEquals(expectedScString2, ScStr2);
        assertEquals(expectedScString3, ScStr3);
        assertEquals(expectedScString1.hashCode(), ScStr1.hashCode(), "Hashes don't match");
        assertEquals(expectedScString2.hashCode(), ScStr2.hashCode(), "Hashes don't match");
        assertEquals(expectedScString3.hashCode(), ScStr3.hashCode(), "Hashes don't match");
        if (p1 != p2) {
            assertNotEquals(expectedScString1, ScStr2);
        }
        if (p2 != p3) {
            assertNotEquals(expectedScString2, ScStr3);
        }
        if (p3 != p1){
            assertNotEquals(expectedScString3, ScStr1);
        }
    }

    // Agregar transformaciones a ScFloat y ScInt
    @RepeatedTest(200)
    void transformationScInt() {
        ScInt expectedScInt1 = new ScInt(p1);
        ScInt expectedScInt2 = new ScInt(p2);
        ScInt expectedScInt3 = new ScInt(p3);
        ScInt int1 = bin1.toScInt();
        ScInt int2 = bin2.toScInt();
        ScInt int3 = bin3.toScInt();
        assertEquals(expectedScInt1, int1);
        assertEquals(expectedScInt2, int2);
        assertEquals(expectedScInt3, int3);
        assertEquals(expectedScInt1.hashCode(), int1.hashCode(), "Hashes don't match");
        assertEquals(expectedScInt2.hashCode(), int2.hashCode(), "Hashes don't match");
        assertEquals(expectedScInt3.hashCode(), int3.hashCode(), "Hashes don't match");
        if (p1 != p2) {
            assertNotEquals(expectedScInt1, int2);
        }
        if (p2 != p3) {
            assertNotEquals(expectedScInt2, int3);
        }
        if (p3 != p1) {
            assertNotEquals(expectedScInt3, int1);
        }
    }

    @RepeatedTest(200)
    void transformationScFloat() {
        ScFloat expectedScFloat1 = new ScFloat((float) p1);
        ScFloat expectedScFloat2 = new ScFloat((float) p2);
        ScFloat expectedScFloat3 = new ScFloat((float) p3);
        ScFloat float1 = bin1.toScFloat();
        ScFloat float2 = bin2.toScFloat();
        ScFloat float3 = bin3.toScFloat();
        assertEquals(expectedScFloat1, float1);
        assertEquals(expectedScFloat2, float2);
        assertEquals(expectedScFloat3, float3);
        assertEquals(expectedScFloat1.hashCode(), float1.hashCode(), "Hashes don't match");
        assertEquals(expectedScFloat2.hashCode(), float2.hashCode(), "Hashes don't match");
        assertEquals(expectedScFloat3.hashCode(), float3.hashCode(), "Hashes don't match");
        if (p1 != p2) {
            assertNotEquals(expectedScFloat1, float2);
        }
        if (p2 != p3) {
            assertNotEquals(expectedScFloat2, float3);
        }
        if (p3 != p1) {
            assertNotEquals(expectedScFloat3, float1);
        }
    }
}

