package perso.abheille.pojos;

public class Author {

    private Integer idauthor;

    private String authorname;

    private String authorbio;


    public Author(Integer idauthor, String authorname, String authorbio) {
        this.idauthor = idauthor;
        this.authorname = authorname;
        this.authorbio = authorbio;
    }


    public int getIdauthor() {
        return idauthor;
    }


    public void setIdauthor(Integer idauthor) {
        this.idauthor = idauthor;
    }


    public String getAuthorname() {
        return authorname;
    }


    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }


    public String getAuthorbio() {
        return authorbio;
    }


    public void setAuthorbio(String authorbio) {
        this.authorbio = authorbio;
    }
}
