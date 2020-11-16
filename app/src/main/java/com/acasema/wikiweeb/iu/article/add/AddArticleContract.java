package com.acasema.wikiweeb.iu.article.add;

import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.iu.base.BasePresenter;
import com.acasema.wikiweeb.iu.base.BaseView;

/**
 * contrato enter presenter y view para no pasar class clase completa y que el presenter tenga todo
 * del fragment y dicecersa
 */
public interface AddArticleContract {
    public interface Presenter extends BasePresenter {
        /**
         * metodo para añadir articulo
         */
        void addArticle(String title, int type, int Classification, String quantity, String synopsis);
    }
    public interface View extends BaseView<Article> {
        void setTitleEmptyError();//Método que indica el titulo es vacio
        void setQuatityEmptyError();//Método que indica cantidad es vacio
        void setTitleFormatError();//Método que indica que el formato del titulo no es corecto
        void setQuatityFormatError();//Método que indica que el formato de la cantidad no es corecto
        void setArticleExitsError();//Método que indica el articulo ya existe
    }
}
