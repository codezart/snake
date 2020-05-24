import java.util.Random;

public class Food {
    Block food_position;

    public Food(){
       food_position = randomPosition();
    }

    public int getRow() {
        return food_position.getX();
    }

    public void setRow(int row) {
        food_position.setX(row);
    }

    public int getCol() {
        return food_position.getY();
    }

    public void setCol(int col) {
        food_position.setY(col);
    }

    public Block randomPosition(){

        food_position = new Block ((int) (Math.random() * 25), (int) (Math.random() * 25));
        System.out.println(food_position.getX()+" "+ food_position.getY());
        //need to check if it clashes with the snake body.....................................................
        return food_position;
    }
}
