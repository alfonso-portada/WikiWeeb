package com.acasema.wikiweeb.data.repository;

import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.data.model.Review;
import com.acasema.wikiweeb.data.model.User;

import java.util.ArrayList;

public class ReviewRepository {
    private static ReviewRepository repository;
    private ArrayList<Review> reviews;

    static {repository = new ReviewRepository();}

    private ReviewRepository(){
        reviews = new ArrayList<>();
        initialice();
    }

    public static ReviewRepository getInstance(){
        return repository;
    }

    private void initialice() {

    }

    public Review addReview(User user, Article article, String review, int score){
        Review result = new Review(user, article, review, score);

        if(reviews.contains(result))
            return null;

        reviews.add(result);

        return result;
    }
}
