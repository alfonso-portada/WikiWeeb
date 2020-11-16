package com.acasema.wikiweeb.iu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.acasema.wikiweeb.R;

/**
 * Fragment provisional que tiene los aceso al resto de los fragment
 */
public class DashBoardFagment extends Fragment {

    private Button bttAbout;
    private Button bttViewUser;
    private Button bttAddArticle;
    private Button bttAddReview;

    public DashBoardFagment(){}

    //region ciclo de vida
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dash_board, container, false);

        bttAbout = v.findViewById(R.id.bttAbout);
        bttViewUser = v.findViewById(R.id.bttViewUser);
        bttAddArticle = v.findViewById(R.id.bttAddArticle);
        bttAddReview = v.findViewById(R.id.bttAddReview);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bttAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAboutFragment();
            }
        });
        bttViewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toViewUserFragment();
            }
        });
        bttAddArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAddArticleFragment();
            }
        });
        bttAddReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAddReviewFragment();
            }
        });
    }
    //endregion


    //region metodos para moverse a diferenter fragment
    private void toAddArticleFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_dashBoardragment_to_addArticleFragment);
    }

    private void toViewUserFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_dashBoardragment_to_viewUserFragment);
    }

    public void toAboutFragment(){
        NavHostFragment.findNavController(this).navigate(R.id.action_dashBoardragment_to_aboutFragment);
    }
    public void toAddReviewFragment(){
        NavHostFragment.findNavController(this).navigate(R.id.action_dashBoardragment_to_addReviewFragment);
    }
    //endregion
}