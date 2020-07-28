package freshstart;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCode.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Stack;

public class Testing2 extends Application {
    public static Stage primaryStage;
    public static Board board;
    public static GameLoop loop;
    public static GraphicsContext gc;
    public static Snake snake = new Snake();
    public static Food food = new Food(10,10);

    public void start(Stage stage){
        primaryStage = stage;
        primaryStage.setTitle("Practicing Canvas");
        Canvas canvas = new Canvas(board.BOARDWIDTH,board.BOARDHEIGHT);
        Group root = new Group(canvas);
        gc = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(true);

        build();
        Scene scene = new Scene(root, Board.BOARDWIDTH, Board.BOARDHEIGHT);
        scene.setOnKeyPressed(e ->{
            KeyCode kc = e.getCode();
            if(e.getCode() == KeyCode.UP){
                snake.setDirection(Direction.UP);
            }
            else if(e.getCode() == KeyCode.DOWN){
                snake.setDirection(Direction.DOWN);
            }
            else if(e.getCode() == KeyCode.RIGHT){
                snake.setDirection(Direction.RIGHT);
            }
            else if(e.getCode() == KeyCode.LEFT){
                snake.setDirection(Direction.LEFT);
            }
        });
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.show();
        (new Thread(loop)).start();
    }

    public static void build(){

        board = new Board(gc,snake,food);
        loop = new GameLoop(board,gc, snake);
        board.generateBoard();
    }

}
