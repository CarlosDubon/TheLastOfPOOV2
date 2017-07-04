/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes.criaturas;


import control.Sonido;
import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import java.awt.Rectangle;
import java.util.ArrayList;
import mapa.Mapa;
import threads.ThreadDisparo;

/**
 * Tiene el contror de todas las propiedades del jugador <br>
 * <b>Stats</b>
 * - Vida
 * - Disparos
 * - Energia
 * - Municiones
 * - puntaje
 * @author Carlos
 */
public class Jugador extends Criatura{
    private Teclado teclado;
    private int EP;
    private double fire;
    private Disparo disparo;
    public ArrayList<Disparo> arrayDisparos;
    private Thread thread;
    private Pantalla pantalla;
    private int RDC;
    private static Sonido SDIS;
    private boolean Zreleased= false;
    private int puntaje;
    /**
     * Inicializa todas las propiedades de Jugador
     * @param teclado 
     * @param posicionX
     * @param posicionY
     * @param sprite
     * @param mapa 
     */
    public Jugador(Teclado teclado, int posicionX, int posicionY,Sprite sprite, Mapa mapa){
        this.mapa = mapa;
        this.teclado = teclado;
        this.x = posicionX;
        this.y = posicionY;
        this.sprite = sprite;
        this.pantalla = pantalla;
        RDC = 30;
        Velocidad = 1;
        arrayDisparos = new ArrayList<Disparo>();
        puntaje = 0;
        ATK = 7;
        HP = 200;
        EP = 200;
        fire=25;
    }
    /**
     * Actualiza al juagador dentro del juego <br>
     * - movimientos
     * -ataque
     * -vida-
     * -energia
     * 
     */
    @Override
    public void actualizar(){
        
        desplazamientoX =0;
        desplazamientoY =0;
        
        
        if (animacion < 32767){
            animacion ++;
        }else{
            animacion =0;
        }
        
        if(teclado.arriba){
            desplazamientoY-=Velocidad;
        }
        if(teclado.abajo){
            desplazamientoY+=Velocidad;
        }
        if(teclado.derecha){
            desplazamientoX+=Velocidad;
        }
        if(teclado.izquierda){
            desplazamientoX-=Velocidad;
        }
        if(teclado.Shift){
            if(EP > 0){
                RDC=20;
                Velocidad = 4;
                EP  -= 2;
                if(EP < 5){
                    Velocidad = 1;
                    RDC=30;
                }
            }
        }else{
            RDC=30;
            Velocidad=1;
            if(EP < 200)
                EP++;
            if(fire < 25 && Zreleased == true)
                fire+=0.20;
        }
        if(desplazamientoX != 0 || desplazamientoY !=0){
            
            if(!getEliminado()){
            if(!isCollision(desplazamientoX,0,-10,30,-5,41)){
                setX(desplazamientoX);
            }
            if(!isCollision(0,desplazamientoY,-10,30,-5,41)){
                setY(desplazamientoY);
            }

            }
            
            mover(desplazamientoX,desplazamientoY);
            isMove = true;
        }else{
            isMove = false;
        }
        if(direccion == 'n'){
            sprite = Sprite.ARRIBA0;
            if(isMove){
                if(animacion % RDC > RDC/2){
                    sprite = Sprite.ARRIBA1;
                }else{
                    sprite = Sprite.ARRIBA_1;
                }
            }
        }
        if(direccion == 's'){
            sprite=Sprite.INICIAL0;
            if(isMove){
                if(animacion % RDC > RDC/2){
                    sprite = Sprite.INICIAL1;
                }else{
                    sprite = Sprite.INICIAL_1;
                }
            }
        }
        if(direccion == 'e'){
            sprite=Sprite.DERECHA0;
             if(isMove){
                if(animacion % RDC > RDC/2){
                    sprite = Sprite.DERECHA1;
                }else{
                    sprite = Sprite.DERECHA_1;
                }
            }
        }
        if(direccion == 'o'){
            sprite = Sprite.IZQUIERDA0;
             if(isMove){
                if(animacion % RDC > RDC/2){
                    sprite = Sprite.IZQUIERDA1;
                }else{
                    sprite = Sprite.IZQUIERDA_1;
                }
            }
        }
        
    }
    /**
     * añade disparos al array de disparos para luego ser ejecutados
     */
    public void disparar(){
        
        disparo = new Disparo(x+5,y+3,Sprite.DISPARO1,this,mapa, this.direccion);
        arrayDisparos.add(disparo);
        thread = new Thread(new ThreadDisparo(arrayDisparos.get(arrayDisparos.size()-1)));
        thread.start();
        
        SDIS= new Sonido("Disparo");
        SDIS.clip.start();
 
    }
    /**
     * mustra al jugador en pantalla
     * 
     */
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarJugador(x, y, this);
        
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }
    
    public void setHP(int HP){
        this.HP = HP;
    }

    public void setFire(int fire) {
        this.fire += fire;
    }
    
    /**
     * verifica si el jugador esta disparando continuamente
     * @param Zreleased 
     */
    public void setZreleased(boolean Zreleased) {
        this.Zreleased = Zreleased;
    }

    public void setVelocidad(int Velocidad) {
        this.Velocidad = Velocidad;
    }
    
    public int getEP(){
        return EP;
    }
    
    public int getHP(){
        return HP;
    }

    public double getFire() {
        return fire;
    }
    
    
    public Rectangle getBounds(){
        return new Rectangle(x+16,y+26,16,16);
    }
    
    public int getAtk(){
        return ATK;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    

    
    
}
