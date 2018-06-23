package perso.abheille.daos;

import perso.abheille.pojos.Article;
import perso.abheille.pojos.Author;
import perso.abheille.pojos.Categorie;
import perso.abheille.pojos.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {

    public Article getArticleById(int idArticle) {
        String query = "SELECT article.idarticle,article.nomarticle, article.contenu,article.dateajout,"
                + "author.idauthor,author.authorname,author.authorbio , "
                + "categorie.idcategorie,categorie.nomcategorie "
                + "FROM article "
                + "JOIN author ON article.idauthor=author.idauthor "
                + "JOIN categorie ON article.idcategorie=categorie.idcategorie "
                + "JOIN article_has_tag ON article.idarticle=article_has_tag.idarticle "
                + "WHERE article.idarticle=?";
        List<Article> listOfArticle = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idArticle);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listOfArticle.add(
                        new Article(
                                resultSet.getInt("idarticle"),
                                resultSet.getString("nomarticle"),
                                resultSet.getString("contenu"),
                                resultSet.getTimestamp("dateajout"),
                                new Author(
                                        resultSet.getInt("idauthor"),
                                        resultSet.getString("authorname"),
                                        resultSet.getString("authorbio")
                                ),
                                new Categorie(
                                        resultSet.getInt("idcategorie"),
                                        resultSet.getString("nomcategorie")
                                ),
                                getArticleTagList(resultSet.getInt("idarticle"))
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfArticle.get(0);
    }

    public List<Article> getArticleByTag(int idtag){
        String query = "SELECT article.idarticle,article.nomarticle, article.contenu,article.dateajout,"
                + "author.idauthor,author.authorname,author.authorbio , "
                + "categorie.idcategorie,categorie.nomcategorie "
                + "FROM article "
                + "JOIN author ON article.idauthor=author.idauthor "
                + "JOIN categorie ON article.idcategorie=categorie.idcategorie "
                + "JOIN article_has_tag ON article.idarticle=article_has_tag.idarticle "
                + "JOIN tag ON article_has_tag.idtag=tag.idtag "
                + "WHERE tag.idtag=?";
        List<Article> listOfArticleByTag = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idtag);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listOfArticleByTag.add(
                        new Article(
                                resultSet.getInt("idarticle"),
                                resultSet.getString("nomarticle"),
                                resultSet.getString("contenu"),
                                resultSet.getTimestamp("dateajout"),
                                new Author(
                                        resultSet.getInt("idauthor"),
                                        resultSet.getString("authorname"),
                                        resultSet.getString("authorbio")
                                ),
                                new Categorie(
                                        resultSet.getInt("idcategorie"),
                                        resultSet.getString("nomcategorie")
                                ),
                                getArticleTagList(resultSet.getInt("idarticle"))
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfArticleByTag;
    }
    public List<Article> getArticleByCategory (int idcategorie){
        String query = "SELECT article.idarticle,article.nomarticle, article.contenu,article.dateajout,"
                + "author.idauthor,author.authorname,author.authorbio , "
                + "categorie.idcategorie,categorie.nomcategorie "
                + "FROM article "
                + "JOIN author ON article.idauthor=author.idauthor "
                + "JOIN categorie ON article.idcategorie=categorie.idcategorie "
                + "WHERE categorie.idcategorie=?";
        List<Article> listOfArticleByCategory = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idcategorie);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listOfArticleByCategory.add(
                        new Article(
                                resultSet.getInt("idarticle"),
                                resultSet.getString("nomarticle"),
                                resultSet.getString("contenu"),
                                resultSet.getTimestamp("dateajout"),
                                new Author(
                                        resultSet.getInt("idauthor"),
                                        resultSet.getString("authorname"),
                                        resultSet.getString("authorbio")
                                ),
                                new Categorie(
                                        resultSet.getInt("idcategorie"),
                                        resultSet.getString("nomcategorie")
                                ),
                                getArticleTagList(resultSet.getInt("idarticle"))
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfArticleByCategory;
    }


    public List<Article> getAllArticles() {
        String query = "SELECT article.idarticle,article.nomarticle, article.contenu,article.dateajout, "
                + "author.idauthor,author.authorname,author.authorbio , "
                + "categorie.idcategorie,categorie.nomcategorie "
                + "FROM article "
                + "JOIN author ON article.idauthor=author.idauthor "
                + "JOIN categorie ON article.idcategorie=categorie.idcategorie ";
        List<Article> listOfAllArticles = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                listOfAllArticles.add(
                        new Article(
                                resultSet.getInt("idarticle"),
                                resultSet.getString("nomarticle"),
                                resultSet.getString("contenu"),
                                resultSet.getTimestamp("dateajout"),
                                new Author(
                                        resultSet.getInt("idauthor"),
                                        resultSet.getString("authorname"),
                                        resultSet.getString("authorbio")
                                ),
                                new Categorie(
                                        resultSet.getInt("idcategorie"),
                                        resultSet.getString("nomcategorie")
                                ),
                                getArticleTagList(resultSet.getInt("idarticle"))
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfAllArticles;
    }

    private List<Tag> getArticleTagList(int idarticle) {
        String query = "SELECT tag.idtag,tag.tagname FROM tag JOIN article_has_tag ON tag.idtag=article_has_tag.idtag " +
                "WHERE article_has_tag.idarticle=?";
        List<Tag> articleTagList = new ArrayList<>();
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idarticle);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                articleTagList.add(
                        new Tag(
                                resultSet.getInt("idtag"),
                                resultSet.getString("tagname")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articleTagList;
    }
}



