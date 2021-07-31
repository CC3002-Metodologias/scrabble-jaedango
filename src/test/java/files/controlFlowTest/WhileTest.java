package files.controlFlowTest;

import files.controlFlow.While;
import files.operations.Ops;
import files.operations.constant.Constant;
import files.operations.constant.ConstantFactory;
import files.operations.constant.VariableFactory;
import files.operations.ops.NumOps.Add;
import files.operations.ops.NumOps.Mul;
import files.operations.ops.Operations;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class WhileTest {
    ConstantFactory c = new ConstantFactory();
    VariableFactory v = new VariableFactory();

    /*@Test
    void whileTest1() {
        ConstantNum var = c.variable("a", 0);
        System.out.println(new While(new CompareTo(var, c.cNum(5)).eval() != 1, var = c.variable(var, new Add(var, c.cNum(1)))).eval());

    }*/

    /*
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
        */

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
    //}

    /*
    @Test
    void whileTest2() {
        c.variable("b", 1);
        ConstantNum num2 = c.cNum(2);
        new While2(c.variable("b", new Mul((Constant) c.variable("b"), num2)));

        System.out.println("b=0 :" + c.variable("b"));
        Operations op1 = c.variable("b", new Mul((Constant) c.variable("b"), num2));
        System.out.println("operation 1 = " + op1);
        System.out.println("op1 eval : " + op1.eval());
        System.out.println("b=1 :" + c.variable("b"));
        Operations op2 = op1;
        System.out.println(c.variable("b", new Mul((Constant) c.variable("b"), num2)));
        System.out.println("ops2 = op1,eval : " + op2.eval());
        new While(true, c.variable("b", new Mul((Constant) c.variable("b"), c.cNum(2)))).val();


    } */

    /*
    @Test
    void test3() {
        ConstantNum l = c.cNum(1);
        ConstantNum var1 = c.variable("a", 1);
        System.out.println(var1.eval());
        Operations var2 = c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)));
        System.out.println(var1.eval());
        Ops h = var2::eval;
        System.out.println(h.eval());
        System.out.println(h.eval());
        Ops g = var1::eval;
        System.out.println(g.eval());


        System.out.println();
        System.out.println("no se que esta pasando");
        System.out.println("variable : " + ((Constant) c.variable("a")).getValue());
        Runnable variable = () -> c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)));
        System.out.println(variable);
        variable.run();
        variable.run();
        variable.run();
        System.out.println(c.variable("a"));
    }
    */


    /*
    @Test
    void noseTest() {
        c.variable("a", 0);
        Operations ops = c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)));
        Supplier variable = () -> ops;
        variable.get();
        variable.get();
        System.out.println(c.variable("a"));

        //Runnable runnable = () -> ops;
        //runnable.run();
        //runnable.run();
        //System.out.println(c.variable("a"));

        Function<Operations,Constant> function = Operations::eval;

        function.apply(ops);
        System.out.println(ops.eval());

        function.apply(ops);
        System.out.println(ops.eval());

        Consumer<Operations> consumer = name -> c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)));

        // System.out.println(consumer.accept(new Add(c.cNum(1), c.cNum(2))));

        System.out.println(c.variable("a"));
        System.out.println("while :");
        new While2(c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)))).eval();
        System.out.println(c.variable("a"));

        System.out.println("while3 : ");
        new While3(c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)))).eval();

        Supplier<Operations> supplier2= () -> c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)));
        supplier2.get();
        System.out.println(supplier2.get().eval());
        System.out.println(supplier2.get().eval());

        System.out.println();
        System.out.println("intento3");
        Operations operations = c.variable("a", new Add((Constant) c.variable("a"), c.cNum(1)));
        Supplier<Operations> supplier3 = () -> operations;
        supplier3.get();
        System.out.println(supplier3.get().eval());
        System.out.println(supplier3.get().eval());

        System.out.println();
        System.out.println("otro intento");
        c.variable("b", 2);
        Mul mul = new Mul((Constant) c.variable("b"), c.cNum(2));
        System.out.println(mul.eval());
        Operations opxd = c.variable("b", mul);
        System.out.println(opxd.eval());
        Supplier<Operations> supplierxd = () -> opxd;
        System.out.println(supplierxd.get().eval());
        System.out.println(supplierxd.get().eval());
    }
*/

    @Test
    public void otroTest() {
        Constant a = v.variable("a", 1);
        System.out.println(v.variable("a"));
        Operations op = v.variable("a", new Add((Constant) v.variable("a"), c.cNum(1)));
        System.out.println(op.eval());
        new While(true, v.variable("a", new Add((Constant) v.variable("a"), c.cNum(1)))).eval2();
        System.out.println(v.variable("a"));
    }

}
