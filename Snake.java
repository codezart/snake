import java.util.ArrayList;

public class Snake {
    public ArrayList<Block> snake = new ArrayList<>();
    public int snake_size = snake.size();
    int head_x, head_y;

    public Snake(Food food){
        // initializes a snake head location on board and stores it in a list.
        do{
            head_x = (int) (Math.random()*25);
            head_y = (int) (Math.random()*25);
        }while(food.getRow() == head_x || food.getCol() == head_y);

        //inserting head and a block in snake arraylist
        snake.add(new Block(head_x, head_y));
        snake.add(new Block(head_x - 1, head_y));

    }

    // Adds new body part when snake eats an apple.
    public void add_snake_body() {
        snake.add(retrieve_new_block_position());
    }

    // gets new snake body part position.
    public Block retrieve_new_block_position(){
        int last_block_x = snake.get(snake_size - 1).getX();
        int last_block_y = snake.get(snake_size - 1).getY();
        int second_last_block_x = snake.get(snake_size - 2).getX();
        int second_last_block_y = snake.get(snake_size - 2).getY();
        int new_block_x;
        int new_block_y;

        if(second_last_block_x == last_block_x){
            new_block_x = last_block_x;
            new_block_y = last_block_y - 1;
        }
        else{
            new_block_x = last_block_x - 1;
            new_block_y = last_block_y;
        }
         return new Block(new_block_x, new_block_y);
    }

    //checks if a position is occupied by a snake body part.
    public boolean is_snake_present(int row, int col){
        int index = 0;
        int snake_curr_block_x;
        int snake_curr_block_y;

        while(index < snake.size()){
            snake_curr_block_x = snake.get(index).getX();
            snake_curr_block_y = snake.get(index).getY();

            if( snake_curr_block_x == row && snake_curr_block_y == col)
                return true;
            index++;
        }
        return false;
    }
    //GETTER & SETTER METHODS
    public ArrayList<Block> getSnake() {
        return snake;
    }

    public int getHead_x() {
        return head_x;
    }

    public void setHead_x(int head_x) {
        this.head_x = head_x;
    }

    public int getHead_y() {
        return head_y;
    }

    public void setHead_y(int head_y) {
        this.head_y = head_y;
    }
}
