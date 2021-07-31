package files.visitor;

import files.operations.Ops;
import files.operations.constant.Constant;
import files.operations.constant.ConstantLogical;
import files.operations.ops.Operations;

public class IfVisitor extends Visitor {
    ConstantLogical condition;
    Ops trueValue;
    Ops falseValue;

    public IfVisitor(ConstantLogical Condition, Ops trueValue, Ops falseValue) {

    }

    @Override
    public void visitConstant(Constant constant) {

    }

    @Override
    public void visitOperation(Operations operations) {

    }
}
