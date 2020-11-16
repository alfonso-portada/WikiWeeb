package com.acasema.wikiweeb.iu.article.add;

import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.data.repository.ArticleRepository;

import static com.acasema.wikiweeb.iu.utils.CommonUtils.isPositiveNumbreValid;
import static com.acasema.wikiweeb.iu.utils.CommonUtils.isTitleArticleValid;

/**
 * clase  para procesar los datos proporcionados por el presenter y actuar en cosecuencia en el repositorio
 */
public class AddArticleInteractorImpl {

    public IAddArticleInteractor presenter;

    /**
     * Definición de las interfaces que debe implementar cualquier presentador
     * que haga uso del Interactor.
     */
    public interface IAddArticleInteractor{
        void onTitleEmptyError();
        void onQuatityEmptyError();
        void onTitleFormatError();
        void onQuatityFormatError();
        void onArticleExitsError();
        void onSucces(Article article);
    }

    /**
     * Se realiza la asignación de su Presentador en el constructor. La relación es uno a uno.
     * @param presenter que implemente la interfaz
     */
    public AddArticleInteractorImpl(IAddArticleInteractor presenter){
        this.presenter = presenter;
    }

    /**
     * Este método valida el article verificando los datos y piciendole al repository que lo añada
     */
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
