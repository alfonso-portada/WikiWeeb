package com.acasema.wikiweeb;

import android.app.Application;

import com.acasema.wikiweeb.data.model.User;

public class WikiWeebAplication extends Application {
    private User user;

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
}
