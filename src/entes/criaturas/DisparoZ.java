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
public class DisparoZ extends Criatura{
    private int OriginalX;
    private int OriginalY;
    public FinalBoss FB;
    public final static int MarIzq=-5;
    public final static int MarDer=15;
    public final static int MarSup=15;
    public final static int MarInf=-8;
    
    public DisparoZ(int posicionX,int posicionY,Sprite sprite,FinalBoss FB,Mapa mapa, char direccion){
        this.x = posicionX;
        this.y = posicionY;
        this.OriginalX=posicionX;
        this.OriginalY=posicionY;
        this.sprite = sprite;
        this.mapa = mapa;
        this.FB = FB;
        this.direccion= direccion;
        this.Velocidad = 3;
    }
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarDisparoZ(x, y, this);
    }
    
     public Rectangle getBounds(){
        return new Rectangle(x,y,70,70);
    }

    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    public int getVelocidad() {
        return Velocidad;
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
    
}
