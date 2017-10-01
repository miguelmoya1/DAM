package companies;

public class Company {
    protected String name;
    
    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name;
    }
}
