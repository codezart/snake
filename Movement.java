public class Movement extends Thread {
    public Snake snake;

    public Movement(Snake snake){
        this.snake = snake;
    }

    @Override
    public void run() {
        super.run();
        int i=0;
        while( i < 4 /* Boolean method that checks if the snake eats it's body*/ ){

            int index = 0;
            int snake_curr_block_x;
            int snake_curr_block_y;

            while(index < snake.snake.size()){
                snake_curr_block_x = snake.snake.get(index).getX();
                snake_curr_block_y = snake.snake.get(index).getY();

                //setting new positions for snake body
                snake.snake.get(index).setX(snake_curr_block_x);
                snake.snake.get(index).setY(snake_curr_block_y + 1);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                index++;
            }
            i++;
        run();
        }
    }
}
