/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;
import graficos.Pantalla;
import mapa.tile.Tile;
/**
 * Clase abstracta que contiene los metodos que usaran las demas clases en este paquete
 * @author Carlos
 */
public abstract class Mapa {
    protected int ancho;
    protected int alto;
   
    protected int[] tile;
    protected Tile[] cuadrosCatalogo;
    /**
     * Constrcutor que crea un array de tiles de un tamaño en especifico
     * @param ancho ancho del mapa
     * @param alto alto del mapa
     */
    public Mapa(int ancho, int alto){
        this.ancho=ancho;
        this.alto=alto;
        
        tile = new int [ancho*alto];
        generarMapa();
    }
    /**
     * Constructor que unicamente recive una ruta de un mapa
     * @param ruta 
     */
    public Mapa(String ruta){
        cargarMapa(ruta);
        generarMapa();
    }
    /**
     * utilizado en la fase de pruebas para generar mapas random
     */
    protected void generarMapa(){
    
    }
    /**
     * Carga un mapa desde una ruta
     * @param ruta 
     */
    protected void cargarMapa(String ruta){
    
    }
    /**
     * Actualiza el estdo del mapa
     */
    public void actualizar(){
    
    }
    /**
     * Muestra el mapa en pantalla
     * @param compensacionX diferencia de x del movimiento
     * @param compensacionY diferencia de y del movimiento
     * @param pantalla 
     */
    public void mostrar(final int compensacionX,final int compensacionY,Pantalla pantalla){
        this.generarMapa();
        pantalla.resetDiferencia(compensacionX, compensacionY);
        int o = compensacionX >> 5; // /32
        int e = (compensacionX + pantalla.getAncho()+Tile.LADO)>> 5;
        int n = compensacionY >> 5;
        int s = (compensacionY + pantalla.getAlto()+Tile.LADO)>> 5;
        for(int y = n; y <s ;y++){
            for(int x = o; x<e ;x++){
                    //getTile(x,y).mostrar(x,y,pantalla);
                if(x<0 || y<0 || x>=ancho || y>=alto){
                    Tile.VACIO.mostrar(x, y, pantalla);
                }else{
                    cuadrosCatalogo[x + y * ancho].mostrar(x, y, pantalla);
                }
            }
        }
        if(MapaCargado.cont < 32767){
            MapaCargado.cont++;
        }else{
            MapaCargado.cont =0;
        }
    }
    /**
     * Asigna a cada tile un numero que lo representara para generarce de manera aleatiria
     * @param x
     * @param y
     * @return 
     */
    public Tile getTile(final int  x,final int  y){
        if(x < 0 || y < 0 || x >= ancho || y > alto){
                return Tile.VACIO;
        }
        switch (tile[x+y * ancho]){
            case 0:
                return Tile.LADRILLO;
            case 1:
                return Tile.ESDL;
            case 2:
                return Tile.ESIL;
            case 3:
                return Tile.EIDL;
            case 4:
                return Tile.EIIL;
            case 5:
                return Tile.ARRIBAL;
            case 6:
                return Tile.ABAJOL;
            case 7:
                return Tile.BLOQUEL;
            case 8:
                return Tile.DERECHAL;
            case 9:
                return Tile.IZQUIERDAL;
            default:
                return Tile.VACIO;
        }
    }
    
    public Tile getCuadrosCatalogo(int posicion){
        return cuadrosCatalogo[posicion];
    }
    public int getAncho(){
        return ancho;
    }
}
