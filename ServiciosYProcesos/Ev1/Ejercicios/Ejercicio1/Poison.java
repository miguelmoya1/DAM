/**
 * Poison
 */
public class Poison implements IDrink {
    protected int lifes;

    public Poison (int lifes) {
        this.lifes = lifes;
    }

    public void poison() {
        System.out.println("You lose " + lifes + " life points!");
    }

    @Override
    public void drink() {
        System.out.println("Glup glup glup. Oh no! This is poison!");
    }
}