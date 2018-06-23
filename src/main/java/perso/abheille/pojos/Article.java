package perso.abheille.pojos;

import java.sql.Timestamp;
import java.util.List;

public class Article {
    private Integer idarticle;
    private String nomArticle;
    private String contenu;
    private Timestamp dateAjout;
    private Author author;
    private Categorie categorie;
    private List<Tag> tag;


    public Article(Integer idarticle,String nomArticle, String contenu, Timestamp dateAjout, Author author,Categorie categorie, List<Tag> tag) {
        this.idarticle=idarticle;
        this.nomArticle=nomArticle;
        this.contenu = contenu;
        this.dateAjout = dateAjout;
        this.author=author;
        this.categorie=categorie;
        this.tag=tag;
    }


    public String getNomArticle() {
        return nomArticle;
    }


    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }


    public int getIdarticle() {
        return idarticle;
    }


    public void setIdarticle(Integer idarticle) {
        this.idarticle = idarticle;
    }


    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    public String getContenu() {
        return contenu;
    }


    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


    public Timestamp getDateAjout() {
        return dateAjout;
    }


    public void setDateAjout(Timestamp dateAjout) {
        this.dateAjout = dateAjout;
    }


    public Author getAuthor() {
        return author;
    }


    public void setAuthor(Author author) {
        this.author = author;
    }


    public Categorie getCategorie() {
        return categorie;
    }


    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
