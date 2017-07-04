/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import entes.criaturas.Criatura;
import entes.criaturas.Disparo;
import graficos.Pantalla;
import graficos.Sprite;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controla el disparo del jugador principal.
 * @author Carlos
 */
public class ThreadDisparo extends Criatura implements Runnable {
    private Disparo disparo;
    private boolean Alive=true;
    private int Cont=0;
    
    
    /**
     * Recibe los datos de un objeto tipo disparo para, haciendo uso de sus metodos , acceder a sus atributos y modificarlos.
     * @param disparoZ 
     */
    public ThreadDisparo(Disparo disparo){
        this.disparo = disparo;
    }
    
    /**
     * Se encarga de modificar los valores de x y y de cada disparo; este metodo toma en cuenta la direccion a la que apunta el enemigo
     * final y realiza sus actualizaciones concorde a ello.
     */
    @Override
    public  void run() {
        /*while(!isCollision(disparo.getDesplazamientoX(),disparo.getDesplazamientoY())){
        disparo.setDesplazamientoX(desplazamientoX);
        }*/
        disparo.setHiloDisparo(Thread.currentThread());
        switch (disparo.getDireccion()) {
            case 'e':
                disparo.setStaticX(disparo.getOriginalX()+24);
                break;
            case 'o':
                disparo.setStaticX(disparo.getOriginalX()+5);
                break;
            case 's':
                disparo.setStaticY(disparo.getOriginalY()+10);
                break;
        //disparo.setStaticY(disparo.getOriginalY()-5);
            case 'n':
                break;
            default:
                disparo.setStaticY(disparo.getOriginalY()+10);
                break;
        }
        
        while(Alive){
         
            
            switch(disparo.getDireccion()){
                case 'n':
                    disparo.setStaticX(disparo.getOriginalX()+10);
                    disparo.setSprite(Sprite.DISPARO5);
                    disparo.setY(-disparo.getVelocidad());            
                    if((disparo.getY() < disparo.getOriginalY()-423) || 
                        disparo.isCollision(disparo.getDesplazamientoX(), disparo.getDesplazamientoY(),Disparo.MarIzq,
                                            Disparo.MarDer,Disparo.MarSup,Disparo.MarInf)){
                        
                        disparo.setSprite(Sprite.DISPARO2);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                        disparo.jugador.arrayDisparos.remove(disparo.jugador.arrayDisparos.indexOf(disparo));
                        this.Alive=false;

                    }
                    break;
                case 's':
                    disparo.setStaticX(disparo.getOriginalX()+11);
                    disparo.setSprite(Sprite.DISPARO3);
                    disparo.setY(disparo.getVelocidad());            
                    if((disparo.getY() > disparo.getOriginalY()+423) || 
                        disparo.isCollision(disparo.getDesplazamientoX(), disparo.getDesplazamientoY(),Disparo.MarIzq,
                                            Disparo.MarDer,Disparo.MarSup,Disparo.MarInf)){
                        
                        disparo.setSprite(Sprite.DISPARO2);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                        disparo.jugador.arrayDisparos.remove(disparo.jugador.arrayDisparos.indexOf(disparo));
                        this.Alive=false;

                        
                    }
                    break;
                case 'e':
                    disparo.setStaticY(disparo.getOriginalY()+15);
                    disparo.setSprite(Sprite.DISPARO1);
                     disparo.setX(disparo.getVelocidad());            
                    if((disparo.getX() > disparo.getOriginalX()+423) || 
                        disparo.isCollision(disparo.getDesplazamientoX(), disparo.getDesplazamientoY(),Disparo.MarIzq,
                                            Disparo.MarDer,Disparo.MarSup,Disparo.MarInf)){
                       
                        disparo.setSprite(Sprite.DISPARO2);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                        disparo.jugador.arrayDisparos.remove(disparo.jugador.arrayDisparos.indexOf(disparo));
                        this.Alive=false;
                        
                    }
                    break;
                case 'o':
                    disparo.setStaticY(disparo.getOriginalY()+15);
                    disparo.setSprite(Sprite.DISPARO4);
                     disparo.setX(-disparo.getVelocidad());            
                    if((disparo.getX() < disparo.getOriginalX()-423) || 
                        disparo.isCollision(disparo.getDesplazamientoX(), disparo.getDesplazamientoY(),Disparo.MarIzq,
                                            Disparo.MarDer,Disparo.MarSup,Disparo.MarInf)){
                        
                        disparo.setSprite(Sprite.DISPARO2);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                        disparo.jugador.arrayDisparos.remove(disparo.jugador.arrayDisparos.indexOf(disparo));
                        this.Alive=false;

                    }
                    break;
                default:
                    disparo.setStaticX(disparo.getOriginalX()+16);
                    disparo.setSprite(Sprite.DISPARO3);
                    disparo.setY(disparo.getVelocidad());            
                    if((disparo.getY() > disparo.getOriginalY()+423) || 
                        disparo.isCollision(disparo.getDesplazamientoX(), disparo.getDesplazamientoY(),Disparo.MarIzq,
                                            Disparo.MarDer,Disparo.MarSup,Disparo.MarInf)){
                        
                        disparo.setSprite(Sprite.DISPARO2);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                        disparo.jugador.arrayDisparos.remove(disparo.jugador.arrayDisparos.indexOf(disparo));
                        this.Alive=false;

                        
                    }
                    break;
            }
            
            
 
            
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            
            //System.out.println(disparo.getX()+" "+disparo.getY());
        }
        
    }
    
    
}
