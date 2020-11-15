package com.acasema.wikiweeb.iu.review.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.data.model.Review;


public class ViewReviewFragment extends Fragment {

    private TextView tvTitle;
    private TextView tvReview;
    private TextView tvScore;

    private Button btnUser;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_review, container, false);

        tvTitle = v.findViewById(R.id.tvTitle);
        tvReview = v.findViewById(R.id.tvReview);
        tvScore = v.findViewById(R.id.tvScore);

        btnUser = v.findViewById(R.id.btnUser);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if(bundle != null){
            Review review = (Review) bundle.getSerializable(Review.TAG);
            tvTitle.setText(getResources().getStringArray(R.array.ArticleType)[review.getArticle().getType()] +" de "+ review.getArticle().getTitle());
            tvReview.setText(review.getReview());
            tvScore.setText(getString(R.string.tvScore)+ Float.toString(review.getScore()/10));

            btnUser.setText(review.user.getUser());
            btnUser.setClickable(false);
            btnUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }
}