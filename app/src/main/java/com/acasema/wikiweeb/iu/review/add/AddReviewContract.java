package com.acasema.wikiweeb.iu.review.add;

import com.acasema.wikiweeb.data.model.Review;
import com.acasema.wikiweeb.data.model.User;
import com.acasema.wikiweeb.iu.base.BasePresenter;
import com.acasema.wikiweeb.iu.base.BaseView;

/**
 * contrato enter presenter y view para no pasar class clase completa y que el presenter tenga todo
 * del fragment y dicecersa
 */
public interface AddReviewContract {
    public interface Presenter extends BasePresenter {
        /**
         * metodo para añadir review
         */
        void addReview(User user,  String title, int type, String review, int score);
    }

    public interface View extends BaseView<Review> {
        void setArticleEmptyError();//Método que indica que el articulo esta vacio
        void setReviewEmptyError();//Método que indica  que el campo review esta bacio
        void setArticleNotExitsError();//Método que indica el articulo no existe
        void setReviewExitsError();//Método que indica que la reviw ya existe
    }
}
