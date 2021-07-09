package files.operationsTets;

import files.operations.constant.Constant;
import files.operations.constant.ConstantFactory;
import files.operations.constant.ConstantLogical;
import files.operations.constant.ConstantNum;
import files.operations.ops.LogicOps.Or;
import files.types.BooleanFactory;
import files.types.ScBoolean;
import files.types.numbers.NumberFactory;
import files.types.numbers.ScBinary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrTest {
    // Factories
    NumberFactory n = new NumberFactory();
    BooleanFactory b = new BooleanFactory();
    ConstantFactory c = new ConstantFactory();
    // Binary
    String binary1, binary2, binary3, binary4;
    ScBinary scBinary1, scBinary2, scBinary3, scBinary4;
    ConstantNum cBin1;
    ConstantLogical cBin11, cBin2, cBin3, cBin4;
    // Booleans
    boolean bool1, bool2;
    ScBoolean scBoolean1, scBoolean2;
    ConstantLogical cBool1, cBool2;

    @BeforeEach
    void setUp() {
        // Binaries
        binary1 = "10010";
        binary2 = "01010";
        binary3 = "00111";
        binary4 = "11111";
        scBinary1 = n.getScBinary(binary1);
        scBinary2 = n.getScBinary(binary2);
        scBinary3 = n.getScBinary(binary3);
        scBinary4 = n.getScBinary(binary4);
        cBin1 = c.cNum(scBinary1);
        cBin11 = c.cLog(scBinary1);
        cBin2 = c.cLog(scBinary2);
        cBin3 = c.cLog(scBinary3);
        cBin4 = c.cLog(scBinary4);
        // Boolean
        bool1 = true;
        bool2 = false;
        scBoolean1 = b.getScBoolean(bool1);
        scBoolean2 = b.getScBoolean(bool2);
        cBool1 = c.cLog(scBoolean1);
        cBool2 = c.cLog(scBoolean2);
    }

    @Test
    void orBoolTest() {
        var expected1 = c.cLog(scBoolean1);
        var expected2 = c.cLog(scBoolean2);
        Constant actual1 = new Or(cBool1, cBool2).eval();
        Constant actual2 = new Or(cBool2, new Or(cBool2, cBool1)).eval();
        Constant actual3 = new Or(new Or(cBool2, cBool2), cBool2).eval();
        Constant actual4 = new Or(new Or(cBool1, cBool2), new Or(cBool1, cBool2)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected1, actual2);
        assertEquals(expected2, actual3);
        assertEquals(expected1, actual4);
    }

    @Test
    void orBoolBinTest() {
        var expected1 = cBin11;
        var expected2 = cBin2;
        var expected3 = cBin3;
        var expected4 = cBin4;
        Constant actual1 = new Or(cBool2, cBin1).eval();
        Constant actual2 = new Or(new Or(cBin2, cBool2), cBool2).eval();
        Constant actual3 = new Or(cBool2, new Or(cBool2, cBin3)).eval();
        Constant actual4 = new Or(new Or(cBool1, cBin4), new Or(cBool1, cBool2)).eval();
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }
}
