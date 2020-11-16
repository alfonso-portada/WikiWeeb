package com.acasema.wikiweeb.iu.article.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.data.model.Article;

/**
 * fragment no completo para ver articulo
 */
public class ViewArticleFragment extends Fragment {

    private Article article;

    private TextView tvTitle;
    private TextView tvCategory;
    private TextView tvQuantity;
    private TextView tvSynopsis;

    public ViewArticleFragment() {}

    //region ciclo de vida
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view_article, container, false);

        tvTitle= v.findViewById(R.id.tvTitle);
        tvCategory= v.findViewById(R.id.tvCategory);
        tvQuantity= v.findViewById(R.id.tvQuantity);
        tvSynopsis= v.findViewById(R.id.tvSynopsis);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle != null){
            article = (Article) bundle.getSerializable(Article.TAG);
            tvTitle.setText(getResources().getStringArray(R.array.ArticleType)[article.getType()] +" de "+ article.getTitle());
            tvCategory.setText(getString(R.string.tvCategory)+ getResources().getStringArray(R.array.ArticleType)[article.getCategory()]);
            tvQuantity.setText(getString(R.string.tvquantity)+ article.getQuantity());
            tvSynopsis.setText(article.getSynopsis());
        }
    }
    //endregion
}