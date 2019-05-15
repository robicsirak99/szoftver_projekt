package game.view.game;

import game.controller.App;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GamePane extends Pane {


    private String image = App.class.getResource("/Images/gamebackground.png").toExternalForm();
    public Text p1 = new Text("BLACK");
    public Text p2 = new Text("WHITE");

    /**
     *
     * Létrehoz egy <code>GameScene</code> objektumot, ami tartalmazz a játék működéséhez szükséges
     * 24 darab Circle objektumot, valamit két <code>Text</code> objektumot ami a játékban
     * a következő játékos jelzésére szolgál, illetve beállítja a <code>GameScene</code> objektum hátterét,
     * és a tartalmazott objektumok megjelenését, elhelyezkedésést
     */
    public GamePane(){
        setPrefSize(450,450);
        int id = 1;
        for(int t = 1; t<=3; t++){
            for(int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    if (!((i == 1) && (j == 1))) {
                        Circ circ = new Circ(String.valueOf(id));
                        if(i > 1) circ.c.setTranslateX(i * 225 - t*50);
                        else if(i == 1) circ.c.setTranslateX(i * 225);
                        else circ.c.setTranslateX(i * 225 + t*50);
                        if(j > 1) circ.c.setTranslateY(j * 225 - t*50);
                        else if(j == 1) circ.c.setTranslateY(j * 225);
                        else circ.c.setTranslateY(j * 225 + t*50);
                        getChildren().add(circ.c);
                        id++;
                    }
                }
            }
        }
        set_background_image(this);
        set_text_style(p1);
        set_text_style(p2); p2.setFill(Color.GRAY);
        getChildren().addAll(p1,p2);
        p1.setTranslateX(10);
        p1.setTranslateY(20);
        p2.setTranslateX(375);
        p2.setTranslateY(20);
    }

    /**
     * Az értékül kapott <code>Pane</code> objektum hátterét állítja be.
     *
     * @param pane ennek az objektumnak állítja be a hátterét
     */
    public void set_background_image(Pane pane){
        pane.setStyle("-fx-background-image: url('" + image + "'); " +
                "-fx-background-position: center center; " +
                "-fx-background-repeat: stretch;");
    }

    /**
     * Az értékül kapott <code>Text</code> objektumon eszközöl megjelenési beállításokat (betűméret).
     *
     * @param text ennek a paraméternek változtatja a megjelenését
     */
    public void set_text_style(Text text){
        text.setStyle("-fx-font-weight: bold; -fx-font-size: 15px;");
    }

}

