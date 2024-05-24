package question;

public class Proposition {
    private String enonce;
    private boolean estVrai;
    private boolean estChoisi;

    public Proposition(String enonce, boolean estVrai) {
        this.enonce = enonce;
        this.estVrai = estVrai;
    }

    public String getEnonce() {
        return enonce;
    }

    public boolean EstVrai() {
        return estVrai;
    }

    public boolean EstChoisi() {
        return estChoisi;
    }

    public void setEstChoisi(boolean estChoisi) {
        this.estChoisi = estChoisi;
    }
}