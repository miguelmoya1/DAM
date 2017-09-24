import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        List<IDrink> list = new ArrayList<>();
        Random random = new Random();

        list.add(new Potion(random.nextInt(10)));
        list.add(new Potion(random.nextInt(10)));
        list.add(new Potion(random.nextInt(10)));

        list.add(new Poison(random.nextInt(10)));
        list.add(new Poison(random.nextInt(10)));
        list.add(new Poison(random.nextInt(10)));

        list.add(new IDrink() {
            @Override
            public void drink() {
                System.out.println("Glup glup glup. mmmm... Goat's pee!");
            }
        });
        list.add(new IDrink() {
            @Override
            public void drink() {
                System.out.println("Glup glup glup. Orange juice!!");
            }
        });
        Collections.shuffle(list);
        list.forEach(item -> {
            item.drink();
            if (item instanceof Potion)
                ((Potion) item).heal();
            else if (item instanceof Poison)
                ((Poison) item).poison();
        });
    }
    
}


