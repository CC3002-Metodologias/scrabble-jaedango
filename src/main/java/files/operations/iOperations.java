package files.operations;

import files.exceptions.WrongValueException;
import files.operands.Logical;
import files.types.numbers.ScBinary;
import files.types.numbers.ScNumber;

public interface iOperations {
    public static ScNumber add(ScNumber val1, ScNumber val2) {
        return val1.add(val2);
    }

    /*
    public static ScNumber add(Logical val1, ScNumber val2) throws Exception {
        try {
            ScBinary v = (ScBinary) val1;
            return v.add(val2);
        }
        catch {
            throw new WrongValueException();
        }
    }*/

    public static ScNumber sub(ScNumber val1, ScNumber val2) {
        return val1.sub(val2);
    }

    public static ScNumber mul(ScNumber val1, ScNumber val2) {
        return val1.mul(val2);
    }

    public static ScNumber div(ScNumber val1, ScNumber val2) {
        return val1.div(val2);
    }

    public static Logical and(Logical val1, Logical val2) {
        return val1.and(val2);
    }

    public static Logical or(Logical val1, Logical val2) {
        return val1.or(val2);
    }
}
