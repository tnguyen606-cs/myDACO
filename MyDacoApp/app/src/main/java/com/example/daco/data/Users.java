package com.example.daco.data;

public class Users {
    private int id;
    private String firstName;
    private String lastName;
    private String name;
    private String username;
    private String password;

    public Users(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.firstName = name.substring(0, ' ');
        this.lastName = name.substring(' ');
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Getter method for the name of Personnel.
     *
     * @return the name value of the current Personnel
     */
    public String getDacoName() {
        return this.name;
    }

    public String getDacoPassword() {
        return this.password;
    }

    public String getDacoUsername() {
        return this.username;
    }

    public int getDacoId() {
        return this.id;
    }

    public String getDacoFirstName() {
        return this.name.substring(0, ' ');
    }

    public String getDacoLastName() {
        return this.name.substring(' ');
    }

}
