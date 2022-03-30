import java.util.function.Function;
public class pruebaCompilot {
    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> {
            while(x%2 == 0) {
                x++;
            }
            return x%3 == 0 ? x : -1;
        };

        System.out.println(f.apply(2));
    }
}
