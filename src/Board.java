import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Board {

    public static int BOARDHEIGHT = 500;
    public static int BOARDWIDTH = 500;
    public static int BLOCKHEIGHT = 20;
    public static int BLOCKWIDTH = 20;
    public static int TOTAL_BLOCKS_ROW = BOARDHEIGHT/ BLOCKHEIGHT;
    public static int TOTAL_BLOCKS_COL = BOARDWIDTH/ BLOCKWIDTH;
    public ImageView[][] board;
    public Image black_square;
    public Image apple;
    public Image snake_dot;
    public GridPane gridPane = new GridPane();

    public void assign_images(){
        try{
            apple = new Image("images/apple.png");
            snake_dot = new Image("images/dot.png");
            black_square = new Image("images/black_square.png");
        }catch(Exception e){
            System.out.println("Error: related to the address of images");
        }
    }

    public Board(){

        assign_images();

        //initializing the board
        board = new ImageView[TOTAL_BLOCKS_ROW][TOTAL_BLOCKS_COL];
    }

    public void generateBoard(int food_x, int food_y, Snake snake_body) {

        for(int row=0; row< TOTAL_BLOCKS_ROW; row++){
            for(int col=0; col< TOTAL_BLOCKS_COL; col++){

                if(row == food_x && col == food_y)// && check if it is not on snake body)
                    board[row][col] = new ImageView(apple);
                else if( snake_body.is_snake_present(row,col) && col != 0)
                    board[row][col] =  new ImageView(snake_dot);
                else
                    board[row][col] = new ImageView(black_square);

                // Setting the size of each block on the scene
                board[row][col].setFitHeight(BLOCKHEIGHT);
                board[row][col].setFitWidth(BLOCKWIDTH);

                Controller.grid_pane.add(board[row][col], row, col, 1 ,1);
            }
        }

    }





}
