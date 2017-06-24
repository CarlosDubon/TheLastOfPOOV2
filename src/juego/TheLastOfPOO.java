/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import control.Estado;
import control.Puntaje;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import control.Teclado;
import entes.criaturas.Disparo;
import entes.criaturas.Heart;
import entes.criaturas.Jugador;
import entes.criaturas.Key;
import entes.criaturas.Plasta;
import entes.criaturas.Portal;
import graficos.Pantalla;
import graficos.Sprite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mapa.Mapa;
import mapa.MapaCargado;
import mapa.tile.Tile;
import database.DBQuery;
import entes.criaturas.Baty;
import threads.Tiempo;


/**
 *
 * @author Carlos
 */
public class TheLastOfPOO extends Canvas implements Runnable, KeyListener{


    private static final long serialVersionUID = 1L;
    private static JFrame ventana;
    private static final int ANCHO = 800;
    private static final int ALTO = 600;
    private static final String TITLE = "The LastOf POO ";
    private static int aps =0;
    private static int fps=0;

    
    private static Thread thread;
    private static volatile boolean funcionando = false; 
    
    private static Estado estado;
    
    protected static boolean Zpressed=false;
    private static Thread ZHilo;
    
    private static Mapa mapa;
    private static Mapa mapa1;
    private static Mapa mapa2;
    private static Mapa mapa3;
    
    private static boolean Active= false;
    
    private static Mapa mapa1Keyed;
    private static Mapa mapa1Blocked;
    private static boolean BlockedMapa1= false;
    private static Mapa mapa2Keyed_1;
    private static Mapa mapa2Keyed_2;
    
    private static Jugador jugador;
    private static Disparo disparo;
    private static Plasta plasta;
    private static Plasta plasta2;
    private static Portal portal;
    private static Baty baty;
    private static Baty baty2;
    
    private static Key key1;
    private static Key key2_1;
    private static Key key2_2;
    
    private static final int xScore=80,yScore=230, Mx=375 , My=64;
    
    private static Heart heart1;
    
    private Teclado teclado;
    private String Nick=null; // A la hora de dar start resetear el nick
    private static Pantalla pantalla;
    
    private static DBQuery BaseDeDatos;
    private static Puntaje[] Top10;
    
    private static int CursorX;        
    private static int CursorY;
    
    public static boolean ControlTiempo=false;
    public static int segundos;
    public static String TiempoF;
    private static Tiempo tiempo;
    private static Thread THilo;
    
    public static BufferedImage imagen = new BufferedImage(ANCHO,ALTO,BufferedImage.TYPE_INT_RGB);
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    
    private static BufferedImage Menu;
    private static BufferedImage PantallaScore;

    private static BufferedImage Cursor;
    
    private TheLastOfPOO(){
        setPreferredSize(new Dimension(ANCHO, ALTO));
        estado = new Estado();
        //Estado.estado=2; //Testing (PORTAL NO FUNCIONA SI SE DESCOMENTA)
        pantalla = new Pantalla(ANCHO,ALTO);
        teclado = new Teclado();
       
        try {
            Menu = ImageIO.read(new File(".\\.\\recursos\\texturas\\GameMenu.png"));
            PantallaScore= ImageIO.read(new File(".\\.\\recursos\\texturas\\GameScore.png"));
            Cursor= ImageIO.read(new File(".\\.\\recursos\\texturas\\Cursor.png"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
       
       segundos=0;
       tiempo=new Tiempo();
       THilo= new Thread(tiempo);
       
        
       BaseDeDatos= new DBQuery();
       
       mapa= new MapaCargado("/texturas/InicioPixel.png");
       mapa1 = new MapaCargado("/texturas/InicioPixel.png");
       mapa1Keyed= new MapaCargado("/texturas/InicioPixel2.png");
       mapa1Blocked= new MapaCargado("/texturas/InicioPixel_blocked.png");
       mapa2 = new MapaCargado("/texturas/mapa2.png");
       mapa2Keyed_1 = new MapaCargado("/texturas/mapa2_1.png");
       mapa2Keyed_2 = new MapaCargado("/texturas/mapa2_2.png");
       mapa3 = new MapaCargado("/texturas/mapa3.png");
       jugador = new Jugador(teclado,367,350,Sprite.INICIAL0,mapa);
       //disparo = new Disparo(teclado,367,350,Sprite.DISPARO1,jugador,mapa);
       plasta = new Plasta(teclado,1200,500,Sprite.PLASTAIN0,jugador,mapa);
       baty = new Baty(1050,390,Sprite.BATIZ0,jugador,mapa);
       baty2 = new Baty(587,1046,Sprite.BATIZ0,jugador,mapa);
       //plasta2 = new Plasta(teclado,552,376,Sprite.PLASTAIN0,jugador,mapa);
       portal = new Portal(1500,875,Sprite.PORTAL1,jugador,mapa);
       
       key1=new Key(450, 1270, Sprite.KEY1, jugador, mapa1);
       key2_1=new Key(230, 1430, Sprite.KEY1, jugador, mapa2);
       key2_2=new Key(755, 600, Sprite.KEY1, jugador, mapa2);
       
       heart1= new Heart(428, 788, Sprite.HEART1, jugador, mapa1);
       
       CursorX = 200;
       CursorY = 278;

        addKeyListener(teclado);
        addKeyListener(this);
        ventana = new JFrame(TITLE);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this,BorderLayout.CENTER);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
    public static void main(String[] args) {
        TheLastOfPOO juego = new TheLastOfPOO();
        juego.iniciar();
        
    }
    private synchronized void iniciar(){
        funcionando = true;
        thread = new Thread(this,"Graficos");
        thread.start();
    }
    private synchronized void detener(){
        funcionando = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    private void actualizar(){
        teclado.actualizar();
        
        
        switch (estado.getEstado()){
            case 1:
                if(jugador.getBounds().intersects(700, 960, 32, 32*7)){
                    BlockedMapa1=true;
                }
                if(key1.isKeyUsed()){
                    mapa=mapa1Keyed;
                    BlockedMapa1=false;
                }else{
                    
                    if(BlockedMapa1){
                        mapa=mapa1Blocked;
                    }else{
                        mapa=mapa1;   
                    }
                    
                     
                }
                    
                jugador.setMapa(mapa);
                plasta.actualizar();
                baty.actualizar();
                baty2.actualizar();
                //plasta2.actualizar();
                heart1.actualizar();
                portal.actualizar();
                key1.actualizar();
                break;
            case 2:
                if(key2_1.isKeyUsed()){
                    if(key2_2.isKeyUsed()){
                        mapa=mapa2Keyed_2;
                    }
                    else{
                        mapa=mapa2Keyed_1;
                    }
                    
                }else{
                    mapa=mapa2;
                }
                
                jugador.setMapa(mapa);
                portal.actualizar();
                key2_1.actualizar();
                key2_2.actualizar();
                break;
            case 3:
                mapa=mapa3;
                jugador.setMapa(mapa);
                break;
        }
        if (Estado.estado != 0 && Estado.estado != 4)
            jugador.actualizar();
        aps++;
    }
    
    private void mostrar(){
        //System.out.println(segundos);
        BufferStrategy estrategia = getBufferStrategy();
        if (estrategia == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = estrategia.getDrawGraphics();

        pantalla.limpiar();
        mapa.mostrar(jugador.getX() - pantalla.getAncho()/2+jugador.getSprite().getLado()/2, jugador.getY() - pantalla.getAlto()/2 + jugador.getSprite().getLado()/2, pantalla);
        
        switch (estado.getEstado()){
            case 1:
                plasta.mostrar(pantalla);
                baty.mostrar(pantalla);
                baty2.mostrar(pantalla);
                //plasta2.mostrar(pantalla);
                portal.mostrar(pantalla);
                heart1.mostrar(pantalla);
                key1.mostrar(pantalla);
                break;
            case 2:
                portal.mostrar(pantalla);
                key2_1.mostrar(pantalla);
                key2_2.mostrar(pantalla);
                break;
            case 3:
                break;
        }
        jugador.mostrar(pantalla);
        
        
            for(int i =0;i<jugador.arrayDisparos.size();i++){
                jugador.arrayDisparos.get(i).mostrar(pantalla);
            }
                  
        
        Font fontTimer = new Font("Agency FB",Font.BOLD,25);
        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
        
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(),null);
        
        g.setColor(new Color(0x2c3e50));
        g.fillRect(0,0, ANCHO, 50);
        g.setColor(Color.WHITE);
        g.drawString("X: "+jugador.getX(),600,20);
        g.drawString("Y: "+jugador.getY(),600,30);
        g.drawString("HP: ",10,20);
        g.drawString("EP: ",10, 30);
        g.drawString("FR: ",10, 40);
        g.setFont(fontTimer);
        g.drawString(""+jugador.getPuntaje(), 400, 40);
     
        g.drawString(""+TiempoF,750,25);
        g.setColor(new Color(46, 204, 113));
        g.fillRect(35, 15, jugador.getHP()/2, 5);
        g.setColor(new Color(52, 152, 219));
        g.fillRect(35, 25,jugador.getEP()/2,5);
        g.setColor(new Color(186, 20, 31));
        g.fillRect(35, 35,(int)jugador.getFire()*4,5);
        if(jugador.getHP() <= 0){
            THilo.stop();
            Font fontGameOver = new Font("Agency FB",Font.BOLD,35); 
            g.setFont(fontGameOver);
            g.setColor(Color.BLACK);
            g.fillRect(0,0, ANCHO, ALTO);
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", ANCHO/2-50,ALTO/2);
            g.drawString("Press Enter to continue...", ANCHO/2-120,ALTO/2+40);
            if(Nick == null && !Active){
                Active=true;
                Nick=JOptionPane.showInputDialog(this, "Nickname: ", "GAME OVER", JOptionPane.QUESTION_MESSAGE);
                BaseDeDatos.insertJugador(Nick, jugador.getPuntaje());
                
                //System.out.println(Nick);
            }
            
            
        }
        
        if(Estado.estado == 0){

            g.drawImage(Menu, 0, 0, this);
            g.drawImage(Cursor,CursorX,CursorY,this);
        }
        
        if (Estado.estado == 4){
            int cont=0;
            g.setColor(Color.WHITE);
            g.setFont(new Font("Agency FB",Font.BOLD,30));
            g.drawImage(PantallaScore, 0, 0, this);
            for(int i=0; i< Top10.length;i++){
                if(Top10[i]!= null){
                    if(i<5){
                        g.drawString((i+1)+". "+Top10[i].getNick()+"  "+Top10[i].getScore(), xScore, yScore+(i*My));
                    }
                    else{
                        g.drawString((i+1)+". "+Top10[i].getNick()+"  "+Top10[i].getScore(), xScore+Mx, yScore+((i-5)*My));
                    }
               }
                
            }

                
                                 
        }
        


        g.dispose();
        estrategia.show();
        fps++;
    }
    
    @Override
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
        
        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();
        double tiempoTranscurrido;
        double delta =0;
        
        requestFocus();
        
        while(funcionando){
            final long inicioBucle = System.nanoTime();
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;
            delta += tiempoTranscurrido/NS_POR_ACTUALIZACION;
            
            while(delta >=1){
                actualizar();
                delta --;
            }
            mostrar();
            if(System.nanoTime()-referenciaContador > NS_POR_SEGUNDO){
                
                ventana.setTitle(TITLE + " || APS: " + aps + " || FPS: "+fps);
                
                aps=0;
                fps=0;
                referenciaContador= System.nanoTime();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            jugador.setHP(0);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_Z){
            
            if (!Zpressed){
                jugador.setZreleased(false);
                if(jugador.getFire() > 0){
                    jugador.disparar();
                    jugador.setFire(-1);
                    if(jugador.getFire() < 5){
                    }
                }
                
                ZHilo=new Thread(new TimerZ());
                ZHilo.start();
                
            }
            
            
            
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(Estado.estado == 0 && CursorY <=378){
                CursorY += 100;
            }else
                CursorY = 278;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(Estado.estado == 0 && CursorY > 278){
                CursorY -= 100;
            }else
                CursorY = 478;
        }
        
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            if(Estado.estado == 0){
                switch (CursorY){
                    case 278:
                        ControlTiempo=true;
                        THilo.start();
                        Estado.estado = 1;
                        break;
                    case 378:
                        
                        Top10=BaseDeDatos.TopScores();
                        
                        Estado.estado=4;
                        break;
                    case 478:
                        System.exit(0);
                        break;
                }
                CursorY=278;
            }
            else if(Estado.estado !=0 && jugador.getHP() <=0 && Estado.estado !=4){
                Restock();
                Estado.estado=0;
            }
            else if (Estado.estado == 4){
                Estado.estado=0;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_Z){
            jugador.setZreleased(true);
            Zpressed=false;
        }
    }
    
    public void Restock(){
        teclado= new Teclado();
        addKeyListener(teclado);
        
        Active=false;
        BlockedMapa1=false;
        
        Nick=null;
       
       mapa=mapa1;
       
       segundos=0;
       tiempo=new Tiempo();
       THilo=new Thread(tiempo);
       ControlTiempo=false;
       
       jugador = new Jugador(teclado,367,350,Sprite.INICIAL0,mapa);
       plasta = new Plasta(teclado,1200,500,Sprite.PLASTAIN0,jugador,mapa);
       key1=new Key(450, 1270, Sprite.KEY1, jugador, mapa1);
       portal = new Portal(1500,875,Sprite.PORTAL1,jugador,mapa);
       baty = new Baty(1050,390,Sprite.BATIZ0,jugador,mapa);
       baty2 = new Baty(587,1046,Sprite.BATIZ0,jugador,mapa);

       
       key2_1=new Key(220, 1430, Sprite.KEY1, jugador, mapa2);
       key2_2=new Key(750, 587, Sprite.KEY1, jugador, mapa2);
    }
    
    
    public class TimerZ implements Runnable{
        
        @Override
        public void run() {
            TheLastOfPOO.Zpressed= true;
            try{
              
                Thread.sleep(200);
            
            }catch(Exception e){}
            TheLastOfPOO.Zpressed= false;
        }
        
    }
    
}
