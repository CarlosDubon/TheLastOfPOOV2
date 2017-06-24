/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.MaquinaEstado;

import java.awt.Graphics;
import principal.MaquinaEstado.Estados.Juego.GestorJuego;

/**
 *
 * @author Carlos
 */
public class GestorEstado {
    private EstadoJuego[] Estados;
    private EstadoJuego estadoActual;
    
    public GestorEstado(){
        iniciarEstados();
        iniciarEstadoActual();
    }

    private void iniciarEstados() {
        Estados = new EstadoJuego[1];
        Estados[0] = new GestorJuego();
        // añadir e iniciar los demas estados a medida lso creemos
    }

    private void iniciarEstadoActual() {
        estadoActual = Estados[0];
    }
    
    public void actualizar(){
        estadoActual.actualizar();
    }
    
    public void dibujar(final Graphics g){
        estadoActual.dibujar(g);
    }
    
    public void cambiarEstado(final int nuevoEstado){
        estadoActual = Estados[nuevoEstado];
    }
    public EstadoJuego getEstadoActual(){
        return estadoActual;
    }
}
