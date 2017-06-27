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
import juego.TheLastOfPOO;
import mapa.Mapa;

/**
 *
 * @author Dougl
 */
public class Trofeo extends Criatura{
    Pantalla pantalla;
    private int animacion;
    private Jugador jugador;
    private boolean Win=false;
    public Trofeo(int x, int y, Sprite sprite,Jugador jugador, Mapa mapa){
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
            sprite = Sprite.TF1;
            if(animacion % 80 > 40 ){
                sprite = Sprite.TF1;
            } 
            if(animacion % 40 > 20){
                sprite = Sprite.TF2;
            } 
        }else{
            sprite=Sprite.TFNULL;
            
        }
        
        if(jugador.getBounds().intersects(getBounds()) && !Win){
            
            TheLastOfPOO.Win=true;
            Estado.estado=10;
            
            this.isMove=false;
        }
    }
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarTrofeo(x, y, this);
    
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,32,32);
    }

    public boolean isHeartUsed() {
        return Win;
    }
}
