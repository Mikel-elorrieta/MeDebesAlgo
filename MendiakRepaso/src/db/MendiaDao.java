package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modeloa.Mendia;

public class MendiaDao {
    private Konexioa konexioa;

    public MendiaDao() {
        konexioa = new Konexioa();
    }

    public Mendia[] getAllObjetuak() {
        Mendia[] mendiaList = null;
        int count = 0;

        try (Connection con = konexioa.getConnection()) {
            String countSql = "SELECT COUNT(*) AS total FROM `montes`";
            try (PreparedStatement countPstmt = con.prepareStatement(countSql)) {
                try (ResultSet countRs = countPstmt.executeQuery()) {
                    if (countRs.next()) {
                        count = countRs.getInt("total");
                    }
                }
            }

            mendiaList = new Mendia[count];

            String sql = "SELECT * FROM `montes`";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    int index = 0;
                    while (rs.next()) {
                        String Nombre = rs.getString("Nombre");
                        String Provincia = rs.getString("Provincia");
                        String Altura = rs.getString("Altura");
                        String Coordenadas = rs.getString("Coordenadas");
                        String Macizo = rs.getString("Cordillera");
                        String Ruta = rs.getString("Ruta");

                        Mendia mendia = new Mendia(Nombre, Provincia, Altura, Coordenadas, Macizo, Ruta);
                        mendiaList[index] = mendia;
                        index++;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            konexioa.desconectar();
        }

        return mendiaList;
    }
    public boolean insertMendia(Mendia mendia) {
        boolean inserted = false;
        try (Connection con = konexioa.getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO `montes` (Nombre, Provincia, Altura, Coordenadas, Cordillera,Ruta) VALUES (?, ?, ?, ?, ?, ?)")) {
            pstmt.setString(1, mendia.getNombre());
            pstmt.setString(2, mendia.getProvincia());
            pstmt.setString(3, mendia.getAltura());
            pstmt.setString(4, mendia.getCoordenadas() );
            pstmt.setString(5, mendia.getMacizo());
            pstmt.setString(6, mendia.getRuta());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                inserted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inserted;
    }
    
    public boolean deleTaula() {
        boolean deleted = false;
        try (Connection con = konexioa.getConnection();
             PreparedStatement pstmt = con.prepareStatement("DELETE FROM `montes`")) {
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                deleted = true;
                System.out.println("Datos dentro de la tabla montes eliminados exitosamente.");
            } else {
                System.out.println("No se encontraron datos dentro de la tabla montes.");
            } 
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return deleted;

    }

    

}