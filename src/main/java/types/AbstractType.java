package types;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 * @author jaedango
 */

public abstract class AbstractType implements ScType {

    /**
     * appends SString to the end of the SString
     * @param addend SString to append
     */
    @Override
    public ScString addToString(ScString addend) {
        return new ScString(this + addend.toString());
    }
}
