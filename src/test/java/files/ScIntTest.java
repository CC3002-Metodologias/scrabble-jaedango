package files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

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
        var ExpectedScInt1 = new ScInt(n1);
        var ExpectedScInt2 = new ScInt(n2);
        var ExpectedScInt3 = new ScInt(n3);
        assertEquals(ExpectedScInt1, int1);
        assertEquals(ExpectedScInt2, int2);
        assertEquals(ExpectedScInt3, int3);
        assertEquals(ExpectedScInt1.hashCode(), int1.hashCode(), "Hashes don't match.");
        assertEquals(ExpectedScInt2.hashCode(), int2.hashCode(), "Hashes don't match.");
        assertEquals(ExpectedScInt3.hashCode(), int3.hashCode(), "Hashes don't match.");

        assertNotEquals(ExpectedScInt1, int2);
        assertNotEquals(ExpectedScInt2, int3);
        assertNotEquals(ExpectedScInt3, int1);
    }

}
