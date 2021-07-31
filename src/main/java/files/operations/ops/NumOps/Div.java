package files.operations.ops.NumOps;

import files.operations.Ops;
import files.operations.constant.Constant;
import files.operations.constant.ConstantNum;
import files.operations.ops.Operations;
import files.types.numbers.ScNumber;
import files.visitor.Visitor;

import java.util.Objects;

/**
 * @author jaedango
 */

public class Div extends NumOps{
    Ops val1;
    Ops val2;

    /**
     * @return left and right operator
     */
    public Ops[] getValue() {
        Ops[] list = new Ops[2];
        list[0] = val1;
        list[1] = val2;
        return list;
    }

    /**
     * @return string with class name
     */
    public String getName() {
        return "Div";
    }

    /**
     * Class Constructors
     * @param val1 -> Constant or Operation
     * @param val2 -> Constant or Operation
     */
    public Div(Ops val1, Ops val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

/*
    /**
     * Methods Override to print and assert equals

    @Override
    public int hashCode() {
        return Objects.hash(Div.class, this.val1, this.val2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Div) {
            var other = (Div) obj;
            return val1.equals(other.val1) && val2.equals(other.val2);
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + val1.toString() + " / " + val2.toString() + ")";
    }
*/
    /**
     * Eval expression value
     * @return new Constant number
     */
    @Override
    public Constant eval() {
        Constant value1 = (Constant) this.val1.eval();
        Constant value2 = (Constant) this.val2.eval();
        ScNumber v1 = (ScNumber) value1.getValue();
        ScNumber v2 = (ScNumber) value2.getValue();
        return new ConstantNum(v1.div(v2));
    }

    /**
     * Visitor
     */
    @Override
    public void accept(Visitor visitor) {
        val1.accept(visitor);
        val2.accept(visitor);
        visitor.visitOperation(this);
    }
}
