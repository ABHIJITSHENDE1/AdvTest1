package Question1;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static Scanner in = new Scanner(System.in);
    private static FilmDao filmDao = new FilmDao();
    public static void main(String[] args) {
        System.out.println("Enter Option");
        System.out.println("1:Insert Film Info");
        System.out.println("2:Update Film Info");
        System.out.println("3:Top 1 Rated Movie");
        System.out.println("4:Top 3 Movie BY Rating");
        int ch = in.nextInt();
        switch (ch){
            case 1:
                insertFilm();
                break;
            case 2:
                updateFilmYear();
                break;
            case 3:
                top1RatedMovie();
                break;
            case 4:
                top3RatedMovie();
                break;
        }

    }

    private static void top3RatedMovie() {
        List<Film> top3MoviefilmList = filmDao.top3Movie();
        System.out.println("Top 3 Movie Is");
        for (Film f: top3MoviefilmList){
            System.out.println("Film Name : "+f.getFilName());
            System.out.println("Year : "+f.getFilmYear());
            System.out.println("Language : " + f.getFilmLang());
            System.out.println("Rate : "+ f.getFilmRate());
            System.out.println("-----------------------------");
        }
    }

    private static void top1RatedMovie() {
        List<Film> filmList = filmDao.displayTop1Movie();
        for (Film f : filmList){
            System.out.println("Top 1 Movie Is");
            System.out.println("Film Name : "+f.getFilName());
            System.out.println("Year : "+f.getFilmYear());
            System.out.println("Language : " + f.getFilmLang());
            System.out.println("Rate : "+ f.getFilmRate());
            System.out.println("-----------------------------");

        }

    }

    private static void updateFilmYear() {
        System.out.println("Enter Film Updated Film year");
        String upYear = in.next();
        System.out.println("Enter Film Name");
        String fname = in.next();
        int n = filmDao.updateFilmYear(upYear,fname);
        System.out.println(n + "Rows Updated");
    }

    private static void insertFilm() {
        System.out.println("Enter Film Info----->");
        System.out.println("Enter Film Name");
        String fName = in.next();
        System.out.println("Enter film Year");
        String filmYear = in.next();
        System.out.println("Enter Film Lang");
        String lang = in.next();
        System.out.println("Enter Film Rating");
        int fRate = in.nextInt();
        Film film = new Film(fName,filmYear,lang,fRate);
        int n= filmDao.insertInfo(film);
        System.out.println(n + " Rows Inserted");
    }

}
