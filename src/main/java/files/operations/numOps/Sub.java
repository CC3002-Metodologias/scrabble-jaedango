package files.operations.numOps;

import files.exceptions.WrongValueException;
import files.operands.Logical;
import files.types.numbers.ScBinary;
import files.types.numbers.ScNumber;

/**
 * @author jaedango
 */

// Note : No supe como resolver los casos mas que agregando un monton de constructores :(

public class Sub {
    ScNumber value;

    public ScNumber getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public Sub(ScNumber val1,ScNumber val2) {
        this.value = val1.sub(val2);
    }

    public Sub(Logical val1, ScNumber val2) throws Exception {
        if (val1 instanceof ScBinary) {
            ScBinary v = (ScBinary) val1;
            this.value = v.sub(val2);
        } else {
            this.value = null;
            throw new WrongValueException();
        }
    }

    public Sub(ScNumber val1, Logical val2) throws Exception {
        if (val2 instanceof ScBinary) {
            ScBinary v = (ScBinary) val2;
            this.value = val1.sub(v);
        } else {
            this.value = null;
            throw new WrongValueException();
        }
    }

    public Sub(Logical val1, Logical val2) throws Exception {
        if (val1 instanceof ScBinary && val2 instanceof ScBinary) {
            ScBinary v1 = (ScBinary) val1;
            ScBinary v2 = (ScBinary) val2;
            this.value = v1.sub(v2);
        } else {
            this.value = null;
            throw new WrongValueException();
        }
    }

    public Sub(ScNumber val1, NumOps val2) {
        this.value = val1.sub(val2.getValue());
    }

    public Sub(NumOps val1, ScNumber val2) {
        this.value = val1.getValue().sub(val2);
    }

    public Sub(NumOps val1, NumOps val2) {
        this.value = val1.getValue().sub(val2.getValue());
    }

    public Sub(NumOps val1, Logical val2) throws WrongValueException {
        if (val2 instanceof ScBinary) {
            ScBinary v = (ScBinary) val2;
            this.value = val1.getValue().sub(v);
        } else {
            throw new WrongValueException();
        }
    }

    public Sub(Logical val1, NumOps val2) throws WrongValueException {
        if (val1 instanceof ScBinary) {
            ScBinary v = (ScBinary) val1;
            this.value = v.sub(val2.getValue());
        } else {
            throw new WrongValueException();
        }
    }
}
