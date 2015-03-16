import java.util.ArrayList;

// Zu beobachtendes Subject (Publisher)

// Uses the Subject interface to update all Observers
public class SubjectConcreteA implements Subject {

	// Store all subscriber for this Object in ArrayList
	private ArrayList<Subscriber> mySubscriberArray;

	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;

	//
	// Constructor
	//

	public SubjectConcreteA() {

		// Creates an ArrayList to hold all observers
		mySubscriberArray = new ArrayList<Subscriber>();

	}

	//
	// Implementations
	//

	public void register(Subscriber newObserver) {

		// Adds a new observer to the ArrayList
		mySubscriberArray.add(newObserver);

	}

	public void unregister(Subscriber deleteObserver) {

		// Get the index of the observer to delete
		int observerIndex = mySubscriberArray.indexOf(deleteObserver);

		// Print out message (Have to increment index to match)
		System.out.println("Observer " + (observerIndex + 1) + " deleted");

		// Removes observer from the ArrayList
		mySubscriberArray.remove(observerIndex);

	}

	public void notifySubscriber() {

		// Cycle through all observers and notifies them of
		// price changes

		for (Subscriber observer : mySubscriberArray) {
			observer.update(ibmPrice, aaplPrice, googPrice);
		}
	}

	//
	// Change prices for all stocks and notifies observers of changes
	//

	public void setIBMPrice(double newIBMPrice) {

		this.ibmPrice = newIBMPrice;
		notifySubscriber();
		System.out.println("setIBMPrice " + ibmPrice + " Notify my Subscriber");

	}

	public void setAAPLPrice(double newAAPLPrice) {

		this.aaplPrice = newAAPLPrice;
		notifySubscriber();
		System.out.println("setAAPLPrice to: " + aaplPrice
				+ " Notify my Subscriber");

	}

	public void setGOOGPrice(double newGOOGPrice) {

		this.googPrice = newGOOGPrice;
		notifySubscriber();
		System.out.println("setGOOGPrice to: " + googPrice
				+ " Notify my Subscriber");

	}

}