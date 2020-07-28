package freshstart;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Board {
    public static int BOARDHEIGHT = 500;
    public static int BOARDWIDTH = 500;
    public static int BLOCKHEIGHT = 10;
    public static int BLOCKWIDTH = 10;
    public static int TOTAL_BLOCKS_ROW = BOARDHEIGHT/ BLOCKHEIGHT;
    public static int TOTAL_BLOCKS_COL = BOARDWIDTH/ BLOCKWIDTH;

    // color options for FOOD, snake, block respectively
    public Color red = Color.RED;
    public Color white = Color.WHITESMOKE;
    public Color black = Color.BLACK;

    public GraphicsContext gc;
    public Snake snake;
    public Food food;
    public Color[][] board = new Color[TOTAL_BLOCKS_ROW][TOTAL_BLOCKS_COL];

    public Board(GraphicsContext gc, Snake snake, Food food){
        this.gc = gc;
        this.snake = snake;
        this.food = food;
    }
    public void generateBoard(){
        for(int row=0; row< TOTAL_BLOCKS_ROW; row++){
            for(int col=0; col< TOTAL_BLOCKS_COL; col++){

                if(row == food.getFoodPosition().getRow() && col == food.getFoodPosition().getCol()){
                    board[row][col] = red;
                    gc.setFill(board[row][col]);
                    gc.fillRect(col *BLOCKWIDTH,row*BLOCKWIDTH,BLOCKWIDTH, BLOCKHEIGHT);
                }
                else if( col !=0 && snake.is_snake_present(row,col) ){
                    board[row][col] =  white;
                    gc.setFill(board[row][col]);
                    gc.fillRect(col*BLOCKWIDTH,row*BLOCKWIDTH,BLOCKWIDTH, BLOCKHEIGHT);
                }
                else{
                    board[row][col] = black;
                    gc.setFill(board[row][col]);
                    gc.fillRect(col*BLOCKWIDTH,row*BLOCKWIDTH,BLOCKWIDTH, BLOCKHEIGHT);
                }
            }
        }
    }


}
