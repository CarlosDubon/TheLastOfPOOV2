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
public class FinalBoss extends Criatura{
    private Jugador jugador;
    public FinalBoss(int x, int y, Sprite sprite,Jugador jugador, Mapa mapa){
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
    }
    public void actualizar(){
    
    }
    public void mostrar(Pantalla pantalla){
        pantalla.mostrarFB(x, y, this);
    }
}
