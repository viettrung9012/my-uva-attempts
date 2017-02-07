import java.util.Scanner;

public class Main {
    static String getResult(double height, double up, double down, double fatigue) {
        double distance = 0;
	int days = 0;
	while (distance <= height && distance >= 0) {
	    double upDistance =  up * (1 - days * fatigue / 100);
	    upDistance = upDistance >= 0 ? upDistance : 0;
	    distance = distance + upDistance;
	    days++;
	    if (distance > height) break;
	    distance = distance - down;
	}
	return (distance > height ? "success on day " : "failure on day ") + days;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	double height, up, down, fatigue;
	height = sc.nextDouble();
	up = sc.nextDouble();
	down = sc.nextDouble();
	fatigue = sc.nextDouble();
	while (height != 0) {
	    System.out.println(getResult(height, up, down, fatigue));
	    height = sc.nextDouble();
	    up = sc.nextDouble();
	    down = sc.nextDouble();
	    fatigue = sc.nextDouble();
	}
    }
}
