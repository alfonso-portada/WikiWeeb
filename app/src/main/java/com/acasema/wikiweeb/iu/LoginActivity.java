package com.acasema.wikiweeb.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.user.UserPresenter;
import com.acasema.wikiweeb.user.ValidateUserContract;

public class
LoginActivity extends AppCompatActivity implements ValidateUserContract.View {
    ValidateUserContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new UserPresenter(this);
    }

    public void toInventoryActivity(View v){

        Intent intent = new Intent(this, InventoryActivity.class);
        startActivity(intent);
    }

    public void validateUsaer(View v){
        presenter.validateUser("","");
    }

    /**
     * se muestra al usuario que no esiste el email
     */
    @Override
    public void emailNotExistError() {

    }

    /**
     * se muestra al usuario que no es corecto la contraseña
     */
    @Override
    public void passwordError() {

    }

    @Override
    public void onSucces() {
        Intent intent = new Intent(this, SingUpActivity.class);
        startActivity(intent);

    }
}