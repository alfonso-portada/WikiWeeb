package com.acasema.wikiweeb.iu.article.list;

import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.iu.base.BaseFragmentPresenter;
import com.acasema.wikiweeb.iu.base.BaseListView;

public interface ListArticleContract {
    public interface Presenter extends BaseFragmentPresenter{
        void load();
        void loadSortByName();
    }
    public interface View extends BaseListView<Article> {
        void setNoData();
        void showPrograss();
        void hidePrograss();
    }
}
