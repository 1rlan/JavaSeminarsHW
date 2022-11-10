public class Main {
    public static void main(String[] args) {
        System.out.print(factorial(5));
    }
    static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}