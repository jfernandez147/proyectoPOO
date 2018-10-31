package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //generon una variable estatica para verificar que la conexion no se abrio todavia
    private static Conexion instancia = null;
    
    private final String user = "root";
    private final String pass = "";
    private final String url = "jdbc:mysql://localhost:3306/Centro8";
    private Connection con = null;
    
    public static Conexion getInstance(){
        //verifica si se ha abierto una conexion.
        if (instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
    //evita que de otra clase se cree otra conexion.
    private Conexion(){}
    
    //abre la conexion a la base de datos.
    public Connection getConexion(){
        try{
            con = (Connection)DriverManager.getConnection(this.url, this.user, this.pass);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    
}
