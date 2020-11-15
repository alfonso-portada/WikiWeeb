package com.acasema.wikiweeb.data.repository;

import android.widget.ArrayAdapter;

import com.acasema.wikiweeb.data.model.Article;

import java.util.ArrayList;

public class ArticleRepository {
    private static ArticleRepository repository;
    private ArrayList<Article> articles;

    static {repository = new ArticleRepository();}

    private ArticleRepository(){
        articles = new ArrayList<>();
        initialice();
    }

    public static ArticleRepository getInstance(){
        return repository;
    }

    private void initialice() {
        articles.add(new Article("add",0));
        articles.add(new Article("add",1));
        articles.add(new Article("app",2));
        articles.add(new Article("att",0));
        articles.add(new Article("att",1));
        articles.add(new Article("att",2));
    }

    public Article addArticle(String title, int type, int classification, String quantity, String synopsis){
        Article result = new Article(title, type, classification, quantity, synopsis);

        if(articles.contains(result))
            return null;

        articles.add(result);

        return result;
    }
    public ArrayList<Article> getArticles(){
        return articles;
    }

    public ArrayList<Article> getArticlesWithTheSameType(int type){
        ArrayList<Article> result = new ArrayList<Article>();
        for (int i = 0; i < articles.size(); i++) {
            if(articles.get(i).getType() == type){
                result.add(articles.get(i));
            }
        }
        return result;
    }

    public Article getArticle(String title, int type){
        int result = articles.indexOf(new Article(title, type));
        if(result<0)
            return null;
        return articles.get(result);
    }
}
