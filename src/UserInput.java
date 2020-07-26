import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import static javafx.scene.input.KeyCode.*;

public class UserInput implements EventHandler<KeyEvent> {
    public Snake snake;
    public Movement movement;
    public UserInput(Snake snake, Movement movement){
        this.snake = snake;
        this.movement = movement;
    }

    @Override
    public void handle(KeyEvent key) {
        if(key.getCode() == UP){
            if(movement.dir == Direction.DOWN) {

            }else{
                movement.setDir(Direction.UP);
            }
        }
        if (key.getCode() == DOWN){
            if(movement.dir == Direction.UP) {

            }else{
                movement.setDir(Direction.DOWN);
            }
        }
        if(key.getCode() == RIGHT){
            if(movement.dir == Direction.LEFT) {

            }else{
                movement.setDir(Direction.RIGHT);
            }
        }
        if (key.getCode() == LEFT){
            if(movement.dir == Direction.RIGHT) {

            }else{
                movement.setDir(Direction.LEFT);
            }
        }

    }
}
