package freshstart;

import java.util.ArrayList;
import java.util.Stack;


public class Snake{
   ArrayList<Block> snakeBody = new ArrayList<>();
   Block head;
   Direction direction = Direction.RIGHT;
   public Block b;
   public Block temp;
   int new_x_position;
   int new_y_position;
   public Snake(){
      int headX = (int) (Math.random()* Board.TOTAL_BLOCKS_COL);
      int headY = (int) (Math.random()* Board.TOTAL_BLOCKS_ROW);
      head = new Block(headX, headY);
      //adds 3 snake body blocks
      snakeBody.add(head);
      snakeBody.add(new Block(headX+1, headY));
      snakeBody.add(new Block(headX+2, headY));

   }
   public Direction getDirection(){ return direction;}
   public void setDirection(Direction direction){ this.direction = direction;}

   //checks if a position is occupied by a snake body part.
   public boolean is_snake_present(int row, int col){
      int index = 0;
      int snake_curr_block_x;
      int snake_curr_block_y;

      while(index < snakeBody.size()){
         snake_curr_block_x = snakeBody.get(index).getCol();
         snake_curr_block_y = snakeBody.get(index).getRow();

         if( snake_curr_block_x == col && snake_curr_block_y == row)
            return true;
         index++;
      }
      return false;
   }

   public void move_RIGHT(){
      new_x_position = head.getCol() + 1;
      new_y_position = head.getRow() ;

      if(!check_if_snake_is_in_bounds(new_x_position, new_y_position))
         return ;

       updateSnakePosition(new_x_position, new_y_position);
   }

   public void move_LEFT(){
      new_x_position = head.getCol() - 1;
      new_y_position = head.getRow() ;

      if(!check_if_snake_is_in_bounds(new_x_position, new_y_position))
         return ;

       updateSnakePosition(new_x_position, new_y_position);
   }
   public void move_UP(){
      new_x_position = head.getCol();
      new_y_position = head.getRow() - 1;

      if(!check_if_snake_is_in_bounds(new_x_position, new_y_position))
         return ;

       updateSnakePosition(new_x_position, new_y_position);

   }
   public void move_DOWN(){
      new_x_position = head.getCol() ;
      new_y_position = head.getRow() + 1;

      if(!check_if_snake_is_in_bounds(new_x_position, new_y_position))
         return ;

       updateSnakePosition(new_x_position, new_y_position);
   }

   public boolean check_if_snake_is_in_bounds(int x, int y){

      return x >= 0 && x <= Board.TOTAL_BLOCKS_COL && y >= 0 && y <= Board.TOTAL_BLOCKS_ROW;
   }

   public void updateSnakePosition(int new_x_position, int new_y_position){
      b = head;
      snakeBody.set(0, new Block(new_x_position, new_y_position));
      head.setCol(new_x_position);
      head.setRow(new_y_position);
      for (int i = 1; i < snakeBody.size(); ++i){
         temp = snakeBody.get(i);
         snakeBody.set(i,b);
         b = temp;
      }
   }

   public void addBody(){
      int lastBodyX = snakeBody.get(snakeBody.size()-1).getCol();
      int lastBodyY = snakeBody.get(snakeBody.size()-1).getRow();
      int secondLastBodyX = snakeBody.get(snakeBody.size()-2).getCol();
      int secondLastBodyY = snakeBody.get(snakeBody.size()-2).getRow();

      int newBodyX, newBodyY;
      if(lastBodyX == secondLastBodyX){
            newBodyX = lastBodyX;
            newBodyY = lastBodyY + 1;
      }
      else if(lastBodyY == secondLastBodyY){
         newBodyY = lastBodyY;
         newBodyX = lastBodyX-1;
      }
      else{
         newBodyX = lastBodyX;
         newBodyY = lastBodyY + 1;
      }
      snakeBody.add(new Block(newBodyX,newBodyY));
   }
   public boolean isEatSelf(){
      int headX = head.getCol();
      int headY = head.getRow();
      int i=1;
      while(i < snakeBody.size()){
         if(headX == snakeBody.get(i).getCol() && headY == snakeBody.get(i).getCol())
            return true;
         ++i;
      }
      return false;
   }
}
