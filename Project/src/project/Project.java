package exercises;

import java.util.Scanner;

public class Pay {

	public static void main(String[] args) {
		int hourlyPay = 0;

		Scanner input = new Scanner(System.in);
		
		System.out.println("Choose your skill level: 1, 2, or 3 >>>>>");
		int skillLevel = input.nextInt();
		
		switch (skillLevel) {
		case 1:
			hourlyPay = 17;
			break;
		case 2:
			hourlyPay = 20;
			break;
		case 3:
			hourlyPay = 22;
			break;
		default:
			System.out.println("Invalid skill level.");
		}

		if (skillLevel > 0 && skillLevel < 4) {
			System.out.println("How many hours did you work? >>>>>");
			int regularHours = input.nextInt();
			int overTimeHours = 0;
			if (regularHours > 40) {
				overTimeHours = regularHours - 40;
				regularHours = 40;
			}
			
			double regularPay = regularHours * hourlyPay;
			double overTimePay = overTimeHours * hourlyPay * 1.5;
			int totalHours = regularHours + overTimeHours;
			double totalPay = regularPay + overTimePay;
			final double medicalInsurance = 32.5;
			final int dentalInsurance = 20;
			final int longTermDisability = 10;
			double retirementPlan = totalPay * .03;
			double itemizedDeductions = 0;
			int choice = 0;
			int skillSelection = 0;
			if (skillLevel == 2 || skillLevel == 3) {
				do {
					System.out.println("Do you want 1. medical, 2. dental, or 3. long term disability insurance? (Enter 0 to skip). >>>>>");
					choice = input.nextInt();
					skillSelection++;
					if (choice == 1) {
						itemizedDeductions += medicalInsurance;
						System.out.println("You have added medical insurance.");
					} else if (choice == 2) {
						itemizedDeductions += dentalInsurance;
						System.out.println("You have added dental insurance.");
					} else if (choice == 3) {
						itemizedDeductions += longTermDisability;
						System.out
								.println("You have added long term disability insurance.");
					} else {
						System.out.println("You have chosen to skip the insurance options.");
						choice = 0;
					}
				} while (choice != 0 && skillSelection < 1);
			}
			if (skillLevel == 3) {
				System.out.println("Do you want to participate in the retirement plan? Press 1 for yes or press 2 for no >>>>>");
				int retirementYesNo = input.nextInt();
				if (retirementYesNo == 1) {
					itemizedDeductions += retirementPlan;
					System.out.println("You chose a retirement plan.");
				} else {
					System.out.println("You didn't choose retirement plan.");
				}

			}

			double netPay = totalPay - itemizedDeductions;

			System.out.println("\nHours worked: " + totalHours);
			System.out.println("Hourly pay rate: $" + hourlyPay);
			System.out.println("Regular pay for 40 hours: $" + regularPay);
			System.out.println("Overtime pay: $" + overTimePay);
			System.out.println("Total pay: $" + totalPay);
			if (itemizedDeductions > totalPay) {
				System.out.println("Error: deductions exceed total pay.");
			} else {
				System.out.println("Total itemized deductions: $" + itemizedDeductions);
				System.out.println("Net pay: $" + netPay);
			}
		}

	}

}