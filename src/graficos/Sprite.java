/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;


/**
 *
 * @author Carlos
 */
public class Sprite {
    private final int lado;
    private int x;
    private int y;
    
    public int[] pixeles;
    private HojaSprites hoja;
    
    //Coleccion de sprites
    // ESTILO LADRILLOS
    public static final Sprite LADRILLO = new Sprite(32,0,0,HojaSprites.Sprites);
    public static final Sprite VACIO = new Sprite(32,0xff000000);
    public static final Sprite ESIL = new Sprite(32,1,0,HojaSprites.Sprites);
    public static final Sprite ESDL = new Sprite(32,2,0,HojaSprites.Sprites);
    public static final Sprite EIIL = new Sprite(32,3,0,HojaSprites.Sprites);
    public static final Sprite EIDL = new Sprite(32,4,0,HojaSprites.Sprites);
    public static final Sprite ARRIBAL = new Sprite(32,5,0,HojaSprites.Sprites);
    public static final Sprite ABAJOL = new Sprite(32,6,0,HojaSprites.Sprites);
    public static final Sprite BLOQUEL = new Sprite(32,7,0,HojaSprites.Sprites);
    public static final Sprite IZQUIERDAL = new Sprite(32,8,0,HojaSprites.Sprites);
    public static final Sprite DERECHAL = new Sprite(32,9,0,HojaSprites.Sprites);
    public static final Sprite PUERTAUP = new Sprite(32,7,1,HojaSprites.Sprites);
    public static final Sprite PUERTADOWN = new Sprite(32,8,1,HojaSprites.Sprites);
    //FIN ESTILO LADRILLOS
    //PERSONAJE------------------------
    public static final Sprite INICIAL_1 =  new Sprite(48,0,0,HojaSprites.HojaSpritePersonaje);
    public static final Sprite INICIAL0 =  new Sprite(48,1,0,HojaSprites.HojaSpritePersonaje);
    public static final Sprite INICIAL1 =  new Sprite(48,2,0,HojaSprites.HojaSpritePersonaje);
    public static final Sprite IZQUIERDA_1 =  new Sprite(48,0,1,HojaSprites.HojaSpritePersonaje);
    public static final Sprite IZQUIERDA0 =  new Sprite(48,1,1,HojaSprites.HojaSpritePersonaje);
    public static final Sprite IZQUIERDA1 =  new Sprite(48,2,1,HojaSprites.HojaSpritePersonaje);
    public static final Sprite DERECHA_1 =  new Sprite(48,0,2,HojaSprites.HojaSpritePersonaje);
    public static final Sprite DERECHA0 =  new Sprite(48,1,2,HojaSprites.HojaSpritePersonaje);
    public static final Sprite DERECHA1 =  new Sprite(48,2,2,HojaSprites.HojaSpritePersonaje);
    public static final Sprite ARRIBA_1 =  new Sprite(48,0,3,HojaSprites.HojaSpritePersonaje);
    public static final Sprite ARRIBA0 =  new Sprite(48,1,3,HojaSprites.HojaSpritePersonaje);
    public static final Sprite ARRIBA1 =  new Sprite(48,2,3,HojaSprites.HojaSpritePersonaje);
    
//FIN PERSONAJE----------------------
// INICIO PLAYA
    public static final Sprite AGUA = new Sprite(32,0,1,HojaSprites.Sprites);
    public static final Sprite BOSQUE = new Sprite(32,1,1,HojaSprites.Sprites);
    public static final Sprite ARENA = new Sprite(32,2,1,HojaSprites.Sprites);
    public static final Sprite PIEDRA = new Sprite(32,5,1,HojaSprites.Sprites);
//FIN PLAYA
//INICIO PLASTA
    public static final Sprite PLASTAIN0 = new Sprite(32,1,0,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTAIN_1 = new Sprite(32,0,0,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTAIN1 = new Sprite(32,2,0,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTAIZ0 = new Sprite(32,1,1,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTAIZ_1 = new Sprite(32,0,1,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTAIZ1 = new Sprite(32,2,1,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTADE0 = new Sprite(32,1,2,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTADE_1 = new Sprite(32,0,2,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTADE1 = new Sprite(32,2,2,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTAUP0 = new Sprite(32,1,3,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTAUP_1 = new Sprite(32,0,3,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTAUP1 = new Sprite(32,2,3,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTADIE = new Sprite(32,0,4,HojaSprites.HojaSpritePlasta);
    public static final Sprite PLASTAD = new Sprite(32,1,4,HojaSprites.HojaSpritePlasta);
    
//FIN PLASTA
    // INICIO FINAL
    public static final Sprite LAVA1 = new Sprite(32,3,1,HojaSprites.Sprites);
    public static final Sprite LAVA2 = new Sprite(32,4,1,HojaSprites.Sprites);
    public static final Sprite PIEDRAF = new Sprite(32,6,1,HojaSprites.Sprites);
    
    //FINAL FINAL
    public static final Sprite PORTAL1 = new Sprite(32,0,0,HojaSprites.HojaPortalSprite);
    public static final Sprite PORTAL2 = new Sprite(32,1,0,HojaSprites.HojaPortalSprite);
    public static final Sprite PORTAL3 = new Sprite(32,2,0,HojaSprites.HojaPortalSprite);
    public static final Sprite PORTAL4 = new Sprite(32,3,0,HojaSprites.HojaPortalSprite);
    //Inicio PORTAL
    
    //INICIO KEY
    
    public static final Sprite KEY1 = new Sprite(32,0,0,HojaSprites.HojaKeySprite);
    public static final Sprite KEY2 = new Sprite(32,1,0,HojaSprites.HojaKeySprite);
    public static final Sprite KEYNULL = new Sprite(32,2,0,HojaSprites.HojaKeySprite);
    
    //FIN KEY
    
    //INICIO CORAZON
    
    public static final Sprite HEART1 = new Sprite(32,0,0,HojaSprites.HojaCorazonSprite);
    public static final Sprite HEART2 = new Sprite(32,1,0,HojaSprites.HojaCorazonSprite);
    public static final Sprite HEARTNULL = new Sprite(32,2,0,HojaSprites.HojaCorazonSprite);
    
    //FIN CORAZON
    
    //INICIO SPRITE DISPAROS
    public static final Sprite DISPARO1 = new Sprite(16,0,0,HojaSprites.HojaDisparoSprites);
    public static final Sprite DISPARO2 = new Sprite(16,1,0,HojaSprites.HojaDisparoSprites);
    public static final Sprite DISPARO3 = new Sprite(16,2,0,HojaSprites.HojaDisparoSprites);
    public static final Sprite DISPARO4 = new Sprite(16,3,0,HojaSprites.HojaDisparoSprites);
    public static final Sprite DISPARO5 = new Sprite(16,0,1,HojaSprites.HojaDisparoSprites);
    
        
//FIN SPRITE DISPAROS
    //LADRILLOS CON LAVA
    public static final Sprite ESILAVA = new Sprite(32,0,2,HojaSprites.Sprites);
    public static final Sprite ESDLAVA = new Sprite(32,1,2,HojaSprites.Sprites);
    public static final Sprite EIILAVA = new Sprite(32,2,2,HojaSprites.Sprites);
    public static final Sprite EIDLAVA = new Sprite(32,3,2,HojaSprites.Sprites);
    public static final Sprite ARRIBALAVA = new Sprite(32,4,2,HojaSprites.Sprites);
    public static final Sprite ABAJOLAVA = new Sprite(32,5,2,HojaSprites.Sprites);
    public static final Sprite IZQUIERDALAVA = new Sprite(32,6,2,HojaSprites.Sprites);
    public static final Sprite DERECHALAVA = new Sprite(32,7,2,HojaSprites.Sprites);

    //FIN LADRILLOS LAVA
    //Fin Portal
    
    //SPRITES MURCIELAGO
    public static final Sprite BATINICIO0 = new Sprite(48,1,0,HojaSprites.HojaBatSprites);
    public static final Sprite BATINICIO1 = new Sprite(48,0,0,HojaSprites.HojaBatSprites);
    public static final Sprite BATINICIO_1 = new Sprite(48,2,0,HojaSprites.HojaBatSprites);
    public static final Sprite BATIZ0 = new Sprite(48,1,1,HojaSprites.HojaBatSprites);
    public static final Sprite BATIZ1 = new Sprite(48,0,1,HojaSprites.HojaBatSprites);
    public static final Sprite BATIZ_1 = new Sprite(48,2,1,HojaSprites.HojaBatSprites);
    public static final Sprite BATDE0 = new Sprite(48,1,2,HojaSprites.HojaBatSprites);
    public static final Sprite BATDE1 = new Sprite(48,0,2,HojaSprites.HojaBatSprites);
    public static final Sprite BATDE_1 = new Sprite(48,2,2,HojaSprites.HojaBatSprites);
    public static final Sprite BATABAJO0 = new Sprite(48,1,3,HojaSprites.HojaBatSprites);
    public static final Sprite BATABAJO1 = new Sprite(48,0,3,HojaSprites.HojaBatSprites);
    public static final Sprite BATABAJO_1 = new Sprite(48,2,3,HojaSprites.HojaBatSprites);
    public static final Sprite BATADIE = new Sprite(48,0,4,HojaSprites.HojaBatSprites);

    // FIN SPRITES MURCIELAGOS
    //SPRITES MURCIELAGO
    public static final Sprite BATRINICIO0 = new Sprite(48,1,0,HojaSprites.HojaBatRedSprites);
    public static final Sprite BATRINICIO1 = new Sprite(48,0,0,HojaSprites.HojaBatRedSprites);
    public static final Sprite BATRINICIO_1 = new Sprite(48,2,0,HojaSprites.HojaBatRedSprites);
    public static final Sprite BATRIZ0 = new Sprite(48,1,1,HojaSprites.HojaBatRedSprites);
    public static final Sprite BATRIZ1 = new Sprite(48,0,1,HojaSprites.HojaBatRedSprites);
    public static final Sprite BATRIZ_1 = new Sprite(48,2,1,HojaSprites.HojaBatRedSprites);
    public static final Sprite BATRDE0 = new Sprite(48,1,2,HojaSprites.HojaBatRedSprites);
    public static final Sprite BATRDE1 = new Sprite(48,0,2,HojaSprites.HojaBatRedSprites);
    public static final Sprite BATRDE_1 = new Sprite(48,2,2,HojaSprites.HojaBatRedSprites);
    public static final Sprite BATRABAJO0 = new Sprite(48,1,3,HojaSprites.HojaBatRedSprites);
    public static final Sprite BATRABAJO1 = new Sprite(48,0,3,HojaSprites.HojaBatRedSprites);
    public static final Sprite BATRABAJO_1 = new Sprite(48,2,3,HojaSprites.HojaBatRedSprites);
    public static final Sprite BATRADIE = new Sprite(48,0,4,HojaSprites.HojaBatRedSprites);

    // FIN SPRITES MURCIELAGOS
//Fin de la coleccion
    
    public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja){
        this.lado = lado;
        this.hoja = hoja;
        pixeles = new int[lado*lado];
        this.x = columna *lado;
        this.y = fila*lado;
        
        for(int i=0 ; i<lado ; i++){
            for(int j=0; j<lado ;j++){
                pixeles[j+i * lado] = hoja.pixeles[(j+x)+(i+y)*hoja.getAncho()];
            }
        }
    }
    public Sprite(final int lado, final int color){
        this.lado = lado;
        pixeles = new int[lado*lado];
        for(int i =0; i<pixeles.length;i++){
            pixeles[i]=color;
        }
    }
    public int getLado(){
        return lado;
    }
}
