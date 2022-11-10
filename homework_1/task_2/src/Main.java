import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        fibonacci(10);
    }

    static void fibonacci(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i <= 1) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
        System.out.print(Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}