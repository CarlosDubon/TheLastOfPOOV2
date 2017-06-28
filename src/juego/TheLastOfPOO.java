/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import control.Estado;
import control.Puntaje;
import control.Sonido;

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
import entes.criaturas.BatyRed;
import entes.criaturas.FinalBoss;
import entes.criaturas.KillMarBlue;
import entes.criaturas.Mago;
import entes.criaturas.MagoT;
import entes.criaturas.Skeletor;
import entes.criaturas.Tauro;
import entes.criaturas.Trofeo;
import java.awt.Rectangle;
import javax.sound.sampled.Clip;
import threads.Tiempo;


/**
 *
 * @author Carlos
 */
public final class TheLastOfPOO extends Canvas implements Runnable, KeyListener{


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
    private static boolean LastTrap = false;
    
    private static Mapa mapa1Keyed;
    private static Mapa mapa1Blocked;
    private static boolean BlockedMapa1= false;
    private static Mapa mapa2Keyed_1;
    private static Mapa mapa2Keyed_2;
    private static Mapa mapa3_Traped;
    
    
    private static Jugador jugador;
    private static Plasta plasta;
    private static Portal portal;
    private static Baty baty;
    private static Baty baty2;
    private static BatyRed batyRed3;
    private static BatyRed batyRed;
    private static Skeletor skeletor;
    private static Mago mago1;
    private static KillMarBlue kill;
    private static Mago mago2;
    private static MagoT magoT1;
    private static MagoT magoT2;
    private static MagoT magoT3;
    private static BatyRed batyRed2;
    private static KillMarBlue kill2;
    private static KillMarBlue kill3;
    private static Skeletor catrina2;
    private static Mago mago3;
    private static MagoT magoT4;
    private static Skeletor catrina;
    private static Tauro tauro;
    private static Tauro tauro2;
    private static Tauro tauro3;
    private static Baty batyBlue2;
    private static Baty batyBlue3;
    private static Plasta plasta2;
    private static FinalBoss Zh0rThiz;
    
    private static Key key1;
    private static Key key2_1;
    private static Key key2_2;
    
    private static final int xScore=80,yScore=230, Mx=375 , My=64;
    
    private static Heart heart1;
    private static Heart heart2;
    private static Heart heart3;
    private static Heart heart4;
    private static Heart heart5;
    
    private static Heart heart2_1;
    private static Heart heart2_2;
    private static Heart heart2_3;
    private static Heart heart2_4;
    private static Heart heart2_5;
    
    private static Heart heart3_1;
    private static Heart heart3_2;
    private static Heart heart3_3;
    private static Heart heart3_4;
    private static Heart heart3_5;
    private static Heart heart3_6;
    
    private static Trofeo trofeo;
    public static boolean Win;
    
    private  final static Sonido Musica0 = new Sonido("Musica2");
    private  final static Sonido MusicaGame = new Sonido("Musica3");
    private  final static Sonido Musica1 = new Sonido("Musica3_final");
    private  final static Sonido Musica_Win = new Sonido("Musica_Win");
    private  final static Sonido Musica_Loose = new Sonido("Musica_Loose");
    private  static boolean isMusica=false;
   
    private Teclado teclado;
    private String Nick=null; // A la hora de dar start resetear el nick
    private static Pantalla pantalla;
    
    private final static DBQuery BaseDeDatos = new DBQuery();
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
    private static BufferedImage HelpScreen;

    private static BufferedImage Cursor;
    
    private static int PuntajeT=750;
    
    private TheLastOfPOO(){
        setPreferredSize(new Dimension(ANCHO, ALTO));
        estado = new Estado();
        
        //Estado.estado=3; //Testing (PORTAL NO FUNCIONA SI SE DESCOMENTA)
        pantalla = new Pantalla(ANCHO,ALTO);
        
       
        try {
            Menu = ImageIO.read(new File(".\\.\\recursos\\texturas\\GameMenu.png"));
            PantallaScore= ImageIO.read(new File(".\\.\\recursos\\texturas\\GameScore.png"));
            HelpScreen = ImageIO.read(new File(".\\.\\recursos\\texturas\\HelpScreen.png"));
            Cursor= ImageIO.read(new File(".\\.\\recursos\\texturas\\Cursor.png"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
       
       mapa= new MapaCargado("/texturas/InicioPixel.png");
       mapa1 = new MapaCargado("/texturas/InicioPixel.png");
       mapa1Keyed= new MapaCargado("/texturas/InicioPixel2.png");
       mapa1Blocked= new MapaCargado("/texturas/InicioPixel_blocked.png");
       mapa2 = new MapaCargado("/texturas/mapa2.png");
       mapa2Keyed_1 = new MapaCargado("/texturas/mapa2_1.png");
       mapa2Keyed_2 = new MapaCargado("/texturas/mapa2_2.png");
       mapa3 = new MapaCargado("/texturas/mapa3.png");
       mapa3_Traped = new MapaCargado("/texturas/mapa3_Trap.png");
       
       Restock();

       //jugador.setStaticX(400);
       //jugador.setStaticY(280);
       
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
                
                batyRed.actualizar();
                //plasta2.actualizar();
                heart1.actualizar();
                heart2.actualizar();
                heart3.actualizar();
                heart4.actualizar();
                heart5.actualizar();
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
                skeletor.actualizar();
                tauro.actualizar();
                batyBlue3.actualizar();
                batyRed3.actualizar();
                plasta2.actualizar();
                batyBlue2.actualizar();
                tauro3.actualizar();
                kill.actualizar();
                portal.actualizar();
                key2_1.actualizar();
                key2_2.actualizar();
                
                heart2_1.actualizar();
                heart2_2.actualizar();
                heart2_3.actualizar();
                heart2_4.actualizar();
                heart2_5.actualizar();
                
                break;
            case 3:
                
                if (Zh0rThiz.getHP()>0 && !LastTrap && jugador.getBounds().intersects(new Rectangle(1430, 800, 7*32, 32))){
                    LastTrap=true;
                    isMusica=false;
                }
                
                if(LastTrap){
                    mapa=mapa3_Traped;
                    Zh0rThiz.actualizar();
                }else{
                    mapa=mapa3;
                }
                
                if(Zh0rThiz.getHP() <=0){
                    trofeo.actualizar();
                    Zh0rThiz.actualizar();
                    LastTrap=false;
                }
                
                jugador.setMapa(mapa);
                mago1.actualizar();
                magoT1.actualizar();
                magoT2.actualizar();
                magoT3.actualizar();
                magoT4.actualizar();
                mago2.actualizar();
                mago3.actualizar();
                kill2.actualizar();
                kill3.actualizar();
                tauro2.actualizar();
                catrina.actualizar();
                catrina2.actualizar();
                batyRed2.actualizar();
                
                heart3_1.actualizar();
                heart3_2.actualizar();
                heart3_3.actualizar();
                heart3_4.actualizar();
                heart3_5.actualizar();
                heart3_6.actualizar();
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
        
        if(!isMusica && (Estado.estado ==1 ||Estado.estado ==2 ||Estado.estado ==3) && !LastTrap){
            StopAll();
            MusicaGame.PlayLoop();
            isMusica=true;
        }
        
        switch (estado.getEstado()){
            case 1:
                plasta.mostrar(pantalla);
                baty.mostrar(pantalla);
                baty2.mostrar(pantalla);
                batyRed.mostrar(pantalla);
                
                //plasta2.mostrar(pantalla);
                portal.mostrar(pantalla);
                heart1.mostrar(pantalla);
                heart2.mostrar(pantalla);
                heart3.mostrar(pantalla);
                heart4.mostrar(pantalla);
                heart5.mostrar(pantalla);
                key1.mostrar(pantalla);
                break;
            case 2:
                skeletor.mostrar(pantalla);
                kill.mostrar(pantalla);
                tauro.mostrar(pantalla);
                batyBlue2.mostrar(pantalla);
                batyBlue3.mostrar(pantalla);
                batyRed3.mostrar(pantalla);
                plasta2.mostrar(pantalla);
                tauro3.mostrar(pantalla);
                portal.mostrar(pantalla);
                key2_1.mostrar(pantalla);
                key2_2.mostrar(pantalla);
                
                heart2_1.mostrar(pantalla);
                heart2_2.mostrar(pantalla);
                heart2_3.mostrar(pantalla);
                heart2_4.mostrar(pantalla);
                heart2_5.mostrar(pantalla);
                
                break;
            case 3:
                
                if(Zh0rThiz.getHP() <=0){
                    trofeo.mostrar(pantalla);
                }
                
                mago1.mostrar(pantalla);
                magoT1.mostrar(pantalla);
                magoT2.mostrar(pantalla);
                magoT3.mostrar(pantalla);
                magoT4.mostrar(pantalla);
                mago2.mostrar(pantalla);
                mago3.mostrar(pantalla);
                kill2.mostrar(pantalla);
                kill3.mostrar(pantalla);
                tauro2.mostrar(pantalla);
                catrina.mostrar(pantalla);
                catrina2.mostrar(pantalla);
                batyRed2.mostrar(pantalla);
                Zh0rThiz.mostrar(pantalla);
                
                heart3_1.mostrar(pantalla);
                heart3_2.mostrar(pantalla);
                heart3_3.mostrar(pantalla);
                heart3_4.mostrar(pantalla);
                heart3_5.mostrar(pantalla);
                heart3_6.mostrar(pantalla);
                for(int i =0;i<Zh0rThiz.arrayDisparosZ.size();i++){
                    Zh0rThiz.arrayDisparosZ.get(i).mostrar(pantalla);
                }
                
                
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
        //g.drawString("X: "+jugador.getX(),600,20);
        //g.drawString("Y: "+jugador.getY(),600,30);
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
            Estado.estado=6;
            if(isMusica){
                isMusica = false;
                StopAll();
                Musica_Loose.clip.start();
            }
            Font fontGameOver = new Font("Agency FB",Font.BOLD,35); 
            g.setFont(fontGameOver);
            g.setColor(Color.BLACK);
            g.fillRect(0,0, ANCHO, ALTO);
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", ANCHO/2-50,ALTO/2);
            g.drawString("Press Enter to continue...", ANCHO/2-120,ALTO/2+40);
            PuntajeT=jugador.getPuntaje()-segundos;
            if(PuntajeT<0){
                PuntajeT=0;
            }
            
            jugador.setPuntaje(PuntajeT);
            //jugador.setPuntaje(jugador.getHP());
            
            if(Nick == null && !Active){
                Active=true;
                Nick=JOptionPane.showInputDialog(this, "Nickname: ", "GAME OVER", JOptionPane.QUESTION_MESSAGE);
                if(Nick.isEmpty()){
                    Nick = "No nick";
                }
                BaseDeDatos.insertJugador(Nick, jugador.getPuntaje());
                
                //System.out.println(Nick);
            }
            
            
        }
        
        if(Estado.estado == 10){
            THilo.stop();
            if (!isMusica){
                StopAll();
                Musica_Win.clip.start();
                isMusica=true;
            }
            Font fontGameOver = new Font("Agency FB",Font.BOLD,35); 
            g.setFont(fontGameOver);
            g.setColor(Color.BLACK);
            g.fillRect(0,0, ANCHO, ALTO);
            g.setColor(Color.WHITE);
            g.drawString("CONGRATULATIONS", ANCHO/2-100,ALTO/2-40);
            g.drawString("YOU WIN", ANCHO/2-50,ALTO/2);
            g.drawString("Press Enter to continue...", ANCHO/2-150,ALTO/2+40);
            
            jugador.setPuntaje(jugador.getPuntaje()+jugador.getHP());
            
            if(Nick == null && !Active){
                Active=true;
                Nick=JOptionPane.showInputDialog(this, "Nickname: ", "YOU ARE THE WINNER", JOptionPane.QUESTION_MESSAGE);
                if(Nick.isEmpty()){
                    Nick = "No nick";
                }
                BaseDeDatos.insertJugador(Nick, jugador.getPuntaje());
            }
        }
        
        if(Estado.estado ==3 && LastTrap){
            if (!isMusica){
                StopAll();
                Musica1.PlayLoop();
                isMusica=true;
            }
            g.setColor(Color.GREEN);
            g.fillRect(150,575, Zh0rThiz.getHP(), 15);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Consolas",Font.ITALIC,20));
            g.drawString("ZhOrThiz", ANCHO/2 - 40, 575-10);
        }
        
        if(Estado.estado == 0){
            
            if (!isMusica){
                StopAll();
                Musica0.PlayLoop();
                isMusica=true;
            }

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
                        g.drawString((i+1)+". "+Top10[i].getNick()+" \t "+Top10[i].getScore(), xScore, yScore+(i*My));
                    }
                    else{
                        g.drawString((i+1)+". "+Top10[i].getNick()+" \t "+Top10[i].getScore(), xScore+Mx, yScore+((i-5)*My));
                    }
               }
                
            }
               
        }
        if(Estado.estado==5){
            g.drawImage(HelpScreen, 0, 0, this);
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
            if(Estado.estado == 0 && CursorY <=478){
                CursorY += 100;
            }else
                CursorY = 238;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(Estado.estado == 0 && CursorY > 238){
                CursorY -= 100;
            }else
                CursorY = 538;
        }
        
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            if(Estado.estado == 0){
                switch (CursorY){
                    case 238:
                        ControlTiempo=true;
                        THilo.start();
                        Estado.estado = 1;
                        isMusica=false;
                        break;
                    case 338:
                        
                        Top10=BaseDeDatos.TopScores();
                        
                        Estado.estado=4;
                        break;
                    case 438:
                        Estado.estado=5;
                        break;
                    case 538:
                        System.exit(0);
                        break;
                }
                CursorY=238;
            }
            else if(Estado.estado==6){
                Restock();
                isMusica=false;
                Estado.estado=0;
                
            }
            else if (Estado.estado == 4 || Estado.estado == 5){
                Estado.estado=0;
                
            }
            else if(Estado.estado ==10){
                Restock();
                isMusica=false;
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
        
       CursorX = 200;
       CursorY = 238;
        
       Active=false;
       LastTrap=false;
       BlockedMapa1=false;
       Win=false;
        
       Nick=null;
       
       mapa=mapa1;
       
       segundos=0;
       tiempo=new Tiempo();
       THilo=new Thread(tiempo);
       ControlTiempo=false;
       
       
       //Mapa1
       
       jugador = new Jugador(teclado,367,350,Sprite.INICIAL0,mapa);
       //jugador.setStaticY(1130);//TEST PARA MAPA 3
       //jugador.setStaticX(1329);//TEST PARA MAPA 3
       plasta = new Plasta(teclado,1200,500,Sprite.PLASTAIN0,jugador,mapa);
       key1=new Key(450, 1270, Sprite.KEY1, jugador, mapa1);
       heart1= new Heart(428, 788, Sprite.HEART1, jugador, mapa);
       heart2= new Heart(444, 788, Sprite.HEART1, jugador, mapa);
       heart3= new Heart(436, 788+16, Sprite.HEART1, jugador, mapa);
       heart4= new Heart(1272, 190, Sprite.HEART1, jugador, mapa);
       heart5= new Heart(1450, 875, Sprite.HEART1, jugador, mapa);
       portal = new Portal(1500,875,Sprite.PORTAL1,jugador,mapa);
       baty = new Baty(1050,390,Sprite.BATIZ0,jugador,mapa);
       baty2 = new Baty(587,1046,Sprite.BATIZ0,jugador,mapa);
       batyRed = new BatyRed(1383,858,Sprite.BATRIZ0,jugador,mapa);
       

       
       //Mapa2
       
       skeletor = new Skeletor(919,718,Sprite.SKINICIO0,jugador,mapa);
       kill = new KillMarBlue(247,1356,Sprite.KMDOWN0,jugador,mapa);
       tauro = new Tauro(1250,250,Sprite.TRDOWN0,jugador,mapa);
       batyBlue2 = new Baty(1124,1250,Sprite.BATIZ0,jugador,mapa);
       batyBlue3 = new Baty(214,802,Sprite.BATABAJO0,jugador,mapa,'n');
       batyRed3 = new BatyRed(341,802,Sprite.BATABAJO0,jugador,mapa,'n');
       plasta2 = new Plasta(teclado,375,1495,Sprite.PLASTADE0,jugador,mapa);
       tauro3 = new Tauro(1015,967,Sprite.TRIZ0,jugador,mapa);
       key2_1=new Key(220, 1430, Sprite.KEY1, jugador, mapa);
       key2_2=new Key(750, 587, Sprite.KEY1, jugador, mapa);
       heart2_1= new Heart(1175, 360, Sprite.HEART1, jugador, mapa);
       heart2_2= new Heart(480, 1530, Sprite.HEART1, jugador, mapa);
       heart2_3= new Heart(1125, 1320, Sprite.HEART1, jugador, mapa);
       heart2_4= new Heart(1125+16, 1320, Sprite.HEART1, jugador, mapa);
       heart2_5= new Heart(1125+8, 1320+16, Sprite.HEART1, jugador, mapa);
       
       
       //Mapa 3
       trofeo= new Trofeo(1145, 1136, Sprite.TF1, jugador, mapa);
       mago1=  new Mago(919,260,Sprite.MGRINICIO0,jugador,mapa);
       mago3=  new Mago(1945,1220,Sprite.MGRINICIO0,jugador,mapa);
       mago2 = new Mago(410,1296,Sprite.MGRINICIO0,jugador,mapa);
       magoT1=  new MagoT(1270,265,Sprite.MGTINICIO0,jugador,mapa,1270,265-(5*32));
       magoT2=  new MagoT(1913,1776,Sprite.MGTINICIO0,jugador,mapa,1913+(6*32),1776+(5*32));
       magoT3=  new MagoT(1500,1800,Sprite.MGTINICIO0,jugador,mapa,1500,1800+(6*32));
       magoT4=  new MagoT(410,930,Sprite.MGTINICIO0,jugador,mapa,410-(6*32),930);
       catrina = new Skeletor(764,1836,Sprite.SKINICIO0,jugador,mapa);
       catrina2 = new Skeletor(1928,816,Sprite.SKINICIO0,jugador,mapa);
       kill2 = new KillMarBlue(1784,1461,Sprite.KMDOWN0,jugador,mapa);
       kill3 = new KillMarBlue(920,530,Sprite.KMDOWN0,jugador,mapa);
       tauro2 = new Tauro(1545,710,Sprite.TRDOWN0,jugador,mapa);
       batyRed2 = new BatyRed(1913,415,Sprite.BATRIZ0,jugador,mapa);
       Zh0rThiz = new FinalBoss(830,1130,Sprite.FBDE0,jugador,mapa);
       heart3_1= new Heart(1916, 290, Sprite.HEART1, jugador, mapa);
       heart3_2= new Heart(1770, 950, Sprite.HEART1, jugador, mapa);
       heart3_3= new Heart(448, 1535, Sprite.HEART1, jugador, mapa);
       heart3_4= new Heart(675, 805, Sprite.HEART1, jugador, mapa);
       heart3_5= new Heart(675+16, 805, Sprite.HEART1, jugador, mapa);
       heart3_6= new Heart(675+8, 805+16, Sprite.HEART1, jugador, mapa);
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
    
    public void StopAll(){
        Musica_Win.clip.stop();
        Musica0.stop();
        Musica1.stop();
        MusicaGame.stop();
        Musica_Loose.stop();
    }

}
