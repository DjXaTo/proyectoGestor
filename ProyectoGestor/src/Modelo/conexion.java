package Modelo;

import java.sql.Connection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {

    String usuarioSQL;
    String passSQL;
    String URLSQL;
    String bdSQL;
    
    Connection conn = null;

    public conexion() {
         RecogeDatos();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + URLSQL + "/" + bdSQL, usuarioSQL, passSQL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
    }

    public void RecogeDatos() {
        try {
            File fe = new File("datos_conexion.txt");
            FileReader fr = new FileReader(fe);
            BufferedReader br = new BufferedReader(fr);

            usuarioSQL = br.readLine();
            passSQL = br.readLine();
            URLSQL = br.readLine();
            bdSQL = br.readLine();
                        
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al coger los datos de conexion");
        }
    }

    public Connection conectar() { 
        return conn;
    }
    
    
}
