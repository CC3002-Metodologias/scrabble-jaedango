package files.types.numbers;

import files.operands.BinaryOperand;
import files.operands.Logical;
import files.types.AbstractType;
import files.types.ScBoolean;
import files.types.ScString;

import java.util.Objects;

import static files.types.numbers.BinaryToInt.intToBin;
import static files.types.numbers.BinaryToInt.binToInt;

/**
 * @author jaedango
 * ScBinary : binary for Scrabble
 * accepts only Strings that contains 1's & 0's
 * note that 00001 and 0001 are different
 */

public class ScBinary extends AbstractType implements BinaryOperand, ScNumber, Logical {
    protected String value;

    public ScBinary(String bin) {
        if (bin.matches("^[01]+$")) {
            this.value = bin;
        } else {
            this.value = "0";
        }
    }

    public String getValue() {
        return this.value;
    }

    /**
     * ScBinary getter method
     * @return String with ScBinary value
     */
    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ScBinary.class, this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScBinary) {
            var other = (ScBinary) obj;
            return value.equals(other.value);
        }
        return false;
    }

    @Override
    public ScString addScString(ScString addend) {
        return new ScString(this.value + addend.toString());
    }

    /**
     * Methods to transform ScBinary into other classes
     */
    @Override
    public ScString toScString() {
        return new ScString(this.value);
    }

    @Override
    public ScFloat toScFloat() {
        float f = (float) binToInt(this.value);
        return new ScFloat(f);
    }

    @Override
    public ScInt toScInt() {
        int n = binToInt(this.value);
        return new ScInt(n);
    }

    @Override
    public ScBinary toScBinary() {
        return new ScBinary(this.value);
    }

    /**
     * Logical 'and' and 'or' functions
     * @return new Logical
     */
    @Override
    public Logical and(Logical conjunct) {
        return conjunct.andBinary(this);
    }

    @Override
    public Logical or(Logical conjunct) {
        return conjunct.orBinary(this);
    }

    /**
     * boolean 'and' with a ScBoolean
     */
    @Override
    public ScBinary andBool(ScBoolean bool) {
        String copy = this.value;
        StringBuilder str = new StringBuilder();
        for (int i=0;i<copy.length();i++) {
            char c = copy.charAt(i);
            if (c=='0' || !bool.getValue()) {
                str.append('0');
            } else {
                str.append('1');
            }
        }
        return new ScBinary(str.toString());
    }

    /**
     * boolean 'or' operator with a ScBoolean
     */
    @Override
    public ScBinary orBool(ScBoolean bool) {
        String copy = this.value;
        StringBuilder str = new StringBuilder();
        for (int i=0;i<copy.length();i++) {
            char c = copy.charAt(i);
            if (c=='0' && !bool.getValue()) {
                str.append('0');
            } else {
                str.append('1');
            }
        }
        return new ScBinary(str.toString());
    }

    /**
     * boolean 'and' with ScBinary
     */
    @Override
    public Logical andBinary(ScBinary operand) {
        return null;
    }

    /**
     * boolean 'or' with ScBinary
     */
    @Override
    public Logical orBinary(ScBinary operand) {
        return null;
    }

    /**
     * Basic Operations
     */
    public ScNumber add(ScNumber addend) { return addend.addToBin(this); }

    public ScNumber sub(ScNumber subtrahend) {
        return subtrahend.subToBin(this);
    }

    public ScNumber mul(ScNumber product) {
        return product.mulToBin(this);
    }

    public ScNumber div(ScNumber dividend) {
        return dividend.divToBin(this);
    }

    /**
     * Binary operations with ints
     * @return ScBinary
     */
    @Override
    public ScBinary addToInt(ScInt n) {
        int val = n.value + binToInt(this.value);
        return new ScBinary(intToBin(val));
    }

    @Override
    public ScBinary subToInt(ScInt n) {
        int val = n.value - binToInt(this.value);
        return new ScBinary(intToBin(val));
    }

    @Override
    public ScBinary mulToInt(ScInt n) {
        int val = n.value * binToInt(this.value);
        return new ScBinary(intToBin(val));
    }

    @Override
    public ScBinary divToInt(ScInt n) {
        int val = n.value / binToInt(this.value);
        return new ScBinary(intToBin(val));
    }

    /**
     * Binary operations with other Binary
     * @return new ScBinary
     */
    @Override
    public ScBinary addToBin(ScBinary bin) {
        int val = binToInt(bin.value) + binToInt(this.value);
        return new ScBinary(intToBin(val));
    }

    @Override
    public ScBinary subToBin(ScBinary bin) {
        int val = binToInt(bin.value) - binToInt(this.value);
        return new ScBinary(intToBin(val));
    }

    @Override
    public ScBinary mulToBin(ScBinary bin) {
        int val = binToInt(bin.value) * binToInt(this.value);
        return new ScBinary(intToBin(val));
    }

    @Override
    public ScBinary divToBin(ScBinary bin) {
        int val = binToInt(bin.value) / binToInt(this.value);
        return new ScBinary(intToBin(val));
    }

    /**
     * Binary operations with Floats
     * Binary cannot be operated with floats for this section.
     * @return null
     */
    @Override
    public ScFloat addToFloat(ScFloat addend) {
        return null;
    }

    @Override
    public ScFloat subToFloat(ScFloat subtrahend) {
        return null;
    }

    @Override
    public ScFloat mulToFloat(ScFloat product) {
        return null;
    }

    @Override
    public ScFloat divToFloat(ScFloat dividend) {
        return null;
    }
}
