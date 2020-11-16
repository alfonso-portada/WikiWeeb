package com.acasema.wikiweeb.data.model;

import java.io.Serializable;

/**
 * clase POJO de review sobre los articulos
 */
public class Review implements Serializable {

    public static final String TAG = "Review";

    public User user;
    public Article article;
    public String review;
    public int score;


    public Review(User user, Article article, String review, int score) {
        this.user = user;
        this.article = article;
        this.review = review;
        this.score = score;
    }


    //region getter and setter
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }

    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    //endregion


    //region Override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (!user.equals(review.user)) return false;
        return article.equals(review.article);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + article.hashCode();
        return result;
    }
    //endregion
}
