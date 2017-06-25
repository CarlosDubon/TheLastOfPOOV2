/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import entes.criaturas.Baty;
import entes.criaturas.BatyRed;
import entes.criaturas.Disparo;
import entes.criaturas.Heart;
import mapa.tile.Tile;
import entes.criaturas.Jugador;
import entes.criaturas.Key;
import entes.criaturas.Mago;
import entes.criaturas.Plasta;
import entes.criaturas.Portal;
import entes.criaturas.Skeletor;

/**
 *
 * @author Carlos
 */
public class Pantalla {

    private final int ancho;
    private final int alto;

    private int diferenciaX;
    private int diferenciaY;

    public final int[] pixeles;

    public Pantalla(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;

        pixeles = new int[ancho * alto];
    }

    public void limpiar() {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = 0;
        }
    }

    public void mostrarTile(int compensacionX, int compensacionY, Tile tile) {
        compensacionX -= diferenciaX;
        compensacionY -= diferenciaY;
        for (int y = 0; y < tile.sprite.getLado(); y++) {
            int posicionY = y + compensacionY;
            for (int x = 0; x < tile.sprite.getLado(); x++) {
                int posicionX = x + compensacionX;
                if (posicionX < -tile.sprite.getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto) {
                    break;
                }
                if (posicionX < 0) {
                    posicionX = 0;
                }
                pixeles[posicionX + posicionY * ancho] = tile.sprite.pixeles[x + y * tile.sprite.getLado()];
            }
        }
    }

    public void mostrarJugador(int compensacionX, int compensacionY, Jugador jugador) {
        compensacionX -= diferenciaX;
        compensacionY -= diferenciaY;
        for (int y = 0; y < jugador.getSprite().getLado(); y++) {
            int posicionY = y + compensacionY;
            for (int x = 0; x < jugador.getSprite().getLado(); x++) {
                int posicionX = x + compensacionX;
                if (posicionX < -jugador.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto) {
                    break;
                }
                if (posicionX < 0) {
                    posicionX = 0;
                }
                int colorPixelJugador = jugador.getSprite().pixeles[x + y * jugador.getSprite().getLado()];
                if (colorPixelJugador != 0xff06ff00) {
                    pixeles[posicionX + posicionY * ancho] = jugador.getSprite().pixeles[x + y * jugador.getSprite().getLado()];

                }
            }
        }
    }
    public void mostrarPlasta(int compensacionX,int compensacionY,Plasta plasta){
        compensacionX -=diferenciaX;
        compensacionY -= diferenciaY;
        for(int y =0 ; y < plasta.getSprite().getLado();y++){ 
            int posicionY = y + compensacionY;
            for(int x = 0; x<plasta.getSprite().getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -plasta.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                int colorPixelPlasta = plasta.getSprite().pixeles[x+y*plasta.getSprite().getLado()];
                if(colorPixelPlasta !=0xff06ff00 ){
                    pixeles [posicionX + posicionY * ancho] = plasta.getSprite().pixeles[x + y * plasta.getSprite().getLado()];
                }
            }
        }
    }
    public void mostrarPortal(int compensacionX,int compensacionY,Portal portal){
        compensacionX -=diferenciaX;
        compensacionY -= diferenciaY;
        for(int y =0 ; y < portal.getSprite().getLado();y++){ 
            int posicionY = y + compensacionY;
            for(int x = 0; x<portal.getSprite().getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -portal.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                int colorPixelPortal = portal.getSprite().pixeles[x+y*portal.getSprite().getLado()];
                if(colorPixelPortal !=0xff00ff3c ){
                    pixeles [posicionX + posicionY * ancho] = portal.getSprite().pixeles[x + y * portal.getSprite().getLado()];
                }
            }
        }
    }
 
    
    public void mostrarHeart(int compensacionX,int compensacionY,Heart heart){
        compensacionX -=diferenciaX;
        compensacionY -= diferenciaY;
        for(int y =0 ; y < heart.getSprite().getLado();y++){ 
            int posicionY = y + compensacionY;
            for(int x = 0; x<heart.getSprite().getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -heart.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                int colorPixelHeart = heart.getSprite().pixeles[x+y*heart.getSprite().getLado()];
                if(colorPixelHeart !=0xff00ff3c ){
                    pixeles [posicionX + posicionY * ancho] = heart.getSprite().pixeles[x + y * heart.getSprite().getLado()];
                }
            }
        }
    }
    
    public void mostrarKey(int compensacionX,int compensacionY,Key key){
        compensacionX -=diferenciaX;
        compensacionY -= diferenciaY;
        for(int y =0 ; y < key.getSprite().getLado();y++){ 
            int posicionY = y + compensacionY;
            for(int x = 0; x<key.getSprite().getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -key.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                int colorPixelKey = key.getSprite().pixeles[x+y*key.getSprite().getLado()];
                if(colorPixelKey !=0xff06ff00 ){
                    pixeles [posicionX + posicionY * ancho] = key.getSprite().pixeles[x + y * key.getSprite().getLado()];
                }
            }
        }
    }
    
    public void mostrarDisparo(int compensacionX, int compensacionY, Disparo disparo){
        compensacionX -=diferenciaX;
        compensacionY -= diferenciaY;
        for(int y =0 ; y < disparo.getSprite().getLado();y++){ 
            int posicionY = y + compensacionY;
            for(int x = 0; x<disparo.getSprite().getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -disparo.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                int colorPixelDisparo = disparo.getSprite().pixeles[x+y*disparo.getSprite().getLado()];
                if(colorPixelDisparo !=0xff06ff00 ){
                    pixeles [posicionX + posicionY * ancho] = disparo.getSprite().pixeles[x + y * disparo.getSprite().getLado()];
                }
            }
        }
    }
    public void mostrarBaty(int compensacionX, int compensacionY, Baty baty){
        compensacionX -=diferenciaX;
        compensacionY -= diferenciaY;
        for(int y =0 ; y < baty.getSprite().getLado();y++){ 
            int posicionY = y + compensacionY;
            for(int x = 0; x<baty.getSprite().getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -baty.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                int colorPixelBaty = baty.getSprite().pixeles[x+y*baty.getSprite().getLado()];
                if(colorPixelBaty !=0xff00ff12 ){
                    pixeles [posicionX + posicionY * ancho] = baty.getSprite().pixeles[x + y * baty.getSprite().getLado()];
                }
            }
        }
    }
        public void mostrarBatyRed(int compensacionX, int compensacionY, BatyRed batyRed){
        compensacionX -=diferenciaX;
        compensacionY -= diferenciaY;
        for(int y =0 ; y < batyRed.getSprite().getLado();y++){ 
            int posicionY = y + compensacionY;
            for(int x = 0; x<batyRed.getSprite().getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -batyRed.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                int colorPixelBatyRed = batyRed.getSprite().pixeles[x+y*batyRed.getSprite().getLado()];
                if(colorPixelBatyRed !=0xff00ff12 ){
                    pixeles [posicionX + posicionY * ancho] = batyRed.getSprite().pixeles[x + y * batyRed.getSprite().getLado()];
                }
            }
        }
    }
    public void mostrarSkeletor(int compensacionX, int compensacionY, Skeletor skeletor){
        compensacionX -=diferenciaX;
        compensacionY -= diferenciaY;
        for(int y =0 ; y < skeletor.getSprite().getLado();y++){ 
            int posicionY = y + compensacionY;
            for(int x = 0; x<skeletor.getSprite().getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -skeletor.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                int colorPixelSkeletor = skeletor.getSprite().pixeles[x+y*skeletor.getSprite().getLado()];
                if(colorPixelSkeletor !=0xff00ff12 ){
                    pixeles [posicionX + posicionY * ancho] = skeletor.getSprite().pixeles[x + y * skeletor.getSprite().getLado()];
                }
            }
        }
    }
    
    public void mostrarMago(int compensacionX, int compensacionY, Mago skeletor){
        compensacionX -=diferenciaX;
        compensacionY -= diferenciaY;
        for(int y =0 ; y < skeletor.getSprite().getLado();y++){ 
            int posicionY = y + compensacionY;
            for(int x = 0; x<skeletor.getSprite().getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -skeletor.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                int colorPixelSkeletor = skeletor.getSprite().pixeles[x+y*skeletor.getSprite().getLado()];
                if(colorPixelSkeletor !=0xff06ff00 ){
                    pixeles [posicionX + posicionY * ancho] = skeletor.getSprite().pixeles[x + y * skeletor.getSprite().getLado()];
                }
            }
        }
    }

    public void resetDiferencia(final int diferenciaX, final int diferenciaY) {
        this.diferenciaX = diferenciaX;
        this.diferenciaY = diferenciaY;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

}
