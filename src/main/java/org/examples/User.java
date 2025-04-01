package org.examples;

public class User {
    private int ID;
    private String firstName;
    private String lastName;
    private String memorableWord;
    private String emailAddress;
    private String password;
    private String role;

    public User(int id, String firstName, String lastName, String memorableWord,
                String emailAddress, String password, String role){
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.memorableWord = memorableWord;
        this.emailAddress = emailAddress;
        this.password = password;
        this.role = role;
    }
}