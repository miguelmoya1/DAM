package listfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Miguel Moya Ortega
 */
public class ListFilter {

    public List<Student> filterStudents(List<Student> srcList, Predicate<Student> predicate) {
        predicate.test((Student) srcList);
        return srcList;
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
    }
}

/**
 * The method filterStudents receives a student list and returns another list
 * with only the items which meet the condition defined in the Predicate. A
 * Predicate is a functional interface (included in java 8) that needs to
 * implement a method (boolean test(T t)). Implement it using lambda
 * expressions. In the main method you'll have to create a list of at least 8
 * students, and then, using the method filterStudents generate 3 other lists
 * that only hold students who: 1. Are older than 20. 2. Are inscribed in the
 * “Programming” subject. 3. His name contains “Peter”.
 */
