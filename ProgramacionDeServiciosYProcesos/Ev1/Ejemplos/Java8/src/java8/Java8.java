/** *
 * @Author: Miguel Moya Ortega
 */
package java8;

import java.util.Arrays;
import java.util.List;

public class Java8 {

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(100, 10, 2, 6, 54, 32, 67, 12, 7);

        lista.forEach(i -> System.out.println(i));

        lista.stream().filter(x -> x > 7).map(Integer::reverse).forEach(System.out::println);

    }
}
