import java.util.Scanner;

/**
 * Created by Trung on 30/1/16.
 */
public class UVa579 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String time = sc.nextLine();
        while (!time.equals("0:00")) {
            String[] splittedTime = time.split(":");
            Double hour = Double.parseDouble(splittedTime[0]);
            Double minute = Double.parseDouble(splittedTime[1]);
            Double hourDegree = hour/12 * 360 + minute/(60*12) * 360;
            Double minuteDegree = minute / 60 * 360;
            Double diff = Math.abs(hourDegree - minuteDegree) < 180 ? Math.abs(hourDegree - minuteDegree) : 360 - Math.abs(hourDegree - minuteDegree);
            System.out.printf("%.3f%n", diff);
            time = sc.nextLine();
        }
    }
}
