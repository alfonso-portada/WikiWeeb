package com.acasema.wikiweeb.data.model;


import java.io.Serializable;

/**
 * Clase POJO de aticulos
 */
public class Article implements Serializable {

    public static final String TAG = "Article";

    private String title;
    private int type;
    private int quantity;
    private int category;
    private String synopsis;


    //region contructores
    public Article(String title, int type, int category, String quantity , String synopsis) {
        this.title = title;
        this.type = type;
        this.category =category;
        this.quantity = Integer.parseInt(quantity);
        this.synopsis = synopsis;
    }
    public Article(String title, int type) {
        this.title = title;
        this.type =  type;
    }
    //endregion


    //region getter and setter
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }

    public String getSynopsis() {
        return synopsis;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    //endregion


    //region override
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (!title.equals(article.title)) return false;
        return type == article.type;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result * type;
        return result;
    }

    @Override
    public String toString() {
        return title;
    }
    //endregion

}
