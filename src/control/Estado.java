/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Carlos
 */
public class Estado {
    public static int estado;
    
    public Estado(){
        estado = 0;
    }
    
    public void setEstado(int Estado){
        this.estado = Estado;
    }
    public int getEstado(){
        return estado;
    }
}
