package files.operations.ops.LogicOps;

import files.operands.Logical;
import files.operations.Ops;
import files.operations.constant.Constant;
import files.operations.constant.ConstantLogical;
import files.operations.ops.Operations;
import files.visitor.Visitor;

/**
 * @author jaedango
 */

public class And extends LogicOps {
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
        return "And";
    }

    /**
     * Class Constructors
     * @param val1 -> Constant or Operation
     * @param val2 -> Constant or Operation
     */
    /*
    public And(Constant val1, Constant val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public And(Operations val1, Constant val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public And(Constant val1, Operations val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public And(Operations val1, Operations val2) {
        this.val1 = val1;
        this.val2 = val2;
    }*/

    public And(Ops val1, Ops val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    /*
    @Override
    public String toString() {
        return "(" + val1.toString() + " & " + val2.toString() + ")";
    }
    */

    /**
     * Eval expression value
     * @return new Logical Value
     */
    @Override
    public Constant eval() {
        Constant value1 = (Constant) this.val1.eval();
        Constant value2 = (Constant) this.val2.eval();
        Logical v1 = (Logical) value1.getValue();
        Logical v2 = (Logical) value2.getValue();
        return new ConstantLogical(v1.and(v2));
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
