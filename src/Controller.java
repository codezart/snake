
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.TimerTask;


public class Controller {
    public Snake snake;
    public Board board;
    public Food food;
    public Movement move;
    public static GridPane grid_pane;
    public Scene scene;
    public UserInput userInput;
    public Direction direction;

    // Creating all the necessary instances of snake game
    public Controller() throws InterruptedException {
        food = new Food();
        grid_pane = new GridPane();
        //assigning a random food position to the food apple
        assign_random_position_to_food();
        snake = new Snake(food);
        board = new Board();
        move = new Movement(snake);
        board.generateBoard(food.row, food.col, snake);
        userInput = new UserInput(snake, move);
        Parent root = grid_pane;
        scene = new Scene(root, Board.BOARDHEIGHT,Board.BOARDWIDTH);
        scene.setOnKeyPressed(userInput);


    }

    public void run_game() throws InterruptedException {

        if(move.getDir() == Direction.UP){ move.move_UP(); }
        if(move.getDir() == Direction.DOWN){ move.move_DOWN(); }
        if(move.getDir() == Direction.RIGHT){ move.move_RIGHT(); }
        if(move.getDir() == Direction.LEFT){ move.move_LEFT(); }
        if(snake == null){
            System.out.println("gameover!!");
            return;
        }

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                board.generateBoard(food.row, food.col, snake);
                scene.setRoot(grid_pane);
            }
        });

    }
    public void assign_board_to_grid(){
        for ( int row = 0; row < board.board.length; ++row)
            for( int col = 0; col < board.board[row].length; ++col )
                grid_pane.add(board.board[row][col], row, col, 1, 1);
    }
    public void assign_random_position_to_food(){
        food.RandomPosition();
    }

}
