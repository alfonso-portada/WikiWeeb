package com.acasema.wikiweeb.iu.signup;


import com.acasema.wikiweeb.data.model.User;

public class SignUpPresenter implements SignUpContract.Presenter, SignUpInteractorImpl.ISignUpInteractor {

    private SignUpContract.View view;
    private SignUpInteractorImpl interactor;

    public SignUpPresenter(SignUpContract.View view) {
        this.view = view;
        this.interactor = new SignUpInteractorImpl(this);
    }

    //region contraro LoginContract.Presenter
    // metodo derivado del contraro SignUpContract.Presenter
    @Override
    public void addUser(String user, String password, String confirmPassword) {
        interactor.CreateUser(user, password, confirmPassword);
    }

    // metodo derivado del contraro SignUpContract.Presenter heredado de BasePresenter
    @Override
    public void onDestroy() {
        this.view = null;
        this.interactor = null;
    }
    //endregion



    //region interfaz ILoginInteractor de LoginInteractor
    // metodo derivado de ISignUpInteractor
    @Override
    public void onUserEmptyError() {
        view.setUserEmptyError();
    }

    // metodo derivado de ISignUpInteractor
    @Override
    public void onPasswordFormatError() {
        view.setPasswordFormatError();
    }

    // metodo derivado de ISignUpInteractor
    @Override
    public void onPasswordEmptyError() {
        view.setPasswordEmptyError();
    }

    // metodo derivado de ISignUpInteractor
    @Override
    public void onPasswordsNotEqualError() {
        view.setPasswordsNotEqualError();
    }

    // metodo derivado de ISignUpInteractor
    @Override
    public void onUserExitsError() {
        view.setUserExitsError();
    }

    // metodo derivado de ISignUpInteractor
    @Override
    public void onSuccess(User user) {
        view.onSucces(user);
    }
    //endregion

}
