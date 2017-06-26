/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;
import graficos.Pantalla;
import mapa.tile.Tile;
/**
 *
 * @author Carlos
 */
public abstract class Mapa {
    protected int ancho;
    protected int alto;
   
    protected int[] tile;
    protected Tile[] cuadrosCatalogo;
    
    public Mapa(int ancho, int alto){
        this.ancho=ancho;
        this.alto=alto;
        
        tile = new int [ancho*alto];
        generarMapa();
    }
    
    public Mapa(String ruta){
        cargarMapa(ruta);
        generarMapa();
    }
    
    protected void generarMapa(){
    
    }
    
    protected void cargarMapa(String ruta){
    
    }
    public void actualizar(){
    
    }
    
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
