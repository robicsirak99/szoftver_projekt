package game.view.menu;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class EndMenu extends StackPane {

    public Text text = new Text("NULL");

    public MyButton new_game_button = new MyButton("NEW GAME");
    public MyButton exit_game_button = new MyButton("EXIT");

    public EndMenu(String image){

        this.new_game_button.setId("newgame");
        this.exit_game_button.setId("exit");

        setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;");

        text.setStyle("-fx-text-fill: black; " +
                "-fx-font-weight: bold; " +
                "-fx-font-size: 30px;");
        text.setTranslateY(-100);

        setPrefSize(450,450);
        setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(text, new_game_button, exit_game_button);
        getChildren().addAll(vBox);
    }

}
