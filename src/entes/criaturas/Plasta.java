/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import mapa.Mapa;

/**
 *
 * @author Carlos
 */
public class Plasta extends Criatura {

    private Teclado teclado;
    private Jugador jugador;


    
    
    
    public Plasta(Teclado teclado,int x, int y,Sprite sprite,Jugador jugador,Mapa mapa){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.teclado = teclado;
        this.HP = 30;
        this.Velocidad = 1;
        this.originalX = x;
        this.originalY = y;
        this.jugador = jugador;
        this.mapa=mapa;
        isKiller = false;
        ATK = 2;
    
    }
    
    @Override
    public void actualizar(){

        desplazamientoX =0;
        desplazamientoY =0;
        int limiteX = 950;
        int limiteY = 250;
        
        
        if (HP > 0){
            isMove = true;
        }else if(HP<=0 && !isKiller){
            jugador.setPuntaje(jugador.getPuntaje()+20);
            isKiller = true;
            isMove = false;
        }
        
        if (animacion < 32767){
            animacion ++;
        }else{
            animacion =0;
        }
        
        
        if(isMove){
            if(x >= jugador.getX() && y >= jugador.getY()){
                direccion = 'o';
            }else{
                direccion = 'e';
            }
            if(Math.sqrt(Math.pow(y-jugador.getY(),2) + Math.pow(x-jugador.getX(),2)) <= 100){
                    moverX(desplazamientoX,jugador.getX()+24,Velocidad,direccion);
                    moverY(desplazamientoY,jugador.getY(),Velocidad,direccion);
                                               
            }
           
            if(jugador.getBounds().intersects(getBounds())){
                jugador.setHP(jugador.getHP()-ATK);
            }
            
            
            
            if(x-limiteX > 0 && y-limiteY == 250){
                moverX(desplazamientoX,limiteX,Velocidad,'o');
            }
            if(x-limiteX ==0){
                moverY(desplazamientoX,limiteY,Velocidad,'n');
            }
            if((y-limiteY)==0){
                moverX(desplazamientoX,originalX,Velocidad,'e');
            }
            if((originalY-y > 0) && x-limiteX == 250){
                moverY(desplazamientoY,originalY,Velocidad,'s');
            }
            
            for(int i=0;i<jugador.arrayDisparos.size();i++){
                if(jugador.arrayDisparos.get(i).getBounds().intersects(getBounds())){
                    this.sprite=Sprite.PLASTAD;
                    
                    HP = HP - jugador.getAtk();
                    jugador.arrayDisparos.get(i).setStaticX(0);
                    jugador.arrayDisparos.get(i).setStaticY(0);
                    //System.out.println(HP);
                }
            }
            
            if(direccion == 'o'){
                sprite = Sprite.PLASTAIZ0;
                 if(isMove){
                    if(animacion % 20 > 10){
                        sprite = Sprite.PLASTAIZ1;
                    }else{
                        sprite = Sprite.PLASTAIZ_1;
                    }
                }
              }
            if(direccion == 'n'){   
               sprite = Sprite.PLASTAUP0;
                   if(animacion % 20 > 10){
                       sprite = Sprite.PLASTAUP1;
                   }else{
                        sprite = Sprite.PLASTAUP_1;
                   }
            }
            if(direccion == 'e'){   
               sprite = Sprite.PLASTADE0;
                   if(animacion % 20 > 10){
                       sprite = Sprite.PLASTADE1;
                   }else{
                        sprite = Sprite.PLASTADE_1;
                   }
                
            }
            if(direccion == 's'){   
               sprite = Sprite.PLASTAIN0;
                   if(animacion % 20 > 10){
                       sprite = Sprite.PLASTAIN_1;
                   }else{
                        sprite = Sprite.PLASTAIN1;
                   }
                
            }
        }else {
            sprite = Sprite.PLASTADIE;
        }
    }
    
    public void mostrar(Pantalla pantalla){

        pantalla.mostrarPlasta(x, y, this);
        

    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,32,32);
    }
    
    
    
}
