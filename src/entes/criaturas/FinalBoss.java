/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes.criaturas;


import graficos.Pantalla;
import graficos.Sprite;
import java.awt.Rectangle;
import java.util.ArrayList;
import mapa.Mapa;
import threads.ThreadDisparoZ;

/**
 * Se encarga de controlar las estadisticas del enemigo final <br>
 * <b>Stats</b> <br>
 * - Vida
 * - Ataque
 * - Movimientos
 * @author Carlos
 */
public class FinalBoss extends Criatura{
    private Jugador jugador;
    private int contador;
    private int count;
    private DisparoZ disparoZ;
    private char DireccionAux;
    private Thread thread;
    public ArrayList<DisparoZ> arrayDisparosZ;
    /**
     * Inicialza los atributos de la clase
     * @param x posicion inical X
     * @param y posicion inicial Y
     * @param sprite Sprite respectivo de la criatura 
     * @param jugador Objeto de tipo jugador
     * @param mapa  mapa adonde se mostrara el enemigo
     */
    public FinalBoss(int x, int y, Sprite sprite,Jugador jugador, Mapa mapa){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.jugador = jugador;
        this.mapa = mapa;
        this.HP = 500;
        this.Velocidad = 5;
        this.originalX = x;
        this.originalY = y;
        this.isKiller = false;
        this.ATK = 5;
        this.arrayDisparosZ = new ArrayList<DisparoZ>();
    }
    /**
     * Actualiza el estado del enemigo dentro de su rango de accion
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
        if(contador < 32767){
            contador++;
        }else{
            contador =0;
        }

        
        if(HP<=0 && !isKiller){
            jugador.setPuntaje(jugador.getPuntaje()+450);
            isKiller = true;
        }
        
        if (HP > 0){
            isMove = true;
        }else{
            isMove = false;
        }
        
        if(isMove){
            if(x > jugador.getX()){
                direccion = 'o';
                DireccionAux= 'e';
            }
            if(x < jugador.getX()){
                direccion = 'e';
                DireccionAux= 'o';
            }
            
            if(jugador.getX() > x && jugador.getX() < x+70 && y < jugador.getY() ){
                direccion = 's';
                DireccionAux='n';
            }
            if(jugador.getX() > x && jugador.getX() < x+70 && y > jugador.getY() ){
                direccion = 'n';
                DireccionAux='s';
            }
            
            if(count < 120){
                count++;
            }else{
                disparoZ = new DisparoZ(x,y,Sprite.DZ1,this,mapa,this.direccion);
                arrayDisparosZ.add(disparoZ);
                thread = new Thread(new ThreadDisparoZ(arrayDisparosZ.get(arrayDisparosZ.size()-1)));
                thread.start();
                count=0;
            }
            if(contador <240/2){
                y-=2;
            }else if (contador <720/2){
                y+=2;   
            }else if(contador < 960/2){
                y-=2;
            }else if(contador < (1080)/2){
                direccion=DireccionAux;
            }else if(contador < (1080+60)/2){
                if(x<jugador.getX()){
                    direccion = 'e';
                }else{
                    direccion ='o';
                }
                moverX(desplazamientoX,jugador.getX(),Velocidad,direccion);
            }else{
                contador = 0;
            }
            
            if(jugador.getBounds().intersects(getBounds())){
                jugador.setHP(jugador.getHP()-ATK);
                
            }
            for(int i = 0;i<jugador.arrayDisparos.size();i++ ){
                if(jugador.arrayDisparos.get(i).getBounds().intersects(getBounds()) && direccion== DireccionAux){
                    HP = HP - jugador.getAtk();
                    jugador.arrayDisparos.get(i).setStaticX(0);
                    jugador.arrayDisparos.get(i).setStaticY(0);
                }
            }
            for(int i = 0;i<arrayDisparosZ.size();i++ ){
                if(arrayDisparosZ.get(i).getBounds().intersects(jugador.getBounds())){
                    jugador.setHP(jugador.getHP()-ATK);

                }
            }
            
            
        if(direccion == 'o'){
            sprite = Sprite.FBIZ0;
            if(animacion % 40 > 20){
                sprite = Sprite.FBIZ1;
            }else{
                sprite = Sprite.FBIZ_1;
            }
        }
        if(direccion == 's'){   
           sprite = Sprite.FBDOWN0;
            if(animacion % 40 > 20){
                sprite = Sprite.FBDOWN1;
            }else{
                 sprite = Sprite.FBDOWN_1;
            }
        }
        if(direccion == 'e'){   
           sprite = Sprite.FBDE0;
            if(animacion % 40 > 20){
                sprite = Sprite.FBDE1;
            }else{
                 sprite = Sprite.FBDE_1;
            }

        }
        if(direccion == 'n'){   
           sprite = Sprite.FBUP0;
            if(animacion % 40 > 20){
                sprite = Sprite.FBUP1;
            }else{
                 sprite = Sprite.FBUP_1;
            }

        }
        }else{
            sprite = Sprite.FBDIE;
        }
    }
    /**
     * Mustra el enemigo en pantalla
     * @param pantalla 
     */
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarFB(x, y, this);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,70,70);
    }
    public int getHP(){
        return HP;
    }
}
