package Calculators;

import java.util.Scanner;


public class AeroPlainMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name of the Aircraft");
		String airCraftName = scan.next();
		System.out.println("Enter the source");
		String source = scan.next();
		System.out.println("Enter the destination");
		String destination = scan.next();
		System.out.println("Enter the type of Flight\r\n" + "1.Public Aircraft\r\n" + "2.Private Aircraft");

		int choice = scan.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("Is the flight check in before two hours");
			String checking = scan.next();
			System.out.println("Enter the number of kgs allowed per person");
			int noOfKgAllowed = scan.nextInt();
			System.out.println("Enter the additional fee charged for extra baggage per Kg");
			float additionalKg = scan.nextFloat();
			PublicAircraft p = new PublicAircraft(airCraftName, source, destination, true, noOfKgAllowed, additionalKg);
			p.displayDetails();
			break;
		}

		case 2: {

			break;
		}

		}

	}

}

