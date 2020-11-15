package com.acasema.wikiweeb.iu.review.add;

import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.data.model.Review;
import com.acasema.wikiweeb.data.model.User;
import com.acasema.wikiweeb.data.repository.ArticleRepository;
import com.acasema.wikiweeb.data.repository.ReviewRepository;

public class AddReviewInteractorImpl {

    private IAddReviewInteractor presenter;

    public interface IAddReviewInteractor{
        void onArticleEmptyError();
        void onReviewEmptyError();
        void onArticleNotExitsError();
        void onReviewExitsError();
        void onSucces(Review review);
    }

    public AddReviewInteractorImpl(IAddReviewInteractor presenter) {
        this.presenter = presenter;
    }

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
