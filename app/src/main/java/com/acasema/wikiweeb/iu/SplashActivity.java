package com.acasema.wikiweeb.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.acasema.wikiweeb.R;

public class SplashActivity extends AppCompatActivity {

    private static final long WAIT_TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    /***
     * en estemetodo se deve ejecutar las operaciones de la aplicacion, como conectarse a base de dtas etc.
     * en este caso despues de WAIT_TIME ejecuta el hilo que ejecuta initlogin
     */
    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            initlogin();
            }
        }, WAIT_TIME);
    }

    private void initlogin() {
        startActivity(new Intent(this, LoginActivity.class));
        //vamos a llamar de forma esplicita a finish para terminar la activity
        finish();
    }
}