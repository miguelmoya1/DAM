/**
 * Potion
 */
public class Potion implements IDrink {

    protected int lifes;

    public Potion (int lifes) {
        this.lifes = lifes;
    }

    public void heal() {
        System.out.println("You gain " + this.lifes + " life points!");
    }

    @Override
    public void drink() {
        System.out.println("Glup glup glup. This is a potion!");
    }
}