package listfilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Miguel Moya Ortega
 */
public class ListFilter {

    public static List<Student> getOldestNames(List<Student> list) {
        return list.stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Student> filterStudents(List<Student> srcList, Predicate<Student> predicate) {
        return srcList.stream().filter(predicate).collect(Collectors.toList());
    }

    public static Set<String> getAllSubjects(List<Student> list) {
        return list.stream()
                .map(s -> s.getSubjects())
                .reduce((t, u) -> {
                    t.addAll(u);
                    return t;
                })
                .get()
                .stream()
                .sorted()
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("Miguel", (byte) 22, new ArrayList<>(Arrays.asList("a1", "a2", "a3"))));
        list.add(new Student("Sergio", (byte) 21, new ArrayList<>(Arrays.asList("a3", "a4", "a5"))));
        list.add(new Student("Carla", (byte) 20, new ArrayList<>(Arrays.asList("a9", "a3", "a6"))));

        list.add(new Student("LordPeterena", (byte) 35, new ArrayList<>(Arrays.asList("a1", "a4", "a8"))));
        list.add(new Student("Jose", (byte) 14, new ArrayList<>(Arrays.asList("a1", "a6", "a9"))));
        list.add(new Student("Peter", (byte) 30, new ArrayList<>(Arrays.asList("a2", "a3", "Programming"))));

        list.add(new Student("Andrés", (byte) 12, new ArrayList<>(Arrays.asList("a5", "a6", "a7"))));
        list.add(new Student("Andrea", (byte) 36, new ArrayList<>(Arrays.asList("a9", "Programming", "a2"))));

        List<Student> older = filterStudents(list, ((s) -> s.getAge() > 20));
        List<Student> inscribed = filterStudents(list, ((s) -> s.getSubjects().contains("Programming")));
        List<Student> contains = filterStudents(list, ((s) -> s.getName().contains("Peter")));

        // System.out.println(older);
        System.out.println(getOldestNames(older));

        // System.out.println(inscribed);
        System.out.println(getOldestNames(inscribed));

        // System.out.println(contains);
        System.out.println(getOldestNames(contains));
        
        System.out.println(getAllSubjects(list));

    }
}
