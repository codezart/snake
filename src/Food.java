import java.util.Random;

public class Food {
    int row;
    int col;

    public Food(){

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int[] RandomPosition(){
        this.row = (int) (Math.random() * 25);
        this.col = (int) (Math.random() * 25);
        System.out.println(this.row+" "+ this.col);
        //need to check if it clashes with the snake body
        int[] position = {row,col};
        return position;
    }
}
