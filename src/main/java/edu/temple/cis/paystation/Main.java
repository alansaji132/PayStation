package edu.temple.cis.paystation;

import java.util.Map;
import java.util.Scanner;

/**
 * The main class for the PayStation application.
 *
 * Responsibilities:
 *
 * 1) Provide a text-based user interface for the PayStation application.
 * 2) Create a PayStationImpl object and use it to implement the user interface.
 * 3) Provide a admin console for the PayStation application in order to change the town and rate strategy.
 */
public class Main {

    public static void main(String[] args) throws IllegalCoinException {
        Scanner input = new Scanner(System.in); // keyboard input
        
        PayStationImpl ps = new PayStationImpl(); // set up a default paystation 

        String menu = "1. Deposit Coins\n" +
                "2. Display\n" +
                "3. Buy Ticket\n" +
                "4. Cancel\n" +
                "5. Enter admin console";

        int choice = 0;
        while (true) {
            System.out.println(menu);
            System.out.println("Option Chosen: ");
            choice = input.nextInt();
            switch (choice) {
                case 1: // Deposit Coins
                    System.out.println("Enter coin value to deposit: ");
                    int coin = input.nextInt();
                    try {
                        ps.addPayment(coin);
                    } catch (IllegalCoinException e) {
                        // TODO: handle exception
                        System.out.println(e);
                    }
                    
                    break;
                case 2: // Display
                    // show time bought
                    System.out.println("Time bought: " + ps.readDisplay());
                    break;
                case 3: // Buy Ticket
                    Receipt r = ps.buy();
                    System.out.println("Receipt time: " + r.value()+" Valid until: "+ r.expirationTime());
                    break;
                case 4: // Cancel
                    // when cancel is pressed, print out the amount of money returned and the coin type, i.e., 1 quarter, 2 dimes, 3 nickels
                    Map<Integer, Integer> retCoin = ps.cancel();
                    System.out.println("Returned Coins: ");
                    for (Map.Entry<Integer, Integer> entry : retCoin.entrySet()) {
                        System.out.println(entry.getValue() + " " + entry.getKey() + " cent coins\n");
                    }
                    break;
                case 5: // Enter admin console 
                    ps = setup(input, ps);
                    break;
                default: // Invalid choice
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    private static PayStationImpl setup(Scanner input, PayStationImpl ps){
        String menu = "1. View Current PayStation Set Up\n" +
                "2. Switch Town/Rate Stragety\n" +
                "3. Empty\n" +
                "4. Shutdown Machine\n" +
                "5. Exit";
        String town = "1. Alphatown\n" + // or ps.listTowns(); the method way is better because new towns can be added without having to physically access machine 
        "2. Betatown\n" +
        "3. Gammatown\n" +
        "4. Deltatown\n" +
        "5. Omegatown";
        String[] towns = {"Alphatown", "Betatown","Gammatown", "Deltatown", "Omegatown"};

        int choice = 0;
        while (true) {
            System.out.println(menu);
            System.out.println("Option Chosen: ");
            choice = input.nextInt();
            switch (choice) {
                case 1: // View PayStation Set Up 
                    System.out.println(ps.toString());
                    break;
                case 2: 
                    System.out.println(town);
                    System.out.println("Option Chosen: ");
                    choice = input.nextInt();
                    if(ps.setTown(towns[choice -1])){
                        System.out.println("Set town to: "+ towns[choice -1]);
                    }
                    else{
                        System.out.println("Failed to set town");
                    }
                    

                    break;
                case 3: // Buy Ticket
                    System.out.println("Money in the machine: "+ ps.empty()); 
                    break;
                case 4: 
                    //might make sense to force operator to empty machine before shutting it down 
                    System.exit(0);
                    break;
                case 5: // Return back to customer view 
                    return ps; 
                default: // Invalid choice
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
