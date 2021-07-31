package files.visitor;

import files.operations.constant.Constant;
import files.operations.ops.Operations;

public class VisitorCondition extends Visitor {
    Constant val;

    @Override
    public void visitConstant(Constant constant) {
        val = constant;
    }

    @Override
    public void visitOperation(Operations operations) {
        val = operations.eval();
    }
}
