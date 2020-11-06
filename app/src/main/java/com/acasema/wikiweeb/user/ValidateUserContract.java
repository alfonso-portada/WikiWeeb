package com.acasema.wikiweeb.user;

public interface ValidateUserContract {
    public interface Presenter {
        //valida el usuario para el login
        void validateUser( String password, String email);
    }
    public interface View extends UserView{
        //email no existe
        void emailNotExistError();
        //password no es corecta
        void passwordError();
    }
}
