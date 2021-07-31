package files.controlFlow;

import files.operations.Ops;
import files.operations.constant.Constant;
import files.operations.constant.ConstantLogical;
import files.operations.ops.Operations;
import files.types.ScBoolean;

/**
 * Not Functional
 */

public class While implements Control {
    Constant condition;
    Operations whileTrue;

    public While(Constant condition, Operations whileTrue) {
        this.condition = condition;
        this.whileTrue = whileTrue;
    }

    public While(boolean condition, Operations whileTrue) {
        this.condition = new ConstantLogical(new ScBoolean(condition));
        this.whileTrue = whileTrue;
    }


    @Override
    public Ops eval() {
        ScBoolean scBoolean = (ScBoolean) condition.getValue();
        boolean aBool = scBoolean.getValue();
        while (aBool) {
            scBoolean = (ScBoolean) condition.getValue();
            aBool = scBoolean.getValue();
            whileTrue.eval();
        }
        return whileTrue;
    }
}
