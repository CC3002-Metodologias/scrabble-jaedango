package files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

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
    protected String  d = "1001.0001";
    protected Random r = new Random();
    protected Random r2 = new Random();
    protected final int n1 = r.nextInt() % 100;
    protected final int n2 = r2.nextInt() % 100;
    protected String s1 = Integer.toBinaryString(n1);
    protected String s2 = Integer.toBinaryString(n2);

    @BeforeEach
    void setUp(){
        bin1 = new ScBinary(s1);
        bin2 = new ScBinary(s2);
        bin3 = new ScBinary(d);
    }

    @RepeatedTest(20)
    void constructorTest() {
        var ExpectedScBinary1 = new ScBinary(s1);
        var ExpectedScBinary2 = new ScBinary(s2);
        var ExpectedScBinary3 = new ScBinary(d);
        assertEquals(ExpectedScBinary1, bin1);
        assertEquals(ExpectedScBinary2, bin2);
        assertEquals(ExpectedScBinary3, bin3);
        assertEquals(ExpectedScBinary1.hashCode(), bin1.hashCode(), "Hashes don't match");
        assertEquals(ExpectedScBinary2.hashCode(), bin2.hashCode(), "Hashes don't match");
        assertEquals(ExpectedScBinary3.hashCode(), bin3.hashCode(), "Hashes don't match");

        assertNotEquals(bin1, bin2);
        assertNotEquals(bin1, bin3);
        assertNotEquals(bin3, bin2);
    }

}

