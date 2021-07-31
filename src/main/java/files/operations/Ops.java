package files.operations;

import files.visitor.Visitor;

/**
 * @author jaedango
 */

public interface Ops {
    Ops eval();
    String getName();
    public void accept(Visitor visitor);
}
