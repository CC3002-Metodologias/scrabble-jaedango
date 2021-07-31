package files.operations.ops.NumOps;

import files.operations.Ops;
import files.operations.constant.Constant;
import files.operations.constant.ConstantNum;
import files.operations.constant.ConstantString;
import files.operations.ops.Operations;
import files.types.ScString;
import files.types.numbers.ScNumber;
import files.visitor.Visitor;

/**
 * @author jaedango
 */

public class Add extends NumOps{
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
        return "Add";
    }

    /**
     * Class Constructors
     * @param val1 -> Constant or Operation
     * @param val2 -> Constant or Operation
     */
    /*
    public Add(Constant val1, Constant val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public Add(Constant val1, Operations val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public Add(Operations val1, Constant val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public Add(Operations val1, Operations val2) {
        this.val1 = val1;
        this.val2 = val2;
    }*/

    public Add(Ops val1, Ops val2) {
        this.val1 = val1;
        this.val2 = val2;
    }
/*
    /**
     * Methods Override to print and assert equals

    @Override
    public int hashCode() {
        return Objects.hash(Add.class, this.val1, this.val2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Add) {
            var other = (Add) obj;
            return val1.equals(other.val1) && val2.equals(other.val2);
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + val1.toString() + " + " + val2.toString() + ")";
    }
*/
    /**
     * Eval expression value
     * @return new Constant number or String
     */
    @Override
    public Constant eval() {
        Constant value1 = (Constant) this.val1.eval();
        Constant value2 = (Constant) this.val2.eval();
        if (value1.getValue() instanceof ScNumber && value2.getValue() instanceof ScNumber) {
            Constant rv1 = new ConstantNum((ScNumber) value1.getValue(), val1.getName());
            Constant rv2 = new ConstantNum((ScNumber) value2.getValue(), val2.getName());
            ScNumber v1 = (ScNumber) rv1.getValue();
            ScNumber v2 = (ScNumber) rv2.getValue();
            return new ConstantNum(v1.add(v2));
        }
        if (value1.getValue() instanceof ScString && value2.getValue() instanceof  ScString) {
            ScString v1 = (ScString) value1.getValue();
            ScString v2 = (ScString) value2.getValue();
            return new ConstantString(v1.add(v2));
        } else {
            return null;
        }
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
