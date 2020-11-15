package com.acasema.wikiweeb.iu.signup;

import android.os.Handler;
import android.text.TextUtils;

import com.acasema.wikiweeb.data.model.User;
import com.acasema.wikiweeb.data.repository.UserRepository;
import com.acasema.wikiweeb.iu.utils.CommonUtils;

public class SignUpInteractorImpl {

    private ISignUpInteractor presenter;

    /*
     * Definición de las interfaces que debe implementar cualquier presentador
     * que haga uso del Interactor.
     */
    public interface ISignUpInteractor {

        void onUserEmptyError();
        void onPasswordFormatError();
        void onPasswordEmptyError();
        void onPasswordsNotEqualError();
        void onUserExitsError();
        void onSuccess(User user); //Secuencia normal del caso de uso.
    }

    public SignUpInteractorImpl(ISignUpInteractor presenter) {
        this.presenter = presenter;
    }

    public void CreateUser(final String user, final String password, final String confirmPassword){
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (TextUtils.isEmpty(user)) {
                    presenter.onUserEmptyError();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    presenter.onPasswordEmptyError();
                    return;
                }
                if (!CommonUtils.isPasswordValid(password)) {
                    presenter.onPasswordFormatError();
                    return;
                }
                if (password.equals(confirmPassword)){
                    presenter.onPasswordsNotEqualError();
                    return;
                }
                if (!UserRepository.getInstance().add(user, password)) {
                    presenter.onUserExitsError();
                    return;
                }
                presenter.onSuccess(new User(user, password));

            }

        }, 2000);
    }
}
