
/*
 * Grand Circus Lab to create an array of students
 * 
 * Partners: Ali and Sienna and Tia
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		// variables
		Scanner in = new Scanner(System.in);

		String[] students = { "Tia", "Ali", "Sienna", "Josue", "Carla", "Ling", "Holly", "Carol Ann", "Sydney",
				"Clarice" };
		String[] hometown = { "Troy", "Hazel Park", "Rogue", "Detroit", "Taylor", "Warren", "Holly", "Grand Rapids",
				"Iowa", "Lambtown" };
		String[] favFood = { "Tonkatsu", "Split Pea Soup", "Hot Ramen", "Mashed Bananas", "Tacos", "Bangers and Mash",
				"Waffles", "Lollipops", "Pizza", "Fava Beans" };
		char choice = 'Y';
		char choices = 'Y';
		String detailChoice = "";

		do {
			System.out.println("Class Roster:");
			for (int i = 0; i < students.length; i++) {

				System.out.println((i + 1) + ") " + students[i]);
			}

			System.out.println("Which student would you like to learn more about? Enter 1 through " + students.length);
			int userChoice;

			try {
				userChoice = in.nextInt() - 1;
				while (userChoice < 0 || userChoice > students.length) {
					System.out.println("Student does not exist. Please try again. Enter number 1 - " + students.length);
					userChoice = in.nextInt() - 1;

				}

				in.nextLine();// clear out scanner object

				System.out.print("Student " + (userChoice + 1) + " is " + students[userChoice] + ".");
				System.out.println(" What would you like to know about " + students[userChoice] + "?");
				System.out.println(" enter hometown or favorite food.");

				detailChoice = in.nextLine().toUpperCase();

				while (!detailChoice.equals("HOMETOWN") && !detailChoice.equals("FAVORITE FOOD")
						&& !detailChoice.equals("\n")) {
					System.out.println("That data does not exist. Please try again.");
					System.out.println(" enter hometown or favorite food.");
					// in.next();// clear scanner object
					detailChoice = in.nextLine().toUpperCase();

				}

				getStudentsInfo(userChoice, students, hometown, favFood, detailChoice);

				System.out.println("Would you like to know more? (enter y or n)");
				choice = in.next().toUpperCase().charAt(0);
					
				while (choice != 'N') {
					if (choice == 'Y') {
						if (detailChoice.equals("HOMETOWN")) {
							detailChoice = "FAVORITE FOOD";
							getStudentsInfo(userChoice, students, hometown, favFood, detailChoice);
							
						} else {
							detailChoice = "HOMETOWN";
							getStudentsInfo(userChoice, students, hometown, favFood, detailChoice);
							
						}
					}else {
						System.out.println("Invalid choice. Try Again.");
						System.out.println("Would you like to know more? (enter y or n)");
						choice = in.next().toUpperCase().charAt(0);
					}
					System.out.println("Would you like to know more? (enter y or n)");
					choice = in.next().toUpperCase().charAt(0);

				}
			} catch (InputMismatchException | NumberFormatException ex) {
				System.out.println("Invalid Input!");
				in.nextLine();
				continue;

			}

			System.out.println("Would you like to continue? (y,n)");
			choices = in.next().toUpperCase().charAt(0);

		} while (choices == 'Y');

		System.out.println("Thanks!");
		in.close();

	}

	public static void getStudentsInfo(int studentOfInterest, String[] students, String[] hometowns, String[] favFoods,
			String dataWanted) {

		if (dataWanted.equals("HOMETOWN")) {
			System.out.println(students[studentOfInterest] + " is from " + hometowns[studentOfInterest]);
		} else {
			System.out.println(students[studentOfInterest] + "'s favorite food is " + favFoods[studentOfInterest]);
		}

	}
}
