package files.operations.constant;

import files.operands.Logical;

import java.util.Objects;

/**
 * @author jaedango
 */

public class ConstantLogical implements Constant {
    Logical value;

    public ConstantLogical(Logical val1) {
        this.value = val1;
    }

    /**
     * @return Logical constant value
     */
    @Override
    public Logical getValue() {
        return this.value;
    }

    /**
     * @return Constant Value
     */
    @Override
    public ConstantLogical eval() {
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
        return Objects.hash(ConstantLogical.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConstantLogical) {
            var other = (ConstantLogical) obj;
            return this.value.equals(other.value);
        } else {
            return false;
        }
    }
}
