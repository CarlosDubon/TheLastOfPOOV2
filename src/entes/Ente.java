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
 * Case abstracta que se encarga de tener los metodos comunes entre todas las criarutas.
 */
public abstract class Ente {
    
    protected int x; // posicion X de una criatura
    protected int y; // posicion Y de una criatura
    
    private boolean eliminado = false; // determina si una criatura esta eliminada muy parecida a ente
    protected Mapa mapa; // variable de tipo mapa 
    
    /**
     * Se encarga de actualziar el estado de una criatura
     */
    public void actualizar(){
    }
    
    /**
     * Se encarga de mostrar en pantalla la criatura
     */
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
    /**
     * Metodo que por medio de un valor <b> x </b> que se le envie como parametro <br>
     * aumenta el valor de x de la criatura en el valor <b> x </b> enviado por parametro.
     * @param x paso al que se desea aumentar la posicion X
     */
    public void setX(int x){
        this.x += x;
    }
    /**
     * Metodo que por medio de un valor <b> y </b> que se le envie como parametro <br>
     * aumenta el valor de x de la criatura en el valor <b> y </b> enviado por parametro.
     * @param y paso al que se desea aumentar la posicion Y
     */
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
