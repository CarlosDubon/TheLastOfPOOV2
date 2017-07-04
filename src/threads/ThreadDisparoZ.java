/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import control.Sonido;
import entes.criaturas.Criatura;
import entes.criaturas.DisparoZ;
import graficos.Sprite;

/**
 *Controla el disparo del enemigo final.
 * @author Carlos
 */
public class ThreadDisparoZ extends Criatura implements Runnable {
    private DisparoZ disparo;
    private boolean Alive=true;
    private int Cont=0;
    private Sonido SDIS;
    /**
     * Recibe los datos de disparoZ para, haciendo uso de sus metodos , acceder a sus atributos y modificarlos.
     * @param disparoZ 
     */
    public ThreadDisparoZ(DisparoZ disparoZ){
        this.disparo = disparoZ;
    }
    
    /**
     * Se encarga de modificar los valores de x y y de cada disparo; este metodo toma en cuenta la direccion a la que apunta el enemigo
     * final y realiza sus actualizaciones concorde a ello.
     */
    @Override
    public void run() {
        SDIS=new Sonido("DisparoZ");
        SDIS.clip.start();
        while(Alive){
         
            
            switch(disparo.getDireccion()){
                case 's':
                    //disparo.setStaticY(disparo.getOriginalY()+15);
                    disparo.setSprite(Sprite.DZ3);
                     disparo.setY(disparo.getVelocidad());            
                    if((disparo.getY() > disparo.getOriginalY()+450)/* || 
                            disparo.isCollision(disparo.getDesplazamientoX(), disparo.getDesplazamientoY(),DisparoZ.MarIzq,
                            DisparoZ.MarDer,DisparoZ.MarSup,DisparoZ.MarInf)*/){
                       
                        disparo.setSprite(Sprite.DZ5);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                        disparo.FB.arrayDisparosZ.remove(disparo.FB.arrayDisparosZ.indexOf(disparo));
                        this.Alive=false;
                        
                    }
                    break;
                case 'n':
                    //disparo.setStaticY(disparo.getOriginalY()+15);
                    disparo.setSprite(Sprite.DZ4);
                     disparo.setY(-disparo.getVelocidad());            
                     if((disparo.getY() < disparo.getOriginalY()-450) /*||
                             disparo.isCollision(disparo.getDesplazamientoX(), disparo.getDesplazamientoY(),DisparoZ.MarIzq,
                             DisparoZ.MarDer,DisparoZ.MarSup,DisparoZ.MarInf)*/){
                        
                        disparo.setSprite(Sprite.DZ5);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                        disparo.FB.arrayDisparosZ.remove(disparo.FB.arrayDisparosZ.indexOf(disparo));
                        this.Alive=false;

                    }
                    break;
                case 'e':
                    disparo.setStaticY(disparo.getOriginalY()+15);
                    disparo.setSprite(Sprite.DZ1);
                     disparo.setX(disparo.getVelocidad());            
                    if((disparo.getX() > disparo.getOriginalX()+500)/* || 
                            disparo.isCollision(disparo.getDesplazamientoX(), disparo.getDesplazamientoY(),DisparoZ.MarIzq,
                            DisparoZ.MarDer,DisparoZ.MarSup,DisparoZ.MarInf)*/){
                       
                        disparo.setSprite(Sprite.DZ5);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                        disparo.FB.arrayDisparosZ.remove(disparo.FB.arrayDisparosZ.indexOf(disparo));
                        this.Alive=false;
                        
                    }
                    break;
                case 'o':
                    disparo.setStaticY(disparo.getOriginalY()+15);
                    disparo.setSprite(Sprite.DZ2);
                     disparo.setX(-disparo.getVelocidad());            
                     if((disparo.getX() < disparo.getOriginalX()-500) /*||
                             disparo.isCollision(disparo.getDesplazamientoX(), disparo.getDesplazamientoY(),DisparoZ.MarIzq,
                             DisparoZ.MarDer,DisparoZ.MarSup,DisparoZ.MarInf)*/){
                        
                        disparo.setSprite(Sprite.DZ5);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                        disparo.FB.arrayDisparosZ.remove(disparo.FB.arrayDisparosZ.indexOf(disparo));
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
