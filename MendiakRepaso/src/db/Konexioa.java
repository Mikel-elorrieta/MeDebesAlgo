package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {
    private String url = "jdbc:mysql://localhost:3307/montes";
    private String user = "root";
    private String pass = "";
    private Connection connection;

    public Konexioa() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("konexioa ondo eginda");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("konexioa itxita");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
