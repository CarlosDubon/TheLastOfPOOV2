/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

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
    
    public MapaCargado(String ruta) {
        super(ruta);
    }
    
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
                    cuadrosCatalogo[i] = Tile.AGUA;
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
                    cuadrosCatalogo[i] = Tile.LAVA1;
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
                    cuadrosCatalogo[i] = Tile.ESILAVA;
                    continue;
                case 0xffd11f1f:
                    cuadrosCatalogo[i] = Tile.ESDLAVA;
                    continue;
                case 0xffee5555:
                    cuadrosCatalogo[i] = Tile.EIILAVA;
                    continue;
                case 0xffee55d0:
                    cuadrosCatalogo[i] = Tile.EIDLAVA;
                    continue;
                case 0xffcb1919:
                    cuadrosCatalogo[i] = Tile.ARRIBALAVA;
                    continue;
                case 0xfff28181:
                    cuadrosCatalogo[i] = Tile.ABAJOLAVA;
                    continue;
                case 0xffaa6363:
                    cuadrosCatalogo[i] = Tile.IZQUIERDALAVA;
                    continue;
                case 0xffa82323:
                    cuadrosCatalogo[i] = Tile.DERECHALAVA;
                    continue;
                    
                    
                            
                default:
                    cuadrosCatalogo[i] = Tile.VACIO;
            } 
        }
    }
    
}
