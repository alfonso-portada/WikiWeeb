package com.acasema.wikiweeb.iu.review.add;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.WikiWeebAplication;
import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.data.model.Review;
import com.acasema.wikiweeb.data.repository.ArticleRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Fragment  para añadir Review
 */
public class AddReviewFragment extends Fragment implements AddReviewContract.View {

    private FloatingActionButton fab;

    private Spinner spinnerTypeArticle;

    private AutoCompleteTextView actvTitle;
    private TextInputEditText tieReview;

    private TextInputLayout tilTitle;
    private TextInputLayout tilReview;

    private SeekBar sbScore;
    private TextView tvScore;

    private AddReviewContract.Presenter presenter;

    public AddReviewFragment() {
    }


    //region metodos del ciclo de vida
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_review, container, false);

        fab = v.findViewById(R.id.fab);

        spinnerTypeArticle = v.findViewById(R.id.spinnerTypeArticle);

        actvTitle = v.findViewById(R.id.actvTitle);

        tieReview = v.findViewById(R.id.tieReview);

        tilTitle = v.findViewById(R.id.tilTitle);
        tilReview = v.findViewById(R.id.tilReview);

        sbScore = v.findViewById(R.id.sbScore);
        tvScore = v.findViewById(R.id.tvScore);

        presenter = new AddReviewPresenter(this);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<CharSequence> adapterTypeArticle = ArrayAdapter.createFromResource(getActivity(), R.array.ArticleType, android.R.layout.simple_spinner_item);
        adapterTypeArticle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeArticle.setAdapter(adapterTypeArticle);

        updateAutocompletede();

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addReview();
            }
        });

        sbScore.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTvScore(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        actvTitle.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                updateAutocompletede();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    //endregion


    //region AddArticleContract.View

    @Override
    public void setArticleEmptyError() {
        tilTitle.setError(getString(R.string.ArticleEmptyError));
    }

    @Override
    public void setReviewEmptyError() {
        tilReview.setError(getString(R.string.ReviewEmptyError));
    }

    @Override
    public void setArticleNotExitsError() {
        showErrorWithButton(getString(R.string.ArticleNotExitsError), getString(R.string.create), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAddArticleFragment(new Article(actvTitle.getText().toString(),
                        spinnerTypeArticle.getSelectedItemPosition()));
            }
        });
    }

    @Override
    public void setReviewExitsError() {
        showError(getString(R.string.ReviewExitsError));
    }

    @Override
    public void onSucces(Review review) {
        toViewReviewFragment(review);
    }
    //endregion


    //region MyMetodo
    private void addReview() {
        presenter.addReview(((WikiWeebAplication)getActivity().getApplication()).getUser(),
                actvTitle.getText().toString(),spinnerTypeArticle.getSelectedItemPosition(),
                tieReview.getText().toString(), sbScore.getProgress());
    }

    public void showError(String message){
        Snackbar.make(getActivity().findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }
    public void showErrorWithButton(String message, String buttonMenssage, View.OnClickListener onClickListener){
        Snackbar.make(getActivity().findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).setAction(buttonMenssage, onClickListener).show();
    }

    private void updateAutocompletede() {
        ArrayAdapter<Article> adapterAutoCompleteText = new ArrayAdapter<Article>(getActivity(),
                android.R.layout.simple_expandable_list_item_1,
                ArticleRepository.getInstance().getArticlesWithTheSameType(spinnerTypeArticle.getSelectedItemPosition()));
        actvTitle.setAdapter(adapterAutoCompleteText);
    }

    private void updateTvScore(float score){
        tvScore.setText(Float.toString(score/10));
    }

    private void toAddArticleFragment(Article article){
        Bundle bundle =new Bundle();
        bundle.putSerializable(Article.TAG, article);
        NavHostFragment.findNavController(this).navigate(R.id.action_addReviewFragment_to_addArticleFragment, bundle);
    }
    private void toViewReviewFragment(Review review){
        Bundle bundle =new Bundle();
        bundle.putSerializable(Review.TAG, review);
        NavHostFragment.findNavController(this).navigate(R.id.action_addReviewFragment_to_viewReviewFragment, bundle);
    }
    //endregion

}