/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa.tile;

import graficos.Pantalla;
import graficos.Sprite;

/**
 * Carga todos los tiles registrados en el juego y se les asigna un sprite y si es solido o no
 * @author Carlos
 */
public  class Tile {
    private boolean solido;
    

    //Coleccion de Tiles
    public static final Tile LADRILLO = new Tile(Sprite.LADRILLO);
    public static final Tile VACIO = new Tile(Sprite.VACIO,true);
    public static final Tile ESDL = new Tile(Sprite.ESDL, true);
    public static final Tile ESIL = new Tile(Sprite.ESIL, true);
    public static final Tile EIDL = new Tile(Sprite.EIDL, true);
    public static final Tile EIIL = new Tile(Sprite.EIIL, true);
    public static final Tile ARRIBAL = new Tile(Sprite.ARRIBAL, true);
    public static final Tile ABAJOL = new Tile(Sprite.ABAJOL, true);
    public static final Tile BLOQUEL = new Tile(Sprite.BLOQUEL, true);
    public static final Tile DERECHAL = new Tile(Sprite.DERECHAL, true);
    public static final Tile IZQUIERDAL = new Tile(Sprite.IZQUIERDAL, true);
    public static final Tile AGUA = new Tile(Sprite.AGUA, true);
    public static final Tile AGUA2 = new Tile(Sprite.AGUA2, true);
    public static final Tile BOSQUE = new Tile(Sprite.BOSQUE, true);
    public static final Tile ARENA = new Tile(Sprite.ARENA);
    public static final Tile PIEDRA = new Tile(Sprite.PIEDRA,true);
    public static final Tile LAVA1 = new Tile(Sprite.LAVA1,true);
    public static final Tile LAVA2 = new Tile(Sprite.LAVA2,true);
     public static final Tile PIEDRAF = new Tile(Sprite.PIEDRAF,true);
    public static  Tile PUERTAUP = new Tile(Sprite.PUERTAUP,true);
    public static  Tile PUERTADOWN = new Tile(Sprite.PUERTADOWN,true);
    
    public static final Tile ESILAVA = new Tile(Sprite.ESILAVA,true);
    public static final Tile ESDLAVA = new Tile(Sprite.ESDLAVA,true);
    public static final Tile EIILAVA = new Tile(Sprite.EIILAVA, true);
    public static final Tile EIDLAVA = new Tile(Sprite.EIDLAVA, true);
    public static final Tile ARRIBALAVA = new Tile(Sprite.ARRIBALAVA, true);
    public static final Tile ABAJOLAVA = new Tile(Sprite.ABAJOLAVA, true);
    public static final Tile IZQUIERDALAVA = new Tile(Sprite.IZQUIERDALAVA, true);
    public static final Tile DERECHALAVA = new Tile(Sprite.DERECHALAVA, true);
    public static final Tile ESILAVA2 = new Tile(Sprite.ESILAVA2,true);
    public static final Tile ESDLAVA2 = new Tile(Sprite.ESDLAVA2,true);
    public static final Tile EIILAVA2 = new Tile(Sprite.EIILAVA2, true);
    public static final Tile EIDLAVA2 = new Tile(Sprite.EIDLAVA2, true);
    public static final Tile ARRIBALAVA2 = new Tile(Sprite.ARRIBALAVA2, true);
    public static final Tile ABAJOLAVA2 = new Tile(Sprite.ABAJOLAVA2, true);
    public static final Tile IZQUIERDALAVA2 = new Tile(Sprite.IZQUIERDALAVA2, true);
    public static final Tile DERECHALAVA2 = new Tile(Sprite.DERECHALAVA2, true);

    
    //FIN
    public int x;
    public int y;
    
    public Sprite sprite;
    
    public static final int LADO = 32;
    
    /**
     * Constructor que cambia el sprite de un tile y la propiedad isSolid
     * @param sprite 
     */
    public Tile(Sprite sprite){
        this.sprite = sprite;
        this.solido = false;
    }
    /**
     * Constructor que cambia el sprite y cambia la propiedad is solid dependiendo de lo que reciba
     * @param sprite
     * @param solido 
     */
    public Tile(Sprite sprite, boolean solido){
        this.sprite = sprite;
        this.solido = solido;
    }
    /**
     * muestra el tile en pantalla
     * @param x
     * @param y
     * @param pantalla 
     */
    public void mostrar(int x, int y, Pantalla pantalla){
        pantalla.mostrarTile(x << 5,y << 5, this);

    }

    public void setSolido(boolean solido) {
        this.solido = solido;
    }
    
       
    public boolean isSolido(){
        return solido;
    }
}
