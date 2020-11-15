package com.acasema.wikiweeb.iu.review.add;

import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.data.model.Review;
import com.acasema.wikiweeb.data.model.User;
import com.acasema.wikiweeb.iu.base.BasePresenter;

public interface AddReviewContract {
    public interface Presenter extends BasePresenter {
        void addReview(User user,  String title, int type, String review, int score);
    }

    public interface View {
        void setArticleEmptyError();
        void setReviewEmptyError();
        void setArticleNotExitsError();
        void setReviewExitsError();
        void onSucces(Review review);
    }
}
