import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class GetTheStock implements Runnable {

	// Could be used to set how many seconds to wait
	// in Thread.sleep() below

	// private int startTime;
	private String stock;
	private double price;

	// Will hold reference to the StockGrabber object

	private Subject stockGrabber;

	//
	// Constructor
	//

	public GetTheStock(Subject stockGrabber, int newStartTime, String newStock,
			double newPrice) {

		// Store the reference to the stockGrabber object so
		// I can make calls to its methods

		this.stockGrabber = stockGrabber;

		// startTime = newStartTime; Not used to have variable sleep time
		stock = newStock;
		price = newPrice;

	}

	public void run() {

		// Change the price 20 times
		for (int i = 1; i <= 20; i++) {

			try {

				// Sleep for 2 seconds
				Thread.sleep(2000);

				// Use Thread.sleep(startTime * 1000); to
				// make sleep time variable
			} catch (InterruptedException e) {
			}

			// Generates a random number between -.03 and .03
			double randNum = (Math.random() * (0.06)) - 0.03;

			Locale locale = new Locale("en", "UK");
			DecimalFormat df = (DecimalFormat) NumberFormat
					.getNumberInstance(locale);
			df.applyPattern("#.##");

			// Formats decimals to 2 places
			// DecimalFormat df = new DecimalFormat("#.##");

			// Change the String price and then convert it back into a double
			price = Double.valueOf(df.format((price + randNum)));

			if (stock == "IBM")
				((SubjectConcreteA) stockGrabber).setIBMPrice(price);
			if (stock == "AAPL")
				((SubjectConcreteA) stockGrabber).setAAPLPrice(price);
			if (stock == "GOOG")
				((SubjectConcreteA) stockGrabber).setGOOGPrice(price);

			System.out.println(stock + ": " + df.format((price + randNum))
					+ " " + df.format(randNum));

			System.out.println();

		}
	}

}