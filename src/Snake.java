import java.util.ArrayList;
import java.util.logging.Level;

public class Snake {
    public static int LENGTH;
    public ArrayList<ArrayList<Integer>> snake_body = new ArrayList<>();
    public int size = snake_body.size();
    int head_x, head_y;

    public Snake(Food food){
        // initializes a snake head location on board and stores it in a list.
        do{
            head_x = (int) (Math.random()*25);
            head_y = (int) (Math.random()*25);
        }while(food.getRow() == head_x || food.getCol() == head_y);

        //inserting head in snake arraylist
        snake_body.add(new ArrayList<>());
        snake_body.get(0).add(head_x);
        snake_body.get(0).add(head_y);
        //inserting second piece in snake arraylist
        snake_body.add(new ArrayList<>());
        snake_body.get(1).add(head_x - 1);
        snake_body.get(1).add(head_y );
        LENGTH = 2;
    }

    public void add_snake_body() {

        int[] new_piece_position = retrieve_new_piece_position();
        snake_body.add(new ArrayList<>());
        snake_body.get(snake_body.size() - 1).add(new_piece_position[0]);
        snake_body.get(snake_body.size() - 1).add(new_piece_position[1]);
        LENGTH++;

    }

    public int[] retrieve_new_piece_position(){

        int last_piece_x = snake_body.get(size - 1).get(0);
        int last_piece_y = snake_body.get(size - 1).get(1);
        int second_last_piece_x = snake_body.get(size - 2).get(0);
        int second_last_piece_y = snake_body.get(size - 2).get(1);
        int new_piece_x;
        int new_piece_y;

        if(second_last_piece_x == last_piece_x){
            new_piece_x = last_piece_x;
            new_piece_y = last_piece_y - 1;
        }
        else{
            new_piece_x = last_piece_x - 1;
            new_piece_y = last_piece_y;
        }
         return new int[]{new_piece_x, new_piece_y};
    }
    public boolean is_snake_present(int row, int col){
        int index = 0;
        int snake_curr_part_x;
        int snake_curr_part_y;

        while(index <snake_body.size()){
            snake_curr_part_x = snake_body.get(index).get(0);
            snake_curr_part_y = snake_body.get(index).get(1);

            if( snake_curr_part_x == row && snake_curr_part_y == col)
                return true;
            index++;
        }
        return false;
    }
    //GETTER and SETTER METHODS
    public ArrayList<ArrayList<Integer>> getSnake_body() {
        return snake_body;
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
