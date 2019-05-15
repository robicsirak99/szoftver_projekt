package game.controller;

import game.model.FXData;
import game.model.GameState;
import game.model.SQLPersistance;
import game.view.game.GamePane;
import game.view.menu.EndMenu;
import game.view.menu.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App extends Application {
    /**
     * Logolást lehetőséget biztosító osztály.
     */
    private static Logger logger = LoggerFactory.getLogger(EventHandler.class);
    /**
     * Data osztály példányosítás.
     */
    public static GameState gameState;
    /**
     * FXData osztály példányosítás.
     */
    public static FXData fxData = new FXData();
    /**
     * SQLPersistance osztály példányosítás.
     */
    public static SQLPersistance persistance = new SQLPersistance();

    /**
     * Elindítja a játékot.
     * @param stage a megjelenő ablak
     */
    public void start(Stage stage){
        fxData.setStage(stage);

        //főmenü scene
        MainMenu mainMenu = new MainMenu(fxData.getImage());
        Scene mainMenuScene = new Scene(mainMenu);
        fxData.setStartMenu(mainMenuScene);

        //játék végi menü scene
        EndMenu endMenu = new EndMenu(fxData.getImage());
        Scene endMenuScene = new Scene(endMenu);
        fxData.setEndMenu(endMenuScene);
        fxData.setEndMenuText(endMenu.text);

        button_press_handler(mainMenu.new_game_button);
        button_press_handler(mainMenu.load_game_button);
        button_press_handler(mainMenu.exit_game_button);
        button_press_handler(endMenu.new_game_button);
        button_press_handler(endMenu.exit_game_button);

        fxData.changeScene(mainMenuScene);
        stage.show();
    }

    /**
     * Gombnyomásokra állít be eseményeket.
     * @param button gombra állítja be az eseményt
     */
    public void button_press_handler(Button button) {
        if(button.getId()=="newgame"){
            button.setOnAction((event) -> {
                logger.info("...NEW GAME...");
                set_up_game_scene();
                set_to_defaut();
                load_game();
            });
        } else if(button.getId()=="loadgame"){
            button.setOnAction((event) -> {
                logger.info("...LOAD GAME...");
                set_up_game_scene();
                load_game();
            });
        } else if(button.getId()=="exit"){
            button.setOnAction((event) -> {
                logger.info("...EXIT...");
                fxData.getStage().close();
                set_to_defaut();
            });
        }

    }

    /**
     * Példányosít egy {@code GameScene} objektumot, beállítja az {@code fxData} objektum változóit az új {@code GameScene}-nek megfelelően.
     */
    public void set_up_game_scene(){
        GamePane gamePane = new GamePane();
        Scene game_scene = new Scene(gamePane);
        fxData.setGameScene(game_scene);

        fxData.setPane(gamePane);
        fxData.setP1(gamePane.p1);
        fxData.setP2(gamePane.p2);

        fxData.changeScene(fxData.getGameScene());

        EventHandler eventHandler = new EventHandler(gameState);
        eventHandler.add_evenet_handler();
    }

    /**
     * Lementett játékállás alapján megfelelő színüre festi a {@code Circle} objektumokat.
     */
    public void load_game(){
        for(int i=1; i<=24; i++){
            Circle c = get_cicle_by_id(i);
            if (gameState.get_val_by_id(i) == 1) {
                c.setFill(Color.BLACK);
            } else if (gameState.get_val_by_id(i) == 2) {
                c.setFill(Color.WHITE);
            } else if (gameState.get_val_by_id(i) == 1) {
                c.setFill(Color.GRAY);
            }
        }
    }

    /**
     * A játékállást alap állapotba helyezi.
     */
    public static void set_to_defaut(){gameState.setAll_default();
    }

    /**
     * Id alapján {@code Circle} objektumot küld vissza.
     * @param i id alapján küldi vissza a {@code Circle} objektumot.
     * @return {@code Circle} objektumot küld vissza.
     */
    public Circle get_cicle_by_id(int i) {
        return (Circle) fxData.getPane().getChildren().get(i-1);
    }

    /**
     * Kiolvassa a lementett játékállást, elindítja a játékot, kilépéskor lementi a játékállást.
     * @param args argumentumok
     */
    public static void main(String[] args) {
        gameState = persistance.read_table();
        launch(args);
        persistance.update_table(gameState);
    }
}
