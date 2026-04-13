package com.iispl.utility;

import java.util.Scanner;
import com.iispl.service.ServiceChoice;

public class BankApplicationUtility {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char yourChoice;
		
		do {
			System.out.println("Select the Service:");
			System.out.println("1. Account Related Services\n2. Transaction Related Services");
			int choice = sc.nextInt();
			
			switch(choice) {
            case 1:
            	// Account Related Services
            	ServiceChoice.chooseAccountService(sc);
            	break;

            case 2:
                // Transaction Related Services
            	ServiceChoice.chooseTransactionService(sc);
                break;

            default:
                System.out.println("Invalid choice!");
        }

			
			System.out.println("Do you want to Bank Application Menu again?(Y/N)");
			yourChoice = sc.next().charAt(0);
		}while(yourChoice == 'y' || yourChoice == 'Y');
		System.out.println("Please, visit again!!!");
	}
}
