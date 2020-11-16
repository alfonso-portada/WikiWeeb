package com.acasema.wikiweeb.iu.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.WikiWeebAplication;
import com.acasema.wikiweeb.data.model.User;
import com.acasema.wikiweeb.iu.WikiWeebActivity;
import com.acasema.wikiweeb.iu.signup.SignUpActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Activity para iniciar sesion
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private TextInputEditText tieUser;
    private TextInputEditText tiePassword;

    private TextInputLayout tilUser;
    private TextInputLayout tilPassword;

    private ProgressBar progressBar;

    private LoginContract.Presenter presenter;

    //region ciclo de la vida de activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tieUser = findViewById(R.id.tieUser);
        tiePassword = findViewById(R.id.tiePassword);

        tilUser = findViewById(R.id.tilUser);
        tilPassword = findViewById(R.id.tilPassword);

        progressBar = findViewById(R.id.progressBar);

        presenter = new LoginPresenter(this);
        //tiePassword.addTextChangedListener();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
    //endregion


    //region metodos de los botones
    public void toSingUpActivity(View v){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void validateUser(View v){
        presenter.validateUser(tieUser.getText().toString(), tiePassword.getText().toString());
    }
    public void GuestAccess(View v){
        presenter.validateUser("invitado","12345678aA");
    }
    //endregion


    //region contraro LoginContract.View
    // metodo derivado del contraro LoginContract.View
    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    // metodo derivado del contraro LoginContract.View
    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    // metodo derivado del contraro LoginContract.View
    @Override
    public void onAuthenticationError() {
        showError(getString(R.string.AuthenticationError));
    }

    // metodo derivado del contraro LoginContract.View heredado de UserView
    @Override
    public void setUserEmptyError() {
        tilUser.setError(getString(R.string.UserEmptyError));
    }

    // metodo derivado del contraro LoginContract.View heredado de UserView
    @Override
    public void setPasswordFormatError() {
        tilPassword.setError(getString(R.string.PasswordFormatError));
    }

    // metodo derivado del contraro LoginContract.View heredado de UserView
    @Override
    public void setPasswordEmptyError() {
        tilPassword.setError(getString(R.string.PasswordEmptyError));
    }

    // metodo derivado del contraro LoginContract.View heredado de UserView heredado de BaseView
    @Override
    public void onSucces(User user) {
        ((WikiWeebAplication) getApplication()).setUser(user);
        Intent intent = new Intent(this, WikiWeebActivity.class);
        startActivity(intent);
    }
    //endregion

    public void showError(String message){
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }
}