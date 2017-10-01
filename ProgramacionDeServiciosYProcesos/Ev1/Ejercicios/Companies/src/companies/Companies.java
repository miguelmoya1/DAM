package companies;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Miguel Moya Ortega
 */
public class Companies {

    public static void main(String[] args) {
        TreeMap<Company, TreeSet<Worker>> map
                = new TreeMap<>((c1, c2) -> c1.name.compareTo(c2.name));

        addKey(map, new Company("Isofocus"));
        addKey(map, new Company("Something"));
        addKey(map, new Company("Awesome"));

        map.forEach((k, v) -> {
            v.add(new Worker("Isofocus", 0.1));
            v.add(new Worker("Awesome", 0.2));
            v.add(new Worker("Isofocus", 0.5));
            v.add(new Worker("Something", 0.3));
        });

        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(t -> System.out.println(t));
        });
    }

    public static void addKey(TreeMap tm, Company c) {
        tm.put(c, new TreeSet<Worker>((w1, w2) -> {
            if ((w1.getSalary() - w2.getSalary()) == 0) {
                return w1.getName().compareTo(w2.getName());
            }
            return (int) (w1.getSalary() - w2.getSalary());
        }));
    }
}
