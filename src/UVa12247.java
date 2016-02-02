import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.jar.Pack200;

/**
 * Created by Trung on 1/2/16.
 */
public class UVa12247 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cards = new int[5];
        boolean shouldContinue = false;
        for (int i = 0; i < 5; i++) {
            cards[i] = sc.nextInt();
            if (cards[i] != 0) shouldContinue = true;
        }
        while (shouldContinue) {
            int[] princessCards = Arrays.copyOfRange(cards, 0, 3);
            int[] princeCards = Arrays.copyOfRange(cards, 3, 5);
            int[] numPrincessCardsLessThanPrinceCards = new int[2];
            for (int i = 0; i < princeCards.length; i++) {
                int count = 0;
                for (int j = 0; j < princessCards.length; j++) {
                    if (princeCards[i] > princessCards[j]) count++;
                }
                numPrincessCardsLessThanPrinceCards[i] = count;
            }
            int isPossible;
            int ans = -1;
            if (numPrincessCardsLessThanPrinceCards[0] == 3 && numPrincessCardsLessThanPrinceCards[1] == 3) {
                isPossible = 4;
            } else if (numPrincessCardsLessThanPrinceCards[0] == 2 && numPrincessCardsLessThanPrinceCards[1] == 2) {
                isPossible = 3;
            } else if ((numPrincessCardsLessThanPrinceCards[0] == 3 && numPrincessCardsLessThanPrinceCards[1] == 2) ||
                    (numPrincessCardsLessThanPrinceCards[0] == 2 && numPrincessCardsLessThanPrinceCards[1] == 3)) {
                isPossible = 2;
            } else if (numPrincessCardsLessThanPrinceCards[0] == 3 || numPrincessCardsLessThanPrinceCards[1] == 3) {
                isPossible = 1;
            } else {
                isPossible = 0;
            }
            TreeSet<Integer> cardToAvoid = new TreeSet<>();
            for (int i = 0; i < cards.length; i++) {
                cardToAvoid.add(cards[i]);
            }
            if (isPossible == 0) {
                ans = -1;
            } else if (isPossible == 1) {
                int max = princessCards[0];
                for (int i = 1; i < princessCards.length; i++) {
                    if (princessCards[i] > max) max = princessCards[i];
                }
                for (int i = max + 1; i <= 52; i++) {
                    if (!cardToAvoid.contains(i)) {
                        ans = i;
                        break;
                    }
                }
            } else if (isPossible == 2 || isPossible == 3) {
                int max = princessCards[0];
                int secondMax = 0;
                for (int i = 1; i < princessCards.length; i++) {
                    if (princessCards[i] > max){
                        secondMax = max;
                        max = princessCards[i];
                    } else if (princessCards[i] > secondMax) {
                        secondMax = princessCards[i];
                    }
                }
                for (int i = secondMax + 1; i <= 52; i++) {
                    if (!cardToAvoid.contains(i)) {
                        ans = i;
                        break;
                    }
                }
            } else {
                for (int i = 1; i <= 52; i++) {
                    if (!cardToAvoid.contains(i)){
                        ans = i;
                        break;
                    }
                }
            }
            System.out.println(ans);
            shouldContinue = false;
            for (int i = 0; i < 5; i++) {
                cards[i] = sc.nextInt();
                if (cards[i] != 0) shouldContinue = true;
            }
        }
    }
}
