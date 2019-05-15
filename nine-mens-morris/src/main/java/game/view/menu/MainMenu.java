package game.view.menu;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class MainMenu extends StackPane {

    public MyButton new_game_button = new MyButton("NEW GAME");
    public MyButton load_game_button = new MyButton("LOAD GAME");
    public MyButton exit_game_button = new MyButton("EXIT");

    public MainMenu(String image){
        setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;");

        this.new_game_button.setId("newgame");
        this.load_game_button.setId("loadgame");
        this.exit_game_button.setId("exit");

        setPrefSize(450,450);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(new_game_button,load_game_button,exit_game_button);
        getChildren().add(vBox);
    }

}
