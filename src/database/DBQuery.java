
package database;

import control.Puntaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Esta clase administra las querys pertinentes para la insercion y 
 * recuperacion de datos correspondientes a los puntajes de cada partida admministrada
 * @author Dougl
 */
public class DBQuery {
    
    private Connection con;
    private PostgresqlConexion conexion;
    
    /**
     * Inicializa una nueva instancia que permite realizar la conexiona bases de datos por medio del gestor POSTGRESQL
     */
    public DBQuery(){
        conexion = new PostgresqlConexion();
    }
    
    /**
     * Inserta dentro de la base de datos el nombre del jugador y su puntaje
     * @param Nick Nombre del jugador
     * @param Puntaje Puntaje del jugador
     * @return Devuelve true si la query se realizo con exito, y false si fallo algo en el proceso
     */
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
    
    /**
     * Devuelve un Array de objetos tipo Puntaje, compuesto por 10 puestos, que representan las ultimas 10 partidas realizadas
     * @return Array de Puntajes con longitud 10.
     */
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
