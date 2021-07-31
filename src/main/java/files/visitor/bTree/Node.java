package files.visitor.bTree;

import files.operations.Ops;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

public class Node {
    private ArrayList<Node> children;
    Ops value;
    String name;

    public Node(Ops value) {
        this.children = new ArrayList<>();
        this.value = value;
        this.name = value.getName();
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public Ops getValue() {
        return value;
    }

    public ArrayList<Node> getChildren() {
        for (Node child : children) {
            child.getChildren();
        }
        return null;
    }
}
