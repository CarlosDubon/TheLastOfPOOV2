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
public class Mago extends Criatura{
    private Jugador jugador;
    private Sprite Izq1;
    private Sprite Izq0;
    private Sprite Izq_1;
    private Sprite Der1;
    private Sprite Der0;
    private Sprite Der_1;
    private Sprite Up1;
    private Sprite Up0;
    private Sprite Up_1;
    private Sprite Dwn1;
    private Sprite Dwn0;
    private Sprite Dwn_1;
    public Mago(int x, int y,Sprite sprite, Jugador jugador,Mapa mapa){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.jugador = jugador;
        this.mapa = mapa;
        this.HP = 50;
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
        
        if(HP >= 25){
            Izq1= Sprite.MGRIZ1;
            Izq0 = Sprite.MGRIZ0;
            Izq_1= Sprite.MGRIZ_1;
            Der1= Sprite.MGRDE1;
            Der0=Sprite.MGRDE0;
            Der_1=Sprite.MGRDE_1;
            Up1= Sprite.MGRABAJO1;
            Up0= Sprite.MGRABAJO0;
            Up_1= Sprite.MGRABAJO_1;
            Dwn1 = Sprite.MGRINICIO1;
            Dwn0=Sprite.MGRINICIO0;
            Dwn_1= Sprite.MGRINICIO_1;
        }else{
            ATK=20;
            Izq1= Sprite.MGAIZ1;
            Izq0 = Sprite.MGAIZ0;
            Izq_1= Sprite.MGAIZ_1;
            Der1= Sprite.MGADE1;
            Der0=Sprite.MGADE0;
            Der_1=Sprite.MGADE_1;
            Up1= Sprite.MGAABAJO1;
            Up0= Sprite.MGAABAJO0;
            Up_1= Sprite.MGAABAJO_1;
            Dwn1 = Sprite.MGAINICIO1;
            Dwn0=Sprite.MGAINICIO0;
            Dwn_1= Sprite.MGAINICIO_1;
        }
        
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
                    if(Math.sqrt(Math.pow(y-jugador.getY(),2) + Math.pow(x-jugador.getX(),2)) < 75){
                        Velocidad = 2;
                    }else{
                        Velocidad = 1;
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
                    HP = HP - jugador.getAtk();
                    jugador.arrayDisparos.get(i).setStaticX(jugador.arrayDisparos.get(i).getX()+1500);
                    jugador.arrayDisparos.get(i).setY(700);
                }
            }
            if(direccion == 'o'){
                sprite = Izq0;
                 if(isMove){
                    if(animacion % 40 > 20){
                        sprite = Izq1;
                    }else{
                        sprite = Izq_1;
                    }
                }
              }
            if(direccion == 's'){   
               sprite = Dwn0;
                   if(animacion % 40 > 20){
                       sprite = Dwn1;
                   }else{
                        sprite = Dwn_1;
                   }
            }
            if(direccion == 'e'){   
               sprite = Der0;
                   if(animacion % 40 > 20){
                       sprite = Der1;
                   }else{
                        sprite = Der_1;
                   }
                
            }
            if(direccion == 'n'){   
               sprite = Up0;
                   if(animacion % 40 > 20){
                       sprite = Up1;
                   }else{
                        sprite = Up_1;
                   }
                
            }
            
        }else{
            sprite = Sprite.MGDIE;
        }
    }
    
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarMago(x, y, this);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,48,48);
    }
}
