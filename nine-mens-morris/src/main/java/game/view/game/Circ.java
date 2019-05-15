package game.view.game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Circ {
    public Circle c = new Circle(13);

    public Circ(String id){
        c.setId(id);

        c.setFill(Color.GRAY);
        c.setStroke(Color.GRAY);
        c.setStrokeWidth(2);

    }
}
