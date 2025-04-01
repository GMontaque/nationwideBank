package org.examples;

import java.util.Scanner;

public class BankFront {

    private BankAccountLogic logic;

    public BankFront(){
        this.logic = new BankAccountLogic();
    }

    public void start(){
        Scanner scan = new Scanner(System.in);


        System.out.println("Welcome to Nationwide Bank");
        System.out.println("""
                Discover all our app features that make everyday banking more convenient:
                
                Customise your app home screen - choose slimmer account tiles and remove account type headers to see more on your screen.
                Log into the internet bank and make payments without a card reader.
                Transfer money between accounts.
                Pay a new person or company.
                Manage your overdraft and credit card limits.
                Verify your online purchases.
                Share account details – hold down the account and then copy and paste the details.
                """);

//        call method in bank logic to get txt date for bank accounts and customer data
//        ask user if they are customer or staff and provide them log in screen or exit to leave program
//        once logged-in user is given options based on their access level

        if(logic.loadData()){
            accountCheck(scan);
        }

//        if false exit program with error message

    }

    public void accountCheck(Scanner scan){
        while (true){
            System.out.println("""
                    Please select from the below options:
                    (1) - Log In
                    (2) - Create an account
                    (3) - Exit""");

            String response = scan.nextLine();

            if (response.equals("3")){
                break;
            }

            switch (Integer.parseInt(response)){
                case 1:
                    logic.logInLogic();
                    break;
                case 2:
                    logic.createAccountLogic();
                    break;
            }
        }
    }

    public void logIn(){
        System.out.println("log in");
    }

    public void signUp(){
        System.out.println("sign up");
//        check needed to make sure the email address used does not already exist
    }
}