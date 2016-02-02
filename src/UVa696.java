import java.util.Scanner;

/**
 * Created by Trung on 2/2/16.
 */
public class UVa696 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        while (rows != 0 || cols != 0) {
            int ans;
            if (rows == 0 || cols == 0) {
                ans = 0;
            } else if (rows == 1 || cols == 1) {
                if (rows == 1) {
                    ans = cols;
                } else {
                    ans = rows;
                }
            } else if (rows == 2 || cols == 2) {
                int tmpRows = rows;
                int tmpCols = cols;
                if (cols == 2) {
                    tmpRows = cols;
                    tmpCols = rows;
                }
                if (tmpCols % 4 == 0) {
                    ans = (tmpCols / 4) * 4;
                } else if (tmpCols % 4 == 1) {
                    ans = (tmpCols / 4) * 4 + 2;
                } else {
                    ans = (tmpCols / 4) * 4 + 4;
                }
            } else {
                ans = rows * cols % 2 == 0 ? rows * cols / 2 : rows * cols / 2 + 1;
            }
            System.out.printf("%d knights may be placed on a %d row %d column board.%n", ans, rows, cols);
            rows = sc.nextInt();
            cols = sc.nextInt();
        }
    }
}
