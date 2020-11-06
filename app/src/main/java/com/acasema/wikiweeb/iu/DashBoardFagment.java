package com.acasema.wikiweeb.iu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.acasema.wikiweeb.R;


public class DashBoardFagment extends Fragment {

    ImageButton ibttAbout;
    ImageButton ibttSettings;

    public DashBoardFagment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dash_board, container, false);

        ibttAbout = v.findViewById(R.id.ibttAbout);
        ibttSettings = v.findViewById(R.id.ibttSetting);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ibttAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAboutFragment();
            }
        });

        ibttSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSettingsFragment();
            }
        });
    }

    public void toAboutFragment(){
        NavHostFragment.findNavController(this).navigate(R.id.action_dashBoardragment_to_aboutFragment);
    }

    public void toSettingsFragment(){
        NavHostFragment.findNavController(this).navigate(R.id.action_dashBoardragment_to_settingsFragment);
    }

}