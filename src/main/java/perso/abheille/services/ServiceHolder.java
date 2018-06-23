package perso.abheille.services;



import perso.abheille.daos.ArticleDao;
import perso.abheille.daos.AuthorDao;
import perso.abheille.daos.CategorieDao;
import perso.abheille.daos.TagDao;
import perso.abheille.pojos.Article;
import perso.abheille.pojos.Author;
import perso.abheille.pojos.Categorie;
import perso.abheille.pojos.Tag;

import java.util.List;

public class ServiceHolder {

    public ServiceHolder() {
    }

    public static ServiceHolder getInstance() {
        return UtilServiceHolder.instance;
    }

    private ArticleDao articleDao = new ArticleDao();
    private TagDao tagDao = new TagDao();
    private CategorieDao categorieDao = new CategorieDao();
    private AuthorDao authorDao = new AuthorDao();


    public Article getArticleById(int i) {
        return articleDao.getArticleById(i);
    }


    public List<Tag> getTagList() {
        return tagDao.getTagList();
    }


    public List<Categorie> getCategorieList() {
        return categorieDao.getCategorieList();
    }


    public List<Article> getArticleByTag(int idtag) {
        return articleDao.getArticleByTag(idtag);
    }


    public List<Article> getArticleByCategory(int idcategory) {
        return articleDao.getArticleByCategory(idcategory);
    }


    public List<Article> getAllArticles() {
        return articleDao.getAllArticles();
    }

    public void addCategorie(Categorie categorie) {
        categorieDao.addCategorie(categorie);
    }

    public void addAuthor(Author author) {
        authorDao.addAuthor(author);
    }


    private static class UtilServiceHolder {
        private static ServiceHolder instance = new ServiceHolder();
    }


}
