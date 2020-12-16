package com.acasema.wikiweeb.iu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.acasema.wikiweeb.R;

public class AboutActivity extends AppCompatActivity {

    private String urlMeLinkedin;
    private ImageButton imgBtLinkedin;

    private String urlJNKpage;
    private ImageButton imgBtJNKpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        imgBtLinkedin = findViewById(R.id.imgBtLinkedin);
        urlMeLinkedin = "https://www.linkedin.com/in/alfonso-carlos-serrano-mart%C3%ADn-ab8b1b158/";

        imgBtJNKpage = findViewById(R.id.imgBtJNKpage);
        urlJNKpage = "crosspoplay.000webhostapp.com";

        imgBtLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewInternet(urlMeLinkedin);
            }
        });
        imgBtJNKpage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ViewInternet(urlJNKpage);
            }
        });

    }


    public void ViewInternet(String url){
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}