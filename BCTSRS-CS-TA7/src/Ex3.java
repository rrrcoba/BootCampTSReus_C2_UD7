/**
 * @author Roger Rubio Rufaste
 *
 */

import javax.swing.JOptionPane;
import java.util.Hashtable;

/**
 * This class is the third exercise of TA7
 * 
 */
public class Ex3 {

	public static Hashtable<String, double[]> products = new Hashtable<String, double[]>();

	/**
	 * This main method summons the method that adds products to the "database".
	 * Then summons the method that add products bought by the client and finally
	 * show the info of the sell
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// We start initializing a "database" with 10 products
		initialDb();

		// Then we start the main menu
		menu();
	}

	/**
	 * This method is the main menu of the application where asks what figure wants
	 * the user to calculate the area then summons the method needed
	 */
	public static void menu() {
		// Ask the action
		String action = JOptionPane.showInputDialog("Write what you want to do (add, show, exit):");

		// Switch to every action
		switch (action) {
		case "exit":
			// End of the program
			System.out.println("----------");
			System.out.println("End of the program.");
			break;
		case "add":
			addProduct();
			break;
		case "show":
			showProducts();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Incorrect value.", "Value Error", 0);
			break;
		}
	}

	/**
	 * This method adds products to the "database"
	 */
	public static void addProduct() {
		// We ask the name, the price and the number of products
		String pName = JOptionPane.showInputDialog("Write the name of the product you want to introduce:");
		double pPrice = Double.parseDouble(JOptionPane.showInputDialog("Write the price of the product:"));
		double pNum = Double.parseDouble(JOptionPane.showInputDialog("Write the number of products:"));

		// We create an array to the price and number of products
		double[] priceNum = new double[2];

		// We add the information asked
		priceNum[0] = pPrice;
		priceNum[1] = pNum;

		// And finally we add all of it to the hashtable of products
		products.put(pName, priceNum);

		JOptionPane.showMessageDialog(null, "Product added! Returning to main menu.");

		menu();
	}

	/**
	 * This method shows the information inside the hashtable
	 */
	public static void showProducts() {
		// We start showing a message
		System.out.println("Showing all the products information inside the database:");

		// We iterate for every element inside the hashtable
		for (String p : products.keySet()) {
			double[] priceNum = products.get(p).clone();
			System.out.println("----------");
			System.out.println("Product name: " + p);
			System.out.println("Product price: " + priceNum[0]);
			System.out.println("Number of products: " + priceNum[1]);
		}

		JOptionPane.showMessageDialog(null, "All products showed! Returning to main menu.");

		menu();
	}

	/**
	 * This method initialize 10 products into the "database"
	 */
	public static void initialDb() {
		double[] milkN = { 0.60, 1 };
		products.put("milk", milkN);
		double[] waterN = { 0.54, 1 };
		products.put("water", waterN);
		double[] breadN = { 0.30, 1 };
		products.put("bread", breadN);
		double[] macaroniN = { 0.89, 1 };
		products.put("macaroni", macaroniN);
		double[] tomatoesN = { 1.69, 1 };
		products.put("tomatoes", tomatoesN);
		double[] cheeseN = { 2.89, 1 };
		products.put("cheese", cheeseN);
		double[] orangeN = { 0.40, 1 };
		products.put("orange", orangeN);
		double[] lettuceN = { 2.49, 1 };
		products.put("lettuce", lettuceN);
		double[] onionN = { 1.67, 1 };
		products.put("onion", onionN);
		double[] oilN = { 6.99, 1 };
		products.put("oil", oilN);
	}
}
