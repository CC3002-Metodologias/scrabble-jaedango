package files.visitor;

import com.sun.source.tree.BinaryTree;
import files.operations.Ops;
import files.operations.constant.Constant;
import files.operations.constant.ConstantFactory;
import files.operations.ops.LogicOps.LogicOps;
import files.operations.ops.NumOps.Add;
import files.operations.ops.Operations;
import files.visitor.bTree.Node;
import files.visitor.bTree.Tree;

import java.util.ArrayList;

public class VisitorOperator extends Visitor {
    Node visitorTree;
    Operations ops;

    @Override
    public void visitConstant(Constant constant) {
        String s = constant.getName();
    }

    @Override
    public void visitOperation(Operations operations) {
        Ops val1 = operations.getValue()[0];
        Ops val2 = operations.getValue()[1];
        /*
        visitorTree = new Node(operations);
        visitorTree.addChild(new Node(val1));
        visitorTree.addChild(new Node(val2));*/
        if (operations.getName().equals("Add")) {
            ops = new Add((Constant) operations.getValue()[0], operations.getValue()[1]);
        }

    }

    /*public Constant result() {
        for(Ops ops : visitorTree) {
            ops.eval();
        }
        return null;
    }*/
}
