package com.acasema.wikiweeb;

import android.app.Application;

import com.acasema.wikiweeb.data.model.User;

/**
 * esta clase sistituya la que esta por defecto, esto se menciona en el manifest
 */
public class WikiWeebAplication extends Application {
    private User user;

    /**
     * optienes el usuario con el que se registro o inicio sesión
     * @return el usuario
     */
    public User getUser(){
        return user;
    }

    /**
     * añades el usuario en el registro o en el inicio sesión
     * @param user el usuario
     */
    public void setUser(User user){
        this.user = user;
    }
}
