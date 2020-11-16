package com.acasema.wikiweeb.iu.login;

import android.os.Handler;
import android.text.TextUtils;

import com.acasema.wikiweeb.data.model.User;
import com.acasema.wikiweeb.data.repository.UserRepository;
import com.acasema.wikiweeb.iu.utils.CommonUtils;

/**
 * clase  para procesar los datos proporcionados por el presenter y actuar en cosecuencia en el repositorio
 */
public class LoginInteractorImpl {
    private ILoginInteractor presenter;

    /**
     * Definición de las interfaces que debe implementar cualquier presentador
     * que haga uso del Interactor.
     */
    public interface ILoginInteractor {
        void onUserEmptyError(); //RN-U1 y Alternativa 1.1
        void onPasswordEmptyError(); //RN-U1 y Alternativa 1.1
        void onPasswordFormatError(); //RN-U2 y Alternativa 1.2
        void onAuthenticationError(); //Alternativa 1.3
        void onSuccess(User user); //Secuencia normal del caso de uso.
    }

    /**
     * Se realiza la asignación de su Presentador en el constructor. La relación es uno a uno.
     * @param presenter que implemente la interfaz
     */
    public LoginInteractorImpl(ILoginInteractor presenter) {
        this.presenter = presenter;
    }

    /**
     * Este método valida las credenciales verificando los datos y piciendole al repository si son iguales
     */
    public void validateCredentials(final String user, final String password) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //Reglas de negocio y  Alternativas del caso de uso UC1-Login
                //RN-U1 y Alternativa 1.1.: el usuario no puede ser nulo
                if (TextUtils.isEmpty(user)) {
                    presenter.onUserEmptyError();
                    return;
                }
                //RN-U1 y Alternativa 1.1.: el passowrd no puede ser nulo
                if (TextUtils.isEmpty(password)) {
                    presenter.onPasswordEmptyError();
                    return;
                }
                //RN-U2 y Alternativa 1.2: La contraseña debe tener al menos ocho caracteres, una mayúscula y un número.
                if (!CommonUtils.isPasswordValid(password)) {
                    presenter.onPasswordFormatError();
                    return;
                }
                //Alternativa 1.3 del caso de uso que indica que o bien el password no es correcto o el usuario
                //No se da información al usuario de qué campo es el erróneo
                if (!UserRepository.getInstance().validateAuthentication(user, password)) {
                    presenter.onAuthenticationError();
                    return;
                }
                //Secuencia normal

                presenter.onSuccess(new User(user, password));

            }

        }, 2000);

    }

}
