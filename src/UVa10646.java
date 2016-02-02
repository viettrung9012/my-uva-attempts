import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Trung on 1/2/16.
 */
public class UVa10646 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        int caseNum = 1;
        while (caseNum <= numCases) {
            int[] cards = new int[52];
            for (int i = 0; i < 52; i++) {
                int cardVal;
                String cardString = sc.next();
                switch(cardString.charAt(0)){
                    case 'T':
                        cardVal = 10;
                        break;
                    case 'J':
                        cardVal = 11;
                        break;
                    case 'Q':
                        cardVal = 12;
                        break;
                    case 'K':
                        cardVal = 13;
                        break;
                    case 'A':
                        cardVal = 14;
                        break;
                    default:
                        cardVal = Integer.parseInt(Character.toString(cardString.charAt(0)));
                        break;
                }
                cardVal -= 2;
                switch(cardString.charAt(1)) {
                    case 'D':
                        cardVal += 13;
                        break;
                    case 'H':
                        cardVal += 26;
                        break;
                    case 'S':
                        cardVal += 39;
                        break;
                    default:
                        break;
                }
                cards[i] = cardVal;
            }
            int pileSize = 52;
            int Y = 0;
            for (int n = 0; n < 3; n++) {
                int X = cards[pileSize - 26];
                if (X % 13 >= 8) {
                    X = 10;
                } else {
                    X = (X % 13) + 2;
                }
                for (int i = 0; i < pileSize - 36 + X; i++) {
                    cards[i] = cards[i];
                }
                for (int i = pileSize - 36 + X; i < pileSize - 11 + X; i++) {
                    cards[i] = cards[i + 11 - X];
                }
                pileSize = pileSize - 11 + X;
                Y += X;
            }
            int cardAtY = cards[Y-1];
            String ans = "AB";
            switch (cardAtY / 13) {
                case 0:
                    ans = ans.replace('B', 'C');
                    break;
                case 1:
                    ans = ans.replace('B', 'D');
                    break;
                case 2:
                    ans = ans.replace('B', 'H');
                    break;
                case 3:
                    ans = ans.replace('B', 'S');
                    break;
                default:
                    break;
            }
            switch (cardAtY % 13) {
                case 8:
                    ans = ans.replace('A', 'T');
                    break;
                case 9:
                    ans = ans.replace('A', 'J');
                    break;
                case 10:
                    ans = ans.replace('A', 'Q');
                    break;
                case 11:
                    ans = ans.replace('A', 'K');
                    break;
                case 12:
                    ans = ans.replace('A', 'A');
                    break;
                default:
                    ans = ans.replace('A', Integer.toString((cardAtY % 13) + 2).charAt(0));
                    break;
            }
            System.out.printf("Case %d: %s%n", caseNum, ans);
            caseNum++;
        }
    }
}
