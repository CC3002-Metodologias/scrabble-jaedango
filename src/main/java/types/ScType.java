package types;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 * @author jaedango
 */

public interface ScType {
    /**
     * cast this as String type
     */
    ScString asString();

    /**
     * add a SString at the end of SString
     */
    ScString addToString(ScString addend);
}
