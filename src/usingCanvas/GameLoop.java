package usingCanvas;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameLoop implements Runnable{
    private final Board board;
    private final GraphicsContext gc;
    private float interval;
    private int frameRate;
    private Snake snake;
    private boolean keyPressed;
    private static boolean running;
    private boolean paused;

    public GameLoop(Board board, GraphicsContext gc , Snake snake) {
        this.board = board;
        this.snake = snake;
        this.gc = gc;
        frameRate = 20;
        interval = 1000.0f/frameRate;
        running = true;
        paused = false;
        keyPressed = false;
    }

    @Override
    public void run() throws IllegalArgumentException{
        while(running){
            float time = System.currentTimeMillis();

            if(snake.getDirection() == Direction.UP){
                running =  snake.move_UP();
                System.out.println("due to moveup"+running);
            }
            else if(snake.getDirection() == Direction.DOWN){
                running =  snake.move_DOWN();
                System.out.println("due to moveDOWN"+running);
            }
            else if(snake.getDirection() == Direction.RIGHT){
                running =  snake.move_RIGHT();
                System.out.println("due to moveRIGHT"+running);
            }
            else if(snake.getDirection() == Direction.LEFT){
                running =  snake.move_LEFT();
                System.out.println("due to moveLEFT"+running);
            }

            if(snake.isEatSelf()){
                running = false;
                System.out.println("due to snake eatself"+running);
            }

            if(snake.head.getCol() == Food.foodPosition.getCol() && snake.head.getRow() == Food.foodPosition.getRow()){
                snake.addBody();
                Food.foodPosition.RandomPosition();
            }
            System.out.println(snake.snakeBody.size());

            board.generateBoard();
            time = System.currentTimeMillis() - time;
            if(time < interval){
                try{
                    Thread.sleep((long)(interval - time));
                }catch(InterruptedException e){}
            }
        }
        System.out.println("GAME OVER!");
        gc.setFill(Color.CHOCOLATE);
        gc.fillText("GAME OVER!",20*Board.BLOCKWIDTH,20*Board.BLOCKWIDTH);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);

    }
}
