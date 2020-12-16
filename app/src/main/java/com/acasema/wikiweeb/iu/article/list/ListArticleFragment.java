package com.acasema.wikiweeb.iu.article.list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.adapter.ArticleAdapter;
import com.acasema.wikiweeb.data.model.Article;

import java.util.ArrayList;
import java.util.List;


public class ListArticleFragment extends Fragment implements ListArticleContract.View, ArticleAdapter.OnArticleLisener{

    private ListArticlePresenter presenter;

    private RecyclerView rvArticle;

    private ArticleAdapter adapter;

    private LinearLayout llNoData;
    private LinearLayout llProgresbar;

    private Toolbar toolbar;

    public ListArticleFragment() {
        // Required empty public constructor
    }

    //region ciclo de vida
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_article, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.toolbar);

        llNoData = view.findViewById(R.id.llNoData);
        llProgresbar = view.findViewById(R.id.llProgresbar);


        rvArticle = view.findViewById(R.id.rvArticle);

        //1. crear el adapter
        adapter = new ArticleAdapter(new ArrayList<Article>(), this);

        //2. diseño de RV
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        //3. se asigna el disaño
        rvArticle.setLayoutManager(layoutManager);

        //4. vincula la vista al modelo
        rvArticle.setAdapter(adapter);

        presenter = new ListArticlePresenter(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.load();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroyView();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_rv_article, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sortByName:
                listSortByName();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    //endregion


    //region contrato con ListArticleContract.View
    @Override
    public void setNoData() {
        llNoData.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPrograss() {
        llProgresbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePrograss() {
        llProgresbar.setVisibility(View.GONE);
    }

    @Override
    public void onSucces(List<Article> list) {
        if(llNoData.getVisibility() == View.VISIBLE)
            llNoData.setVisibility(View.GONE);
        adapter.update(list);
    }

    //endregion


    //region interfaces ArticleAdapter.OnArticleLisener
    @Override
    public void onClickArticle(Article article) {

        Toast.makeText(getContext(), article.toString(), Toast.LENGTH_LONG).show();
        Bundle bundle =new Bundle();
        bundle.putSerializable(Article.TAG, article);
        NavHostFragment.findNavController(this).navigate(R.id.action_listArticleFragment_to_viewArticleFragment, bundle);

    }
    //endregion


    //region opciones del menu propias de este fragment
    public void listSortByName(){
        presenter.loadSortByName();
    }
    //endregion
}