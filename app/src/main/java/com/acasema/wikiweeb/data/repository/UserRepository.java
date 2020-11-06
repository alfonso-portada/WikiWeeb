package com.acasema.wikiweeb.data.repository;

import com.acasema.wikiweeb.data.model.User;

/**
 * esta clase es acesible desde punto de la eplicacion a astraves de getIntance()
 */
public class UserRepository {
    private static UserRepository repository = null;
    private User user;

    private UserRepository(){
        user = new User(1,"acasema", "acasema201@gmail.com", "acasema", "acasema");
    }

    static {repository = new UserRepository();}

    public static UserRepository getIntance(){
        return repository;
    }

}
