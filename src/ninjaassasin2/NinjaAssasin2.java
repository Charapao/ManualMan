/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ninjaassasin2;

import static ninjaassasin2.Player.intforcountjumpintopedan;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Administrator
 */
public class NinjaAssasin2 extends BasicGame{
     static public Player player;
     static public Ground[] grounds;
     static public Topground[] topgrounds;
     static public Middleground[] middlegrounds;
     public static float G = (float) 0.5;
     public static final float PLAYER_JUMP_VY = 10;
     public static final int GAME_WIDTH = 640;
     public static final int GAME_HEIGHT = 480;
     public static final float Ground_VX = -4;
     private Shape[] rectground;
     private Shape[] recttopground;
     private Shape[] rectmiddleground;
     private Shape circleplayer;
     
     private boolean[] colliressground ;
     private boolean[] colliresstopground ;
     private boolean[] colliressmiddleground ;
    /**
     * @param args the command line arguments
     */
   public NinjaAssasin2(String title) {
    super(title);
  }

  

    @Override
    public void init(GameContainer gc) throws SlickException {
        colliressground = new boolean[3];
        for(int i = 0;i< colliressground.length;i++){
        colliressground[i]= false;
        
        }
         colliresstopground = new boolean[3];
        for(int i = 0;i< colliresstopground.length;i++){
        colliresstopground[i]= false;
        
        }
        colliressmiddleground = new boolean[3];
        for(int i = 0;i< colliressmiddleground.length;i++){
        colliressmiddleground[i]= false;
        
        }
        
        rectground = new Rectangle[3];
        recttopground = new Rectangle[3];
        rectmiddleground = new Rectangle[3];
        circleplayer = new Circle(0,0,20);
        for(int i=0; i < 3; i++){
        rectground[i] = new Rectangle(GAME_WIDTH/2-50-640+((640+100)*i),GAME_HEIGHT-40,640,40);
        //GAME_WIDTH/2-50-GAME_WIDTH,GAME_HEIGHT-40
        }
        for(int i=0; i < 3; i++){
        recttopground[i] = new Rectangle(0*(GAME_WIDTH*i), Topground.HEIGHT/2,640,40);
        //GAME_WIDTH/2-50-GAME_WIDTH,GAME_HEIGHT-40
        }
         for(int i=0; i < 3; i++){
        rectmiddleground[i] = new Rectangle(0*(GAME_WIDTH*i), Middleground.HEIGHT/2,640,40);
        //GAME_WIDTH/2-50-GAME_WIDTH,GAME_HEIGHT-40
        }
        player = new Player(GAME_WIDTH/4, 100, 0);
          grounds = new Ground[3]; 
        for (int i = 0; i < 3; i++) {
        grounds[i] = new Ground(GAME_WIDTH-320-50-GAME_WIDTH/2+((640+100)*i), GAME_HEIGHT-20,Ground_VX);
        
        }
          topgrounds = new Topground[3];
          for (int i = 0; i < 3; i++) {
        topgrounds[i] = new Topground(50+((640+100)*i), Topground.HEIGHT/2,Ground_VX);
        
        }
          middlegrounds = new Middleground[3];
          for (int i = 0; i < 3; i++) {
        middlegrounds[i] = new Middleground(-300+((640+100)*i), GAME_HEIGHT/2,Ground_VX);
        
        }
       
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        player.update();
        System.out.println(player.y);
        circleplayer.setCenterX(player.getX());
        circleplayer.setCenterY(GAME_HEIGHT-player.getY());
        for(int temp = 0; temp < 3; temp++){
        rectground[temp].setCenterX(grounds[temp].getX());
        rectground[temp].setCenterY(grounds[temp].getY()); 
        }
         for(int temp = 0; temp < 3; temp++){
        recttopground[temp].setCenterX(topgrounds[temp].getX());
        recttopground[temp].setCenterY(topgrounds[temp].getY()); 
        }
          for(int temp = 0; temp < 3; temp++){
        rectmiddleground[temp].setCenterX(middlegrounds[temp].getX());
        rectmiddleground[temp].setCenterY(middlegrounds[temp].getY()); 
        }
        for(int j= 0;j<colliressground.length;j++){
        colliressground[j]=circleplayer.intersects(rectground[j]);
        if(colliressground[0]||colliressground[1]||colliressground[2]){
          
          player.y=60;
          intforcountjumpintopedan=0;
          player.setVy(0); 
          }
        }
        for(int j= 0;j<colliresstopground.length;j++){
        colliresstopground[j]=circleplayer.intersects(recttopground[j]);
        if(colliresstopground[0]||colliresstopground[1]||colliresstopground[2]){
          
          player.y=420;
          intforcountjumpintopedan=1;
          player.setVy(0); 
          }
        }
         for(int j= 0;j<colliressmiddleground.length;j++){
        colliressmiddleground[j]=circleplayer.intersects(rectmiddleground[j]);
        if(colliressmiddleground[0]||colliressmiddleground[1]||colliressmiddleground[2]){
          //ทำเครทชนบนกับล่าง
            if(player.y<=280&&player.y>=250){
          player.y=280;
          intforcountjumpintopedan=0;
          player.setVy(0); }
            
            if(player.y>=200&&player.y<=230){
          player.y=200;
          intforcountjumpintopedan=1;
          player.setVy(0); }
          }
        }
       
      
        
        for (Ground ground : grounds) {
                
                 ground.update();
                 
            }
        for (Topground topground : topgrounds) {
                
                 topground.update();
                 
            }
        for (Middleground middleground : middlegrounds) {
                
                 middleground.update();
                 
            }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
          player.render();
          g.setColor(Color.yellow);
          g.fill(circleplayer);
          g.setColor(Color.pink);
          g.draw(circleplayer);
          g.drawString("Col1 : "+colliressground[0]+" Col2 :"+colliressground[1]+"Col3 :"+colliressground[2], GAME_WIDTH/2, GAME_HEIGHT/2);
          
          for (Ground ground : grounds) {
                
                 ground.render();
                 
            }
          for (Topground topground : topgrounds) {
                
                 topground.render();
                 
            }
           for (Middleground middleground : middlegrounds) {
                
                 middleground.render();
                 
            }
          for(Shape rec : rectground){
          g.setColor(Color.yellow);
          g.fill(rec);
          g.setColor(Color.pink);
          g.draw(rec);
          }
           for(Shape rectop : recttopground){
          g.setColor(Color.blue);
          g.fill(rectop);
          g.setColor(Color.pink);
          g.draw(rectop);
          }
            for(Shape recmiddle : rectmiddleground){
          g.setColor(Color.white);
          g.fill(recmiddle);
          g.setColor(Color.orange);
          g.draw(recmiddle);
          }
    }
     @Override
        public void keyPressed(int key, char c) {
            if (key == Input.KEY_SPACE) {
            player.jump();
             
             
            
               
        }
        }
     public static void main(String[] args) {
         try {
      NinjaAssasin2 game = new NinjaAssasin2("NinjaAssasinGAME");
      AppGameContainer appgc = new AppGameContainer(game);
      appgc.setDisplayMode(640, 480, false);
      appgc.setMinimumLogicUpdateInterval(1000 / 60);
      appgc.start();
      
    } catch (SlickException e) {
      e.printStackTrace();
    }
    }
}
