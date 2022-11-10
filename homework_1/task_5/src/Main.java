
import java.util.Scanner;

// Программа работает с английскими строками

public class Main {

    public static void main(String[] args) {
        countAndPrint((new Scanner(System.in)).nextLine());
    }

    static void countAndPrint(String str) {
        int vowelCounter = 0, consonantCounter = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (!Character.isLetter(str.charAt(i))) {
                continue;
            }
            if (isVowel(str.charAt(i))) {
                ++vowelCounter;
            } else {
                ++consonantCounter;
            }
        }
        System.out.println(String.format("В строке %d гласных и %d согласных", vowelCounter, consonantCounter));
    }

    static boolean isVowel(char c)
    {
        return (c == 'a' || c == 'A' || c== 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U');
    }
}