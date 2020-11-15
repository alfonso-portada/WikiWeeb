package com.acasema.wikiweeb.iu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.acasema.wikiweeb.R;

public class AboutFragment extends Fragment {

    private String urlMeLinkedin;
    private ImageButton imgBtLinkedin;

    private String urlJNKpage;
    private ImageButton imgBtJNKpage;

    public AboutFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, container, false);

        imgBtLinkedin = v.findViewById(R.id.imgBtLinkedin);
        urlMeLinkedin = "https://www.linkedin.com/in/alfonso-carlos-serrano-mart%C3%ADn-ab8b1b158/";

        imgBtJNKpage = v.findViewById(R.id.imgBtJNKpage);
        urlJNKpage = "crosspoplay.000webhostapp.com";
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
