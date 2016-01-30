import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Trung on 30/1/16.
 */
public class UVa11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCase = sc.nextInt();
        int caseNum = 1;
        while (caseNum <= numCase) {
            int[] incomes = new int[3];
            for (int i = 0; i < incomes.length; i++) {
                incomes[i] = sc.nextInt();
            }
            Arrays.sort(incomes);
            System.out.printf("Case %d: %d%n", caseNum, incomes[1]);
            caseNum++;
        }
    }
}
