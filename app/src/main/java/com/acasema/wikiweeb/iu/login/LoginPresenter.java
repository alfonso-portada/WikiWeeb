package com.acasema.wikiweeb.iu.login;


import com.acasema.wikiweeb.data.model.User;

public class LoginPresenter implements LoginContract.Presenter, LoginInteractorImpl.ILoginInteractor {

    private LoginContract.View view;
    private LoginInteractorImpl interactor;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.interactor = new LoginInteractorImpl(this);
    }


    //region contraro LoginContract.Presenter
    // metodo derivado del contraro LoginContract.Presenter
    public void validateUser(String user, String password) {
        view.showProgress();
        interactor.validateCredentials(user, password);
    }

    // metodo derivado del contraro LoginContract.Presenter heredado de BasePresenter
    /**
     * metodo que elimina la intanciqa a la vista y en un futuro al interactor
     */
    @Override
    public void onDestroy() {
        this.view = null;
        this.interactor = null;

    }
    //endregion



    //region interfaz ILoginInteractor de LoginInteractor
    // metodo derivado de ILoginInteractor
    @Override
    public void onUserEmptyError() {
        view.hideProgress();
        view.setUserEmptyError();
    }

    // metodo derivado de ILoginInteractor
    @Override
    public void onPasswordEmptyError() {
        view.hideProgress();
        view.setPasswordEmptyError();
    }

    // metodo derivado de ILoginInteractor
    @Override
    public void onPasswordFormatError() {
        view.hideProgress();
        view.setPasswordFormatError();
    }

    // metodo derivado de ILoginInteractor
    @Override
    public void onAuthenticationError() {
        view.hideProgress();
        view.onAuthenticationError();
    }

    // metodo derivado de ILoginInteractor
    @Override
    public void onSuccess(User user) {

        view.hideProgress();
        view.onSucces(user);
    }
    //endregion


}