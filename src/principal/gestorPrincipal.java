/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import principal.Graficos.Lienzo;
import principal.Graficos.Ventana;
import principal.MaquinaEstado.GestorEstado;

/**
 *
 * @author Carlos
 */
public class gestorPrincipal {
    
    private boolean isFuncionando = false; 
    private String Title;
    private int Ancho;
    private int Alto;
    
    private Lienzo lienzo;
    private Ventana ventana;
    private GestorEstado ge;

    public gestorPrincipal(String Title, int Ancho, int Alto) {
        this.Title = Title;
        this.Ancho = Ancho;
        this.Alto = Alto;
    }
    public static void main(String[] args){
        gestorPrincipal gp = new gestorPrincipal("The Last Of POO",640,360);
        
        gp.iniciarJuego();
        gp.iniciarBuclePrincipal();
    }

    private void iniciarJuego() {
        isFuncionando = true;
        inicializar();
    }

    private void iniciarBuclePrincipal() {
        int aps =0;
        int fps=0;
        
        final int NS_POR_SEGUNDO = 1000000000;
        final int APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
        
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        
        double tiempoTranscurrido;
        double delta =0;
               
        while(isFuncionando){
            final long inicioBucle = System.nanoTime();
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;
            delta += tiempoTranscurrido/NS_POR_ACTUALIZACION;
            
            while(delta >=1){
                actualizar();
                aps++;
                delta --;
            }
            dibujar();
            fps++;
            if(System.nanoTime()-referenciaContador > NS_POR_SEGUNDO){                
                System.out.println("FPS: "+ fps +" APS: "+aps);
                aps=0;
                fps=0;
                referenciaContador= System.nanoTime();
            }
        }
    }

    private void inicializar() {
        lienzo = new Lienzo();
        ventana = new Ventana();
        ge = new GestorEstado();
    }

    private void actualizar() {
        
    }

    private void dibujar() {
    }

}
