package files.controlFlow;

import files.operations.constant.ConstantNum;
import files.types.numbers.ScFloat;
import files.types.numbers.ScInt;
import files.types.numbers.ScNumber;

/**
 * @author jaedango
 */

public class CompareTo {
    ConstantNum val1;
    ConstantNum val2;

    public CompareTo(ConstantNum val1, ConstantNum val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public int eval() {
        ScNumber num1 = (ScNumber) this.val1.getValue();
        ScNumber num2 = (ScNumber) this.val2.getValue();

        float val1, val2;

        if (num1.toScInt() != null) {
            ScInt scInt = num1.toScInt();
            val1 = (float) scInt.getValue();
        } else {
            ScFloat scFloat = (ScFloat) num1;
            val1 = scFloat.getValue();
        }
        if (num2.toScInt() != null) {
            ScInt scInt = num2.toScInt();
            val2 = (float) scInt.getValue();
        } else {
            ScFloat scFloat = (ScFloat) num2;
            val2 = scFloat.getValue();
        }

        if (val1 > val2) {
            return 1;
        } else {
            if (val1 == val2) {
                return 0;
            } else {
                return -1;
            }
        }

    }
}
