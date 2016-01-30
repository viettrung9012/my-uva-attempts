import java.util.Scanner;

/**
 * Created by Trung on 30/1/16.
 */
public class UVa11559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int participants = sc.nextInt();
            int budget = sc.nextInt();
            int hotels = sc.nextInt();
            int weeks = sc.nextInt();
            int[] cost = new int[hotels];
            int[][] vacancy = new int[hotels][weeks];
            for (int i = 0; i < hotels; i++) {
                cost[i] = sc.nextInt();
                for (int j = 0; j < weeks; j++) {
                    vacancy[i][j] = sc.nextInt();
                }
            }
            int lowCost = Integer.MAX_VALUE;
            for (int i = 0; i < hotels; i++) {
                for (int j = 0; j < weeks; j++) {
                    if (vacancy[i][j] >= participants && participants * cost[i] <= budget && participants * cost[i] < lowCost) {
                        lowCost = participants * cost[i];
                    }
                }
            }
            if (lowCost < Integer.MAX_VALUE) {
                System.out.println(lowCost);
            } else {
                System.out.println("stay home");
            }
        }
    }
}
