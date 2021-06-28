package files.types.numbers;

import files.types.ScType;

public interface ScNumber extends ScType {
    ScFloat toScFloat();

    ScFloat addToFloat(ScFloat addend);

    ScFloat subToFloat(ScFloat subtrahend);

    ScFloat mulToFloat(ScFloat product);

    ScFloat divToFloat(ScFloat dividend);

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
}
