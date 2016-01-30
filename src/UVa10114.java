import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Trung on 30/1/16.
 */
public class UVa10114 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int months = sc.nextInt();
        while (months > 0) {
            double downPayment = sc.nextDouble();
            double loan = sc.nextDouble();
            double monthlyLoanPayment = loan/months;
            int depreciationRecords = sc.nextInt();
            HashMap<Integer, Double> record = new HashMap<>();
            for (int i = 0; i < depreciationRecords; i++) {
                record.put(sc.nextInt(), sc.nextDouble());
            }
            int curMonth = 0;
            double curDepRate = record.get(0);
            double carValue = (downPayment + loan) * (1 - curDepRate);
            while (loan > carValue) {
                curMonth++;
                loan = loan - monthlyLoanPayment;
                if (record.containsKey(curMonth)) {
                    curDepRate = record.get(curMonth);
                }
                carValue = carValue * (1 - curDepRate);
            }
            if (curMonth != 1) {
                System.out.println(curMonth + " months");
            } else {
                System.out.println(curMonth + " month");
            }
            months = sc.nextInt();
        }
    }
}
