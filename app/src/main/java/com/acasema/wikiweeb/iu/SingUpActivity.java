package com.acasema.wikiweeb.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.user.AddUserContract;
import com.acasema.wikiweeb.user.UserPresenter;
import com.google.android.material.textfield.TextInputEditText;

public class SingUpActivity extends AppCompatActivity implements AddUserContract.View{
    private String user;
    private String password;
    private String repitePassword;
    private String email;
    private AddUserContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        TextInputEditText tieUser = findViewById(R.id.tieUser);
        user = tieUser.getText().toString();

        TextInputEditText tiePassword = findViewById(R.id.tiePassword);
        password = tiePassword.getText().toString();

        TextInputEditText tieRepiterPassword = findViewById(R.id.tieRepiterPassword);
        repitePassword = tieRepiterPassword.getText().toString();

        TextInputEditText tieEmail = findViewById(R.id.tieEmail);
        email = tieEmail.getText().toString();

        presenter = new UserPresenter(this);

        findViewById(R.id.bttSingUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               signUp();
            }
        });
    }
    public void signUp(){
        //1. reglas de negocio RN-1, RN-2, RN-3
        if(validateUser(user) && validatePassword(password, repitePassword) && validateEmail(email))
            presenter.addUser(user, password, email);
    }

    /**
     * que email complete los requisitos funcionales
     */
    private boolean validateEmail(String email) {
        return true;
    }

    /**
     * que password complete los requisitos funcionales
     */
    private boolean validatePassword(String password, String repiutePassword) {
        return true;
    }

    /**
     * que user complete los requisitos funcionales
     */
    private boolean validateUser(String user) {
        return true;
    }

    /**
     * validad que el usuario no esta duplicado
     */
    @Override
    public void emailDuplicateError() {

    }

    /**
     * si es corecto vamos al activity
     */
    @Override
    public void onSucces() {
        Intent intent = new Intent(this, InventoryActivity.class);
        startActivity(intent);
    }
}