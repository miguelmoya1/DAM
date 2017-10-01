package nochildrenallowed;

public class NoChildrenAllowed {

    public static void main(String[] args) {
        AdultClub club = new AdultClub("Bad things");
        try {
            club.add(new Person("Miguel", 22));
            club.add(new Person("Peter", 38));
            club.add(new Person("Sergio", 12));
            club.add(new Person("Alex", 20));

        } catch (ChildrenException e) {
            System.err.println(e.getMessage());
        }
    }
}
