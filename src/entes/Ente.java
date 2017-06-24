/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes;

import graficos.Pantalla;
import mapa.Mapa;

/**
 *
 * @author Carlos
 */
public abstract class Ente {
    protected int x;
    protected int y;
    
    private boolean eliminado = false;
    protected Mapa mapa;
    
    public void actualizar(){
    }
    
    public void mostrar(){
    
    }
    
    public void eliminar(){
        eliminado = true;
    }
    
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x += x;
    }
    public void setY(int y){
        this.y += y;
    }
    public void setStaticX(int x){
        this.x = x;
    }
    public void setStaticY(int y){
        this.y = y;
    }
    public boolean getEliminado(){
        return eliminado;
    }
}
