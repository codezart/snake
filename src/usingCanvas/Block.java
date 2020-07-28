package usingCanvas;

public class Block {
    private int row;
    private int col;

    public Block(int col, int row){
        this.row = row;
        this.col = col;
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
        row = (int) (Math.random() * Board.TOTAL_BLOCKS_ROW);
        col = (int) (Math.random() * Board.TOTAL_BLOCKS_COL);
    }
}
