/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Dougl
 */
public class Puntaje {
    
    private final String Nick;
    private  final int Score;

    public Puntaje(String Nick, int Score) {
        this.Nick = Nick;
        this.Score = Score;
    }

    public String getNick() {
        return Nick;
    }

    public int getScore() {
        return Score;
    }
    
}
