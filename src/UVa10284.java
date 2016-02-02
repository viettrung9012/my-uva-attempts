import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Trung on 2/2/16.
 */
public class UVa10284 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String inputStr = sc.next();
            String[] inputs = inputStr.split("/");
            int[][] board = new int[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    board[i][j] = 1;
                }
            }
            ArrayList<String> pieces = new ArrayList<>();
            ArrayList<Integer> pX = new ArrayList<>();
            ArrayList<Integer> pY = new ArrayList<>();
            for (int i = 0; i < inputs.length; i++) {
                String des = inputs[i];
                int curY = i;
                int curX = 0;
                for (int j = 0; j < des.length(); j++) {
                    if ('0' <= des.charAt(j) && des.charAt(j) <= '9') {
                        int advanceX = Integer.parseInt(Character.toString(des.charAt(j)));
                        curX += advanceX;
                    } else {
                        pieces.add(Character.toString(des.charAt(j)));
                        pX.add(curX);
                        pY.add(curY);
                        board[curY][curX] = -1;
                        curX++;
                    }
                }
            }
            for (int i = 0; i < pieces.size(); i++) {
                switch (pieces.get(i)) {
                    case "p":
                        int[] bprows = { 1, 1};
                        int[] bpcols = {-1, 1};
                        board = checkMove(board, pY.get(i), pX.get(i), bprows, bpcols, 1);
                        break;
                    case "P":
                        int[] wprows = {-1, -1};
                        int[] wpcols = {-1,  1};
                        board = checkMove(board, pY.get(i), pX.get(i), wprows, wpcols, 1);
                        break;
                    case "n":
                    case "N":
                        int[] nrows = {-2, -2, -1, -1,  1,  1,  2,  2};
                        int[] ncols = {-1,  1, -2,  2, -2,  2, -1,  1};
                        board = checkMove(board, pY.get(i), pX.get(i), nrows, ncols, 1);
                        break;
                    case "b":
                    case "B":
                        int[] brows = {-1, -1,  1,  1};
                        int[] bcols = {-1,  1, -1,  1};
                        board = checkMove(board, pY.get(i), pX.get(i), brows, bcols, 8);
                        break;
                    case "r":
                    case "R":
                        int[] rrows = {-1,  0,  1,  0};
                        int[] rcols = { 0, -1,  0,  1};
                        board = checkMove(board, pY.get(i), pX.get(i), rrows, rcols, 8);
                        break;
                    case "q":
                    case "Q":
                        int[] qrows = {-1, -1, -1, 0, 1, 1,  1,  0};
                        int[] qcols = {-1,  0,  1, 1, 1, 0, -1, -1};
                        board = checkMove(board, pY.get(i), pX.get(i), qrows, qcols, 8);
                        break;
                    case "k":
                    case "K":
                        int[] krows = {-1, -1, -1, 0, 1, 1,  1,  0};
                        int[] kcols = {-1,  0,  1, 1, 1, 0, -1, -1};
                        board = checkMove(board, pY.get(i), pX.get(i), krows, kcols, 1);
                        break;
                    default:
                        break;

                }
            }
            int count = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] > 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static int[][] checkMove(int[][] board, int yPos, int xPos, int[] rows, int[] cols, int maxMultiplier) {
        int multiplier = 1;
        boolean[] ignored = new boolean[rows.length];
        for (int i = 0; i < rows.length; i++){
            ignored[i] = false;
        }
        boolean allIgnored = ignored[0];
        while (!allIgnored && multiplier <= maxMultiplier) {
            for (int j = 0; j < ignored.length; j++) {
                if (!ignored[j]) {
                    int nextY = yPos + multiplier * rows[j];
                    int nextX = xPos + multiplier * cols[j];
                    if (nextY < 0 || nextY > 7 || nextX < 0 || nextX > 7 || board[nextY][nextX] < 0) {
                        ignored[j] = true;
                    } else {
                        board[nextY][nextX] = 0;
                    }
                }
            }
            multiplier++;
            for (int j = 1; j < ignored.length; j++) {
                allIgnored &= ignored[j];
            }
        }
        return board;
    }
}
