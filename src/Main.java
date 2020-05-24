import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Main extends Application {
    public static Board map;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Snake Game");

        GridPane root = new GridPane();
        map = new Board(root, Board.BOARDWIDTH, Board.BOARDHEIGHT);
        Scene scene = new Scene(root, Board.BOARDHEIGHT, Board.BOARDWIDTH);
        primaryStage.setScene(scene);
        primaryStage.show();
        for (int i=0; i<10; i++)
            gameLoop(primaryStage, map.getGridPane(), scene);


    }

    public static void gameLoop(Stage primaryStage, GridPane root, Scene scene){
        scene.setRoot(root);
        primaryStage.setScene(scene);
        map.startGame(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
