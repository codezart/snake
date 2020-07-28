package freshstart;


import javafx.scene.canvas.GraphicsContext;

public class GameLoop implements Runnable{
    private final Board board;
    private final GraphicsContext gc;
    private float interval;
    private int frameRate;
    private Snake snake;
    private boolean keyPressed;
    private boolean running;
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
        while(running && !paused){
            float time = System.currentTimeMillis();

            if(snake.getDirection() == Direction.UP)
                 snake.move_UP();
            else if(snake.getDirection() == Direction.DOWN)
                snake.move_DOWN();
            else if(snake.getDirection() == Direction.RIGHT)
                snake.move_RIGHT();
            else if(snake.getDirection() == Direction.LEFT)
                snake.move_LEFT();

            if(snake.isEatSelf())
                running = false;
            
            board.generateBoard();
            if(snake.head.getCol() == Food.foodPosition.getCol() && snake.head.getRow() == Food.foodPosition.getRow())
                snake.addBody();
            System.out.println(snake.snakeBody.size());


            time = System.currentTimeMillis() - time;
            if(time < interval){
                try{
                    Thread.sleep((long)(interval - time));
                }catch(InterruptedException e){}
            }
        }
    }
}
