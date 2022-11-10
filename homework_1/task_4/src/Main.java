import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 6, 2, 8, 4, 8, 0, 1, 3, 5, 6, 7};
        System.out.println(Arrays.stream(bubbleSort(array)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    static int[] bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}

