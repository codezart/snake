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

    public void RandomPosition(){
        this.row = (int) (Math.random() * Board.TOTAL_BLOCKS_ROW);
        this.col = (int) (Math.random() * Board.TOTAL_BLOCKS_COL);
        System.out.println(this.row+" -food- "+ this.col);
        //need to check if it clashes with the snake body.....................................................

    }
}
