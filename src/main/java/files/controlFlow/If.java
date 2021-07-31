package files.controlFlow;

import files.operations.Ops;
import files.operations.constant.Constant;
import files.operations.constant.ConstantLogical;
import files.operations.ops.Operations;
import files.types.ScBoolean;
import files.visitor.Visitor;

/**
 * @author jaedango
 */

public class If implements Control {
    ConstantLogical condition;
    Operations ifTrue;
    Operations ifFalse;

    public If(ConstantLogical condition, Operations ifTrue, Operations ifFalse) {
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    public If(boolean condition, Operations ifTrue, Operations ifFalse) {
        this.condition = new ConstantLogical(new ScBoolean(condition));
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    /**
     * @return string with class name
     */
    public String getName() {
        return "If";
    }

    /**
     * @return left argument if true, right argument if false
     */
    @Override
    public Ops eval() {
        ScBoolean scBoolean = (ScBoolean) condition.getValue();
        boolean aBool = scBoolean.getValue();
        if (aBool) {
            return ifTrue.eval();
        } else {
            return ifFalse.eval();
        }
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
