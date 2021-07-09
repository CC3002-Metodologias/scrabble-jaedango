package files.operations.ops.LogicOps;

import files.operands.Logical;
import files.operations.constant.Constant;
import files.operations.constant.ConstantLogical;
import files.operations.ops.Operations;

import java.util.Objects;

/**
 * @author jaedango
 */

public class And extends LogicOps {
    Constant val1;
    Constant val2;

    /**
     * Class Constructors
     * @param val1 -> Constant or Operation
     * @param val2 -> Constant or Operation
     */
    public And(Constant val1, Constant val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public And(Operations val1, Constant val2) {
        this.val1 = (ConstantLogical) val1.eval();
        this.val2 = val2;
    }

    public And(Constant val1, Operations val2) {
        this.val1 = val1;
        this.val2 = (ConstantLogical) val2.eval();
    }

    public And(Operations val1, Operations val2) {
        this.val1 = (ConstantLogical) val1.eval();
        this.val2 = (ConstantLogical) val2.eval();
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
        Logical v1 = (Logical) this.val1.getValue();
        Logical v2 = (Logical) this.val2.getValue();
        return new ConstantLogical(v1.and(v2));
    }
}
