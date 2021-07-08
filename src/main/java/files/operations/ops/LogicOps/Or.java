package files.operations.ops.LogicOps;

import files.operands.Logical;
import files.operations.constant.Constant;
import files.operations.constant.ConstantLogical;
import files.operations.ops.Operations;

import java.util.Objects;

/**
 * @author jaedango
 */

public class Or extends LogicOps{
    Constant val1;
    Constant val2;

    public Or(Constant val1, Constant val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public Or(Operations val1, Constant val2) {
        this.val1 = (ConstantLogical) val1.eval();
        this.val2 = val2;
    }

    public Or(Constant val1, Operations val2) {
        this.val1 = val1;
        this.val2 = (ConstantLogical) val2.eval();
    }

    public Or(Operations val1, Operations val2) {
        this.val1 = (ConstantLogical) val1.eval();
        this.val2 = (ConstantLogical) val2.eval();
    }

    @Override
    public int hashCode() {
        return Objects.hash(Or.class, this.val1, this.val2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Or) {
            var other = (Or) obj;
            return val1.equals(other.val1) && val2.equals(other.val2);
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + val1.toString() + " or " + val2.toString() + ")";
    }

    @Override
    public Constant eval() {
        Logical v1 = (Logical) this.val1.getValue();
        Logical v2 = (Logical) this.val2.getValue();
        return new ConstantLogical(v1.and(v2));
    }
}
