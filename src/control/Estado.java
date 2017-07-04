/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 * Esta clase se encarga de manipular el flujo del juego a paritr de la asignacion de valores predefinidos
 * @author Carlos
 */
public class Estado {
    public static int estado;
    
    /**
     * Incializa el valor del estado en 0, el cual representa el menu del juego
     */
    public Estado(){
        estado = 0;
    }
    
    /**
     * Establece un nuevo al estado del juego <br><br>
     * 0-MENU<br>
     * 1-1er nivel<br>
     * 2-2do nivel<br>
     * 3-3er nivel<br>
     * 4-Puntaje<br>
     * 5-Help<br>
     * 6-Muerte<br>
     * 10- Gane
     * @param Estado Valor del nuevo estado
     */
    public void setEstado(int Estado){
        this.estado = Estado;
    }
    
    /**
     * Devuelve el valor del estado actual
     * @return Valor del estado actual
     */
    public int getEstado(){
        return estado;
    }
}
