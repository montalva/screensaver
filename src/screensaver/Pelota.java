/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package screensaver;

import java.awt.Color;
import edu.princeton.cs.introcs.*;

/**
 *
 * @author Dario
 */
public class Pelota extends Thread {
    double x,y;
    int velocidad, size;
    double radio;
    
    public Pelota(double xi, double yi, int velocidad, int size, int radio){
          x = xi;
          y = yi;
	  this.velocidad = velocidad;	
	  this.size=size;
          this.radio=radio*10;
          System.out.println(xi+" "+yi+" "+velocidad+" "+size);
    }
    
    
    public void run() {
        
          double vx = 1;
          double vy = 1;
          
          if (Math.random()>0.5) 
              vx *= 1;
          else
              vx *= -1;
    
          if (Math.random()>0.5) 
              vy *= 1;
          else
              vy *= -1;
           
          
          while (true) {         
               if (x + radio > size || x - radio < 0) { vx *= -1; }
               if (y + radio > size || y - radio < 0) { vy *= -1; }
               x += vx;
               y += vy;
           
             //  StdDraw.setPenColor(StdDraw.RED);
             //  StdDraw.filledCircle(x, y, radio);
               try { sleep(velocidad); } catch(Exception e){}
            //   StdDraw.setPenColor(StdDraw.WHITE);
            //   StdDraw.filledCircle(x, y, radio+1);           
            //   try { sleep(velocidad); } catch(Exception e){}
          }
     }
}
