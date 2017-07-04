/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;
import juego.TheLastOfPOO;

/**
 * Clase que se encarga del funcionamiento del tiempo en el juego
 * @author Dougl
 */
public class Tiempo implements Runnable{
    private int milisegundos;
    private int segundos;
    private int minutos;
    
    private String SegAux;
    private String MinAux;
    
    /**
     * Inicializa el valor del tiempo en 0
     */
    public Tiempo(){
        milisegundos=0;
        segundos=0;
        minutos=0;
    }
    /**
     * Hace el conteo del timepo en intervalos de 10 ms, actualizando los atributos de la clase y el tiempo en la clase pricipal del juego.
     */
    @Override
    public void run() {
           
        try{
           while(TheLastOfPOO.ControlTiempo){
                Thread.sleep(5);
               milisegundos+=5;

               if(milisegundos == 1000){
                   segundos++;
                   TheLastOfPOO.segundos++;
                   milisegundos=0;
               }

               if(segundos == 60){
                   minutos ++;
                   segundos=0;
               }


               if(segundos < 10){
                   SegAux= "0"+ segundos;
               }
               else{
                   SegAux=""+segundos;
               }

               if(minutos < 10){
                   MinAux= "0"+ minutos;
               }
               else{
                   MinAux=""+minutos;
               }

               TheLastOfPOO.TiempoF=MinAux+":"+SegAux;
           } 
            
        }catch(Exception e){}           
            
        
    }
    
    
    
}
