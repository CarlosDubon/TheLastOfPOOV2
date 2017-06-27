/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Carlos
 */
public class HojaSprites {
    private final int ancho;
    private final int alto;
    public final int[] pixeles;
    
    //Coleccion de hojas de sprites
    public static HojaSprites Sprites = new HojaSprites("/texturas/Sprites.png",320,320);
    public static HojaSprites HojaSpritePersonaje = new HojaSprites("/texturas/HojaSpritePersonaje.png",144,192);
    public static HojaSprites HojaSpritePlasta = new HojaSprites("/texturas/PlastaSprites.png",96,160);
    public static HojaSprites HojaPortalSprite = new HojaSprites("/texturas/portalSprites.png",128,32);
    public static HojaSprites HojaKeySprite = new HojaSprites("/texturas/HojaSpritesLlave.png",96,32);
    public static HojaSprites HojaCorazonSprite = new HojaSprites("/texturas/HojaSpriteCorazon.png",96,32);
    public static HojaSprites HojaDisparoSprites = new HojaSprites("/texturas/SpriteDisparo.png",64,64);
    public static HojaSprites HojaBatSprites = new HojaSprites("/texturas/BatSprites.png",144,240);
    public static HojaSprites HojaBatRedSprites = new HojaSprites("/texturas/BatRedSprites.png",144,240);
    public static HojaSprites HojaSkeletorSprites = new HojaSprites("/texturas/SkeletorSprites.png",144,240);
    public static HojaSprites HojaMagoRSprites = new HojaSprites("/texturas/HojaSpritesMagoRojo.png",144,240);
    public static HojaSprites HojaMagoASprites = new HojaSprites("/texturas/HojaSpritesMagoRojoAmarillo.png",144,240);
    public static HojaSprites HojaKillMarBlueSprites = new HojaSprites("/texturas/KillmarBlueSprites.png",144,240);
    public static HojaSprites HojaTauroSprites = new HojaSprites("/texturas/TaouroSprites.png",144,240);
    public static HojaSprites HojaMagoTSprites = new HojaSprites("/texturas/HojaSpritesMagoAzul.png",144,240);
    public static HojaSprites HijaFinalBossSprites = new HojaSprites("/texturas/FinalBossSprites.png",210,350);
    public static HojaSprites HojaDisparoZSprites = new HojaSprites("/texturas/DisparoZ.png",350,70);
    public static HojaSprites HojaTrofeoSprite = new HojaSprites("/texturas/TrofeoSprite.png",96,32);


    //fin de la coleccion
    
    public HojaSprites(final String ruta,final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;
            
        pixeles = new int[ancho*alto];
        BufferedImage imagen;    
        try {    
            imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public int getAncho(){
        return ancho;
    }
}
