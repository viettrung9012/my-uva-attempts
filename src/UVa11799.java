import java.util.Scanner;

/**
 * Created by Trung on 30/1/16.
 */
public class UVa11799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        int caseNum = 1;
        while (caseNum <= numCases) {
            int students = sc.nextInt();
            int speed = 0;
            for (int i = 0; i < students; i++) {
                int studentSpeed = sc.nextInt();
                if (studentSpeed > speed) {
                    speed = studentSpeed;
                }
            }
            System.out.printf("Case %d: %d%n", caseNum, speed);
            caseNum++;
        }
    }
}
