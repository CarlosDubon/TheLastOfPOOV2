/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import java.awt.Rectangle;
import mapa.Mapa;

/**
 *
 * @author Carlos
 */
public class Disparo extends Criatura {
    private Pantalla pantalla;
    private final int velocidad = 5;
    private int OriginalX;
    private int OriginalY;
    public Jugador jugador;
    public final static int MarIzq=-5;
    public final static int MarDer=15;
    public final static int MarSup=15;
    public final static int MarInf=-8;
    private Thread HiloDisparo;
    
    public Disparo(int posicionX,int posicionY,Sprite sprite,Jugador jugador,Mapa mapa, char direccion){
        this.x = posicionX;
        this.y = posicionY;
        this.OriginalX=posicionX;
        this.OriginalY=posicionY;
        this.sprite = sprite;
        this.mapa = mapa;
        this.jugador = jugador;
        this.direccion= direccion;
    
    }

        
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarDisparo(x, y, this);
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,16,16);
    }

    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    public int getVelocidad() {
        return velocidad;
    }
    
    

    public int getDesplazamientoX() {
        return desplazamientoX;
    }

    public int getDesplazamientoY() {
        return desplazamientoY;
    }

    public void setDesplazamientoX(int desplazamientoX) {
        this.desplazamientoX = desplazamientoX;
    }

    public void setDesplazamientoY(int desplazamientoY) {
        this.desplazamientoY = desplazamientoY;
    }

    public int getOriginalX() {
        return OriginalX;
    }

    public int getOriginalY() {
        return OriginalY;
    }

    public Thread getHiloDisparo() {
        return HiloDisparo;
    }

    public void setHiloDisparo(Thread HiloDisparo) {
        this.HiloDisparo = HiloDisparo;
    }
    
    

}
