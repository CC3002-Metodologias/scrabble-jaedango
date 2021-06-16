package types.numbers;

import types.ScType;

/**
 * @author <a href=mailto:ignacio.slater@ug.uchile.cl>Ignacio Slater Muñoz</a>
 * @author jaedango
 */

public interface ScNumber extends ScType {
    ScFloat asFloat();

    ScFloat addToFloat(ScFloat addend);

    ScFloat subtractToFloat(ScFloat subtrahend);

    ScFloat multiplyToFloat(ScFloat product);

    ScFloat divideToFloat(ScFloat divisor);

    ScNumber addToInt(ScInt addend);

    ScNumber subtractToInt(ScInt subtrahend);

    ScNumber multiplyToInt(ScInt product);

    ScNumber divideToInt(ScInt dividend);
}
