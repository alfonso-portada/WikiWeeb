package com.acasema.wikiweeb.iu.user;

import com.acasema.wikiweeb.data.model.User;
import com.acasema.wikiweeb.iu.base.BaseView;

/**
 * interfaz base para los contratos view con relacion de usuario
 */
public interface UserView extends BaseView<User> {
    void setUserEmptyError();//Método que indica el usuario no puede ser nulo.
    void setPasswordFormatError();//Método que indica que la contraseña no cumple el patrón indicado
    void setPasswordEmptyError();//Método que indica la contraseña no puede ser nula
}
