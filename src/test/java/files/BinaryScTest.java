package files;

import org.junit.jupiter.api.BeforeEach;

/**
 * @author jaedango
 * ScBinaryTest : Test para ScBinary
 */

// Hubo un error que desconozco el motivo pero no dejo que el archivo se llamara ScBinaryTest
public class BinaryScTest {
    private ScBinary bin1;

    @BeforeEach
    public void setUp(){
        bin1 = new ScBinary("1001");
    }

}

