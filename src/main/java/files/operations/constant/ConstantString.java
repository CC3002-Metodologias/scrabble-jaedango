package files.operations.constant;

import files.types.ScString;
import files.types.ScType;

import java.util.Objects;

public class ConstantString implements Constant {
    ScString value;

    public ConstantString(ScString val1) {
        this.value = val1;
    }

    @Override
    public ScString getValue() {
        return this.value;
    }

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
