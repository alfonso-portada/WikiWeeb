package com.acasema.wikiweeb.data.repository;

import com.acasema.wikiweeb.data.model.User;

import java.util.ArrayList;

/**
 * repositorio del los usuario
 * esta clase es acesible desde punto de la eplicacion a astraves de getIntance()
 */
public class UserRepository {

    private static UserRepository repository = null;
    private ArrayList<User> users;

    static {repository = new UserRepository();}

    private UserRepository(){
        users = new ArrayList<>();
        initialice();
    }

    public static UserRepository getInstance(){
        return repository;
    }

    private void initialice() {
        users.add(new User("acasema", "1111"));
        users.add(new User("invitado","12345678aA"));
    }

    public boolean add(String user, String password){
        User u = new User(user, password);
        if(contains(u))
            return false;
        users.add(u);
        return true;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public boolean validateAuthentication(String user, String password) {
        return contains(new User(user,password));
    }

    public boolean contains(User user){
        return users.contains(user);
    }
}
