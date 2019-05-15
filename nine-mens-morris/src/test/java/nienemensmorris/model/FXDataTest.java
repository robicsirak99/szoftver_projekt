package nienemensmorris.model;

import game.model.FXData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FXDataTest {


    @Test
    void test(){

        FXData fxData = new FXData();
        assertNotEquals(null, fxData.getImage());

        assertNotNull(fxData.getPane());
        assertNull(fxData.getP1());
        assertNull(fxData.getP2());

    }

}
