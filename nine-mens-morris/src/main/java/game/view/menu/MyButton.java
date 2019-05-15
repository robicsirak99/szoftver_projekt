package game.view.menu;

import javafx.scene.control.Button;

public class MyButton extends Button {

    public MyButton(String text){
        setText(text);
        setStyle("-fx-border-color: black; " +
                "-fx-border-width: 2px; " +
                "-fx-background-color: white; " +
                "-fx-text-fill: black; " +
                "-fx-font-weight: bold; " +
                "-fx-font-size: 14px;");
    }

}
