package nienemensmorris.model;

import game.model.GameState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {

    @Test
    void test(){
        GameState gameState = new GameState();

        assertEquals(0,gameState.count_buttons(1));
        assertEquals(0,gameState.count_buttons(2));
        for(int i=1; i<=24; i++){
            assertEquals(0,gameState.get_val_by_id(i));
        }
        assertEquals(9,gameState.getNum_of_buttons());
        assertEquals(1,gameState.getNext_step());

        assertEquals(false, gameState.getAll_buttons_placed());
        assertEquals(false,gameState.getP1_can_jump());
        assertEquals(false,gameState.getP2_can_jump());

        assertEquals(0, gameState.getP1_buttons_placed());
        assertEquals(0, gameState.getP2_buttons_placed());
    }


}
