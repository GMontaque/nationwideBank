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


        boolean runProgram = false;
        if(logic.loadData()){
            runProgram = !accountCheck(scan).equals("failed");
//            else {
//                System.out.println("Please not you require a valid account to gain access, please try again later");
//            };
        } else {
            System.out.println("Error: the Log in details could not be loaded, " +
                    "program has closed please try again later");
        }

        if (runProgram){
            System.out.println("program is running");
        }

//        if false exit program with error message

    }

    public String accountCheck(Scanner scan){
        String status = "";
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

            String correctInput = "authorised";
            switch (response){
                case "1":
                    String input;

                    do {
                        System.out.println("Welcome to the Log in Screen, Please confirm (1) customer or (2) staff");
                        input = scan.nextLine();
                    } while (logic.inputCheck(input, 2));
                    correctInput = logIn(Integer.parseInt(input),scan);
                    break;
                case "2":
                    signUp(scan);
                    break;
            }

            if (correctInput.equals("authorised")){
                status = "authorised";
                break;
            } else {
                status = "failed";
            }
        }
        return status;
    }

    public String logIn(int input, Scanner scan) {

        if(input == 1){
            System.out.println("customer");
            String email;
            String password;
            do {
                System.out.println("Please enter your email address");
                email = scan.nextLine();

                System.out.println("Please enter your password");
                password = scan.nextLine();
            } while (logic.logInLogic(email,password));

        } else {
            System.out.println("staff");
            String email;
            String password;
            do {
                System.out.println("Please enter your email address");
                email = scan.nextLine();

                System.out.println("Please enter your password");
                password = scan.nextLine();
            } while (logic.logInLogic(email,password));

        }

        return (logic.getLogInAttempt() > 0) ? "authorised" : "failed";
    }

    public void signUp(Scanner scan){
        System.out.println("sign up");
        logic.createAccountLogic();
//        check needed to make sure the email address used does not already exist
    }
}