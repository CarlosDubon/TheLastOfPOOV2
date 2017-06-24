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
 *
 * @author Dougl
 */
public class Heart extends Criatura{
    Pantalla pantalla;
    private int animacion;
    private Jugador jugador;
    private boolean HeartUsed=false;
    public Heart(int x, int y, Sprite sprite,Jugador jugador, Mapa mapa){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.mapa = mapa;
        this.jugador = jugador;
        isMove = true;
    }
    
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
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarHeart(x, y, this);
    
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,32,32);
    }

    public boolean isHeartUsed() {
        return HeartUsed;
    }
}
