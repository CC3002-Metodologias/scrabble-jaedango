package files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static files.BinaryToInt.intToBin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author jaedango
 * ScIntTest : Test para ScInt
 */

public class ScIntTest {
    protected ScInt int1;
    protected ScInt int2;
    protected ScInt int3;
    Random r1 = new Random();
    Random r2 = new Random();
    Random r3 = new Random();
    protected final int n1 = r1.nextInt() % 1000;
    protected final int n2 = r2.nextInt() % 1000;
    protected final int n3 = r3.nextInt() % 1000;

    @BeforeEach
    public void setUp() {
        int1 = new ScInt(n1);
        int2 = new ScInt(n2);
        int3 = new ScInt(n3);
    }

    @RepeatedTest(20)
    void constructorTest() {
        var expectedScInt1 = new ScInt(n1);
        var expectedScInt2 = new ScInt(n2);
        var expectedScInt3 = new ScInt(n3);
        assertEquals(expectedScInt1, int1);
        assertEquals(expectedScInt2, int2);
        assertEquals(expectedScInt3, int3);
        assertEquals(expectedScInt1.hashCode(), int1.hashCode(), "Hashes don't match.");
        assertEquals(expectedScInt2.hashCode(), int2.hashCode(), "Hashes don't match.");
        assertEquals(expectedScInt3.hashCode(), int3.hashCode(), "Hashes don't match.");

        assertNotEquals(expectedScInt1, int2);
        assertNotEquals(expectedScInt2, int3);
        assertNotEquals(expectedScInt3, int1);
    }

    @RepeatedTest(20)
    void transformScString() {
        ScString expectedScString1 = new ScString(String.valueOf(n1));
        ScString expectedScString2 = new ScString(String.valueOf(n2));
        ScString expectedScString3 = new ScString(String.valueOf(n3));
        ScString scStr1 = int1.toScString();
        ScString scStr2 = int2.toScString();
        ScString scStr3 = int3.toScString();
        assertEquals(expectedScString1, scStr1);
        assertEquals(expectedScString2, scStr2);
        assertEquals(expectedScString3, scStr3);
        assertEquals(expectedScString1.hashCode(), scStr1.hashCode(), "hashes don't match");
        assertEquals(expectedScString2.hashCode(), scStr2.hashCode(), "hashes don't match");
        assertEquals(expectedScString3.hashCode(), scStr3.hashCode(), "hashes don't match");
        assertNotEquals(expectedScString1, scStr2);
        assertNotEquals(expectedScString2, scStr3);
        assertNotEquals(expectedScString3, scStr1);
    }

    @RepeatedTest(20)
    void transformScFloat() {
        ScFloat expectedScFloat1 = new ScFloat((float) n1);
        ScFloat expectedScFloat2 = new ScFloat((float) n2);
        ScFloat expectedScFloat3 = new ScFloat((float) n3);
        ScFloat scFl1 = int1.toScFloat();
        ScFloat scFl2 = int2.toScFloat();
        ScFloat scFl3 = int3.toScFloat();
        assertEquals(expectedScFloat1, scFl1);
        assertEquals(expectedScFloat2, scFl2);
        assertEquals(expectedScFloat3, scFl3);
        assertEquals(expectedScFloat1.hashCode(), scFl1.hashCode(), "Hashes don't match.");
        assertEquals(expectedScFloat2.hashCode(), scFl2.hashCode(), "Hashes don't match.");
        assertEquals(expectedScFloat3.hashCode(), scFl3.hashCode(), "Hashes don't match.");
        assertNotEquals(expectedScFloat1, scFl2);
        assertNotEquals(expectedScFloat2, scFl3);
        assertNotEquals(expectedScFloat3, scFl1);
    }

    @RepeatedTest(20)
    void transformScBinary() {
        ScBinary expectedScBinary1 = new ScBinary(intToBin(n1));
        ScBinary expectedScBinary2 = new ScBinary(intToBin(n2));
        ScBinary expectedScBinary3 = new ScBinary(intToBin(n3));
        ScBinary bin1 = int1.toScBinary();
        ScBinary bin2 = int2.toScBinary();
        ScBinary bin3 = int3.toScBinary();
        assertEquals(expectedScBinary1, bin1);
        assertEquals(expectedScBinary2, bin2);
        assertEquals(expectedScBinary3, bin3);
        assertEquals(expectedScBinary1.hashCode(), bin1.hashCode(), "Hashes don't match");
        assertEquals(expectedScBinary2.hashCode(), bin2.hashCode(), "Hashes don't match");
        assertEquals(expectedScBinary3.hashCode(), bin3.hashCode(), "Hashes don't match");
        assertNotEquals(expectedScBinary1, bin2);
        assertNotEquals(expectedScBinary2, bin3);
        assertNotEquals(expectedScBinary3, bin1);
    }

}
