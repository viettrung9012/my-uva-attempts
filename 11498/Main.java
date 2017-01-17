import java.util.Scanner;

class Main {
    static String getLocation(Point center, Point house) {
    	if (house.isBorderLine(center)) {
	    return "divisa";
	} else if (house.isNorthOf(center)) {
	    if (house.isEastOf(center)) {
	        return "NE";
	    } else {
	        return "NO";
	    }
	} else {
	    if (house.isEastOf(center)) {
	        return "SE";
	    } else {
	        return "SO";
	    }
	}
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	int numQueries = sc.nextInt();
	while (numQueries > 0) {
	    Point center = new Point(sc.nextInt(), sc.nextInt());
	    for (int i = 0; i < numQueries; i++) {
	        System.out.println(getLocation(center, new Point(sc.nextInt(), sc.nextInt())));
	    }
	    numQueries = sc.nextInt();
	}
    }
    static class Point {
    	private int x;
	private int y;
	Point(int x, int y) {
	    this.x = x;
	    this.y = y;
	}
	int getX() { 
		return x;
	}
	int getY() { 
		return y;
	}
	boolean isBorderLine(Point other) {
	    return other.getX() == this.x || other.getY() == this.y;
	}
	boolean isNorthOf(Point other) {
	    return other.getY() < this.y;
	}
	boolean isEastOf(Point other) {
	    return other.getX() < this.x;
	}
    }
}
