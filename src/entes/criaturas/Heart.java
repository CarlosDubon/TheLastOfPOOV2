/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes.criaturas;

import graficos.Pantalla;
import graficos.Sprite;
import java.awt.Rectangle;
import mapa.Mapa;

/**
 * Se encarga de darle funcion al aumento de HP dentro del juego
 * @author Dougl
 */
public class Heart extends Criatura{
    Pantalla pantalla;
    private int animacion;
    private Jugador jugador;
    private boolean HeartUsed=false;
    /**
     *  Inicializa los atributos de la clase
     * @param x posicion X en la que aparecera
     * @param y posicion Y en la que aparecera
     * @param sprite Sprite del corazon
     * @param jugador objeto de tipo jugador
     * @param mapa mapa en el cual aparecera
     */
    public Heart(int x, int y, Sprite sprite,Jugador jugador, Mapa mapa){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.mapa = mapa;
        this.jugador = jugador;
        isMove = true;
    }
    /**
     * Se encarga actualizar el estado del item en el juego
     */
    @Override
    public void actualizar(){
        

        if (animacion < 32767){
            animacion ++;
        }else{
            animacion =0;
        }
        
        
        if(isMove){
            sprite = Sprite.HEART1;
            if(animacion % 80 > 40 ){
                sprite = Sprite.HEART1;
            } 
            if(animacion % 40 > 20){
                sprite = Sprite.HEART2;
            } 
        }else{
            sprite=Sprite.HEARTNULL;
            
        }
        
        if(jugador.getBounds().intersects(getBounds()) && !HeartUsed){
            
            jugador.setHP(jugador.getHP()+20);
            
            HeartUsed=true;
            
            this.isMove=false;
        }
    }
    /**
     * Mustra el item en pantalla en el mapa indicado
     * @param pantalla 
     */
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarHeart(x, y, this);
    
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,32,32);
    }
     /**
      * Verifica si el item ya ha sido recogido
      * @return 
      */
    public boolean isHeartUsed() {
        return HeartUsed;
    }
}
