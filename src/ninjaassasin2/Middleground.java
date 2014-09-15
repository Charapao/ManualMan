/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ninjaassasin2;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Administrator
 */
public class Middleground {
     private float x;
    private float y;
    private float vx;
    public static final int WIDTH = 640;
  public static final int HEIGHT = 40;
  Image middleground;
  public Middleground(float x, float y,float vx) throws SlickException {
   
    this.x = x;
    this.y = y;
    this.vx = vx;
    middleground = new Image("res/ground.png");
    
    
  }
  public void render() {
    middleground.draw(x - WIDTH/2 , y - HEIGHT/2);
    
  }
   public void update() {
    x += vx;  
        if(this.x < -WIDTH/2)
		    {
		    	this.x=100+640+100+640+320+100;
		    }
        
       
        
  }
    public float getX(){
    return x;
    }
    public float getY(){
    return y;
    }
}
