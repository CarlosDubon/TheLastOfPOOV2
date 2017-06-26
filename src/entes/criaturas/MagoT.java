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
public class MagoT extends Criatura{
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
    
    private int contador;
    private int NewY;
    private int NewX;
   
    
    public MagoT(int x, int y,Sprite sprite, Jugador jugador,Mapa mapa, int NewX,int NewY){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.jugador = jugador;
        this.mapa = mapa;
        this.HP = 70;
        this.NewX= NewX;
        this.NewY= NewY;
        this.Velocidad = 1;
        this.originalX = x;
        this.originalY = y;
        this.isKiller = false;
        this.ATK = 15;
        
        Izq1= Sprite.MGTIZ1;
        Izq0 = Sprite.MGTIZ0;
        Izq_1= Sprite.MGTIZ_1;
        Der1= Sprite.MGTDE1;
        Der0=Sprite.MGTDE0;
        Der_1=Sprite.MGTDE_1;
        Up1= Sprite.MGTABAJO1;
        Up0= Sprite.MGTABAJO0;
        Up_1= Sprite.MGTABAJO_1;
        Dwn1 = Sprite.MGTINICIO1;
        Dwn0=Sprite.MGTINICIO0;
        Dwn_1= Sprite.MGTINICIO_1;
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
        
        if (contador < 120){
            contador ++;
        }else{
            contador=0;
        }
        
        if(HP<=0 && !isKiller){
            jugador.setPuntaje(jugador.getPuntaje()+55);
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
                if(contador < 60){
                    setStaticX(originalX);
                    setStaticY(originalY);
                }else{
                    setStaticX(NewX);
                    setStaticY(NewY);
                }
                
            }        
            
            if(jugador.getBounds().intersects(getBounds())){
                jugador.setHP(jugador.getHP()-ATK);
            }
            
            for(int i =0; i < jugador.arrayDisparos.size();i++){
                if(jugador.arrayDisparos.get(i).getBounds().intersects(getBounds())){
                    HP = HP - jugador.getAtk();
                    jugador.arrayDisparos.get(i).setStaticX(0);
                    jugador.arrayDisparos.get(i).setStaticY(0);
                }
            }
            if(direccion == 'o'){
                sprite = Izq0;
                 if(isMove){
                    if(animacion % 60 > 30){
                        sprite = Izq1;
                    }else{
                        sprite = Sprite.MGTSING;
                    }
                }
              }
            if(direccion == 's'){   
               sprite = Dwn0;
                   if(animacion % 60 > 30){
                       sprite = Dwn1;
                   }else{
                        sprite = Sprite.MGTSING;
                   }
            }
            if(direccion == 'e'){   
               sprite = Der0;
                   if(animacion % 60 > 30){
                       sprite = Der1;
                   }else{
                        sprite = Sprite.MGTSING;
                   }
                
            }
            if(direccion == 'n'){   
               sprite = Up0;
                   if(animacion % 60 > 30){
                       sprite = Up1;
                   }else{
                        sprite = Sprite.MGTSING;
                   }
                
            }
            
        }else{
            sprite = Sprite.MGTDIE;
        }
    }
    
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarMagoT(x, y, this);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,48,48);
    }
}
