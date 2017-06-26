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
public class BatyRed extends Criatura {
    private Jugador jugador;
    
    public BatyRed(int x, int y, Sprite sprite, Jugador jugador,Mapa mapa){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.jugador = jugador;
        this.mapa = mapa;
        this.HP = 45;
        this.Velocidad = 2;
        this.originalX = x;
        this.originalY = y;
        this.isKiller = false;
        this.ATK = 5;
        this.direccion = 'o';
    
    }
    public BatyRed(int x, int y, Sprite sprite, Jugador jugador,Mapa mapa,char direccion){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.jugador = jugador;
        this.mapa = mapa;
        this.HP = 45;
        this.Velocidad = 2;
        this.originalX = x;
        this.originalY = y;
        this.isKiller = false;
        this.ATK = 5;
        this.direccion = direccion;
    
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
            jugador.setPuntaje(jugador.getPuntaje()+45);
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
                if(Math.sqrt(Math.pow(y-jugador.getY(),2) + Math.pow(x-jugador.getX(),2)) < 100){
                    Velocidad = 4;
                }else{
                    Velocidad = 2;
                }
            }else{
                moverX(desplazamientoX,originalX,Velocidad,direccion);
                moverY(desplazamientoY,originalY,Velocidad,direccion);
            }
            if(jugador.getBounds().intersects(getBounds())){
                jugador.setHP(jugador.getHP()-ATK);
            }
            for(int i =0; i < jugador.arrayDisparos.size();i++){
                if(jugador.arrayDisparos.get(i).getBounds().intersects(getBounds())){
                    this.HP = HP-jugador.getAtk();
                    jugador.arrayDisparos.get(i).setStaticX(0);
                    jugador.arrayDisparos.get(i).setStaticY(0);
                }
            }
            
            if(direccion == 'o'){
                sprite = Sprite.BATRIZ0;
                if(animacion % 20 > 10){
                    sprite = Sprite.BATRIZ1;
                }else{
                    sprite = Sprite.BATRIZ_1;
                }       
            }
            
            if(direccion == 'e'){
                sprite = Sprite.BATRDE0;
                if(animacion % 20 > 10){
                    sprite = Sprite.BATRDE1;
                }else{
                    sprite = Sprite.BATRDE_1;
                }
            }
            if(direccion == 'n'){
                sprite = Sprite.BATRINICIO0;
                if(animacion % 20 > 10){
                    sprite = Sprite.BATRINICIO1;
                }else{
                    sprite = Sprite.BATRINICIO_1;
                }
            }
            if(direccion == 's'){
                sprite = Sprite.BATRABAJO0;
                if(animacion % 20 > 10){
                    sprite = Sprite.BATRABAJO_1;
                }else{
                    sprite = Sprite.BATRABAJO1;
                }
            }
        }else{
            sprite = Sprite.BATRADIE;
        }
    }
    
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarBatyRed(x,y, this);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,48,48);
    }
}

