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
public class Tauro extends Criatura{
    private Jugador jugador;
    
    public Tauro(int x, int y, Sprite sprite,Jugador jugador, Mapa mapa){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.jugador = jugador;
        this.mapa = mapa;
        this.HP = 40;
        this.Velocidad = 3;
        this.originalX = x;
        this.originalY = y;
        this.isKiller = false;
        this.ATK = 4;
    }
    @Override
    public void actualizar(){
        desplazamientoX =0;
        desplazamientoY =0;
        int limiteY = 749;
        
        if(animacion < 32767){
            animacion++;
        }else{
            animacion =0;
        }
        
        if(HP<=0 && !isKiller){
            jugador.setPuntaje(jugador.getPuntaje()+50);
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
            
            if(Math.sqrt(Math.pow(y-jugador.getY(),2) + Math.pow(x-jugador.getX(),2)) <= 200){
                moverX(desplazamientoX,jugador.getX()+24,Velocidad,direccion);
                moverY(desplazamientoY,jugador.getY(),Velocidad,direccion);
            }
            
            if(y<limiteY){
                moverY(desplazamientoY,limiteY,Velocidad,'s');
            }
            if(y>originalY){
                moverY(desplazamientoY,originalY,Velocidad,'s');
            }
            
            
            for(int i =0; i < jugador.arrayDisparos.size();i++){
                if(jugador.arrayDisparos.get(i).getBounds().intersects(getBounds())){
                    this.HP = HP-jugador.getAtk();
                    jugador.arrayDisparos.get(i).setStaticX(0);
                    jugador.arrayDisparos.get(i).setStaticY(0);
                }
            }
            
            if(direccion == 'o'){
                sprite = Sprite.TRIZ0;
                if(animacion % 20 > 10){
                    sprite = Sprite.TRIZ1;
                }else{
                    sprite = Sprite.TRIZ_1;
                }       
            }
            
            if(direccion == 'e'){
                sprite = Sprite.TRDE0;
                if(animacion % 20 > 10){
                    sprite = Sprite.TRDE1;
                }else{
                    sprite = Sprite.TRDE_1;
                }
            }
            if(direccion == 's'){
                sprite = Sprite.TRDOWN0;
                if(animacion % 20 > 10){
                    sprite = Sprite.TRDOWN1;
                }else{
                    sprite = Sprite.TRDOWN_1;
                }
            }
            if(direccion == 'n'){
                sprite = Sprite.TRUP0;
                if(animacion % 20 > 10){
                    sprite = Sprite.TRUP1;
                }else{
                    sprite = Sprite.TRUP_1;
                }
            }
            
            }else{
                sprite = Sprite.TRDIE;
            }
    }
    
    public void moostrar(Pantalla pantalla){
        pantalla.mostrarTauro(x, y, this);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,48,48);
    }
}
