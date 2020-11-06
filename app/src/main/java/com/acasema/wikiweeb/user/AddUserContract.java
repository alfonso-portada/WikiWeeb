package com.acasema.wikiweeb.user;

public interface AddUserContract {
    public interface Presenter {
        //añade un usuario a la vase de datos para el registro
        void addUser(String user, String password, String email);
    }
    public interface View extends UserView{
        //existe un usuario con ese email
        void emailDuplicateError();
    }
}
