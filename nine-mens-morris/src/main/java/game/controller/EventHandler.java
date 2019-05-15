package game.controller;

import game.model.BoardData;
import game.model.GameState;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Integer.valueOf;

public class EventHandler extends App{

    private static Logger logger = LoggerFactory.getLogger(EventHandler.class);

    public BoardData boardData;
    public GameState gameState;

    public EventHandler(GameState gameState){
        this.gameState = gameState;
        this.boardData = new BoardData(this.gameState);
    }

    public void add_evenet_handler(){
        for(int i=0; i<24; i++){
            new_event_handler((Circle) fxData.getPane().getChildren().get(i));
        }
    }

    public void new_event_handler(Circle circle){
        circle.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            if(gameState.getNext_step() == 1){
                step_1(circle, e);
            } else if (gameState.getNext_step() == 2){
                step_2(circle, e);
            } else if(gameState.getNext_step() == 3) {
                step_3(circle, e);
            } else if(gameState.getNext_step() == 4){
                step_4(circle, e);
            } else if (gameState.getNext_step() == 5) {
                step_5(circle, e);
            } else if(gameState.getNext_step() == 6){
                step_6(circle, e);
            } else if(gameState.getNext_step() == 7){
                step_7(circle, e);
            } else if(gameState.getNext_step() == 8){
                step_8(circle, e);
            }
        });
    }

    public void step_1(Circle circle, MouseEvent e){
        if((gameState.get_val_by_id(valueOf(circle.getId())) == 0) && !gameState.getAll_buttons_placed()){
            place_circle(circle, Color.BLACK, 1);
            gameState.setP1_buttons_placed(gameState.getP1_buttons_placed()+1);
            if (boardData.next_step_is_steal(circle, 1) == true) {
                logger.info("Player1 has to take off a button.");
                gameState.setNext_step(7);
            } else {
                change_style("p2");
                gameState.setNext_step(2);
            }
            logger.info("Player 1 placed his nr. " + gameState.getP1_buttons_placed() + " button, id: " + e.getPickResult().getIntersectedNode().getId());
        } else error();
    }

    public void step_2(Circle circle, MouseEvent e){
        if((gameState.get_val_by_id(valueOf(circle.getId())) == 0) && !gameState.getAll_buttons_placed()) {
            gameState.setP2_buttons_placed(gameState.getP2_buttons_placed()+1);
            if (gameState.getP1_buttons_placed() == gameState.getNum_of_buttons() && gameState.getP2_buttons_placed() == gameState.getNum_of_buttons()) gameState.setAll_buttons_placed(true);
            place_circle(circle, Color.WHITE, 2);
            if (boardData.next_step_is_steal(circle, 2) == true) {
                logger.info("Player2 has to take off a button.");
                gameState.setNext_step(8);
            } else if (gameState.getAll_buttons_placed()){
                change_style("p1");
                gameState.setNext_step(3);
            }
            else {
                change_style("p1");
                gameState.setNext_step(1);
            }
            logger.info("Player 2 placed his nr. " + gameState.getP2_buttons_placed() + " button, id: " + e.getPickResult().getIntersectedNode().getId());
        } else error();
    }

    public void step_3(Circle circle, MouseEvent e){
        if (gameState.get_val_by_id(valueOf(circle.getId())) == 1) {
            gameState.setPrev_click(valueOf(circle.getId()));
            logger.info("Player1 picked up a button");
            place_circle(circle, Color.GRAY, 0);
            if(gameState.getP1_can_jump()) gameState.setPossible_places(25);
            else gameState.setPossible_places(valueOf(circle.getId()));
            gameState.setNext_step(4);
        } else error();
    }

    public void step_4(Circle circle, MouseEvent e){
        if((gameState.get_val_by_id(valueOf(circle.getId())) == 0) && boardData.can_place_here(circle,boardData.b_i[gameState.getPossible_places()])){
            if(gameState.getPrev_click() != valueOf(circle.getId())){
                logger.info("Player1 placed the button");
                place_circle(circle, Color.BLACK, 1);
                if (boardData.next_step_is_steal(circle, 1) == true) {
                    logger.info("Player1 has to take off a button.");
                    gameState.setNext_step(7);
                } else {
                    change_style("p2");
                    gameState.setNext_step(5);
                }
            } else {
                place_circle(circle, Color.BLACK, 1);
                logger.info("Player1 placed the button to the same spot");
                gameState.setNext_step(3);
            }
            gameState.setPrev_click(valueOf(circle.getId()));
        } else error();
    }

    public void step_5(Circle circle, MouseEvent e){
        if (gameState.get_val_by_id(valueOf(circle.getId())) == 2) {
            gameState.setPrev_click(valueOf(circle.getId()));
            logger.info("Player2 picked up a button");
            place_circle(circle, Color.GRAY, 0);
            if(gameState.getP2_can_jump()) gameState.setPossible_places(25);
            else gameState.setPossible_places(valueOf(circle.getId()));
            gameState.setNext_step(6);
        } else error();
    }

    public void step_6(Circle circle, MouseEvent e){
        if ((gameState.get_val_by_id(valueOf(circle.getId())) == 0) && boardData.can_place_here(circle,boardData.b_i[gameState.getPossible_places()])) {
            if(gameState.getPrev_click() != valueOf(circle.getId())){
                logger.info("Player2 placed the button");
                place_circle(circle, Color.WHITE, 2);
                if (boardData.next_step_is_steal(circle, 2) == true) {
                    logger.info("Player2 has to take off a button.");
                    gameState.setNext_step(8);
                } else {
                    change_style("p1");
                    gameState.setNext_step(3);
                }
            } else {
                place_circle(circle, Color.WHITE, 2);
                logger.info("Player2 placed the button to the same spot");
                gameState.setNext_step(5);
            }
            gameState.setPrev_click(valueOf(circle.getId()));
        } else error();
    }

    public void step_7(Circle circle, MouseEvent e){
        if(gameState.get_val_by_id(valueOf(circle.getId())) == 2){
            if((gameState.count_buttons(2) < 4) || (boardData.can_steal_this(circle,2))){
                place_circle(circle,Color.GRAY,0);
                if(gameState.count_buttons(2) < 3 && gameState.getAll_buttons_placed()) {
                    fxData.changeScene(fxData.getEndMenu());
                    logger.info("Player1 won the game.");
                    fxData.getEndMenuText().setText("BLACK WON THE GAME");
                }
                if(gameState.count_buttons(2) < 4) gameState.setP2_can_jump(true);
                if(gameState.getAll_buttons_placed()) gameState.setNext_step(5);
                else gameState.setNext_step(2);
                change_style("p2");
            } else error();
        } else error();
    }

    public void step_8(Circle circle, MouseEvent e){
        if(gameState.get_val_by_id(valueOf(circle.getId())) == 1){
            if((gameState.count_buttons(1) < 4) || (boardData.can_steal_this(circle,1))){
                place_circle(circle,Color.GRAY,0);
                if(gameState.count_buttons(1) < 3 && gameState.getAll_buttons_placed()) {
                    fxData.changeScene(fxData.getEndMenu());
                    logger.info("Player2 won the game.");
                    fxData.getEndMenuText().setText("P2 WON THE GAME");
                }
                if(gameState.count_buttons(1) < 4) gameState.setP1_can_jump(true);
                if(gameState.getAll_buttons_placed()) gameState.setNext_step(3);
                else gameState.setNext_step(1);
                change_style("p1");
            } else error();
        } else error();
    }


    public void place_circle(Circle circle, Color new_fill, int new_val){
        circle.setFill(new_fill);
        gameState.set_val_by_id(circle, new_val);
    }

    public void change_style(String player){
        if(player=="p1") {
            fxData.getP1().setFill(Color.BLACK);
            fxData.getP2().setFill(Color.GRAY);
        } else if (player=="p2"){
            fxData.getP1().setFill(Color.GRAY);
            fxData.getP2().setFill(Color.BLACK);
        }
    }

    public void error(){
        if(gameState.getNext_step() == 1 || gameState.getNext_step() == 4) logger.error("...P1 button place error...");
        else if(gameState.getNext_step() == 2 || gameState.getNext_step() == 6) logger.error("...P2 button place error...");
        else if(gameState.getNext_step() == 3) logger.error("...P1 button pick up error...");
        else if(gameState.getNext_step() == 5) logger.error("...P2 button pick up error...");
        else if(gameState.getNext_step() == 7) logger.error("...P1 button steal error...");
        else if(gameState.getNext_step() == 8) logger.error("...P2 button steal error...");
    }
}
