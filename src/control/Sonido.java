/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *Esta clase se encarga del control y apertura de flujo de los archivos de sonido.
 * @author Dougl
 */
public class Sonido {
    
    private String Archivo;
    private final String ruta="recursos/musica/";
    public Clip clip;
    
    /**
     * Inicializa un Stream de audio a partir del archivo proporcionado. <br>
     * Tener en cuenta que este debe de encontrarse en la ruta relativa "recursos/musica/"
     * @param Archivo Nombre del archivo de musica, se omite la rua absoluta y relativa, y ademas el sufijo ".WAV" 
     */
    public Sonido(String Archivo){
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(ruta + Archivo + ".WAV")));
            
            
        } catch (Exception e) {
            System.out.println("Error");
        } 
    }
    
    /**
     * Reproduce el clip incializado de manera indefinida.
     */
    public void PlayLoop(){
        this.clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    /**
     * Pausa el stream de sonido, y lo reinicia a la posicion incial del clip.
     */
    public void stop(){
        clip.stop();
        clip.setFramePosition(0);
    }
}
