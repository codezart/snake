import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.sleep;


public class Main extends Application {
    public Controller game;
    public static int SNAKE_SPEED = 200;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Snake Game");
        game = new Controller();
        primaryStage.setScene(game.scene);
        primaryStage.show();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    game.run_game();

                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                        });

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();


    }


    public static void main(String[] args) { launch(args); }


}
