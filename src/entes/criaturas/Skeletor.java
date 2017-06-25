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
        int limiteX = 568;
        int limiteY = 456;
        
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
                    moverX(desplazamientoX,jugador.getX()+24,Velocidad,direccion);
                    moverY(desplazamientoY,jugador.getY(),Velocidad,direccion);
                            
            }
            if(jugador.getBounds().intersects(getBounds())){
                jugador.setHP(jugador.getHP()-ATK);
            }
            
            if(x-limiteX > 0 && y-limiteY == 262){
                moverX(desplazamientoX,limiteX,Velocidad,'o');
            }
            if(x-limiteX ==0){
                moverY(desplazamientoX,limiteY,Velocidad,'n');
            }
            if((y-limiteY)==0){
                moverX(desplazamientoX,originalX,Velocidad,'e');
            }
            if((originalY-y > 0) && x-limiteX == 351){
                moverY(desplazamientoY,originalY,Velocidad,'s');
            }
            for(int i =0; i < jugador.arrayDisparos.size();i++){
                if(jugador.arrayDisparos.get(i).getBounds().intersects(getBounds())){
                    HP = HP - jugador.getAtk();
                    jugador.arrayDisparos.get(i).setStaticX(jugador.arrayDisparos.get(i).getX()+100);
                    jugador.arrayDisparos.get(i).setY(700);
                }
            }
            if(direccion == 'o'){
                sprite = Sprite.SKIZ0;
                 if(isMove){
                    if(animacion % 40 > 20){
                        sprite = Sprite.SKIZ1;
                    }else{
                        sprite = Sprite.SKIZ_1;
                    }
                }
              }
            if(direccion == 's'){   
               sprite = Sprite.SKINICIO0;
                   if(animacion % 40 > 20){
                       sprite = Sprite.SKINICIO1;
                   }else{
                        sprite = Sprite.SKINICIO_1;
                   }
            }
            if(direccion == 'e'){   
               sprite = Sprite.SKDE0;
                   if(animacion % 40 > 20){
                       sprite = Sprite.SKDE1;
                   }else{
                        sprite = Sprite.SKDE_1;
                   }
                
            }
            if(direccion == 'n'){   
               sprite = Sprite.SKABAJO0;
                   if(animacion % 40 > 20){
                       sprite = Sprite.SKABAJO1;
                   }else{
                        sprite = Sprite.SKABAJO_1;
                   }
                
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
