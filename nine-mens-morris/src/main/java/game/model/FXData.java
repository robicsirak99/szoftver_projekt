package game.model;

import game.controller.App;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

/**
 * A játék működéséhez szükséges JavaFX objektumokat tárolja.
 */
public class FXData {

    /**
     * A menü háttere.
     */
    private String image = App.class.getResource("/Images/menuebackground.png").toExternalForm();
    /**
     * A megjelenő ablak {@code Stage} objektuma.
     */
    private Stage stage;
    /**
     * A játék {@code Pane} objektuma.
     */
    private Pane pane = new Pane();
    /**
     * A játék {@code Scene} objektuma.
     */
    private Scene gameScene;
    /**
     * A játék elei menü {@code Scene} objektuma.
     */
    private Scene startMenu;
    /**
     * A játékvégi menü {@code Scene} objektuma.
     */
    private Scene endMenu;
    /**
     * Melyik játékos nyerte meg a játékot.
     */
    private Text endMenuText;
    /**
     * A játékban megjelenő {@code Text} objektum.
     */
    private Text p1;
    /**
     * A játékban megjelenő {@code Text} objektum.
     */
    private Text p2;

    /**
     * A játék végi menü részeként megjelenik a nyertes játékos.
     * @param endMenuText a nyertes játékos (fekete vagy fehér)
     */
    public void setEndMenuText(Text endMenuText) {
        this.endMenuText = endMenuText;
    }

    public Text getEndMenuText() {
        return endMenuText;
    }

    public String getImage() {
        return image;
    }

    public Text getP1() {
        return p1;
    }

    public Text getP2() {
        return p2;
    }

    public void setP1(Text p1) {
        this.p1 = p1;
    }

    public void setP2(Text p2) {
        this.p2 = p2;
    }

    public void setStartMenu(Scene startMenu) {
        this.startMenu = startMenu;
    }

    public Scene getStartMenu() {
        return startMenu;
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public Scene getGameScene() {
        return gameScene;
    }

    public void changeScene(Scene scene){
        this.stage.setScene(scene);
    }

    public void setEndMenu(Scene endMenu) {
        this.endMenu = endMenu;
    }

    public Scene getEndMenu() {
        return endMenu;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public Pane getPane() {
        return pane;
    }


}
