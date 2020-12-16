package com.acasema.wikiweeb.iu.article.list;

import com.acasema.wikiweeb.data.model.Article;

import java.util.Collections;
import java.util.List;

public class ListArticlePresenter implements ListArticleContract.Presenter, ListArticleInteractorIml.ListArticleInteractor {

    private ListArticleContract.View view;
    private ListArticleInteractorIml interactor;

    public ListArticlePresenter(ListArticleContract.View view) {
        this.view = view;
        interactor = new ListArticleInteractorIml(this);
    }

    //region interfaz ListArticleContract.Presenter
    @Override
    public void load() {
        view.showPrograss();
        interactor.load();
        //interactor
    }

    @Override
    public void loadSortByName() {
        view.showPrograss();
        interactor.loadSortByName();
    }

    @Override
    public void onDestroyView() {
        view = null;
    }
    //endregion

    //region interfaz ListArticleInteractorIml.ListArticleInteractor
    @Override
    public void OnNoData() {
        view.hidePrograss();
        view.setNoData();
    }

    @Override
    public void onSucces(List<Article> articles) {
        view.hidePrograss();
        view.onSucces(articles);
    }

    @Override
    public void onSuccesSortByName(List<Article> articles) {
        view.hidePrograss();
        Collections.sort(articles);
        view.onSucces(articles);
    }
    //endregion
}
