import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	int cases = sc.nextInt();
	sc.nextLine();
	for (int i = 1; i <= cases; i++) {
	    String speedStr = sc.nextLine();
	    StringTokenizer tokens = new StringTokenizer(speedStr);
	    ArrayList<Integer> speeds = new ArrayList<Integer>();
	    while (tokens.hasMoreTokens()) {
	        speeds.add(Integer.parseInt(tokens.nextToken()));
	    }
	    Collections.sort(speeds);
	    System.out.printf("Case %d: %d\n", i, speeds.get(speeds.size() - 1));
	}
    }
}
