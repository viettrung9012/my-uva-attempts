import java.util.Scanner;

/**
 * Created by Trung on 30/1/16.
 */
public class UVa573 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        while (height != 0) {
            double climbed = 0;
            int days = 0;
            double up = sc.nextDouble();
            int down = sc.nextInt();
            double fatigue = sc.nextDouble()/100;
            double fatigueDistance = up * fatigue;
            while (climbed <= height && climbed >=0) {
                days++;
                climbed += up;
                if (climbed > height) break;
                climbed -= down;
                up -= fatigueDistance;
                if (up < 0) up = 0;
            }
            if (climbed >= height) {
                System.out.printf("success on day %d%n", days);
            } else {
                System.out.printf("failure on day %d%n", days);
            }
            height = sc.nextInt();
        }
    }
}
