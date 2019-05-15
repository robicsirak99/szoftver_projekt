package nienemensmorris.model;

import game.model.BoardData;
import game.model.GameState;
import javafx.scene.shape.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardDataTest {

    @Test
    void testOf(){
        GameState gameState = new GameState();
        BoardData boardData = new BoardData(gameState);
        Circle circle = new Circle(); circle.setId("1");
        assertTrue(boardData.can_place_here(circle, new int[]{0, 1, 2}));
        assertFalse(boardData.can_place_here(circle, new int[]{2}));
        assertFalse(boardData.can_place_here(circle, new int[]{3}));
        assertFalse(boardData.can_place_here(circle, new int[]{4}));

        Circle circle1 = new Circle(); circle1.setId("1");
        Circle circle2 = new Circle(); circle2.setId("2");
        Circle circle3 = new Circle(); circle3.setId("3");
        Circle circle4 = new Circle(); circle4.setId("4");
        assertTrue(boardData.created_a_mill(0, circle1));
        assertTrue(boardData.created_a_mill(0, circle2));
        assertTrue(boardData.created_a_mill(0, circle3));
        assertFalse(boardData.created_a_mill(0, circle4));

        Circle circle5 = new Circle();
        assertThrows(IllegalArgumentException.class, () -> boardData.created_a_mill(1,circle5));

    }


}
