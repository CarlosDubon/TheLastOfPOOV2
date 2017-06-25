/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes.criaturas;

import control.Estado;
import graficos.Pantalla;
import graficos.Sprite;
import java.awt.Rectangle;

import mapa.Mapa;

/**
 *
 * @author Carlos
 */
public class Portal extends Criatura {
    Pantalla pantalla;
    private int animacion;
    private Jugador jugador;
    public Portal(int x, int y, Sprite sprite,Jugador jugador, Mapa mapa){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.mapa = mapa;
        this.jugador = jugador;
    }
    
    @Override
    public void actualizar(){
        isMove = true;

        if (animacion < 32767){
            animacion ++;
        }else{
            animacion =0;
        }
        
        sprite = Sprite.PORTAL1;
        if(isMove){
            if(animacion % 20 > 10 ){
                sprite = Sprite.PORTAL2;
            } 
            if(animacion % 20 > 10){
                sprite = Sprite.PORTAL3;
            } 
            if(animacion % 20 > 10){
                sprite = Sprite.PORTAL4;
            }
        }
        
        if(jugador.getBounds().intersects(getBounds())){
            switch (Estado.estado){
                case 1:
                    jugador.setStaticX(400);
                    jugador.setStaticY(300);
                    Estado.estado=2;
                    x = 1245;
                    y = 960;
                    break;
                case 2:
                    jugador.setStaticX(400);
                    jugador.setStaticY(265);
                    Estado.estado=3;
                    x = 0;
                    y = 0;
                    break;
            }
            
            
            
        }
    }
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarPortal(x, y, this);
    
    }
    public Rectangle getBounds(){
        return new Rectangle(x+10,y+10,22,22);
    }
}
