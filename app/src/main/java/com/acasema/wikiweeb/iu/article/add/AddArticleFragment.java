package com.acasema.wikiweeb.iu.article.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.data.model.Article;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddArticleFragment extends Fragment implements AddArticleContract.View {

    private FloatingActionButton fabAddUser;

    private Spinner spinnerTypeArticle;
    private Spinner spinnerClassification;

    private TextInputEditText tieTitle;
    private TextInputEditText tieQuantity;
    private TextInputEditText tieSynopsis;

    private TextInputLayout tilTitle;
    private TextInputLayout tilQuantity;
    private TextInputLayout tilSynopsis;

    private AddArticleContract.Presenter presenter;

    public AddArticleFragment(){

    }

    //region metodos del ciclo de vida
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_article, container, false);

        fabAddUser = v.findViewById(R.id.fabAddUser);

        spinnerTypeArticle = v.findViewById(R.id.spinnerTypeArticle);
        spinnerClassification = v.findViewById(R.id.spinnerClassification);

        tieTitle = v.findViewById(R.id.tieTitle);
        tieQuantity = v.findViewById(R.id.tieQuantity);
        tieSynopsis = v.findViewById(R.id.tieSynopsis);

        tilTitle = v.findViewById(R.id.tilTitle);
        tilQuantity = v.findViewById(R.id.tilQuantity);
        tilSynopsis = v.findViewById(R.id.tilSynopsis);

        presenter = new AddArticlePresenter(this);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if(bundle != null){
            Article article = (Article) bundle.getSerializable(Article.TAG);
            tieTitle.setText(article.getTitle());
            spinnerTypeArticle.setSelection(article.getType());

        }

        ArrayAdapter<CharSequence> adapterTypeArticle = ArrayAdapter.createFromResource(getActivity(), R.array.ArticleType, android.R.layout.simple_spinner_item);
        adapterTypeArticle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypeArticle.setAdapter(adapterTypeArticle);

        ArrayAdapter<CharSequence> adapterClassification = ArrayAdapter.createFromResource(getActivity(), R.array.Classification, android.R.layout.simple_spinner_item);
        adapterClassification.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClassification.setAdapter(adapterClassification);

        fabAddUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }
    //endregion

    private void addUser() {
        presenter.addArticle(tieTitle.getText().toString(),spinnerTypeArticle.getSelectedItemPosition(),
                spinnerClassification.getSelectedItemPosition(), tieQuantity.getText().toString(),
                tieSynopsis.getText().toString());
    }

    public void showError(String message){
        Snackbar.make(getActivity().findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    //region AddArticleContract.View
    @Override
    public void setTitleEmptyError() {
        tilTitle.setError(getString(R.string.TitleEmptyError));
    }

    @Override
    public void setQuatityEmptyError() {
        tilQuantity.setError(getString(R.string.QuatityEmptyError));
    }

    @Override
    public void setTitleFormatError() {
        tilTitle.setError(getString(R.string.TitleFormatError));
    }

    @Override
    public void setQuatityFormatError() {
        tilQuantity.setError(getString(R.string.QuatityFormatError));
    }

    @Override
    public void setArticleExitsError() {
        showError(getString(R.string.ArticleExitsError));
    }

    @Override
    public void onSucces(Article article) {
        Bundle bundle =new Bundle();
        bundle.putSerializable(Article.TAG, article);
        NavHostFragment.findNavController(this).navigate(R.id.action_addArticleFragment_to_viewArticleFragment, bundle);
    }
    //endregion

}
