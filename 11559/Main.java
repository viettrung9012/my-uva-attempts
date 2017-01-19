import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Comparable;
import java.util.Collections;

class Main {
    static boolean hasEnoughRoom(Hotel hotel, int numPeople) {
        for (int i = 0; i < hotel.getNumAvailableRooms().size(); i++) {
	    if (hotel.getNumAvailableRooms().get(i) >= numPeople) return true;
	}
	return false;
    }
    static String getLowestCost(int numPeople, int budget, ArrayList<Hotel> hotels) {
        Collections.sort(hotels);
	int lowestCost = -1;
	for (int i = 0; i < hotels.size(); i++) {
	    int cost = hotels.get(i).getPrice() * numPeople;
	    if (cost > budget) break;
	    if (!hasEnoughRoom(hotels.get(i), numPeople)) continue;
	    if (lowestCost == -1 || cost < lowestCost) lowestCost = cost;
	}
	return lowestCost == -1 ? "stay home" : (lowestCost + "");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	while (sc.hasNext()) {
	    int numPeople = sc.nextInt();
	    int budget = sc.nextInt();
	    int numHotels = sc.nextInt();
	    int numWeeks = sc.nextInt();
	    ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	    for (int i = 0; i < numHotels; i++) {
	        int price = sc.nextInt();
		ArrayList<Integer> numAvailableRooms = new ArrayList<Integer>();
		for (int j = 0; j < numWeeks; j++) {
		    numAvailableRooms.add(sc.nextInt());
		}
		hotels.add(new Hotel(price, numAvailableRooms));
	    }
	    System.out.println(getLowestCost(numPeople, budget, hotels));
	}
    }
    static class Hotel implements Comparable<Hotel> {
        private int price;
	private ArrayList<Integer> numAvailableRooms;
	Hotel(int price, ArrayList<Integer> numAvailableRooms) {
	    this.price = price;
	    this.numAvailableRooms = numAvailableRooms;
	}
	public int getPrice() {
	    return this.price;
	}
	public ArrayList<Integer> getNumAvailableRooms() {
	    return this.numAvailableRooms;
	}
	public int compareTo(Hotel other) {
	    return this.price - other.getPrice();
	}
    }
} 
