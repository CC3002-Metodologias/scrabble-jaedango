package files.operations.ops.NumOps;

import files.operations.Ops;
import files.operations.constant.Constant;
import files.operations.constant.ConstantLogical;
import files.operations.constant.ConstantNum;
import files.operations.ops.Operations;
import files.types.numbers.ScNumber;
import files.visitor.Visitor;

import java.util.Objects;

/**
 * @author jaedango
 */

public class Mul extends NumOps{
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
        return "Mul";
    }

    /**
     * Class Constructors
     * @param val1 -> Constant or Operation
     * @param val2 -> Constant or Operation
     */
    public Mul(Ops val1, Ops val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

/*
    /**
     * Methods Override to print and assert equals

    @Override
    public int hashCode() {
        return Objects.hash(Mul.class, this.val1, this.val2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Mul) {
            var other = (Mul) obj;
            return val1.equals(other.val1) && val2.equals(other.val2);
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + val1.toString() + " * " + val2.toString() + ")";
    }
*/
    /**
     * Eval expression value
     * @return new Constant number
     */
    @Override
    public Constant eval() {
        Constant num1 = (Constant) this.val1.eval();
        Constant num2 = (Constant) this.val2.eval();
        ScNumber v1 = (ScNumber) num1.getValue();
        ScNumber v2 = (ScNumber) num2.getValue();
        return new ConstantNum(v1.mul(v2));
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
