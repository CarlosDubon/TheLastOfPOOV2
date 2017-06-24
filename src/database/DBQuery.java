
package database;

import control.Puntaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {
    
    private Connection con;
    private PostgresqlConexion conexion;
    
    public DBQuery(){
        conexion = new PostgresqlConexion();
    }
    
    public boolean insertJugador(String Nick, int Puntaje){
        try{
           con = conexion.abrirConexion();
           
           String Query="INSERT INTO jugador(nick,puntaje) VALUES(?,?)";
           PreparedStatement PQuery = con.prepareStatement( Query );
           PQuery.setString(1, Nick);
           PQuery.setInt(2,Puntaje );

           
           
           PQuery.executeUpdate();
           PQuery.close();
           conexion.cerrarConexion(con);
        }catch(SQLException e){
            System.out.println("Aqui esta el error");
            System.out.println("ERROR: "+e.getMessage());
            return false;
        }
        return true;
    }
    
    public Puntaje[] TopScores(){
        Puntaje[] Top10= new Puntaje[10];
        Puntaje Aux;
        int cont=0;
        
        
        try{
            con=conexion.abrirConexion();
            
            String Query= "SELECT * FROM Jugador ORDER BY IdJugador DESC LIMIT 10";
            PreparedStatement PQuery = con.prepareStatement( Query );
            ResultSet RS= PQuery.executeQuery();
            
            while (RS.next()){
                Aux= new Puntaje(RS.getString("nick"), RS.getInt("puntaje"));
                Top10[cont]=Aux;
                cont++;
            }
            
            PQuery.close();
            conexion.cerrarConexion(con);
            return Top10;
        }catch(SQLException e){
            System.out.println("ERROR: "+e.getMessage());
            return null;
        }        
    }
}
