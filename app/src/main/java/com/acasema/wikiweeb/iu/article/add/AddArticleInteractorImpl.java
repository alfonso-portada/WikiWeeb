package com.acasema.wikiweeb.iu.article.add;

import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.data.repository.ArticleRepository;

import static com.acasema.wikiweeb.iu.utils.CommonUtils.isPositiveNumbreValid;
import static com.acasema.wikiweeb.iu.utils.CommonUtils.isTitleArticleValid;

public class AddArticleInteractorImpl {

    public IAddArticleInteractor presenter;

    public interface IAddArticleInteractor{
        void onTitleEmptyError();
        void onQuatityEmptyError();
        void onTitleFormatError();
        void onQuatityFormatError();
        void onArticleExitsError();
        void onSucces(Article article);
    }

    public AddArticleInteractorImpl(IAddArticleInteractor presenter){
        this.presenter = presenter;
    }

    public void addArticle(String title, int type, int classification, String quantity, String synopsis){
        if(title.isEmpty()) {
            presenter.onTitleEmptyError();
            return;
        }
        if(quantity.isEmpty()){
            presenter.onQuatityEmptyError();
            return;
        }
        if(!isTitleArticleValid(title)){
            presenter.onTitleFormatError();
            return;
        }
        if(!isPositiveNumbreValid(quantity)){
            presenter.onQuatityFormatError();
            return;
        }
        Article result = ArticleRepository.getInstance().addArticle(title, type, classification, quantity, synopsis);
        if (result == null){
            presenter.onArticleExitsError();
            return;
        }
        presenter.onSucces(result);

    }

}
