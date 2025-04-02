package org.examples;

import java.util.HashMap;

public class BankAccountLogic {

    private HashMap<Integer,User> customer;
    private HashMap<Integer,BankAccount> bankAccounts;
    private ReadWrite data;
    private User loggedInUser;
    private int logInAttempt;

    public BankAccountLogic(){
        this.customer = new HashMap<>();
        this.bankAccounts = new HashMap<>();
        this.data = new ReadWrite();
        this.loggedInUser = new User();
        logInAttempt = 3;
    }

    public int getLogInAttempt() {
        return logInAttempt;
    }

    public boolean inputCheck(String input, int range){
        try {
            Integer.parseInt(input);
            if (Integer.parseInt(input) > 0 && Integer.parseInt(input) <= range){
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println(input + " is not a valid integer");
            return true;
        }

        return true;
    }

    public boolean logInLogic(String email, String password){
//      this will be passed username and password for customer and staff id as well for staff, checks the details are correct
//      after 3 attempts incorrectly will always return false and break
        logInAttempt--;
        System.out.println(logInAttempt);

        return  logInAttempt > 0;
    }

    public void createAccountLogic(){
//        check needed to make sure the email address used does not already exist
    }

    public boolean loadData(){
        String customerTxt = "src/main/java/org/examples/data/customerLogIn.txt";
        String staffTxt = "src/main/java/org/examples/data/staffLogins.txt";

        String customerSignInData = data.readFile(customerTxt);
        String staffSgnInData = data.readFile(staffTxt);

        if(customerSignInData.isEmpty() || staffSgnInData.isEmpty()){
            System.out.println("Error: File could not load");
            return false;
        } else {
            String[] customerData = customerSignInData.split("\n");
            String[] staffData = staffSgnInData.split("\n");

            for(String singleLine : customerData){
                String[] oneCustomer = singleLine.split(",");
                User newCustomer = new User();
                newCustomer.setCustomerLogIn(
                        Integer.parseInt(oneCustomer[0]),oneCustomer[1],oneCustomer[2],oneCustomer[3],
                        oneCustomer[4],oneCustomer[5],oneCustomer[6]);
                customer.put(Integer.parseInt(oneCustomer[0]), newCustomer);
            }

            for(String singleLine : staffData){
                String[] oneCustomer = singleLine.split(",");
                User newStaff = new User();
                newStaff.setStaffLogIn(
                        Integer.parseInt(oneCustomer[0]),oneCustomer[1],oneCustomer[2],oneCustomer[3],
                        oneCustomer[4],oneCustomer[5],oneCustomer[6]);
                customer.put(Integer.parseInt(oneCustomer[0]), newStaff);
            }

        };
        return true;
    }

}