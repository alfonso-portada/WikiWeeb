package com.acasema.wikiweeb.data.repository;

import android.widget.ArrayAdapter;

import com.acasema.wikiweeb.data.model.Article;

import java.util.ArrayList;

/**
 * Repositorio de articulos
 * esta clase es acesible desde punto de la eplicacion a astraves de getIntance()
 */
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

    /**
     * añade y devuelve un articulo
     * @param title el titulo del articulo
     * @param type el tipo del articulo
     * @param classification la clasificacion del articulo
     * @param quantity la cantidad del articulo
     * @param synopsis la sinopsis del articulo
     * @return el articulo o null si ya existe
     */
    public Article addArticle(String title, int type, int classification, String quantity, String synopsis){
        Article result = new Article(title, type, classification, quantity, synopsis);

        if(articles.contains(result))
            return null;

        articles.add(result);

        return result;
    }

    /**
     * devuelve el arrayList completo
     * @return el arratList
     */
    public ArrayList<Article> getArticles(){
        return articles;
    }

    /**
     * devuelve el arrayList filtrando solo por un tipo (type)
     * @param type el tipo
     * @return el arrayList
     */
    public ArrayList<Article> getArticlesWithTheSameType(int type){
        ArrayList<Article> result = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {
            if(articles.get(i).getType() == type){
                result.add(articles.get(i));
            }
        }
        return result;
    }

    /**
     * devuelve el articulo apartir de las claves
     * @param title el titulo es parte de la clave
     * @param type el tipo es parte de la clave
     * @return el articulo completo
     */
    public Article getArticle(String title, int type){
        int result = articles.indexOf(new Article(title, type));
        if(result<0)
            return null;
        return articles.get(result);
    }
}
