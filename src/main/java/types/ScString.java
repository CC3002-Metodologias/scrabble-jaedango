package types;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 * @author jaedango
 */

public class ScString extends AbstractType{
    private final String value;

    public ScString(String value) {
        this.value = value;
    }

    @Override
    public ScString asString() {
        return new ScString(value);
    }

    public ScString add(ScType addend) {
        return addend.addToString(this);
    }

    @Override
    public String toString() {
        return value;
    }
}
