package com.acasema.wikiweeb.iu.review.add;

import com.acasema.wikiweeb.data.model.Review;
import com.acasema.wikiweeb.data.model.User;

/**
 * presenter para añadir review
 */
public class AddReviewPresenter implements AddReviewContract.Presenter, AddReviewInteractorImpl.IAddReviewInteractor {

    private AddReviewContract.View view;
    private AddReviewInteractorImpl interactor;

    public AddReviewPresenter(AddReviewContract.View view){
        this.view = view;
        this.interactor = new AddReviewInteractorImpl(this);
    }


    //region AddReviewContract.Presenter
    @Override
    public void addReview(User user, String title, int type, String review, int score) {
        interactor.addReview(user, title, type, review, score);
    }
    @Override
    public void onDestroy() {
        this.view = null;
        this.interactor = null;
    }
    //endregion


    //region IAddReviewInteractor

    @Override
    public void onArticleEmptyError() {
        view.setArticleEmptyError();
    }

    @Override
    public void onReviewEmptyError() {
        view.setReviewEmptyError();
    }

    @Override
    public void onArticleNotExitsError() {
        view.setArticleNotExitsError();
    }

    @Override
    public void onReviewExitsError() {
        view.setReviewExitsError();
    }

    @Override
    public void onSucces(Review review) {
        view.onSucces(review);
    }

        //endregion

}
