package files.operations.logicOps;

import files.exceptions.WrongValueException;
import files.operands.Logical;
import files.operations.numOps.NumOps;
import files.types.numbers.ScBinary;
import files.types.numbers.ScNumber;

/**
 * @author jaedango
 */

// Note : No supe como resolver los casos mas que agregando un monton de constructores :(

public class And implements LogicOps{
    Logical value;

    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public Logical getValue() {
        return this.value;
    }

    public And(Logical val1, Logical val2) {
        this.value = val1.and(val2);
    }

    public And(LogicOps val1, Logical val2) {
        this.value = val1.getValue().and(val2);
    }

    public And(Logical val1, LogicOps val2) {
        this.value = val1.and(val2.getValue());
    }

    public And(LogicOps val1, LogicOps val2) {
        this.value = val1.getValue().and(val2.getValue());
    }

    public And(ScNumber val1, Logical val2) throws Exception {
        if (val1 instanceof ScBinary) {
            ScBinary v = (ScBinary) val1;
            this.value = v.and(val2);
        } else {
            throw new WrongValueException();
        }
    }

    public And(Logical val1, ScNumber val2) throws Exception {
        if (val2 instanceof ScBinary) {
            ScBinary v = (ScBinary)  val2;
            this.value = val1.and(v);
        } else {
            throw new WrongValueException();
        }
    }

    public And(ScNumber val1, ScNumber val2) throws Exception {
        if (val1 instanceof ScBinary && val2 instanceof ScBinary) {
            ScBinary v1 = (ScBinary) val1;
            ScBinary v2 = (ScBinary) val2;
            this.value = v1.and(v2);
        } else {
            throw new WrongValueException();
        }
    }

    public And(ScNumber val1, LogicOps val2) throws Exception {
        if (val1 instanceof ScBinary) {
            ScBinary v = (ScBinary) val1;
            this.value = v.and(val2.getValue());
        } else {
            throw new WrongValueException();
        }
    }

    public And(LogicOps val1, ScNumber val2) throws Exception {
        if (val2 instanceof ScBinary) {
            ScBinary v = (ScBinary) val2;
            this.value = val1.getValue().and(v);
        } else {
            throw new WrongValueException();
        }
    }

    public And(NumOps val1, Logical val2) throws Exception {
        if (val1 instanceof ScBinary) {
            ScBinary v = (ScBinary) val1;
            this.value = v.and(val2);
        } else {
            throw new WrongValueException();
        }
    }

    public And(Logical val1, NumOps val2) throws Exception {
        if (val2.getValue() instanceof ScBinary) {
            ScBinary v = (ScBinary) val2.getValue();
            this.value = val1.and(v);
        } else {
            throw new WrongValueException();
        }
    }

    public And(NumOps val1, NumOps val2) throws Exception {
        if (val1.getValue() instanceof  ScBinary && val2.getValue() instanceof ScBinary) {
            ScBinary v1 = (ScBinary) val1.getValue();
            ScBinary v2 = (ScBinary) val2.getValue();
            this.value = v1.and(v2);
        } else {
            throw new WrongValueException();
        }
    }

    public And(NumOps val1, LogicOps val2) throws Exception {
        if (val1.getValue() instanceof ScBinary) {
            ScBinary v1 = (ScBinary) val1.getValue();
            this.value = v1.and(val2.getValue());
        } else {
            throw new WrongValueException();
        }
    }

    public And(LogicOps val1, NumOps val2) throws Exception {
        if (val2.getValue() instanceof ScBinary) {
            ScBinary v2 = (ScBinary) val2.getValue();
            this.value = val1.getValue().and(v2);
        } else {
            throw new WrongValueException();
        }
    }

    public And(NumOps val1, ScNumber val2) throws Exception {
        if (val1.getValue() instanceof ScBinary && val2 instanceof ScBinary) {
            ScBinary v1 = (ScBinary) val1.getValue();
            ScBinary v2 = (ScBinary) val2;
            this.value = v1.and(v2);
        } else {
            throw new WrongValueException();
        }
    }

    public And(ScNumber val1, NumOps val2) throws Exception {
        if (val1 instanceof ScBinary && val2 instanceof ScBinary) {
            ScBinary v1 = (ScBinary) val1;
            ScBinary v2 = (ScBinary) val2.getValue();
            this.value = v1.and(v2);
        } else {
            throw new WrongValueException();
        }
    }
}
