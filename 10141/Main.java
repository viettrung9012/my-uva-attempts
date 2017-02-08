import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	int reqs = sc.nextInt();
	int numProposals = sc.nextInt();
	int nthProposal = 1;
	while (reqs != 0 && numProposals != 0) {
	    sc.nextLine();
	    Proposal acceptedProposal = new Proposal(null, Double.MAX_VALUE, Integer.MIN_VALUE);
	    for (int i = 0; i < reqs; i++) {
	        sc.nextLine();
	    }
	    for (int i = 0; i < numProposals; i++) {
	        String proposalName = sc.nextLine();
		double price = sc.nextDouble();
		int fulfilledReq = sc.nextInt();
		Proposal newProposal = new Proposal(proposalName, price, fulfilledReq);
		if (acceptedProposal.getName() == null) {
		    acceptedProposal = newProposal;
		} else if (newProposal.getFulfilledReq() > acceptedProposal.getFulfilledReq()) {
		    acceptedProposal = newProposal;
		} else if (newProposal.getFulfilledReq() == acceptedProposal.getFulfilledReq() && newProposal.getPrice() < acceptedProposal.getPrice()) {
		    acceptedProposal = newProposal;
		}
		sc.nextLine();
		for (int j = 0; j < fulfilledReq; j++) {
		    sc.nextLine();
		}
	    }
	    if (nthProposal > 1) {
	        System.out.println();
	    }
	    System.out.println("RFP #" + nthProposal);
	    System.out.println(acceptedProposal.getName());
	    nthProposal++;
	    reqs = sc.nextInt();
	    numProposals = sc.nextInt();
	}
    }
    static class Proposal {
        private String name;
	private double price;
	private int fulfilledReq;
	public Proposal(String name, double price, int fulfilledReq) {
	    this.name = name;
	    this.price = price;
	    this.fulfilledReq = fulfilledReq;
	}
	public String getName() {
	    return this.name;
	}
	public int getFulfilledReq() {
	    return this.fulfilledReq;
	}
	public double getPrice() {
	    return this.price;
	}
    }
}
