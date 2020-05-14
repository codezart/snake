import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Snake Game");

        GridPane root = new GridPane();
        Board map = new Board(root, Board.BOARDWIDTH,Board.BOARDHEIGHT);
        primaryStage.setScene(new Scene(map.getGridPane(), Board.BOARDHEIGHT, Board.BOARDWIDTH));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
