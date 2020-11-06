package com.acasema.wikiweeb.user;

/**
 * clase que controla las reglas de negocio de la clase User
 */
public class UserPresenter implements ValidateUserContract.Presenter, AddUserContract.Presenter {
    private UserView view;

    public UserPresenter(UserView view) {
        this.view = view;
    }


    /**
     * metodo que añade un usuario a la base de datos. se tiene que getionar RN-U5
     */
    public void addUser(String user, String password, String email) {
        // error de contraseña
        //((ValidateUserContract.View) view).passwordError();
        // el email no existe
        //((ValidateUserContract.View) view).emailNotExistError();

        // corecto
        view.onSucces();
    }
    public void validateUser( String password, String email) {
        // email duplicado
        //((AddUserContract.View) view).emailDuplicateError();

        // corecto
        view.onSucces();
    }
}
