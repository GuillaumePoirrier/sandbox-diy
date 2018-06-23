package perso.abheille.pojos;

public class Tag {
    private Integer idtag;
    private String tagname;



    public Tag(Integer idtag, String tagname) {
        this.idtag = idtag;
        this.tagname = tagname;

    }


    public int getIdtag() {
        return idtag;
    }


    public void setIdtag(Integer idtag) {
        this.idtag = idtag;
    }


    public String getTagname() {
        return tagname;
    }


    public void setTagname(String tagname) {
        this.tagname = tagname;
    }
}
