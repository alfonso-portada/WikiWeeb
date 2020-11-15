package com.acasema.wikiweeb.iu.signup;

import com.acasema.wikiweeb.iu.base.BasePresenter;
import com.acasema.wikiweeb.iu.user.UserView;

public interface SignUpContract {
    public interface Presenter extends BasePresenter {
        //añade un usuario a la vase de datos para el registro
        void addUser(String user, String password,String confirmPassword);
    }
    public interface View extends UserView {
        void setPasswordsNotEqualError();
        void setUserExitsError();
    }
}
