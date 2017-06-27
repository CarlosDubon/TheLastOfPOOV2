/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes.criaturas;


import entes.Ente;
import graficos.Pantalla;
import graficos.Sprite;


/**
 *
 * @author Carlos
 */
public class Criatura extends Ente{
    protected Sprite sprite;
    protected char direccion = '0';
    protected boolean isMove = false;
    protected int desplazamientoX;
    protected int desplazamientoY;
    protected boolean isKiller;
    protected int HP;
    protected int Velocidad;
    protected int animacion;
    protected int originalX;
    protected int originalY;
    protected int ATK;
    
    
    @Override
    public void actualizar(){
    }
    @Override
    public void mostrar(){
    }
    public void mover(int desplazamientoX, int desplazamientoY){
        if(desplazamientoX > 0){
            direccion = 'e';
        }
        if(desplazamientoX < 0){
            direccion = 'o';
        }
        if(desplazamientoY > 0){
            direccion = 's';
        }
        if(desplazamientoY <0){
            direccion = 'n';
        }
        
        /*if(!getEliminado()){
            if(!isCollision(desplazamientoX, 0, -10, 30, -5, 41)){
                setX(desplazamientoX);
            }
            if(!isCollision(0, desplazamientoY, -10, 30, -5, 41)){
                setY(desplazamientoY);
            }
        }*/
        
  }
        
    public boolean isCollision(int desplazamientoX, int desplazamientoY, int MarIzq, int MarDer, int MarSup, int MarInf){         
        boolean colision = false;
        int posicionX = x+desplazamientoX;
        int posicionY = y+desplazamientoY;
        
        int margenIzquierdo = MarIzq;
        int margenDerecho = MarDer;
        int margenSuperior = MarSup;
        int margenInferior = MarInf;
        
        int bordeIzq= (posicionX+ margenDerecho)/32;
        int bordeDer= (posicionX+ margenDerecho+margenIzquierdo)/32; 
        int bordeSup= (posicionY+ margenInferior)/32;
        int bordeInf= (posicionY+ margenSuperior+margenInferior)/32;
        
        if (mapa.getCuadrosCatalogo(bordeIzq+bordeSup*mapa.getAncho()).isSolido() ){
            colision=true;
        }
        if (mapa.getCuadrosCatalogo(bordeDer+bordeSup*mapa.getAncho()).isSolido() ){
            colision=true;
        }
        if (mapa.getCuadrosCatalogo(bordeIzq+bordeInf*mapa.getAncho()).isSolido() ){
            colision=true;
        }
        if (mapa.getCuadrosCatalogo(bordeDer+bordeInf*mapa.getAncho()).isSolido() ){
            colision=true;
        }
        return colision;
    }
    
    public void moverX(int desplazamientoX,int limiteX, int Velocidad,char direccion){
        this.direccion = direccion;
        if(x > limiteX){
            if((x - limiteX) != 0){
                desplazamientoX -= Velocidad;
            }
        }else{
            if((limiteX - x) != 0){
                desplazamientoX += Velocidad;
            }
        }   
        setX(desplazamientoX);
    }

    public void moverY(int desplazamientoY,int limiteY, int Velocidad,char direccion){
        this.direccion = direccion;
        if(y > limiteY){
            if((y - limiteY) != 0){
                desplazamientoY -= Velocidad;
            }
        }else{
            if((limiteY - y) != 0){
                desplazamientoY += Velocidad;
            }
        }
       
        
        
        setY(desplazamientoY);
    }
    public Sprite getSprite(){
        return sprite;
    }

    public char getDireccion() {
        return direccion;
    }
    
       
}
