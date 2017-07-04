/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Esta Clase controla el estado de las teclas de mayor uso en la aplicacion
 * @author Dougl
 */
public class Teclado implements KeyListener{
    private final static int numeroTeclas = 300;
    private final boolean[] teclas = new boolean[numeroTeclas];
    
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean Shift;
    public boolean Uno;
    public boolean Dos;
    public boolean Tres;
    
    public void actualizar(){
        arriba = teclas[KeyEvent.VK_UP];
        abajo = teclas[KeyEvent.VK_DOWN];
        izquierda = teclas[KeyEvent.VK_LEFT];
        derecha = teclas[KeyEvent.VK_RIGHT];
        Shift = teclas[KeyEvent.VK_X];
        Uno= teclas[KeyEvent.VK_1];
        Dos= teclas[KeyEvent.VK_2];
        Tres =teclas[KeyEvent.VK_3];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Toma el arreglo de booleanos y compara el indice con el codigo de la tecla, y vuelve verdarero el valor de
     * de cada instancia booleana que representan la teclas presionadas
     * @param e Control de eventos en teclados
     */
    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()]=true;
    }

    /**
     * Toma el arreglo de booleanos y compara el indice con el codigo de la tecla, y vuelve falso el valor de
     * de cada instancia booleana que representan la teclas que han sido soltadas
     * @param e Control de eventos de teclado 
     */
    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()]=false;
    }
    
}
