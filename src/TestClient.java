public class TestClient {

	public static void main(String[] args) {

		// Create the Subject object
		// It will handle updating all observers
		// as well as deleting and adding them

		SubjectConcreteA stockGrabber = new SubjectConcreteA();

		// Create an Observer that will be sent updates from Subject

		//
		// Observer 1
		//

		SubscriberConcreteA observer1 = new SubscriberConcreteA(stockGrabber);

		stockGrabber.setIBMPrice(197.00);
		stockGrabber.setAAPLPrice(677.60);
		stockGrabber.setGOOGPrice(676.40);

		//
		// Observer 2
		//

		SubscriberConcreteA observer2 = new SubscriberConcreteA(stockGrabber);

		stockGrabber.setIBMPrice(197.00);
		stockGrabber.setAAPLPrice(677.60);
		stockGrabber.setGOOGPrice(676.40);

		// Delete one of the observers
		// stockGrabber.unregister(observer2);

		stockGrabber.setIBMPrice(197.00);
		stockGrabber.setAAPLPrice(677.60);
		stockGrabber.setGOOGPrice(676.40);

		//
		// Create 3 threads using the Runnable interface
		//

		// GetTheStock implements Runnable, so it doesn't waste
		// its one extendable class option

		Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
		Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 677.60);
		Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 676.40);

		// Call for the code in run to execute
		new Thread(getIBM).start();
		new Thread(getAAPL).start();
		new Thread(getGOOG).start();

	}

}