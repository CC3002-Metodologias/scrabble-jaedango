package files.operations.ops.NumOps;

import files.exceptions.WrongValueException;
import files.operations.constant.Constant;
import files.operations.constant.ConstantNum;
import files.operations.constant.ConstantString;
import files.operations.ops.Operations;
import files.types.ScString;
import files.types.numbers.ScNumber;

import java.util.Objects;

/**
 * @author jaedango
 */

public class Add extends NumOps{
    Constant val1;
    Constant val2;

    public Add(Constant val1, Constant val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public Add(Constant val1, Operations val2) {
        this.val1 = val1;
        this.val2 = val2.eval();
    }

    public Add(Operations val1, Constant val2) {
        this.val1 = val1.eval();
        this.val2 = val2;
    }

    public Add(Operations val1, Operations val2) {
        this.val1 = val1.eval();
        this.val2 = val2.eval();
    }

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

    @Override
    public Constant eval() {
        if (this.val1.getValue() instanceof ScNumber && this.val2.getValue() instanceof ScNumber) {
            ScNumber v1 = (ScNumber) this.val1.getValue();
            ScNumber v2 = (ScNumber) this.val2.getValue();
            return new ConstantNum(v1.add(v2));
        }
        if (this.val1.getValue() instanceof ScString && this.val2.getValue() instanceof  ScString) {
            ScString v1 = (ScString) this.val1.getValue();
            ScString v2 = (ScString) this.val2.getValue();
            return new ConstantString(v1.add(v2));
        } else {
            return null;
        }
    }
}
