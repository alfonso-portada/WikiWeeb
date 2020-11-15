package com.acasema.wikiweeb.iu.article.add;

import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.iu.base.BasePresenter;
import com.acasema.wikiweeb.iu.base.BaseView;

public interface AddArticleContract {
    public interface Presenter extends BasePresenter {
        void addArticle(String title, int type, int Classification, String quantity, String synopsis);
    }
    public interface View {
        void setTitleEmptyError();
        void setQuatityEmptyError();
        void setTitleFormatError();
        void setQuatityFormatError();
        void setArticleExitsError();
        void onSucces(Article article);
    }
}
