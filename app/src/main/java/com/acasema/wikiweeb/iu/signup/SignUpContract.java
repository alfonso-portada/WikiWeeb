package com.acasema.wikiweeb.iu.signup;

import com.acasema.wikiweeb.iu.base.BasePresenter;
import com.acasema.wikiweeb.iu.user.UserView;

/**
 * contrato enter presenter y view para no pasar class clase completa y que el presenter tenga todo
 * del fragment y dicecersa
 */
public interface SignUpContract {
    public interface Presenter extends BasePresenter {
        //añade un usuario a la vase de datos para el registro
        void addUser(String user, String password,String confirmPassword);
    }
    public interface View extends UserView {
        void setPasswordsNotEqualError();//Método que indica que las contraseña no son iguales
        void setUserExitsError();//Método que indica ya existe el usario
    }
}
