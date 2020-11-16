package com.acasema.wikiweeb.iu.article.add;

import com.acasema.wikiweeb.data.model.Article;

/**
 * presenter para añadir articulo
 */
public class AddArticlePresenter implements AddArticleContract.Presenter, AddArticleInteractorImpl.IAddArticleInteractor {

    private AddArticleContract.View view;
    private AddArticleInteractorImpl interactor;

    public AddArticlePresenter(AddArticleContract.View view){
        this.view = view;
        this.interactor = new AddArticleInteractorImpl(this);
    }

    //region metodos de AddArticleContract.Presenter
    @Override
    public void addArticle(String title, int type, int Classification, String quantity, String synopsis) {
        interactor.addArticle(title, type, Classification, quantity, synopsis);
    }

    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }
    //endregion


    //region metodos de IAddArticleInteractor
    @Override
    public void onTitleEmptyError() {
        view.setTitleEmptyError();
    }

    @Override
    public void onQuatityEmptyError() {
        view.setQuatityEmptyError();
    }

    @Override
    public void onTitleFormatError() {
        view.setTitleFormatError();
    }

    @Override
    public void onQuatityFormatError() {
        view.setQuatityFormatError();
    }

    @Override
    public void onArticleExitsError() {
        view.setArticleExitsError();
    }

    @Override
    public void onSucces(Article article) {
        view.onSucces(article);
    }
    //endregion
}
