import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Board {

    public static int BOARDHEIGHT = 500;
    public static int BOARDWIDTH = 500;
    public static int BLOCKHEIGHT = 20;
    public static int BLOCKWIDTH = 20;
    public static ImageView[][] board;
    public Image black_square;
    public Image apple;
    public Image snake_dot;
    public GridPane root;

    public Board(GridPane root, int board_height, int board_width){
        try{
             apple = new Image("images/apple.png");
             snake_dot = new Image("images/dot.png");
             black_square = new Image("images/black_square.png");
        }catch(Exception e){
            System.out.println("Error: related to the address of images");
        }

        //initializing the board
        board = new ImageView[50][50];

        //creating food variable and generating random food position.
        Food food = new Food();
        int[] position = food.RandomPosition();
        int food_x = position[0];
        int food_y = position[1];

        Snake snake_body = new Snake(food);
        //creating the board and assigning values on the grid.
        for(int row=0; row< 25; row++){
            for(int col=0; col< 25; col++){

                if(row == food_x && col == food_y)//&& check if it is not on snake body)
                    board[row][col] = new ImageView(apple);
                else if( snake_body.is_snake_present(row,col) && col != 0){
                    board[row][col] =  new ImageView(snake_dot);
                }
                else
                    board[row][col] = new ImageView(black_square);

                board[row][col].setFitHeight(BLOCKHEIGHT);
                board[row][col].setFitWidth(BLOCKWIDTH);
                root.add(board[row][col],row,col,1,1);
            }
        }
        this.root = root;
    }

    public GridPane getGridPane(){
        return root;
    }

}
