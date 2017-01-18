import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    static int getMiddleValue(ArrayList<Integer> values) {
        Collections.sort(values);
	return values.get(1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
	for (int i = 1; i <= numCases; i++) {
	    ArrayList<Integer> salaries = new ArrayList<Integer>();
	    salaries.add(sc.nextInt());
	    salaries.add(sc.nextInt());
	    salaries.add(sc.nextInt());
	    System.out.printf("Case %d: %d\n", i, getMiddleValue(salaries));
	}
    }
}
