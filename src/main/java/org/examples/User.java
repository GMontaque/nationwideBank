package org.examples;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String memorableWord;
    private String emailAddress;
    private String dateJoined;
    private String staffId;
    private String password;
    private String role;

    public void setCustomerLogIn(int id, String firstName, String lastName, String memorableWord,
                                 String emailAddress, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.memorableWord = memorableWord;
        this.emailAddress = emailAddress;
        this.password = password;
        this.role = role;
    }

    public void setStaffLogIn(int id, String firstName, String lastName, String dateJoined,
                                 String emailAddress, String staffId, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.dateJoined = dateJoined;
        this.staffId = staffId;
        this.role = role;
    }


}

//customer
// id, firstname, lastname, memorable word, email, password, role

//staff
//id, firstname, lastname, company email address, date joined, staff id, role