package types;

import operands.Logical;
import types.numbers.ScBinary;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 * @author jaedango
 */

public class ScBool implements ScType, Logical {
    private final boolean value;

    public ScBool(boolean value) {
        this.value = value;
    }

    public ScBool asBool() {
        return new ScBool(this.value);
    }

    public ScBinary asBinary() {
        return new ScBinary(value ? "1" : "0");
    }

    @Override
    public ScString asString() {
        return new ScString(Boolean.toString(value));
    }

    @Override
    public ScString addToString(ScString addend) {
        return new ScString( addend.toString() + Boolean.toString(value));
    }

    @Override
    public Logical and(Logical conjunct) {
        return conjunct.andBool(this);
    }

    @Override
    public Logical andBool(ScBool bool) {
        return null;
    }

    @Override
    public Logical or(Logical operand) {
        return null;
    }

    @Override
    public Logical orBool(Logical operand) {
        return null;
    }

    @Override
    public Logical andBinary(ScBinary sBinary) {
        return null;
    }
}
