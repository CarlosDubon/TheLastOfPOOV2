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
 * Esta clase tiene todas las propiedades que las criaturas necesitan para su funcionamiento <br>
 * asi como los metodos que utilizaran la mayoria de criaturas
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
    
    /**
     * Actualiza el estado de las crituras en el juego
     */
    @Override
    public void actualizar(){
    }
    /**
     * muestra los graficos de una criatura en pantalla
     */
    @Override
    public void mostrar(){
    }
    /**
     * Determina la direccion hacia la que esta apuntando una criatura
     * @param desplazamientoX moviemiento que tiene una criatura en <b>X</b>
     * @param desplazamientoY moviemiento que tiene una criatura en <b>Y</b>
     */
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
    /**
     * Detecta si una critura colisionara con un "tile" solido dentro del juego.
     * @param desplazamientoX Movimiento en X de una criatura
     * @param desplazamientoY Movimiento en X de una criatura
     * @param MarIzq Margen izquierdo para acortar los pixeles que el sprite no utiliza
     * @param MarDer Margen derecho para acortar los pixeles que el sprite no utiliza
     * @param MarSup Margen supeior para acortar los pixeles que el sprite no utiliza
     * @param MarInf Margen inferior para acortar los pixeles que el sprite no utiliza
     * @return true / false; dependiendo si ocurre o no una colision
     */    
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
    /**
     * Mueve en el eje X a una criatura hacia un limite indicado
     * @param desplazamientoX movimiento en X de la criatura
     * @param limiteX limite en X de hasta adonde llegara la criatura
     * @param Velocidad Velociadad a la que se movera la criatura
     * @param direccion hacia que direccion apuntara la criatura
     */
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
    /**
     * Mueve en el eje Y a una criatura hacia un limite indicado
     * @param desplazamientoY movimiento en Y de la criatura
     * @param limiteY limite en Y de hasta adonde llegara la criatura
     * @param Velocidad Velociadad a la que se movera la criatura
     * @param direccion hacia que direccion apuntara la criatura
     */
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
