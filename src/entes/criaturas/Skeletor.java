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
 * @author Carlos
 */
public class Skeletor extends Criatura {
    private Jugador jugador;
    public Skeletor(int x, int y,Sprite sprite, Jugador jugador,Mapa mapa){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.jugador = jugador;
        this.mapa = mapa;
        this.HP = 30;
        this.Velocidad = 1;
        this.originalX = x;
        this.originalY = y;
        this.isKiller = false;
        this.ATK = 10;
    }
    @Override
    public void actualizar(){
        desplazamientoX =0;
        desplazamientoY =0;
        
        if(animacion < 32767){
            animacion++;
        }else{
            animacion =0;
        }
        
        if(HP<=0 && !isKiller){
            jugador.setPuntaje(jugador.getPuntaje()+40);
            isKiller = true;
        }
        
        if (HP > 0){
            isMove = true;
        }else{
            isMove = false;
        }
        if(isMove){
            if(x >= jugador.getX() && y >= jugador.getY()){
                direccion = 'o';
            }else if(x < jugador.getX() && y < jugador.getY()){
                direccion = 'e';
            }
            if(Math.sqrt(Math.pow(y-jugador.getY(),2) + Math.pow(x-jugador.getX(),2)) <= 250){
                    moverX(desplazamientoX,jugador.getX(),Velocidad,direccion);
                    moverY(desplazamientoY,jugador.getY(),Velocidad,direccion);
                            
            }
            if(jugador.getBounds().intersects(getBounds())){
                jugador.setHP(jugador.getHP()-ATK);
            }
            
        }else{
            sprite = Sprite.SKADIE;
        }
    }
    
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarSkeletor(x, y, this);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,48,48);
    }
    
}
