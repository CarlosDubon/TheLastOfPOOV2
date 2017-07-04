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
import threads.ThreadDisparo;

/**
 * Se encarga de mostrar, actualizar y darle funcionamiento a la criatura llamada <b>"Baty"</b> 
 * @author Carlos
 */
public class Baty extends Criatura {
    private Jugador jugador; // necesita una variable de tipo jugador  ya que se necesita obtenter datos del jugador.
    
    /**
     *  Inicializa todas las propiedades de la criatura.
     * @param x posicion X inicial de la criatura
     * @param y posicion Y inicial de la criatura
     * @param sprite sprite corespondiente de la criatura
     * @param jugador objeto de tipo jugador
     * @param mapa mapa en el cual aparecera la criatura
     */
    public Baty(int x, int y, Sprite sprite, Jugador jugador,Mapa mapa){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.jugador = jugador;
        this.mapa = mapa;
        this.HP = 40;
        this.Velocidad = 2;
        this.originalX = x;
        this.originalY = y;
        this.isKiller = false;
        this.ATK = 4;
        this.direccion = 'o';
    
    }
    /**
     * Igual funcionamiento que el costructor anterior <br>
     * <b>Diferenuas:</b>
     * -Recibe la direccion en a cual se quiere incializar a la criatura
     * @param x
     * @param y
     * @param sprite
     * @param jugador
     * @param mapa
     * @param direccion 
     */
    public Baty(int x, int y, Sprite sprite, Jugador jugador,Mapa mapa,char direccion){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.jugador = jugador;
        this.mapa = mapa;
        this.HP = 40;
        this.Velocidad = 2;
        this.originalX = x;
        this.originalY = y;
        this.isKiller = false;
        this.ATK = 4;
        this.direccion = direccion;
    
    }
    /**
     * Controla todas las estadisticas de la criatura tales como: <br>
     * <b>Stats</b><br>
     * -Vida<br>
     * -Ataque<br>
     * -Movimientos<br>
     * -Animaciones<br>
     * -Ataques especiales<br>
     */
    @Override
    public void actualizar(){
        desplazamientoX =0;
        desplazamientoY =0;
        
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

            
            if(Math.sqrt(Math.pow(y-jugador.getY(),2) + Math.pow(x-jugador.getX(),2)) <= 150){
                moverX(desplazamientoX,jugador.getX()+24,Velocidad,direccion);
                moverY(desplazamientoY,jugador.getY(),Velocidad,direccion);
                if(Math.sqrt(Math.pow(y-jugador.getY(),2) + Math.pow(x-jugador.getX(),2)) < 75){
                    Velocidad = 3;
                }else{
                    Velocidad = 2;
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
                    this.HP = HP-jugador.getAtk();
                    jugador.arrayDisparos.get(i).setStaticX(0);
                    jugador.arrayDisparos.get(i).setStaticY(0);
                }
            }
            
            if(direccion == 'o'){
                sprite = Sprite.BATIZ0;
                if(animacion % 20 > 10){
                    sprite = Sprite.BATIZ1;
                }else{
                    sprite = Sprite.BATIZ_1;
                }       
            }
            
            if(direccion == 'e'){
                sprite = Sprite.BATDE0;
                if(animacion % 20 > 10){
                    sprite = Sprite.BATDE1;
                }else{
                    sprite = Sprite.BATDE_1;
                }
            }
            if(direccion == 'n'){
                sprite = Sprite.BATINICIO0;
                if(animacion % 20 > 10){
                    sprite = Sprite.BATINICIO1;
                }else{
                    sprite = Sprite.BATINICIO_1;
                }
            }
            if(direccion == 's'){
                sprite = Sprite.BATABAJO0;
                if(animacion % 20 > 10){
                    sprite = Sprite.BATABAJO_1;
                }else{
                    sprite = Sprite.BATABAJO1;
                }
            }
        }else{
            sprite = Sprite.BATADIE;
        }
    }
    /**
     * Muestra el sprite de la criatura en pantalla
     * @param pantalla 
     */
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarBaty(x,y, this);
    }
    /**
     * Retorna un 
     * @return rectangulo del tamaño del sprite para poder realizar coliciones
     */
    public Rectangle getBounds(){
        return new Rectangle(x,y,48,48);
    }
}
