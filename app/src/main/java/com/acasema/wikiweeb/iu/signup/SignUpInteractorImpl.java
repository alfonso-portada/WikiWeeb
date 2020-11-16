package com.acasema.wikiweeb.iu.signup;

import android.os.Handler;
import android.text.TextUtils;

import com.acasema.wikiweeb.data.model.User;
import com.acasema.wikiweeb.data.repository.UserRepository;
import com.acasema.wikiweeb.iu.utils.CommonUtils;

/**
 * clase  para procesar los datos proporcionados por el presenter y actuar en cosecuencia en el repositorio
 */
public class SignUpInteractorImpl {

    private ISignUpInteractor presenter;

    /**
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

    /**
     * Se realiza la asignación de su Presentador en el constructor. La relación es uno a uno.
     * @param presenter que implemente la interfaz
     */
    public SignUpInteractorImpl(ISignUpInteractor presenter) {
        this.presenter = presenter;
    }

    /**
     * Este método valida el usuario verificando los datos y piciendole al repository que lo añada
     */
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
