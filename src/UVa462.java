import java.util.Scanner;

/**
 * Created by Trung on 31/1/16.
 */
public class UVa462 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String[] cards = new String[13];
            for (int i = 0; i < cards.length; i++) {
                cards[i] = sc.next();
            }
            int points = 0;
            int[] suitCounts = {0, 0, 0, 0};
            boolean[] stopped = {false, false, false, false};
            String[] suits = {"S", "H", "D", "C"};
            for (int i = 0; i < cards.length; i++) {
                switch(cards[i].charAt(1)) {
                    case 'S':
                        suitCounts[0]++;
                        cards[i] = cards[i].replace('S', '0');
                        break;
                    case 'H':
                        suitCounts[1]++;
                        cards[i] = cards[i].replace('H', '1');
                        break;
                    case 'D':
                        suitCounts[2]++;
                        cards[i] = cards[i].replace('D', '2');
                        break;
                    case 'C':
                        suitCounts[3]++;
                        cards[i] = cards[i].replace('C', '3');
                        break;
                    default:
                        break;
                }
            }
            for (int i = 0; i < cards.length; i++) {
                int suit = Integer.parseInt(cards[i].substring(1));
                switch(cards[i].charAt(0)) {
                    case 'A':
                        points += 4;
                        stopped[suit] = true;
                        break;
                    case 'K':
                        points += 3;
                        if (suitCounts[suit] <= 1) {
                            points -= 1;
                        }
                        if (suitCounts[suit] >= 2) {
                            stopped[suit] = true;
                        }
                        break;
                    case 'Q':
                        points += 2;
                        if (suitCounts[suit] <= 2) {
                            points -= 1;
                        }
                        if (suitCounts[suit] >= 3) {
                            stopped[suit] = true;
                        }
                        break;
                    case 'J':
                        points += 1;
                        if (suitCounts[suit] <= 3) {
                            points -= 1;
                        }
                        break;
                    default:
                        break;
                }
            }
            int additionalPoints = 0;
            for (int i = 0; i < suitCounts.length; i++) {
                switch (suitCounts[i]) {
                    case 0:
                    case 1:
                        additionalPoints += 2;
                        break;
                    case 2:
                        additionalPoints += 1;
                        break;
                    default:
                        break;
                }
            }
            boolean allStopped = true;
            for (int i = 0; i < stopped.length; i++) {
                allStopped &= stopped[i];
            }
            if (points >= 16 && allStopped) {
                System.out.println("BID NO-TRUMP");
            } else if (points + additionalPoints < 14) {
                System.out.println("PASS");
            } else {
                int suitWithMostCards = 0;
                for (int i = 1; i < suitCounts.length; i++) {
                    if (suitCounts[i] > suitCounts[suitWithMostCards]) {
                        suitWithMostCards = i;
                    }
                }
                System.out.println("BID " + suits[suitWithMostCards]);
            }
        }
    }
}
