import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Board {

    public static int BOARDHEIGHT = 500;
    public static int BOARDWIDTH = 500;
    public static int BLOCKHEIGHT = BOARDHEIGHT/50;
    public static int BLOCKWIDTH = BOARDWIDTH/50;
    public static ImageView[][] board;
    public Image black_square;
    public GridPane root;

    public Board(GridPane root, int board_height, int board_width){
        try{
            Image apple = new Image("images/apple.png");
            Image snake_dot = new Image("images/dot.png");
            black_square = new Image("images/black_square.png");
            System.out.println("Works 1");
        }catch(Exception e){
            System.out.println("Error: related to the address of images");
        }
        System.out.println("Works 2");

        board = new ImageView[50][50];

        for(int row=0; row< 50; row++){
            for(int col=0; col< 50; col++){

                /*Food food = new Food();
                int[] position = food.RandomPosition();*/
                board[row][col] = new ImageView(black_square);
                root.add(board[row][col],row,col,1,1);
            }
        }

        System.out.println("Works 3");

        this.root = root;
    }

    public GridPane getGridPane(){
        return root;
    }

}
