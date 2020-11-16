package com.acasema.wikiweeb.data.repository;

import com.acasema.wikiweeb.data.model.Article;
import com.acasema.wikiweeb.data.model.Review;
import com.acasema.wikiweeb.data.model.User;

import java.util.ArrayList;

/**
 * Repositorio de Review
 * esta clase es acesible desde punto de la eplicacion a astraves de getIntance()
 */
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


    /**
     * añade y devuelve un review
     * @param user el creador de la review
     * @param article el articulo al cual se le ace la review
     * @param review la review en si
     * @param score la puntuacion aqui se guarda de 0 al 100, aunque se muentra del 0 al 10 con un decimal
     * @return
     */
    public Review addReview(User user, Article article, String review, int score){
        Review result = new Review(user, article, review, score);

        if(reviews.contains(result))
            return null;

        reviews.add(result);

        return result;
    }
}
