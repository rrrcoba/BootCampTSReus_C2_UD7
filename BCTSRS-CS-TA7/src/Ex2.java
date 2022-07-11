/**
 * @author Roger Rubio Rufaste
 *
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * This class is the second exercise of TA7
 * 
 */
public class Ex2 {

	public static Hashtable<String, Double> productInfo = new Hashtable<String, Double>();
	
	public static ArrayList<String> articles = new ArrayList<String>();

	/**
	 * This main method summons the method that adds products to the "database". 
	 * Then summons the method that add products bought by the client and finally show the info of the sell
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// First we add to the dictionary the products available
		addProductsInfo();
		
		// We summon the method that adds students and marks to the dictionary
		buyProducts();

		// Then we show the content of the dictionary
		showProducts();
	}

	/**
	 * This method adds the products bought by the client to the arraylist
	 */
	public static void buyProducts() {
		// First we ask the number of products the user wants to add
		int nProducts = Integer.parseInt(JOptionPane.showInputDialog("Write the number of products you want to buy "
				+ "(if you want two same products you will need to introduce them two times):"));
		// Then we create an array to store the products
		
		for(int i=0; i<nProducts; i++ ) {
			// We ask the name of the product
			String name = JOptionPane.showInputDialog("Write the name of the product you want to buy. "
					+ "Only available: milk, water, bread, macaroni, tomatoes, cheese, orange, lettuce, onion and oil:");
			// Then we add it to the array
			articles.add(name);
		}
	}

	/**
	 * This method shows the information of the products:
	 * - IVA Applied
	 * - Price
	 * - Number of products
	 * - Payment
	 * - Change
	 */
	public static void showProducts() {
		// We initialize variables for the total price and number of products
		double totalPrice = 0.0;
		int count = 0;
		
		// We start showing the IVA applied
		System.out.println("-----Welcome!-----");
		System.out.println("IVA applied is 4% because all products are primary need.");
		
		// We get the iterator of elements of the array list to start an iteration
		Iterator<String> it = articles.iterator();
		while(it.hasNext()) {
			String art = it.next();
			totalPrice = totalPrice + productInfo.get(art);
			count++;
		}
		
		// We show the total price and the final price with IVA
		System.out.println("The total price is: "+totalPrice+"€");
		double finalPrice = totalPrice*1.04;
		System.out.println("The final price with IVA is: "+finalPrice+"€");
		System.out.println("The number of products is: "+count);

		// Now we ask for the payment
		Double payment = Double.parseDouble(JOptionPane.showInputDialog("Please write your payment:"));
		
		// We show the payment introduced and the return
		System.out.println("Your payment is: "+payment+"€");
		System.out.println("Your change is: "+(payment-finalPrice)+"€");
		System.out.println("-----Thanks!-----");
	}

	/**
	 * This method adds information of each product available such as IVA
	 */
	public static void addProductsInfo() {
		productInfo.put("milk", 0.60);
		productInfo.put("water", 0.54);
		productInfo.put("bread", 0.30);
		productInfo.put("macaroni", 0.89);
		productInfo.put("tomatoes", 1.69);
		productInfo.put("cheese", 2.89);
		productInfo.put("orange", 0.40);
		productInfo.put("lettuce", 2.49);
		productInfo.put("onion", 1.67);
		productInfo.put("oil", 6.99);
	}
}
