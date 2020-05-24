public class Movement {
    public Snake snake;

    public Movement(Snake snake){
        this.snake = snake;
    }

    public Snake run() {

            int index = 0;
            int snake_curr_block_x;
            int snake_curr_block_y;

            while(index < snake.snake.size()){
                snake_curr_block_x = snake.snake.get(index).getX();
                snake_curr_block_y = snake.snake.get(index).getY();

                //setting new positions for snake body
                snake.snake.get(index).setX(snake_curr_block_x);
                snake.snake.get(index).setY(snake_curr_block_y + 1);


                index++;
            }

            return snake;
    }

    public void move_left(){

    }
    public void move_right(){

    }
    public void move_up(){

    }
    public void move_down(){

    }
}
