package files.visitor;

import files.operations.constant.Constant;
import files.operations.ops.Operations;

public abstract class Visitor {
    public abstract void visitConstant(Constant constant);

    public abstract void visitOperation(Operations operations);
}
