package ninjaassasin2;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Player {
    public static float intforcountjumpintopedan = 1;
    public static float x;
    public static float y;
    public static float vy;
    private float vjump;
     public static final int WIDTH = 40;
  public static final int HEIGHT = 40;
    private Image image;
    public Player(float x, float y,float vjump) throws SlickException {
    this.x = x;
    this.y = y;
    this.vy = vjump;
    this.vjump = NinjaAssasin2.PLAYER_JUMP_VY;
    image = new Image("res/ninja.png");
  }
    public void render() {
    image.draw(x - WIDTH/2, NinjaAssasin2.GAME_HEIGHT - (y + HEIGHT/2));
  }
    public void update() {
    y += vy;
    if(intforcountjumpintopedan==1)
    vy -= NinjaAssasin2.G;
    
    else vy += NinjaAssasin2.G;
    
   }
    public void jump() { 
   if(intforcountjumpintopedan==1){
        vy = -1*vjump;
        intforcountjumpintopedan=0; vy=0;}
   else {vy = vjump;intforcountjumpintopedan=1;vy=0;}
    setVy(vy);
  }
    public void setVy(float vy) {
    this.vy = vy;
  }
    public float getX(){
    return x;
    }
    public float getY(){
    return y;
    }
    public float Intcount(){
    return intforcountjumpintopedan;
    }
}
