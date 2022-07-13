/**
 * @author Roger Rubio Rufaste
 *
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class is the first exercise of TA7
 * 
 */
public class Ex1 {

	public static ArrayList<Double> marks = new ArrayList<>();

	public static Hashtable<String, Double> students = new Hashtable<String, Double>();

	/**
	 * This main method summons the method that adds students and marks and
	 * calculates the average. Then it summons the method that shows the students
	 * and average mark.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// We summon the method that adds students and marks to the dictionary
		addStudents();

		// Then we show the content of the dictionary
		showStudents();
	}

	/**
	 * This method adds the number of students and marks that asks to the dictionary
	 * of the class. The mark saved into the dictionary is the average of all marks.
	 */
	public static void addStudents() {
		// First we ask the number of students and marks
		int nStudents = Integer
				.parseInt(JOptionPane.showInputDialog("Write the number of students you want to introduce:"));
		int nMarks = Integer.parseInt(
				JOptionPane.showInputDialog("Write the number of marks for every student you want to introduce:"));

		// For the numbers asked we iterate adding marks for each student
		for (int i = 0; i < nStudents; i++) {
			String student = JOptionPane.showInputDialog("Write the name of the student:");

			for (int j = 0; j < nMarks; j++) {
				// We iterate for the number of marks introduced
				double mark = Double.parseDouble(JOptionPane.showInputDialog("Write the mark of the student:"));
				
				// We add each mark into "marks" arraylist
				marks.add(mark);
			}
			// We use the average method to do the average
			Double avg = average(marks);
			
			// We need to reset "marks" for every student
			marks.clear();
			
			// We put into the dictionary the student with the average mark
			students.put(student, avg);
		}
	}

	/**
	 * This method shows the content of the dictionary.
	 */
	public static void showStudents() {
		// For each element in the dictionary we show the key and the average mark
		for (String st : students.keySet()) {
			System.out.println("Student " + st + " has an average mark of " + students.get(st));
		}
	}

	/**
	 * This method calculates the average mark of an arraylist with marks.
	 * 
	 * @param marks the arraylist with the marks
	 * @return avg the average mark
	 */
	public static Double average(ArrayList<Double> marks) {
		// For each element on marks list we do the summation
		Double avg = 0.0;
		for (Double mark : marks) {
			avg = avg + mark;
		}

		// We calculate the average
		avg = avg / marks.size();

		// We return the average
		return avg;
	}

	/**
	 * This method is the main menu of the application where asks what figure wants
	 * the user to calculate the area then summons the method needed.
	 */
	public static void menu() {
		// Ask the figure
		String figure = JOptionPane.showInputDialog("Write the name of the figure you want to know the area "
				+ "(only circle, triangle and square, in english language and without caps). Write 0 if you want to exit.");

		// Switch to the figure
		switch (figure) {
		case "0":
			// End of the program
			System.out.println("End of the program.");
			break;
		case "circle":

			break;
		case "triangle":

			break;
		case "square":

			break;
		default:
			JOptionPane.showMessageDialog(null, "Incorrect values", "Value Error", 0);
			break;
		}
	}
}
