/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 * Esta clase maneja de forma final(Cuando gana o pierde el jugador), el puntaje obtenido
 * @author Dougl
 */
public class Puntaje {
    
    private final String Nick;
    private  final int Score;

    /**
     * Recibe el nombre ingresado por el jugador, ademas del puntaje obtenido al final del juego.
     * @param Nick Nombre del jugador 
     * @param Score Puntaje del jugador
     */
    public Puntaje(String Nick, int Score) {
        this.Nick = Nick;
        this.Score = Score;
    }

    /**
     * Devuelve el Nombre del jugador almacenado en la instancia desde la que se invoca
     * @return String Con nombre del jugador 
     */
    public String getNick() {
        return Nick;
    }

    /**
     * Devuelve el Puntaje del jugador almacenado en la instancia desde la que se invoca
     * @return int Con puntaje del jugador 
     */
    public int getScore() {
        return Score;
    }
    
}
