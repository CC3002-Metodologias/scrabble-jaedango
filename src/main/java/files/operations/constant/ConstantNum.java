package files.operations.constant;

import files.types.ScType;
import files.types.numbers.ScNumber;
import files.visitor.Visitor;

import java.util.Objects;

/**
 * @author jaedango
 */

public class ConstantNum implements Constant {
    ScNumber value;
    String name;

    public ConstantNum(ScNumber val) {
        this.value = val;
        this.name = val.toString() + "cNum";
    }

    public ConstantNum(ScNumber val, String name) {
        this.value = val;
        this.name = name;
    }

    /**
     * @return Constant Number
     */
    @Override
    public ScType getValue() {
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
    public ConstantNum eval() {
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
        return Objects.hash(ConstantNum.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ConstantNum) {
            var other = (ConstantNum) obj;
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
