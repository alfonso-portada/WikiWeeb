package com.acasema.wikiweeb.iu.login;

import com.acasema.wikiweeb.iu.base.BasePresenter;
import com.acasema.wikiweeb.iu.user.UserView;

/**
 * contrato enter presenter y view para no pasar class clase completa y que el presenter tenga todo
 * del fragment y dicecersa
 */
public interface LoginContract  {
    public interface Presenter extends BasePresenter {
        //valida el usuario para el login
        void validateUser(String user, String password);
    }
    public interface View extends UserView {
        //Método que muestra una barra de progreso en la interfaz
        //mientras se realiza una acción en el interactor
        void showProgress();

        //Método que oculta la barra de progreso en la interfaz
        void hideProgress();

        //Método que muestra un mensaje de error la usuario indicando que la autenticación
        //no ha sido correcta
        void onAuthenticationError();

    }
}
