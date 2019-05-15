package game.model;

import javafx.scene.shape.Circle;
import javax.persistence.*;

import static java.lang.Integer.valueOf;

/**
 * A játékállás osztálya.
 */
@Entity
@Table(name = "GameState")
public class GameState {

    @Id
    private int id = 2;
    /**
     * Hány darab gombot kell lerakjanak a játékosok külön-külön.
     */
    @Column(name = "num_of_buttons")
    private int num_of_buttons = 9;
    /**
     * A fekete játékos hány darab gombot rakott le a táblára.
     */
    @Column(name = "p1_buttons_placed")
    private int p1_buttons_placed;
    /**
     * A fehér játékos hány darab gombot rakott le a táblára.
     */
    @Column(name = "p2_buttons_placed")
    private int p2_buttons_placed;
    /**
     * Az fekete játékos bármelyik üres mezőre elhelyezheti a gombját
     */
    @Column(name = "p1_can_jump")
    private boolean p1_can_jump;
    /**
     * Az fehér játékos bármelyik üres mezőre elhelyezheti a gombját
     */
    @Column(name = "p2_can_jump")
    private boolean p2_can_jump;
    /**
     * A felvett gombot hova helyezheti el a játékos.
     */
    @Column(name = "possible_places")
    private int possible_places;
    /**
     * A következő lépés (1 : a fekete játékos lerak egy gombot, 2 : a fehér játékos lerak egy gombot,
     *                    3 : a fekete játékos felvesz egy gombot, 4: a fekete játékos lerakja a felvett gombot,
     *                    5 : fehér játékos felvesz egy gombot, 6: a fehér játékos lerakja a felvett gombot,
     *                    7 : a fekete játékos elvesz egyet a fehér játékos gombjaiból, 8: a fehér játékos elvesz egyet a fehér játékos gombjaiból).
     */
    @Column(name = "next_step")
    private int next_step = 1;
    /**
     * Mind a 18 gomb le lett helyezve a táblára.
     */
    @Column(name = "all_buttons_placed")
    private boolean all_buttons_placed;
    /**
     * Az előző lépés.
     */
    @Column(name = "prev_click")
    private int prev_click;

    @Column(name = "btn1")
    private int btn1;
    @Column(name = "btn2")
    private int btn2;
    @Column(name = "btn3")
    private int btn3;
    @Column(name = "btn4")
    private int btn4;
    @Column(name = "btn5")
    private int btn5;
    @Column(name = "btn6")
    private int btn6;
    @Column(name = "btn7")
    private int btn7;
    @Column(name = "btn8")
    private int btn8;
    @Column(name = "btn9")
    private int btn9;
    @Column(name = "btn10")
    private int btn10;
    @Column(name = "btn11")
    private int btn11;
    @Column(name = "btn12")
    private int btn12;
    @Column(name = "btn13")
    private int btn13;
    @Column(name = "btn14")
    private int btn14;
    @Column(name = "btn15")
    private int btn15;
    @Column(name = "btn16")
    private int btn16;
    @Column(name = "btn17")
    private int btn17;
    @Column(name = "btn18")
    private int btn18;
    @Column(name = "btn19")
    private int btn19;
    @Column(name = "btn20")
    private int btn20;
    @Column(name = "btn21")
    private int btn21;
    @Column(name = "btn22")
    private int btn22;
    @Column(name = "btn23")
    private int btn23;
    @Column(name = "btn24")
    private int btn24;

    public GameState() {
    }

    public void setPossible_places(int possible_places) {
        this.possible_places = possible_places;
    }

    public int getPossible_places() {
        return possible_places;
    }

    public void setNum_of_buttons(int num_of_buttons){
        this.num_of_buttons = num_of_buttons;
    }
    public int getNum_of_buttons(){
        return num_of_buttons;
    }
    public void setP1_buttons_placed(int p1_buttons_placed) {
        this.p1_buttons_placed = p1_buttons_placed;
    }
    public void setP2_buttons_placed(int p2_buttons_placed) {
        this.p2_buttons_placed = p2_buttons_placed;
    }
    public void setP1_can_jump(boolean p1_can_jump) {
        this.p1_can_jump = p1_can_jump;
    }
    public void setP2_can_jump(boolean p2_can_jump) {
        this.p2_can_jump = p2_can_jump;
    }

    public void setNext_step(int next_step) {
        this.next_step = next_step;
    }
    public void setAll_buttons_placed(boolean all_buttons_placed) {
        this.all_buttons_placed = all_buttons_placed;
    }

    public void setPrev_click(int prev_click) {
        this.prev_click = prev_click;
    }

    public int getP1_buttons_placed() {
        return p1_buttons_placed;
    }
    public int getP2_buttons_placed() {
        return p2_buttons_placed;
    }
    public int getNext_step() {
        return next_step;
    }
    public boolean getP1_can_jump() {
        return p1_can_jump;
    }
    public boolean getP2_can_jump() {
        return p2_can_jump;
    }
    public boolean getAll_buttons_placed() {
        return all_buttons_placed;
    }

    public int getPrev_click() {
        return prev_click;
    }

    public void setBtn1(int btn1) {
        this.btn1 = btn1;
    }
    public void setBtn2(int btn2) {
        this.btn2 = btn2;
    }
    public void setBtn3(int btn3) {
        this.btn3 = btn3;
    }
    public void setBtn4(int btn4) {
        this.btn4 = btn4;
    }
    public void setBtn5(int btn5) {
        this.btn5 = btn5;
    }
    public void setBtn6(int btn6) {
        this.btn6 = btn6;
    }
    public void setBtn7(int btn7) {
        this.btn7 = btn7;
    }
    public void setBtn8(int btn8) {
        this.btn8 = btn8;
    }
    public void setBtn9(int btn9) {
        this.btn9 = btn9;
    }
    public void setBtn10(int btn10) {
        this.btn10 = btn10;
    }
    public void setBtn11(int btn11) {
        this.btn11 = btn11;
    }
    public void setBtn12(int btn12) {
        this.btn12 = btn12;
    }
    public void setBtn13(int btn13) {
        this.btn13 = btn13;
    }
    public void setBtn14(int btn14) {
        this.btn14 = btn14;
    }
    public void setBtn15(int btn15) {
        this.btn15 = btn15;
    }
    public void setBtn16(int btn16) {
        this.btn16 = btn16;
    }
    public void setBtn17(int btn17) {
        this.btn17 = btn17;
    }
    public void setBtn18(int btn18) {
        this.btn18 = btn18;
    }
    public void setBtn19(int btn19) {
        this.btn19 = btn19;
    }
    public void setBtn20(int btn20) {
        this.btn20 = btn20;
    }
    public void setBtn21(int btn21) {
        this.btn21 = btn21;
    }
    public void setBtn22(int btn22) {
        this.btn22 = btn22;
    }
    public void setBtn23(int btn23) {
        this.btn23 = btn23;
    }
    public void setBtn24(int btn24) {
        this.btn24 = btn24;
    }

    public int getBtn1() {
        return btn1;
    }
    public int getBtn2() {
        return btn2;
    }
    public int getBtn3() {
        return btn3;
    }
    public int getBtn4() {
        return btn4;
    }
    public int getBtn5() {
        return btn5;
    }
    public int getBtn6() {
        return btn6;
    }
    public int getBtn7() {
        return btn7;
    }
    public int getBtn8() {
        return btn8;
    }
    public int getBtn9() {
        return btn9;
    }
    public int getBtn10() {
        return btn10;
    }
    public int getBtn11() {
        return btn11;
    }
    public int getBtn12() {
        return btn12;
    }
    public int getBtn13() {
        return btn13;
    }
    public int getBtn14() {
        return btn14;
    }
    public int getBtn15() {
        return btn15;
    }
    public int getBtn16() {
        return btn16;
    }
    public int getBtn17() {
        return btn17;
    }
    public int getBtn18() {
        return btn18;
    }
    public int getBtn19() {
        return btn19;
    }
    public int getBtn20() {
        return btn20;
    }
    public int getBtn21() {
        return btn21;
    }
    public int getBtn22() {
        return btn22;
    }
    public int getBtn23() {
        return btn23;
    }
    public int getBtn24() {
        return btn24;
    }

    /**
     * Visszaállítja a játékot az alap állapotába.
     */
    public void setAll_default() {
        this.num_of_buttons = 9;
        this.p1_buttons_placed = 0;
        this.p2_buttons_placed = 0;
        this.p1_can_jump = false;
        this.p2_can_jump = false;
        this.possible_places = 0;
        this.next_step = 1;
        this.all_buttons_placed = false;
        this.prev_click = 0;
        this.btn1 = 0;
        this.btn2 = 0;
        this.btn3 = 0;
        this.btn4 = 0;
        this.btn5 = 0;
        this.btn6 = 0;
        this.btn7 = 0;
        this.btn8 = 0;
        this.btn9 = 0;
        this.btn10 = 0;
        this.btn11 = 0;
        this.btn12 = 0;
        this.btn13 = 0;
        this.btn14 = 0;
        this.btn15 = 0;
        this.btn16 = 0;
        this.btn17 = 0;
        this.btn18 = 0;
        this.btn19 = 0;
        this.btn20 = 0;
        this.btn21 = 0;
        this.btn22 = 0;
        this.btn23 = 0;
        this.btn24 = 0;
    }

    /**
     * {@code id} alapján visszaküldi a gombok értékt (0=üres mező, 1=fekete játékos gombja van a mezőn, 2=fehér játékos gombja van a mezőn).
     * @param id ez alapján küldi vissza a gombok értékét
     * @return az {@code id}-nak megfelelő gomb értéke
     */
    public int get_val_by_id(int id){
        if(id == 1) return getBtn1();
        else if(id == 2) return getBtn2();
        else if(id == 3) return getBtn3();
        else if(id == 4) return getBtn4();
        else if(id == 5) return getBtn5();
        else if(id == 6) return getBtn6();
        else if(id == 7) return getBtn7();
        else if(id == 8) return getBtn8();
        else if(id == 9) return getBtn9();
        else if(id == 10) return getBtn10();
        else if(id == 11) return getBtn11();
        else if(id == 12) return getBtn12();
        else if(id == 13) return getBtn13();
        else if(id == 14) return getBtn14();
        else if(id == 15) return getBtn15();
        else if(id == 16) return getBtn16();
        else if(id == 17) return getBtn17();
        else if(id == 18) return getBtn18();
        else if(id == 19) return getBtn19();
        else if(id == 20) return getBtn20();
        else if(id == 21) return getBtn21();
        else if(id == 22) return getBtn22();
        else if(id == 23) return getBtn23();
        else if(id == 24) return getBtn24();
        else return -1;
    }

    /**
     * {@code Circle} objektum id-je apaján a neki megfelelő gomb érékét állítja át.
     * @param c ennek a {@code Circle} objektumnak az id-je alapján állítja át a gomb értéket
     * @param val ezt az értéket veszi fel a gomb
     */
    public void set_val_by_id(Circle c, int val){
        if (valueOf(c.getId()) == 1) setBtn1(val);
        else if (valueOf(c.getId()) == 2) setBtn2(val);
        else if (valueOf(c.getId()) == 3) setBtn3(val);
        else if (valueOf(c.getId()) == 4) setBtn4(val);
        else if (valueOf(c.getId()) == 5) setBtn5(val);
        else if (valueOf(c.getId()) == 6) setBtn6(val);
        else if (valueOf(c.getId()) == 7) setBtn7(val);
        else if (valueOf(c.getId()) == 8) setBtn8(val);
        else if (valueOf(c.getId()) == 9) setBtn9(val);
        else if (valueOf(c.getId()) == 10) setBtn10(val);
        else if (valueOf(c.getId()) == 11) setBtn11(val);
        else if (valueOf(c.getId()) == 12) setBtn12(val);
        else if (valueOf(c.getId()) == 13) setBtn13(val);
        else if (valueOf(c.getId()) == 14) setBtn14(val);
        else if (valueOf(c.getId()) == 15) setBtn15(val);
        else if (valueOf(c.getId()) == 16) setBtn16(val);
        else if (valueOf(c.getId()) == 17) setBtn17(val);
        else if (valueOf(c.getId()) == 18) setBtn18(val);
        else if (valueOf(c.getId()) == 19) setBtn19(val);
        else if (valueOf(c.getId()) == 20) setBtn20(val);
        else if (valueOf(c.getId()) == 21) setBtn21(val);
        else if (valueOf(c.getId()) == 22) setBtn22(val);
        else if (valueOf(c.getId()) == 23) setBtn23(val);
        else if (valueOf(c.getId()) == 24) setBtn24(val);
    }

    /**
     * Megszámolja a paraméterül kapott játékosnak hány gombja van elhelyezve a táblán.
     * @param p_val ennek megfelelő játékos gombjait számolja meg
     * @return hány darab gombja van lerakva a játékosnak
     */
    public int count_buttons(int p_val){
        int val = 0;
        for(int i=1; i<=24; i++){
            if(get_val_by_id(i)==p_val) val++;
        }
        return val;
    }
}
