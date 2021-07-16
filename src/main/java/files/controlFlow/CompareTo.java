package files.controlFlow;

import files.operations.constant.ConstantNum;
import files.types.numbers.ScNumber;

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
        return num1.toString().compareTo(num2.toString());

    }
}
