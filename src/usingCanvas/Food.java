package freshstart;

public class Food {
    static Block foodPosition;
    public Food(int row, int col) {
        foodPosition = new Block(row, col);
    }
    public void RandomPosition(){ foodPosition.RandomPosition(); }
    public Block getFoodPosition(){ return foodPosition;}
}
