import java.util.Scanner;
import java.util.ArrayList;

class Main {
    static ArrayList<Pair<Integer, Double>> readDepreciationValues(Scanner sc, int numDepreciations) {
        ArrayList<Pair<Integer, Double>> depreciationValues = new ArrayList<Pair<Integer, Double>>();
	for (int i = 0; i < numDepreciations; i++) {
	    Pair<Integer, Double> depreciationValue = new Pair<Integer, Double>(sc.nextInt(), sc.nextDouble());
	    depreciationValues.add(depreciationValue);
	}
	return depreciationValues;
    }
    static double getRemainingLoan(int months, int loanPeriod, double loanAmount) {
        return loanAmount - months * loanAmount / loanPeriod;
    }
    static double getCurrentDepreciationValue(int months, ArrayList<Pair<Integer, Double>> depreciationValues) {
        for (int i = 0; i < depreciationValues.size(); i++) {
	    if (months == depreciationValues.get(i).getFirst()) {
	        return depreciationValues.get(i).getSecond();
	    } else if (months < depreciationValues.get(i).getFirst() && months > depreciationValues.get(i-1).getFirst()) {
	        return depreciationValues.get(i-1).getSecond();
	    }
	}
	return depreciationValues.get(depreciationValues.size() - 1).getSecond();
    }
    static double getCurrentValue(int months, double previousValue, ArrayList<Pair<Integer, Double>> depreciationValues) {
        double currentDepreciationValue = getCurrentDepreciationValue(months, depreciationValues);
        return previousValue * (1 - currentDepreciationValue);	
    }
    static String getStringOutput(int months) {
        return months + (months == 1 ? " month" : " months");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	int loanPeriod = sc.nextInt();
	double downPayment = sc.nextDouble();
	double loanAmount = sc.nextDouble();
	int numDepreciations = sc.nextInt();
	while (loanPeriod >= 0) {
	    ArrayList<Pair<Integer, Double>> depreciationValues = readDepreciationValues(sc, numDepreciations);
		
	    int months = 0;
	    double remainingLoan = getRemainingLoan(months, loanPeriod, loanAmount);
	    double currentValue = getCurrentValue(months, downPayment + loanAmount, depreciationValues);
	    
	    while (remainingLoan > currentValue) {
	        months++;
		remainingLoan = getRemainingLoan(months, loanPeriod, loanAmount);
		currentValue = getCurrentValue(months, currentValue, depreciationValues);
	    }
            
	    System.out.println(getStringOutput(months));

	    loanPeriod = sc.nextInt();
	    downPayment = sc.nextDouble();
	    loanAmount = sc.nextDouble();
	    numDepreciations = sc.nextInt();    
	}
    }
    static class Pair<T, V> {
    	private T first;
	private V second;
	Pair(T first, V second) {
	    this.first = first;
	    this.second = second;
	}
	public T getFirst() {
	    return this.first;
	}
	public V getSecond() {
	    return this.second;
	}
    }
}
