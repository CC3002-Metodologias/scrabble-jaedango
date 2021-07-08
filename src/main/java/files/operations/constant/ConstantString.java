package files.operations.constant;

import files.types.ScString;

import java.util.Objects;

/**
 * @author jaedango
 */

public class ConstantString implements Constant {
    ScString value;

    public ConstantString(ScString val1) {
        this.value = val1;
    }

    /**
     * return String constant
     */
    @Override
    public ScString getValue() {
        return this.value;
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
}
