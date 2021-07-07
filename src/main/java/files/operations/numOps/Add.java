package files.operations.numOps;

import files.exceptions.WrongValueException;
import files.operands.Logical;
import files.operations.logicOps.LogicOps;
import files.types.ScString;
import files.types.numbers.ScBinary;
import files.types.numbers.ScNumber;

/**
 * @author jaedango
 */

// Note : No supe como resolver los casos mas que agregando un monton de constructores :(

public class Add implements NumOps {
    ScNumber value;
    ScString str;

    public ScNumber getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public Add(ScNumber val1,ScNumber val2) {
            this.value = val1.add(val2);
    }

    public Add(Logical val1, ScNumber val2) throws Exception {
        if (val1 instanceof ScBinary) {
            ScBinary v = (ScBinary) val1;
            this.value = v.add(val2);
        } else {
            this.value = null;
            throw new WrongValueException();
        }
    }

    public Add(ScNumber val1, Logical val2) throws Exception {
        if (val2 instanceof ScBinary) {
            ScBinary v = (ScBinary) val2;
            this.value = val1.add(v);
        } else {
            this.value = null;
            throw new WrongValueException();
        }
    }

    public Add(Logical val1, Logical val2) throws Exception {
        if (val1 instanceof ScBinary && val2 instanceof ScBinary) {
            ScBinary v1 = (ScBinary) val1;
            ScBinary v2 = (ScBinary) val2;
            this.value = v1.add(v2);
        } else {
            this.value = null;
            throw new WrongValueException();
        }
    }

    public Add(ScNumber val1, NumOps val2) {
        this.value = val1.add(val2.getValue());
    }

    public Add(NumOps val1, ScNumber val2) {
        this.value = val1.getValue().add(val2);
    }

    public Add(NumOps val1, NumOps val2) {
        this.value = val1.getValue().add(val2.getValue());
    }

    public Add(NumOps val1, Logical val2) throws WrongValueException {
        if (val2 instanceof ScBinary) {
            ScBinary v = (ScBinary) val2;
            this.value = val1.getValue().add(v);
        } else {
            throw new WrongValueException();
        }
    }

    public Add(Logical val1, NumOps val2) throws WrongValueException {
        if (val1 instanceof ScBinary) {
            ScBinary v = (ScBinary) val1;
            this.value = v.add(val2.getValue());
        } else {
            throw new WrongValueException();
        }
    }

    public Add(LogicOps val1, ScNumber val2) throws WrongValueException {
        if (val1.getValue() instanceof  ScBinary) {
            ScBinary v = (ScBinary) val1.getValue();
            this.value = v.add(val2);
        } else {
            throw new WrongValueException();
        }
    }

    public Add(ScNumber val1, LogicOps val2) throws WrongValueException {
        if (val2.getValue() instanceof ScBinary) {
            ScBinary v = (ScBinary) val2.getValue();
            this.value = val1.add(v);
        } else {
            throw new WrongValueException();
        }
    }

    public Add(LogicOps val1, LogicOps val2) throws WrongValueException {
        if (val1.getValue() instanceof ScBinary && val2.getValue() instanceof ScBinary) {
            ScBinary v1 = (ScBinary) val1.getValue();
            ScBinary v2 = (ScBinary) val2.getValue();
            this.value = v1.add(v2);
        } else {
            throw new WrongValueException();
        }
    }

    public Add(LogicOps val1, NumOps val2) throws WrongValueException {
        if (val1.getValue() instanceof ScBinary) {
            ScBinary v = (ScBinary) val1.getValue();
            this.value = v.add(val2.getValue());
        } else {
            throw new WrongValueException();
        }
    }

    public Add(NumOps val1, LogicOps val2) throws WrongValueException {
        if (val2.getValue() instanceof ScBinary) {
            ScBinary v = (ScBinary) val2.getValue();
            this.value = val1.getValue().add(v);
        } else {
            throw new WrongValueException();
        }
    }

    public Add(LogicOps val1, Logical val2) throws WrongValueException {
        if (val1.getValue() instanceof ScBinary && val2 instanceof ScBinary) {
            ScBinary v1 = (ScBinary) val1.getValue();
            ScBinary v2 = (ScBinary) val2;
            this.value = v1.add(v2);
        } else {
            throw new WrongValueException();
        }
    }

}
