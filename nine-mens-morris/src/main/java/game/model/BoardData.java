package game.model;

import javafx.scene.shape.Circle;
import static java.lang.Integer.valueOf;

/**
 * A játék alapvető szabályait tárolja.
 */
public class BoardData{
    /**
     * A mátrix egyes sorai azokat a mezőket tartalmazzák amelyeken létrejöhet malom.
     */
    public int[][] mill_matrix = {
            {1, 2, 3},
            {3, 5, 8},
            {6, 7, 8},
            {1, 4, 6},
            {9, 10, 11},
            {11, 13, 16},
            {14, 15, 16},
            {9, 12, 14},
            {17, 18, 19},
            {19, 21, 24},
            {22, 23, 24},
            {17, 20, 22},
            {4, 12, 20},
            {2, 10, 18},
            {5, 13, 21},
            {7, 15, 23},
    };
    /**
     * A mátrix sorai azokat a mezőket tartalmazzák, ahova a sor sorszámának megfelelő gomb áthelyezhető.
     */
    public int[][] b_i = {
            {0 ,0},         //0
            {1, 4, 2},         //1 -es gomb áthelyezhető az 1-es, a 4-es és a 2-es mezőre.
            {2, 1, 3, 10},     //2
            {3, 2, 5},         //3
            {4, 1, 6, 12},     //4
            {5, 3, 8, 13},     //5
            {6, 4, 7},         //6
            {7, 6, 8, 15},     //7
            {8, 5, 7},         //8
            {9, 10, 12 },      //9
            {10, 2, 9, 11, 18}, //10
            {11, 10, 13},       //11
            {12, 4, 9, 14, 20}, //12
            {13, 5, 11, 16, 21},//13
            {14, 12, 15},       //14
            {15, 7, 14, 16, 23},//15
            {16, 13, 15},       //16
            {17, 18, 20},       //17
            {18, 10, 17, 19},   //18
            {19, 18, 21},       //19
            {20, 12, 17, 22},   //20
            {21, 13, 19, 24},   //21
            {22, 20, 23 },      //22
            {23, 15, 22, 24},   //23
            {24, 21, 23},       //24
            {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24} //mindenhova léphet
    };
    /**
     * {@code GameState} osztály példányosítás.
     */
    public GameState gameState;
    /**
     * Az osztályhoz szükséges {@code GameState} objektumot adja át.
     * @param gameState az osztályhoz szükséges objektum
     */
    public BoardData(GameState gameState){
        this.gameState = gameState;
    }
    /**
     * Visszaküldi, hogy az adott lépés eredményezett-e olyan állást, hogy az egyik játékos le kell vegyen egy ellenfél gombot.
      * @param circle az ide helyezett gomb eredményezett-e olyan állást, hogy az egyik játékos le kell vegyen egy ellenfél gombot
     * @param p_val ez a játékos le kell-e vegyen egy ellenfél gombot
     * @return adott lépés eredményezett-e olyan állást, hogy az egyik játékos le kell vegyen egy ellenfél gombot
     */
    public boolean next_step_is_steal(Circle circle, int p_val){
        int row1 = search_rows(circle)[0];
        int row2 = search_rows(circle)[1];

        if((is_mill(row1,p_val) && created_a_mill(row1,circle)) ||  (is_mill(row2,p_val) && created_a_mill(row2, circle)))return true;
        else return false;
    }
    /**
     * Le tudja-e venni az adott játékos az adott gombot a tábláról.
     * @param circle ezt a gombot vizsgálja, hogy le lehet-e venni
     * @param p_val ez a játékos le tudja-e venni a gombot
     * @return le tudja-e venni a játékos a gombot
     */
    public boolean can_steal_this(Circle circle, int p_val){
        int [] rows = search_rows(circle);
        if(is_mill(rows[0],p_val) || is_mill(rows[1],p_val)) return false;
        else return true;
    }
    /**
     * Visszaküldi, hogy az adott lépés eredményez-e a malom létrejöttét.
     * @param row ezeken a pozíciókon található a malom
     * @param circle ezen a helyen történt gomb lehelyezés
     * @return az adott lépés eredményezte-e a malom létrejöttét
     */
    public boolean created_a_mill(int row, Circle circle){
        if(mill_matrix[row][0]==valueOf(circle.getId()) || mill_matrix[row][1]==valueOf(circle.getId()) || mill_matrix[row][2]==valueOf(circle.getId()))
            return true;
        else return false;
    }
    /**
     * Információt szolgáltat arról, hogy van-e malom az adott helyen.
     * @param row azt a három pozíciót tartalmazza amelyen megvizsgáljuk, hogy levan-e helyezve ugyanazon játékos 3 gombja
     * @param p_val ennek a játékosnak vizsgáljuk, hogy van-e malma az adott helye
     * @return talál-e malmot
     */
    public boolean is_mill(int row, int p_val){
        if(gameState.get_val_by_id(mill_matrix[row][0])==p_val && gameState.get_val_by_id(mill_matrix[row][1])==p_val && gameState.get_val_by_id(mill_matrix[row][2])==p_val)
            return true;
         else return false;
    }
    /**
     * Megkeresi azt a két pozícióhármast egy {@code Circle} objektum id-je alapján, ahol létrejöhet malom.
     * @param circle ennek az objektumnak az id-je alapján keresi a pozícióhármasokat
     * @return az az id-nek megfelelő két pozícióhármas ahol létrejöhet malom
     */
    public int[] search_rows(Circle circle){
        int[] rows = {-1, -1};
        for(int i=0; i<16; i++){
            for(int j=0; j<3; j++){
                if(mill_matrix[i][j] == valueOf(circle.getId())){
                    if(rows[0] == -1) rows[0] = i;
                    else rows[1] = i;
                }
            }
        }
        return rows;
    }
    /**
     * Az adott {@code Circle} objektum lehelyezhető-e az {@code array}-ban tárolt pozíciókra.
     * @param circle ezt vizsgáljuk, hogy lehegyezhető-e
     * @param array erre a pozíciókra nézzük meg, hogy lehelyezhető-e
     * @return lehelyezhető-e a pozícióra a {@code Circle} objektum
     */
    public boolean can_place_here(Circle circle, int[] array){
        for(int i=0; i < array.length; i++){
            if(valueOf(circle.getId())==array[i]) return true;
        }
        return false;
    }
}
