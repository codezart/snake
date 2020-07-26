public class Movement {
    public Snake snake;
    public static int new_y_position;
    public static int new_x_position;
    public Block b;
    public Block temp;
    public Movement(Snake snake){
        this.snake = snake;
    }
    public Direction dir;

    public Direction getDir(){
        return dir;
    }
    public void setDir(Direction dir){
        this.dir = dir;
    }
    public Snake move_RIGHT(){
        new_x_position = snake.getHead_x() + 1;
        new_y_position = snake.getHead_y();

        if(!check_if_snake_is_in_bounds(new_x_position, new_y_position))
            return null;

        return updateSnakePosition(new_x_position, new_y_position);
    }

    public Snake move_LEFT(){
        new_x_position = snake.getHead_x() - 1;
        new_y_position = snake.getHead_y();

        if(!check_if_snake_is_in_bounds(new_x_position, new_y_position))
            return null;

        return updateSnakePosition(new_x_position, new_y_position);
    }
    public Snake move_UP(){
        new_x_position = snake.getHead_x();
        new_y_position = snake.getHead_y() - 1;

        if(!check_if_snake_is_in_bounds(new_x_position, new_y_position))
            return null;

        return updateSnakePosition(new_x_position, new_y_position);

    }
    public Snake move_DOWN(){
        new_x_position = snake.getHead_x();
        new_y_position = snake.getHead_y() + 1;

        if(!check_if_snake_is_in_bounds(new_x_position, new_y_position))
            return null;

        return updateSnakePosition(new_x_position, new_y_position);
    }

    public boolean check_if_snake_is_in_bounds(int x, int y){

        return x >= 0 && x <= Board.TOTAL_BLOCKS_COL && y >= 0 && y <= Board.TOTAL_BLOCKS_ROW;
    }

    public Snake updateSnakePosition(int new_x_position, int new_y_position){
        b = snake.returnHead();
        snake.snake.set(0, new Block(new_x_position, new_y_position));
        snake.setHead_x(new_x_position);
        snake.setHead_y(new_y_position);
        for (int i = 1; i < snake.snake.size(); ++i){
            temp = snake.snake.get(i);
            snake.snake.set(i,b);
            b = temp;
        }
        return snake;
    }
}
