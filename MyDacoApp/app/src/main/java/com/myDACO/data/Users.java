package com.myDACO.data;

public class Users {
    private String id;
    private String name;
    private String username;
    private String password;

    public Users(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Users() {
    }

    /**
     * Getter methods for User
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

    /**
     * Setter methods for the user
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String concatString(String pre, String post) {
        StringBuilder builder = new StringBuilder();
        builder.append(pre);
        builder.append(" ");
        builder.append(post);
        this.name =  builder.toString();
        return  this.name;
    }
}
