/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import entes.criaturas.Criatura;
import entes.criaturas.DisparoZ;
import graficos.Sprite;

/**
 *
 * @author Carlos
 */
public class ThreadDisparoZ extends Criatura implements Runnable {
    private DisparoZ disparo;
    private boolean Alive=true;
    private int Cont=0;
    
    public ThreadDisparoZ(DisparoZ disparoZ){
        this.disparo = disparoZ;
    }
    @Override
    public void run() {
        while(Alive){
         
            
            switch(disparo.getDireccion()){
                
                case 'e':
                    disparo.setStaticY(disparo.getOriginalY()+15);
                    disparo.setSprite(Sprite.DZ1);
                     disparo.setX(disparo.getVelocidad());            
                    if((disparo.getX() > disparo.getOriginalX()+500)/* || 
                            disparo.isCollision(disparo.getDesplazamientoX(), disparo.getDesplazamientoY(),DisparoZ.MarIzq,
                            DisparoZ.MarDer,DisparoZ.MarSup,DisparoZ.MarInf)*/){
                       
                        //disparo.setSprite(Sprite.DISPARO2);
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
                        
                        //disparo.setSprite(Sprite.DISPARO2);
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
