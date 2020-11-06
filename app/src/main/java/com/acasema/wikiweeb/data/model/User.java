package com.acasema.wikiweeb.data.model;

public class User {

    private int id;
    private String user;
    private String email;
    private String password;
    private String name;

    public User(int id, String user, String email, String password, String name) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    //region GetSet
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //endregion

}
