package files.types.numbers;

import files.types.ScType;

public interface ScNumber extends ScType {
    ScFloat toScFloat();

    ScInt toScInt();

    /**
     * Float Ops : add (+), subs (-), multiply (*), divide (/)
     * @return new ScFloat
     */
    ScFloat addToFloat(ScFloat addend);

    ScFloat subToFloat(ScFloat subtrahend);

    ScFloat mulToFloat(ScFloat product);

    ScFloat divToFloat(ScFloat dividend);

    /**
     * Int Ops : add (+), subs (-), multiply (*), divide (/)
     * @return new ScInt
     */
    ScNumber addToInt(ScInt addend);

    ScNumber subToInt(ScInt subtrahend);

    ScNumber mulToInt(ScInt product);

    ScNumber divToInt(ScInt dividend);

    /**
     * Binary Ops : add (+), subs (-), multiply (*), divide (/)
     * @return new ScBinary
     */
    ScNumber addToBin(ScBinary addend);

    ScNumber subToBin(ScBinary substrate);

    ScNumber mulToBin(ScBinary product);

    ScNumber divToBin(ScBinary dividend);

    /**
     * Basic Ops : add (+), subs (-), multiply (*), divide (/)
     * @return new ScNumber
     */
    ScNumber add(ScNumber addend);

    ScNumber sub(ScNumber subtrahend);

    ScNumber mul(ScNumber product);

    ScNumber div(ScNumber dividend);
}
