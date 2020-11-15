package com.acasema.wikiweeb.data.model;

import java.io.Serializable;

public class User implements Serializable {

    public static final String TAG = "User";

    private String user;
    private int password;


    //region contructores
    public User(String user,int password) {
        this.user = user;
        this.password = password;
    }
    public User(String user,String password) {
        this.user = user;
        this.password = password.hashCode();
    }
    //endregion


    //region Get and Set
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    //endregion


    //region override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user1 = (User) o;

        if (password != user1.password) return false;
        return user.equals(user1.user);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + password;
        return result;
    }
    //endregion
}
