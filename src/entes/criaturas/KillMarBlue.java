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
public class KillMarBlue extends Criatura {
    private Jugador jugador;
    
    public KillMarBlue(int x, int y,Sprite sprite, Jugador jugador, Mapa mapa){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.jugador = jugador;
        this.mapa = mapa;
        this.HP = 60;
        this.Velocidad = 2;
        this.originalX = x;
        this.originalY = y;
        this.isKiller = false;
        this.ATK = 1;
    }
    public void actualizar(){
        desplazamientoX =0;
        desplazamientoY =0;
        
        if(animacion < 32767){
            animacion++;
        }else{
            animacion =0;
        }
        
        if(HP<=0 && !isKiller){
            jugador.setPuntaje(jugador.getPuntaje()+60);
            isKiller = true;
        }
        
        if (HP > 0){
            isMove = true;
        }else{
            isMove = false;
        }
        
        if(isMove){
            
            if(Math.sqrt(Math.pow(y-jugador.getY(),2) + Math.pow(x-jugador.getX(),2)) <= 100){
                if(x >= jugador.getX() && y >= jugador.getY()){
                    direccion = 'o';
                }else{
                    direccion = 'e';
                }
                moverX(desplazamientoX,jugador.getX()+24,Velocidad,direccion);
                moverY(desplazamientoY,jugador.getY(),Velocidad,direccion);
                ATK=1;
                jugador.setHP(jugador.getHP()-ATK);
                if(Math.sqrt(Math.pow(y-jugador.getY(),2) + Math.pow(x-jugador.getX(),2)) < 70){
                    ATK=3;
                    jugador.setHP(jugador.getHP()-ATK);
                    if(Math.sqrt(Math.pow(y-jugador.getY(),2) + Math.pow(x-jugador.getX(),2)) < 50){
                        ATK=5;
                        jugador.setHP(jugador.getHP()-ATK);
                    }
                }
            }else{
                ATK =1;
                moverX(desplazamientoX,originalX,Velocidad,direccion);
                moverY(desplazamientoY,originalY,Velocidad,direccion);
            }
            
            if(x==originalX && y==originalY){
                if(animacion % 80 > 40){
                    sprite = Sprite.KMDE0;
                }else if(animacion % 40 > 20){
                    sprite=Sprite.KMIZ0;
                }else if(animacion % 20 > 10){
                    sprite = Sprite.KMUP0;
                }else if (animacion % 10 > 5){
                    sprite = Sprite.KMDOWN0;
                }
            }
            for(int i=0;i<jugador.arrayDisparos.size();i++){
                if(jugador.arrayDisparos.get(i).getBounds().intersects(getBounds())){
                    this.sprite=Sprite.KMDIE;
                    
                    HP = HP - jugador.getAtk();
                    jugador.arrayDisparos.get(i).setStaticX(0);
                    jugador.arrayDisparos.get(i).setStaticY(0);
                    //System.out.println(HP);
                }
            }
            if(direccion == 'o'){
                sprite = Sprite.KMIZ0;
                if(animacion % 20 > 10){
                    sprite = Sprite.KMIZ1;
                }else{
                    sprite = Sprite.KMIZ_1;
                }       
            }
            
            if(direccion == 'e'){
                sprite = Sprite.KMDE0;
                if(animacion % 20 > 10){
                    sprite = Sprite.KMDE1;
                }else{
                    sprite = Sprite.KMDE_1;
                }
            }
            if(direccion == 'n'){
                sprite = Sprite.KMDOWN0;
                if(animacion % 20 > 10){
                    sprite = Sprite.KMDOWN1;
                }else{
                    sprite = Sprite.KMDOWN_1;
                }
            }
            if(direccion == 's'){
                sprite = Sprite.KMUP0;
                if(animacion % 20 > 10){
                    sprite = Sprite.KMUP1;
                }else{
                    sprite = Sprite.KMUP_1;
                }
            }
            
        }else{
            sprite = Sprite.KMDIE;
        }
    }
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarKill(x, y, this);
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,46,46);
    }
}
