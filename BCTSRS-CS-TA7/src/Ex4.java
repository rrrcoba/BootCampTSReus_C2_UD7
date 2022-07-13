/**
 * @author Roger Rubio Rufaste
 *
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * This class is the fourth exercise of TA7
 * 
 */
public class Ex4 {

	public static Hashtable<String, double[]> products = new Hashtable<String, double[]>();

	public static ArrayList<double[]> purchase = new ArrayList<double[]>();

	public static int nProducts = 0;

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
		String action = JOptionPane
				.showInputDialog("Write what you want to do (add, products, buy, purchase or exit):");

		// Switch to every action
		switch (action) {
		case "exit":
			// End of the program
			JOptionPane.showMessageDialog(null, "Closing... Come back soon!");
			System.out.println("----------");
			System.out.println("End of the program.");
			break;
		case "add":
			addProduct();
			break;
		case "products":
			showProducts();
			break;
		case "buy":
			buyProducts();
			break;
		case "purchase":
			showPurchase();
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

		// We return to the main menu
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

		// We return to the main menu
		menu();
	}

	/**
	 * This method adds the products bought by the client to the arraylist
	 * "purchase"
	 */
	public static void buyProducts() {
		System.out.println("----------");
		// First we ask the number of products the user wants to add
		nProducts = Integer.parseInt(JOptionPane.showInputDialog("Write the number of products you want to buy "
				+ "(if you want two same products you will need to introduce them two times):"));

		int i = 0;
		// We ask same times as times the user told
		while(i<nProducts) {
			// We ask the name of the product
			String name = JOptionPane.showInputDialog("Write the name of the product you want to buy:");

			// Then we create an array to store the products
			double[] priceNum = new double[nProducts];

			// We ask the number of products of this type
			priceNum[1] = Double
					.parseDouble(JOptionPane.showInputDialog("Write the number of products of this type do you want:"));

			// We check the stock before adding the products to the array of the client
			if(products.containsKey(name)) {
				// We get the price of the product the user wants summoning the dictionary
				priceNum[0] = products.get(name)[0];

				// Then we add it to the arraylist
				purchase.add(priceNum);
				
				// We remove 1 product because the client just bought it
				if(products.get(name)[1] >1) {
					// If there's more than 1 we just reduce the stock
					products.get(name)[1]--;
				} else {
					// If there's only 1 we eliminate all the product
					products.remove(name);
				}
				System.out.println("Product added to the purchase.");
				i++;
			} else {
				// If the product doesn't exist
				JOptionPane.showMessageDialog(null, "Sorry, there's not enough stock for the product wanted", "No Stock", 0);
			}
		}

		System.out.println("Purchase finished successfully!");

		menu();
	}

	/**
	 * This method shows the information of the products: - IVA Applied - Price -
	 * Number of products - Payment - Change
	 */
	public static void showPurchase() {
		// We initialize variables for the total price and number of products
		double totalPrice = 0.0;
		int count = 0;

		// We start showing the IVA applied
		System.out.println("-----Welcome!-----");
		System.out.println("IVA applied is 4% because all products are primary need.");

		// We get the iterator of elements of the array list to start an iteration
		Iterator<double[]> it = purchase.iterator();
		while (it.hasNext()) {
			double[] next = it.next();
			totalPrice = totalPrice + (next[0] * next[1]);
			count++;
		}

		// We show the total price and the final price with IVA
		System.out.println("The total price is: " + totalPrice + "€");
		double finalPrice = totalPrice * 1.04;
		System.out.println("The final price with IVA is: " + finalPrice + "€");
		System.out.println("The number of products is: " + count);

		// Now we ask for the payment
		Double payment = Double.parseDouble(JOptionPane.showInputDialog("Please write your payment:"));

		// We show the payment introduced and the return
		System.out.println("Your payment is: " + payment + "€");
		System.out.println("Your change is: " + (payment - finalPrice) + "€");
		System.out.println("-----Thanks!-----");

		// We return to the main menu
		menu();
	}

	/**
	 * This method initialize 10 products into the "database"
	 */
	public static void initialDb() {
		// We add the first 10 products
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