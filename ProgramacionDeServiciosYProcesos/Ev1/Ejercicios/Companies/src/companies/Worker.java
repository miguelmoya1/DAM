package companies;

public class Worker {

    protected String name;
    protected double salary;

    public Worker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Worker setName(String name) {
        this.name = name;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Worker setSalary(double salary) {
        this.salary = salary;
        return this;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name + ", Salary: " + this.salary;
    }    
}
