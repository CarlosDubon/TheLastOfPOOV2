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
import mapa.tile.Tile;

/**
 *Se encarga de abrir los pasillos bloqueados dentro del juego
 * @author Dougl
 */
public class Key extends Criatura{
    Pantalla pantalla;
    private int animacion;
    private Jugador jugador;
    private boolean KeyUsed=false;
    public Key(int x, int y, Sprite sprite,Jugador jugador, Mapa mapa){
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
            sprite = Sprite.KEY1;
            if(animacion % 80 > 40 ){
                sprite = Sprite.KEY1;
            } 
            if(animacion % 40 > 20){
                sprite = Sprite.KEY2;
            } 
        }else{
            sprite=Sprite.KEYNULL;
            
        }
        
        if(jugador.getBounds().intersects(getBounds())){
            
            KeyUsed=true;
            
            this.isMove=false;
        }
    }
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarKey(x, y, this);
    
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,32,32);
    }
    /**
     * Verifica si el item a sido encontrado
     * @return 
     */
    public boolean isKeyUsed() {
        return KeyUsed;
    }
    
    
}
