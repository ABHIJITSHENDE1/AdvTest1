package Question1;

public class Film {
    private int filmId;
    private String filName ;
    private String filmYear;
    private String filmLang;
    private int filmRate;


    public Film(String filName, String filmYear, String filmLang, int filmRate) {
        this.filName = filName;
        this.filmYear = filmYear;
        this.filmLang = filmLang;
        this.filmRate = filmRate;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilName() {
        return filName;
    }

    public void setFilName(String filName) {
        this.filName = filName;
    }

    public String getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(String filmYear) {
        this.filmYear = filmYear;
    }

    public String getFilmLang() {
        return filmLang;
    }

    public void setFilmLang(String filmLang) {
        this.filmLang = filmLang;
    }

    public int getFilmRate() {
        return filmRate;
    }

    public void setFilmRate(int filmRate) {
        this.filmRate = filmRate;
    }
}

