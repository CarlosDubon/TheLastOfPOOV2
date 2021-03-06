/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graficos;

import entes.criaturas.Baty;
import entes.criaturas.BatyRed;
import entes.criaturas.Disparo;
import entes.criaturas.DisparoZ;
import entes.criaturas.FinalBoss;
import entes.criaturas.Heart;
import mapa.tile.Tile;
import entes.criaturas.Jugador;
import entes.criaturas.Key;
import entes.criaturas.KillMarBlue;
import entes.criaturas.Mago;
import entes.criaturas.MagoT;
import entes.criaturas.Plasta;
import entes.criaturas.Portal;
import entes.criaturas.Skeletor;
import entes.criaturas.Tauro;
import entes.criaturas.Trofeo;

/**
 * Realiza las actualizaciones visibles para el usuario, asi como actuliza 
 * la visibilidad de los mapas y recalcula la poscicion de los objetos
 * @author Carlos
 */
public class Pantalla {

    private final int ancho;
    private final int alto;

    private int diferenciaX;
    private int diferenciaY;

    public final int[] pixeles;

    
    /**
     * Crea una instancia de pantalla; ademas inicializa un arreglo de pixeles que represeenta el mapa en que se encuentra
     * la aplicacion
     * @param ancho  de la pantalla
     * @param alto de la pantalla
     */
    public Pantalla(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;

        pixeles = new int[ancho * alto];
    }
    
    /**
     * Vuelve los valores del arreglo de colores (en int) al valor que representa el color negro
     */
    public void limpiar() {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = 0;
        }
    }
    
    /**
     * Muestra en una posicion especifica un "tile" dentro de la partalla, toamndo en cuneta la posicion del
     * jugador y a disposicion en el mapa.
     * @param compensacionX 
     * @param compensacionY
     * @param tile 
     */
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
    
    
    /**
     * Muestra en una posicion especifica un "jugador" dentro de la partalla, toamndo en cuneta la posicion del
     * mismo y a disposicion en el mapa, ademas ignora cierto color con el fin de realizar trasnparencia en la imagen.<br>
     * Los siguientes metodos dentro de la misma clase funcionan de igual forma, solo que con la diferencia en los sprites que cargan, 
     * el color que ignoran, y la centralizacion en el jugador: <br>
     * --AQUI ENUMERAN TODOS LOS METODOS DE ABAJO--
     * @param compensacionX
     * @param compensacionY
     * @param jugador 
     */
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
    
    public void mostrarTrofeo(int compensacionX,int compensacionY,Trofeo heart){
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
                if(colorPixelHeart !=0xff00ff0c){
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
    
    public void mostrarMagoT(int compensacionX, int compensacionY, MagoT skeletor){
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

    
    public void mostrarKill(int compensacionX, int compensacionY, KillMarBlue kill){
        compensacionX -=diferenciaX;
        compensacionY -= diferenciaY;
        for(int y =0 ; y < kill.getSprite().getLado();y++){ 
            int posicionY = y + compensacionY;
            for(int x = 0; x<kill.getSprite().getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -kill.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                int colorPixelSkeletor = kill.getSprite().pixeles[x+y*kill.getSprite().getLado()];
                if(colorPixelSkeletor !=0xffffffff ){
                    pixeles [posicionX + posicionY * ancho] = kill.getSprite().pixeles[x + y * kill.getSprite().getLado()];
                }
            }
        }
    }
    public void mostrarTauro(int compensacionX, int compensacionY, Tauro taouro){
        compensacionX -=diferenciaX;
        compensacionY -= diferenciaY;
        for(int y =0 ; y < taouro.getSprite().getLado();y++){ 
            int posicionY = y + compensacionY;
            for(int x = 0; x<taouro.getSprite().getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -taouro.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                int colorPixelTaouro = taouro.getSprite().pixeles[x+y*taouro.getSprite().getLado()];
                if(colorPixelTaouro !=0xffffffff ){
                    pixeles [posicionX + posicionY * ancho] = taouro.getSprite().pixeles[x + y * taouro.getSprite().getLado()];
                }
            }
        }
    }
    public void mostrarFB(int compensacionX, int compensacionY, FinalBoss FB){
        compensacionX -=diferenciaX;
        compensacionY -= diferenciaY;
        for(int y =0 ; y < FB.getSprite().getLado();y++){ 
            int posicionY = y + compensacionY;
            for(int x = 0; x<FB.getSprite().getLado(); x++){
                int posicionX = x + compensacionX;
                if(posicionX < -FB.getSprite().getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto){
                    break;
                }
                if(posicionX < 0){
                    posicionX = 0;
                }
                int colorPixelTaouro = FB.getSprite().pixeles[x+y*FB.getSprite().getLado()];
                if(colorPixelTaouro !=0xffc65067){
                    pixeles [posicionX + posicionY * ancho] = FB.getSprite().pixeles[x + y * FB.getSprite().getLado()];
                }
            }
        }
    }
    public void mostrarDisparoZ(int compensacionX, int compensacionY, DisparoZ disparo){
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
                if(colorPixelDisparo !=0xff9fffc3 ){
                    pixeles [posicionX + posicionY * ancho] = disparo.getSprite().pixeles[x + y * disparo.getSprite().getLado()];
                }
            }
        }
    }
    
    
    /**
     * Reinicia el diferencial de x y y a valores predetrminados
     * @param diferenciaX Valor inicial de X
     * @param diferenciaY Valor inicial de Y
     */
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
