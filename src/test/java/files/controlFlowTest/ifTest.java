package files.controlFlowTest;

import files.controlFlow.CompareTo;
import files.controlFlow.If;
import files.operations.constant.ConstantFactory;
import files.operations.constant.ConstantLogical;
import files.operations.constant.ConstantNum;
import files.operations.ops.NumOps.Add;
import files.operations.ops.NumOps.Sub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ifTest {
    ConstantFactory c = new ConstantFactory();
    int int1, int2, int3, int4;
    boolean bool1, bool2;
    ConstantNum cn1, cn2, cn3, cn4;
    ConstantLogical cTrue, cFalse;

    @BeforeEach
    void setUp() {
        int1 = 10;
        int2 = 5;
        int3 = int1 + int2;
        int4 = int1 - int2;
        cn1 = c.cNum(int1);
        cn2 = c.cNum(int2);
        cn3 = c.cNum(int3);
        cn4 = c.cNum(int4);
        bool1 = true;
        bool2 = false;
        cTrue = c.cLog(bool1);
        cFalse = c.cLog(bool2);
    }


    @Test
    void ifTest1() {
        assertEquals(cn3, new If(cTrue, new Add(cn1, cn2), new Sub(cn1, cn2)).eval());
        assertEquals(cn4, new If(cFalse, new Add(cn1, cn2), new Sub(cn1, cn2)).eval());
    }

    @Test
    void compareToTest() {
        assertEquals(cn3, new If((new CompareTo(cn1, cn2)).eval() == 1, new Add(cn1, cn2), new Sub(cn1, cn2)).eval());
        assertEquals(cn4, new If((new CompareTo(cn1, cn2)).eval() == 0, new Add(cn1, cn2), new Sub(cn1, cn2)).eval());
        assertEquals(cn4, new If((new CompareTo(cn1, cn2)).eval() == -1, new Add(cn1, cn2), new Sub(cn1, cn2)).eval());
    }
}
