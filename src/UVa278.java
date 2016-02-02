import java.util.Scanner;

/**
 * Created by Trung on 2/2/16.
 */
public class UVa278 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        while (numCases > 0) {
            String chessPiece = sc.next();
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int ans = 0;
            switch (chessPiece) {
                case "k":
                    ans = rows * cols % 2 == 0 ? rows * cols / 2 : rows * cols / 2 + 1;
                    break;
                case "r":
                case "Q":
                    ans = rows < cols ? rows : cols;
                    break;
                case "K":
                    ans = (rows % 2 == 0 ? rows / 2 : rows / 2 + 1) * (cols % 2 == 0 ? cols / 2 : cols / 2 + 1);
                    break;
                default:
                    break;
            }
            System.out.println(ans);
            numCases--;
        }
    }
}
