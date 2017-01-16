import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseNum = sc.nextInt();
        while (testCaseNum > 0) {
            int firstNum = sc.nextInt();
            int secondNum = sc.nextInt();
            if (firstNum > secondNum) {
                System.out.println(">");
            } else if (firstNum < secondNum) {
                System.out.println("<");
            } else {
                System.out.println("=");
            }
            testCaseNum--;
        }
    }
}
