
package nochildrenallowed;

public class ChildrenException extends Exception {
    
    public ChildrenException(Person p) {
        super(p.name + " is " + p.age + ". Only adults are allowed!");
    }
}
