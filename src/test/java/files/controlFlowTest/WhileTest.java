package files.controlFlowTest;

import files.controlFlow.CompareTo;
import files.controlFlow.While;
import files.operations.constant.Constant;
import files.operations.constant.ConstantFactory;
import files.operations.constant.ConstantNum;
import files.operations.ops.NumOps.Add;
import files.operations.ops.Operations;
import org.junit.jupiter.api.Test;

public class WhileTest {
    ConstantFactory c = new ConstantFactory();

    /*@Test
    void whileTest1() {
        ConstantNum var = c.variable("a", 0);
        System.out.println(new While(new CompareTo(var, c.cNum(5)).eval() != 1, var = c.variable(var, new Add(var, c.cNum(1)))).eval());

    }*/

    @Test
    void whileTest1() {
        ConstantNum var = c.variable("a", 0);
        System.out.println("val = 0 :" + var.getValue());
        var = c.variable("a", 5);
        System.out.println("val = 5 :" + var.getValue());
        System.out.println("val +=1 (not eval) :" + new Add((Constant) c.variable("a"), c.cNum(1)));
        System.out.println("val +=1 :" + new Add((Constant) c.variable("a"), c.cNum(1)).eval());
        Operations operations = c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)));
        operations = c.variable("val +=1 :" + "a", new Add((Constant) c.variable("a"), c.cNum(1)));
        System.out.println("val de nuevo :" + c.variable("a").eval());
        operations = operations;
        System.out.println("operations = operations" + c.variable("a").eval());
        // operations = c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)));
        operations.eval();
        System.out.println("operations eval : " + c.variable("a").eval());
        //new While(new CompareTo((ConstantNum) c.variable("a"), c.cNum(9)).eval() == 0, c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)))).eval();
        Operations[] ops =  {c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)))};
        System.out.println("list: " + ops[0].eval());
        System.out.println("list: " + ops[0].eval());
        System.out.println("list: " + ops[0].eval());
        int i = 0;
        System.out.println("while");
        while (i<3) {
            c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)));
            System.out.println(c.variable("a"));
            i++;
        }
        System.out.println(c.variable("a"));
        /*
        ConstantNum var = c.variable("a", 0);
        System.out.println(var.getValue());
        var = c.variable("a", 5);
        System.out.println(var.getValue());
        c.variable("a", (Operations) new Add( c.variable("a"), c.cNum(1)).eval());
        System.out.println(var.getValue());
        System.out.println(c.variable("a"));
        System.out.println(new CompareTo((ConstantNum) c.variable("a"), c.cNum(10)).eval() == 0);
        System.out.println(c.variable("a", new Add(c.variable("a"),c.cNum(1))));

        // Check while

        */
    }

    @Test
    void whileTest2() {
        c.variable("b", 0);
        ConstantNum num1 = c.cNum(1);
        System.out.println("b=0 :" + c.variable("b"));
        Operations op1 = c.variable("b", new Add((Constant) c.variable("b"), num1));
        System.out.println("operation 1 = " + op1);
        System.out.println("op1 eval : " + op1.eval());
        System.out.println("b=1 :" + c.variable("b"));
        Operations op2 = op1;
        System.out.println("ops2 = op1,eval : " + op2.eval());
        new While(true, c.variable("b", new Add((Constant) c.variable("b"), c.cNum(1)))).val();
    }

}
