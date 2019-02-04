import java.util.Scanner;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int daysToAdd, day, month, year;
        daysToAdd = sc.nextInt();
        day = sc.nextInt();
        month = sc.nextInt();
        year = sc.nextInt();
        while (daysToAdd != 0 && day != 0 && month != 0 && year != 0) {
            Calendar cal = Calendar.getInstance();
            cal.set(year, month - 1, day);
            cal.add(Calendar.DAY_OF_MONTH, daysToAdd);
            System.out.println(cal.get(Calendar.DAY_OF_MONTH) + " " + (cal.get(Calendar.MONTH) + 1) + " " + cal.get(Calendar.YEAR));
            daysToAdd = sc.nextInt();
            day = sc.nextInt();
            month = sc.nextInt();
            year = sc.nextInt();
        }
    }
}
