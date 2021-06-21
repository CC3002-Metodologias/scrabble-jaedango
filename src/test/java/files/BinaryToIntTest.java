package files;


import org.junit.jupiter.api.Test;

import static files.types.numbers.BinaryToInt.binToInt;
import static files.types.numbers.BinaryToInt.intToBin;

/**
 * @author jaedango
 * BinaryToInt class testing
 */

public class BinaryToIntTest {
    protected final int num1 = 1;
    protected final int num2 = 75;
    protected final int num3 = 1024;
    protected final int num4 = 9999;
    protected final String pNum1 = "01";
    protected final String pNum2 = "01001011";
    protected final String pNum3 = "010000000000";
    protected final String pNum4 = "010011100001111";
    protected final String nNum1 = "11111111111111111111111111111111";
    protected final String nNum2 = "11111111111111111111111110110101";
    protected final String nNum3 = "11111111111111111111110000000000";
    protected final String nNum4 = "11111111111111111101100011110001";

    @Test
    void binToIntTest() {
        int binToInt1 = binToInt(pNum1);
        int binToInt2 = binToInt(pNum2);
        int binToInt3 = binToInt(pNum3);
        int binToInt4 = binToInt(pNum4);
        int binToInt5 = binToInt(nNum1);
        int binToInt6 = binToInt(nNum2);
        int binToInt7 = binToInt(nNum3);
        int binToInt8 = binToInt(nNum4);
        assert(num1 == binToInt1);
        assert(num2 == binToInt2);
        assert(num3 == binToInt3);
        assert(num4 == binToInt4);
        assert(-num1 == binToInt5);
        assert(-num2 == binToInt6);
        assert(-num3 == binToInt7);
        assert(-num4 == binToInt8);
    }

    @Test
    void intToBinTest() {
        String intToBin1 = intToBin(num1);
        String intToBin2 = intToBin(num2);
        String intToBin3 = intToBin(num3);
        String intToBin4 = intToBin(num4);
        String intToBin5 = intToBin(-num1);
        String intToBin6 = intToBin(-num2);
        String intToBin7 = intToBin(-num3);
        String intToBin8 = intToBin(-num4);
        assert(intToBin1.equals(pNum1));
        assert(intToBin2.equals(pNum2));
        assert(intToBin3.equals(pNum3));
        assert(intToBin4.equals(pNum4));
        assert(intToBin5.equals(nNum1));
        assert(intToBin6.equals(nNum2));
        assert(intToBin7.equals(nNum3));
        assert(intToBin8.equals(nNum4));
    }
}
