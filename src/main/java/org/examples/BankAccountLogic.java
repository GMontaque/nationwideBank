package org.examples;

import java.util.HashMap;

public class BankAccountLogic {

    private HashMap<Integer,User> customer;
    private HashMap<Integer,BankAccount> bankAccounts;
    private ReadWrite data;

    public BankAccountLogic(){
        this.customer = new HashMap<>();
        this.bankAccounts = new HashMap<>();
        this.data = new ReadWrite();
    }

    public void logInLogic(){

    }

    public void createAccountLogic(){

    }

    public boolean loadData(){
        String customerTxt = "src/main/java/org/examples/data/customerLogIn.txt";
        String staffTxt = "src/main/java/org/examples/data/staffLogins.txt";
//        call method in readwrite to pre-populate hashmaps
        String customerSignInData = data.readFile(customerTxt);
        String staffSgnInData = data.readFile(staffTxt);

        if(customerSignInData.isEmpty() || staffSgnInData.isEmpty()){
            System.out.println("Error: File could not load");
            return false;
        } else {
            String[] totalLogInData = (customerSignInData+staffSgnInData).split("\n");

            for(String singleLine : totalLogInData){
                String[] oneCustomer = singleLine.split(",");
                customer.put(Integer.parseInt(oneCustomer[0]),new User(Integer.parseInt(oneCustomer[0]),oneCustomer[1],
                        oneCustomer[2],oneCustomer[3],oneCustomer[4],oneCustomer[5],oneCustomer[6]));
            }

        };
        return false;
    }

}