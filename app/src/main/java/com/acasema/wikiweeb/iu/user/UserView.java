package com.acasema.wikiweeb.iu.user;

import com.acasema.wikiweeb.data.model.User;
import com.acasema.wikiweeb.iu.base.BaseView;

public interface UserView {
    //Método que indica el usuario no puede ser nulo.
    void setUserEmptyError();

    //Método que indica que la contraseña no cumple el patrón indicado
    void setPasswordFormatError();

    //Método que indica la contraseña no puede ser nula
    void setPasswordEmptyError();
    void onSucces(User user);
}
