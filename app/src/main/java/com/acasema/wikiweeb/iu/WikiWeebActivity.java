package com.acasema.wikiweeb.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.acasema.wikiweeb.R;

/**
 * esta actividad es la base donde se pone el resto de los fragment
 */
public class WikiWeebActivity extends AppCompatActivity {

    //region ciclo de vida
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wikiweeb);
    }
    //endregion

}