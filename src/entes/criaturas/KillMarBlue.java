/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes.criaturas;

import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

/**
 *
 * @author Carlos
 */
public class KillMarBlue extends Criatura {
    private Jugador jugador;
    
    public KillMarBlue(int x, int y,Sprite sprite, Jugador jugador, Mapa mapa){
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.jugador = jugador;
        this.mapa = mapa;
        this.HP = 60;
        this.Velocidad = 2;
        this.originalX = x;
        this.originalY = y;
        this.isKiller = false;
        this.ATK = 3;
    }
    public void actualizar(){
        desplazamientoX =0;
        desplazamientoY =0;
        
        if(animacion < 32767){
            animacion++;
        }else{
            animacion =0;
        }
        
        if(HP<=0 && !isKiller){
            jugador.setPuntaje(jugador.getPuntaje()+45);
            isKiller = true;
        }
        
        if (HP > 0){
            isMove = true;
        }else{
            isMove = false;
        }
        
        if(isMove){
        
        }else{
        
        }
    }
    public void mostrar(Pantalla pantalla){
    
    }
}
