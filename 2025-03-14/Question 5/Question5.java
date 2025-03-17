import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        System.out.print("Input: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print("Output: ");
        for (int i = n / 2; i >= 1; i--) {
            System.out.print(i + " ");
        }
        for (int i = n / 2 + 1; i <= n; i++) {
            System.out.print(i + " ");
        }
    }
}
