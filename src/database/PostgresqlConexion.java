
package database;

import java.sql.*;

public class PostgresqlConexion {   
    
    public void cerrarConexion(Connection con){
        try{
            con.close();
        }
        catch(SQLException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    
    public Connection abrirConexion() {
        String driver = "org.postgresql.Driver";
        String connectString = "jdbc:postgresql://localhost:5432/TheLastOfPOO";
        String user = "postgres";
        String password = "root";
        Connection con = null;
        try{
            con = DriverManager.getConnection(connectString, user, password);
        }   
        catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
        finally{
            if(con != null)
                return con;
            else
                return null;
        }
    }
    

}
