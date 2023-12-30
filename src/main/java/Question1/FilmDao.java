package Question1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDao {
    List<Film> filmList = new ArrayList<>();
    List<Film> top3FilmList = new ArrayList<>();
    private static Connection conn= null;
    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmDb","root","tiger");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public int insertInfo(Film film) {

        int n= 0;

        try {

            String query = "insert into filmInfo(filnName,filmYear,filmLang,filmRate) values(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,film.getFilName());
            pstmt.setString(2,film.getFilmYear());
            pstmt.setString(3,film.getFilmLang());
            pstmt.setInt(4,film.getFilmRate());
             n = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }


    public int updateFilmYear(String upYear, String fname) {
        int n = 0;
        String query = "UPDATE filmInfo SET filmYear = '" + upYear + "' WHERE filnName = '" + fname + "'";
        try {
            Statement stmt = conn.createStatement();
            n = stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }


    public List<Film> displayTop1Movie() {
        try {
            String query = "select * from filmInfo where filmRate > (SELECT AVG(filmRate) from filmInfo)";
            Film film = null;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int fId = rs.getInt(1);
                String fName = rs.getString(2);
                String Year = rs.getString(3);
                String Lang = rs.getString(4);
                int rate  = rs.getInt(5);
                 film = new Film(fName,Year,Lang,rate);
                 filmList.add(film);
            }

        } catch (SQLException e) {

        }
        return filmList;
    }

    public List<Film> top3Movie() {
        String query = "   SELECT *  \n" +
                " FROM filmInfo\n" +
                "ORDER BY filmRate DESC\n" +
                "LIMIT 3;";

        Film film = null;
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int fId = rs.getInt(1);
                String fName = rs.getString(2);
                String Year = rs.getString(3);
                String Lang = rs.getString(4);
                int rate  = rs.getInt(5);
                film = new Film(fName,Year,Lang,rate);
                top3FilmList.add(film);
            }

        } catch (SQLException e) {

        }

        return top3FilmList;

    }
    


}
