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
public class Ground {
    private float x;
    private float y;
    private float vx;
    public static final int WIDTH = 640;
  public static final int HEIGHT = 40;
  Image bottomground;
  public Ground(float x, float y,float vx) throws SlickException {
   
    this.x = x;
    this.y = y;
    this.vx = vx;
    bottomground = new Image("res/ground.png");
    
    
  }
  public void render() {
    bottomground.draw(x - WIDTH/2 , y - HEIGHT/2);
    
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
