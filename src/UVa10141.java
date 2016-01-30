import java.util.Scanner;

/**
 * Created by Trung on 30/1/16.
 */
public class UVa10141 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int requirements = sc.nextInt();
        int proposals = sc.nextInt();
        int rfpNum = 1;
        while (requirements != 0 && proposals != 0) {
            sc.nextLine();
            for (int i = 0; i < requirements; i++) {
                sc.nextLine();
            }
            String[] proposalList = new String[proposals];
            double[] priceList = new double[proposals];
            int[] requirementMet = new int[proposals];
            for (int i = 0; i < proposals; i++) {
                proposalList[i] = sc.nextLine();
                priceList[i] = sc.nextDouble();
                requirementMet[i] = sc.nextInt();
                sc.nextLine();
                for (int j = 0; j < requirementMet[i]; j++) {
                    sc.nextLine();
                }
            }
            int indexOfChoice = 0;
            for (int i = 1; i < proposals; i++) {
                if (requirementMet[i] > requirementMet[indexOfChoice]) {
                    indexOfChoice = i;
                } else if (requirementMet[i] == requirementMet[indexOfChoice] && priceList[i] < priceList[indexOfChoice]) {
                    indexOfChoice = i;
                }
            }
            if (rfpNum > 1) {
                System.out.println();
            }
            System.out.printf("RFP #%d%n", rfpNum);
            System.out.println(proposalList[indexOfChoice]);
            requirements = sc.nextInt();
            proposals = sc.nextInt();
            rfpNum++;
        }
    }
}
