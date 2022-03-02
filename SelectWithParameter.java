package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectWithParameter {

   
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/moviesdatas.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectParticularMovie(){
        String sql = "SELECT moviename,Actor,Actress,yearofrelease,director FROM moviesdata where Actor='Ajith Kumar'";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("moviename") +  "\t" + 
                                   rs.getString("Actor") + "\t" +
                                   rs.getString("Actress") + "\t" +
                                   rs.getInt("yearofrelease") + "\t" +
                                   rs.getString("director")
                                   );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        SelectWithParameter app = new SelectWithParameter();
        app.selectParticularMovie();
    }

}