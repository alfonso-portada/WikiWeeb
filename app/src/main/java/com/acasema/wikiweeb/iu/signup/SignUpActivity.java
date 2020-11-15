package com.acasema.wikiweeb.iu.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.WikiWeebAplication;
import com.acasema.wikiweeb.data.model.User;
import com.acasema.wikiweeb.iu.WikiWeebActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity implements SignUpContract.View{
    private TextInputEditText tieUser;
    private TextInputEditText tiePassword;
    private TextInputEditText tieConfirmPassword;

    private TextInputLayout tilUser;
    private TextInputLayout tilPassword;
    private TextInputLayout tilConfirmPassword;

    private SignUpContract.Presenter presenter;


    //region ciclo de la vida de activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        tieUser = findViewById(R.id.tieUser);
        tiePassword = findViewById(R.id.tiePassword);
        tieConfirmPassword = findViewById(R.id.tieRepiterPassword);

        tilUser = findViewById(R.id.tilUser);
        tilPassword = findViewById(R.id.tilPassword);
        tilConfirmPassword = findViewById(R.id.tilRepiterPassword);

        presenter = new SignUpPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
    //endregion


    //region metodos de los botones
    public void signUp(View view){
            presenter.addUser(tieUser.getText().toString(), tiePassword.getText().toString(),
                    tieConfirmPassword.getText().toString());
    }
    //endregion


    //region contraro LoginContract.View
    // metodo derivado del contraro SignUpContract.View heredado de UserView heredado de BaseView
    @Override
    public void onSucces(User user) {
        ((WikiWeebAplication) getApplication()).setUser(user);
        Intent intent = new Intent(this, WikiWeebActivity.class);
        startActivity(intent);
    }

    // metodo derivado del contraro SignUpContract.View
    @Override
    public void setPasswordsNotEqualError() {
        tilConfirmPassword.setError(getString(R.string.PasswordsNotEqualError));
    }

    // metodo derivado del contraro SignUpContract.View
    @Override
    public void setUserExitsError() {
        tilUser.setError(getString(R.string.UserExitsError));
    }

    // metodo derivado del contraro SignUpContract.View heredado de UserView
    @Override
    public void setUserEmptyError() {
        tilUser.setError(getString(R.string.UserEmptyError));
    }

    // metodo derivado del contraro SignUpContract.View heredado de UserView
    @Override
    public void setPasswordFormatError() {
        tilPassword.setError(getString(R.string.PasswordFormatError));
    }

    // metodo derivado del contraro SignUpContract.View heredado de UserView
    @Override
    public void setPasswordEmptyError() {
        tilPassword.setError(getString(R.string.PasswordEmptyError));
    }
    //endregion


}