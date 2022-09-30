package com.myDACO.data;

public class Users {
    private String id;
    private String name;
    private String username;
    private String password;

    public Users(String id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
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

    public String getDacoId() {
        return this.id;
    }

    /*
     * This method checks if whether it is a same assigned Personnel
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o instanceof Users) {
            Users otherUser= (Users) o;
            return this.username.equals(otherUser.getDacoUsername())
                    && this.password.equals(otherUser.getDacoPassword());
        }
        return false;
    }
}
