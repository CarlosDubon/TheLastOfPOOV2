/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import graficos.Sprite;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import mapa.tile.Tile;

/**
 *
 * @author Carlos
 */
public class MapaCargado extends Mapa {
    
    private int[] pixeles;
    public static int cont;
    
    /**
     * Ya que hereda de mapa envia el parametro recibido y se lo coloca al constructor de mapa (el que recibe una ruta)
     * @param ruta 
     */
    public MapaCargado(String ruta) {
        super(ruta);
    }
    /**
     * Carga una imagen desde un archivo png y copia los colores de los pixeles <br>
     * en un array de pixeles y crea el catalogo de tiles en un array
     * @param ruta 
     */
    @Override
    protected void cargarMapa(String ruta){
        try{
            BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));
            ancho = imagen.getWidth();
            alto = imagen.getHeight();
            
            cuadrosCatalogo = new Tile[ancho*alto];
            pixeles = new int[ancho*alto];
            
            imagen.getRGB(0,0,ancho,alto,pixeles,0,ancho);
        
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    /**
     * Llena el array "catalogo de pixeles" dependiendo del color que identifica a cada tile
     */
    @Override
    protected void generarMapa(){
        for(int i =0;i<pixeles.length;i++){
            switch(pixeles[i]){
                case 0xff8f8f8f:
                    cuadrosCatalogo[i] = Tile.LADRILLO;
                    continue;
                case 0xff9b3131:
                    cuadrosCatalogo[i] = Tile.ESIL;
                    continue;
                case 0xff845bd7:
                    cuadrosCatalogo[i] = Tile.ESDL;
                    continue;
                case 0xff5a595e:
                    cuadrosCatalogo[i] = Tile.EIIL;
                    continue;
                case 0xff9b75e8:
                    cuadrosCatalogo[i] = Tile.EIDL;
                    continue;
                case 0xffe16dbf:
                    cuadrosCatalogo[i] = Tile.ARRIBAL;
                    continue;
                case 0xff68c683:
                    cuadrosCatalogo[i] = Tile.ABAJOL;
                    continue;
                case 0xffa27c57:
                    cuadrosCatalogo[i] = Tile.BLOQUEL;
                    continue;
                case 0xffdbb692:
                    cuadrosCatalogo[i] = Tile.IZQUIERDAL;
                    continue;
                case 0xff884b0f:
                    cuadrosCatalogo[i] = Tile.DERECHAL;
                    continue;
                case 0xff2c1441:
                    if(cont % 200 > 100){
                        cuadrosCatalogo[i] = Tile.AGUA;
                    }else{
                        cuadrosCatalogo[i]=Tile.AGUA2;
                    }
                    
                    continue;
                case 0xff4ce66c:
                    cuadrosCatalogo[i] = Tile.BOSQUE;
                    continue;
                case 0xffc7e450:
                    cuadrosCatalogo[i] = Tile.ARENA;
                    continue;
                case 0xffff0000:
                    cuadrosCatalogo[i] = Tile.PIEDRA;
                    continue;
                case 0xffea644d:
                    if(cont % 300 > 150){
                        cuadrosCatalogo[i] = Tile.LAVA1;
                    }else{
                        cuadrosCatalogo[i]=Tile.LAVA2;
                    }
                    
                    continue;
                case 0xff2eb9ec:
                    cuadrosCatalogo[i] = Tile.PIEDRAF;
                    continue;
                case 0xff3c2106:
                    cuadrosCatalogo[i] = Tile.PUERTAUP;
                    continue;
                case 0xff2a2622:
                    cuadrosCatalogo[i] = Tile.PUERTADOWN;
                    continue;
                case 0xff960e0e:
                    if(cont % 300 > 150){
                        cuadrosCatalogo[i] = Tile.ESILAVA;
                    }else{
                        cuadrosCatalogo[i]=Tile.ESILAVA2;
                    }
                    
                    continue;
                case 0xffd11f1f:
                    if(cont % 300 > 150){
                        cuadrosCatalogo[i] = Tile.ESDLAVA;
                    }else{
                        cuadrosCatalogo[i]=Tile.ESDLAVA2;
                    }
                    continue;
                case 0xffee5555:
                    if(cont % 300 > 150){
                        cuadrosCatalogo[i] = Tile.EIILAVA;
                    }else{
                        cuadrosCatalogo[i]=Tile.EIILAVA2;
                    }
                    
                    continue;
                case 0xffee55d0:
                    if(cont % 300 > 150){
                        cuadrosCatalogo[i] = Tile.EIDLAVA;
                    }else{
                        cuadrosCatalogo[i]=Tile.EIDLAVA2;
                    }
                    
                    continue;
                case 0xffcb1919:
                    if(cont % 300 > 150){
                        cuadrosCatalogo[i] = Tile.ARRIBALAVA;
                    }else{
                        cuadrosCatalogo[i]=Tile.ARRIBALAVA2;
                    }
                    
                    continue;
                case 0xfff28181:
                    if(cont % 300 > 150){
                        cuadrosCatalogo[i] = Tile.ABAJOLAVA;
                    }else{
                        cuadrosCatalogo[i]=Tile.ABAJOLAVA2;
                    }
                    
                    continue;
                case 0xffaa6363:
                    if(cont % 300 > 150){
                        cuadrosCatalogo[i] = Tile.IZQUIERDALAVA;
                    }else{
                        cuadrosCatalogo[i]=Tile.IZQUIERDALAVA2;
                    }
                    continue;
                case 0xffa82323:
                    if(cont % 300 > 150){
                        cuadrosCatalogo[i] = Tile.DERECHALAVA;
                    }else{
                        cuadrosCatalogo[i]=Tile.DERECHALAVA2;
                    }
                    
                    continue;
                    
                    
                            
                default:
                    cuadrosCatalogo[i] = Tile.VACIO;
            } 
        }
    }
    
}
