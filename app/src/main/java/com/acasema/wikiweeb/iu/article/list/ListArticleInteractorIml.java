package com.acasema.wikiweeb.iu.article.list;

import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.data.repository.ArticleRepository;

import java.util.List;

public class ListArticleInteractorIml {

    public ListArticleInteractor CallBack;



    public interface ListArticleInteractor{
        void OnNoData();
        void onSucces(List<Article> articles);
        void onSuccesSortByName(List<Article> articles);
    }

    public ListArticleInteractorIml(ListArticleInteractor callBack) {
        CallBack = callBack;
    }

    public void load(){
        List<Article> articles = ArticleRepository.getInstance().getArticles();
        if (articles.size()>0)
            CallBack.onSucces(articles);
        else
            CallBack.OnNoData();
    }
    public void loadSortByName() {
        List<Article> articles = ArticleRepository.getInstance().getArticles();
        if (articles.size()>0)
            CallBack.onSuccesSortByName(articles);
        else
            CallBack.OnNoData();
    }

}
