package files.operations.constant;

import files.types.ScString;
import files.visitor.Visitor;

import java.util.Objects;

/**
 * @author jaedango
 */

public class ConstantString implements Constant {
    ScString value;
    String name;

    public ConstantString(ScString val1) {
        this.value = val1;
        this.name = val1.toString() + "cStr";
    }

    /**
     * return String constant
     */
    @Override
    public ScString getValue() {
        return this.value;
    }

    /**
     * @return String name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * @return Constant Value
     */
    @Override
    public ConstantString eval() {
        return this;
    }

    /**
     * Methods Override to print and assert equals
     */
    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ConstantString.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConstantString) {
            var other = (ConstantString) obj;
            return this.value.equals(other.value);
        } else {
            return false;
        }
    }

    /**
     * Visitor module
     */
    public void accept(Visitor visitor) {
        visitor.visitConstant(this);
    }
}
