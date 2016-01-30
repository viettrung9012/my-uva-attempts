import java.util.Scanner;

/**
 * Created by Trung on 30/1/16.
 */
public class UVa11498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numQuery = sc.nextInt();
        while (numQuery != 0) {
            int originX = sc.nextInt();
            int originY = sc.nextInt();
            while (numQuery > 0) {
                int locX = sc.nextInt();
                int locY = sc.nextInt();
                if (locX == originX || locY == originY) {
                    System.out.println("divisa");
                } else if (locX < originX & locY < originY) {
                    System.out.println("SO");
                } else if (locX < originX) {
                    System.out.println("NO");
                } else if (locX > originX & locY > originY) {
                    System.out.println("NE");
                } else {
                    System.out.println("SE");
                }
                numQuery--;
            }
            numQuery = sc.nextInt();
        }
    }
}
