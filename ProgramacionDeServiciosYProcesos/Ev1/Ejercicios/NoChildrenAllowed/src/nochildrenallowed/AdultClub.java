package nochildrenallowed;

import java.util.ArrayList;

public class AdultClub {

    String name;
    ArrayList<Person> persons;

    public AdultClub(String name) {
        this.name = name;
        this.persons = new ArrayList<>();
    }

    public AdultClub add(Person p) throws ChildrenException {
        if (p.age < 18) throw new ChildrenException(p);
        this.persons.add(p);
        return this;
    }
    
    public AdultClub remove(Person p) {
        this.persons.remove(p);
        return this;
    }
    
    public boolean isMember(Person p) {
        return this.persons.contains(p);
    }
}
