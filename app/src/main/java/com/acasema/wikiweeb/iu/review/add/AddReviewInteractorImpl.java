package com.acasema.wikiweeb.iu.review.add;

import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.data.model.Review;
import com.acasema.wikiweeb.data.model.User;
import com.acasema.wikiweeb.data.repository.ArticleRepository;
import com.acasema.wikiweeb.data.repository.ReviewRepository;

/**
 * clase  para procesar los datos proporcionados por el presenter y actuar en cosecuencia en el repositorio
 */
public class AddReviewInteractorImpl {

    private IAddReviewInteractor presenter;

    /**
     * Definición de las interfaces que debe implementar cualquier presentador
     * que haga uso del Interactor.
     */
    public interface IAddReviewInteractor{
        void onArticleEmptyError();
        void onReviewEmptyError();
        void onArticleNotExitsError();
        void onReviewExitsError();
        void onSucces(Review review);
    }

    /**
     * Se realiza la asignación de su Presentador en el constructor. La relación es uno a uno.
     * @param presenter que implemente la interfaz
     */
    public AddReviewInteractorImpl(IAddReviewInteractor presenter) {
        this.presenter = presenter;
    }

    /**
     * Este método valida la review verificando los datos y piciendole al repository que lo añada
     */
    public void addReview(User user, String title, int type, String review, int score){
        if (title.isEmpty()){
            presenter.onArticleEmptyError();
            return;
        }
        if (review.isEmpty()){
            presenter.onReviewEmptyError();
            return;
        }
        Article article = ArticleRepository.getInstance().getArticle(title, type);
        if(article == null){
            presenter.onArticleNotExitsError();
            return;
        }
        Review result = ReviewRepository.getInstance().addReview(user, article,review,score);
        if(result == null){
            presenter.onReviewExitsError();
            return;
        }
        presenter.onSucces(result);
    }
}
