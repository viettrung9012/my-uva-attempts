import java.util.Scanner;

/**
 * Created by Trung on 30/1/16.
 */
public class UVa11172 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- > 0) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            if (left <= right) {
                if (left < right) {
                    System.out.println("<");
                } else {
                    System.out.println("=");
                }
            } else {
                System.out.println(">");
            }
        }
    }
}
