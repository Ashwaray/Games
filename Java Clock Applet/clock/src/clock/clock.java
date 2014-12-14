/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clock;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.math.*;
import java.util.*;

        /**
 *
 * @author CETPA
 */

public class clock extends Applet implements Runnable{
    Image clk;

    double sec_x,sec_y, min_x, min_y, hr_x,hr_y;

    int hr,min,sec;
    int count =0;
    
    public void init()
    {

        clk = getImage(getDocumentBase(), "120px-Analog_clock_base.PNG");


        sec_x = 58.0;
        sec_y = 40.0;
        min_x = 58.0;
        min_y = 40.0;
        hr_x = 58.0;
        hr_y = 40.0;
        int i;

        Calendar calendar = new GregorianCalendar();
       // setBackground(Color.red);

    /*    hr = calendar.get(Calendar.HOUR);
        min = calendar.get(Calendar.MINUTE);
        sec = calendar.get(Calendar.SECOND);
*/
        System.out.println("Current Time : " + hr + ":"+ min + ":" + sec );

  /*      setvalues_hr(hr);
        setvalues_min(min);
        setvalues_sec(sec);
        System.out.println("hehe x="+hr_x+"y="+hr_y);
        System.out.println("hehe x="+min_x+"y="+min_y);
        System.out.println("hehe x="+sec_x+"y="+sec_y);*/
    }

    public void start()
    {
        Thread t;
        t = new Thread(this,"clock_a");
        t.start();
    }

    public void run()
    {  

       try
        {
            int h,m;
            double s=0;        

            for(h=0;h<24;h++){
                for(m=0;m<15;m++){    //first 15 minutes

                    min_x++;
                    min_y++;

                    if(sec_x >=58 && sec_x <73 && sec_y>= 40 && sec_y<55 ){
                    for(s=0; s<15 ;s++)
                         {                                                          
                             
                              sec_x++;
                              sec_y++;
                              
                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                    if(sec_x >58 && sec_x <=73 && sec_y>= 55 && sec_y<70 ){
                      for(s=0; s<15 ;s++)
                         {
                              sec_x--;
                              sec_y++;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                     if(sec_x <=58 && sec_x >43 && sec_y <= 70 && sec_y>55 ){
                      for(s=0; s<15 ;s++)
                         {
                              sec_x--;
                              sec_y--;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                    if(sec_x >=43 && sec_x <58 && sec_y<= 55 && sec_y>40 ){
                      for(s=0; s<15 ;s++)
                         {
                             sec_x++;
                              sec_y--;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                }
                         for(m=0;m<15;m++){ //second 15 minutes

                    min_x--;
                    min_y++;

                    if(sec_x >=58 && sec_x <78 && sec_y>= 40 && sec_y<55 ){
                    for(s=0; s<15 ;s++)
                         {

                              sec_x++;
                              sec_y++;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                    if(sec_x >58 && sec_x <=73 && sec_y>= 55 && sec_y<70 ){
                      for(s=0; s<15 ;s++)
                         {
                              sec_x--;
                              sec_y++;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                     if(sec_x <=58 && sec_x >43 && sec_y <= 70 && sec_y>55 ){
                      for(s=0; s<15 ;s++)
                         {
                              sec_x--;
                              sec_y--;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                    if(sec_x >=43 && sec_x <58 && sec_y<= 55 && sec_y>40 ){
                      for(s=0; s<15 ;s++)
                         {
                             sec_x++;
                              sec_y--;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                }

                         for(m=0;m<15;m++){ //third 15 minutes

                    min_x--;
                    min_y--;

                    if(sec_x >=58 && sec_x <73 && sec_y>= 40 && sec_y<55 ){
                    for(s=0; s<15 ;s++)
                         {

                              sec_x++;
                              sec_y++;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                    if(sec_x >58 && sec_x <=73 && sec_y>= 55 && sec_y<70 ){
                      for(s=0; s<15 ;s++)
                         {
                              sec_x--;
                              sec_y++;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                     if(sec_x <=58 && sec_x >43 && sec_y <= 70 && sec_y>55 ){
                      for(s=0; s<15 ;s++)
                         {
                              sec_x--;
                              sec_y--;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                    if(sec_x >=43 && sec_x <58 && sec_y<= 55 && sec_y>40 ){
                      for(s=0; s<15 ;s++)
                         {
                             sec_x++;
                              sec_y--;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                }

                         for(m=0;m<15;m++){ // fourth 15 minutes

                    min_x++;
                    min_y--;

                    if(sec_x >=58 && sec_x <73 && sec_y>= 40 && sec_y<55 ){
                    for(s=0; s<15 ;s++)
                         {

                              sec_x++;
                              sec_y++;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                    if(sec_x >58 && sec_x <=73 && sec_y>= 55 && sec_y<70 ){
                      for(s=0; s<15 ;s++)
                         {
                              sec_x--;
                              sec_y++;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                     if(sec_x <=58 && sec_x >43 && sec_y <= 70 && sec_y>55 ){
                      for(s=0; s<15 ;s++)
                         {
                              sec_x--;
                              sec_y--;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                    if(sec_x >=43 && sec_x <58 && sec_y<= 55 && sec_y>40 ){
                      for(s=0; s<15 ;s++)
                         {
                             sec_x++;
                              sec_y--;

                              System.out.println("x="+sec_x+"y="+sec_y);
                              repaint();
                              Thread.sleep(1000);
                         }
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("watch interrupted");
        }

    }

    public double movement(double x)
    {
        double a;
        double y;
        a = 225.0-((50.0-x)*(50.0-x));
        System.out.println("x has value "+x);
        System.out.println("a has value "+a);
        y = Math.sqrt(a);
        System.out.println("y has value "+y);
        return y;
    }

    public void paint(Graphics g)
    {
        
        String add= getDocumentBase().toString();
        System.out.println("address="+add);

        String msg1= "12";
        String msg2= "3";
        String msg3= "6";
        String msg4= "9";

        g.drawImage(clk, 0, 0, this);
       // g.drawArc(0,0,100,100,0,360);
        g.drawLine(58,55,(int)sec_x,(int)sec_y);
        g.drawLine(58,55,(int)min_x,(int)min_y);
        g.drawLine(58,55,(int)hr_x,(int)hr_y);
      /*  g.drawString(msg1,46,10);
        g.drawString(msg2,90,50);
        g.drawString(msg3,50,100);
        g.drawString(msg4,5,50);*/

    }

  public void setvalues_sec(int y)
    {
      System.out.println("sec="+y);
       int i;
       int c;
       int t;

       if(y > 0)
       {
           c = y;
           t = c<15?c:15;

           for(i=0 ; i<t ; i++)
           {
               sec_x++;
               sec_y++;
           }
       }
       if(y > 15)
       {

           c=y;
           t = c<30?c:15;

           while(t>15)
               t = t-15;

           for(i=0 ; i<t ; i++)
           {
               sec_x--;
               sec_y++;
           }


       }

       if(y > 30)
       {
           c= y;
           t = c<45?c:15;

           while(t>15)
               t = t-15;

           for(i=0 ; i<t ; i++)
           {
               sec_x--;
               sec_y--;
           }
       }

       if(y>45)
       {
           c = y;
           t = c<60?c:15;

           while(t > 15)
               t=t-15;
           for(i=0 ; i<t ; i++)
           {
               sec_x++;
               sec_y--;
           }
       }

  }

  public void setvalues_min(int y)
    {
       System.out.println("min="+y);
       int i;
       int c;
       int t;

       if(y > 0)
       {
           c = y;
           t = c<15?c:15;

           for(i=0 ; i<t ; i++)
           {
               min_x++;
               min_y++;
           }
       }
       if(y > 15)
       {

           c=y;
           t = c<30?c:15;

           while(t>15)
               t = t-15;

           for(i=0 ; i<t ; i++)
           {
               min_x--;
               min_y++;
           }


       }

       if(y > 30)
       {
           c= y;
           t = c<45?c:15;

           while(t>15)
               t = t-15;

           for(i=0 ; i<t ; i++)
           {
               min_x--;
               min_y--;
           }
       }

       if(y>45)
       {
           c = y;
           t = c<60?c:15;

           while(t > 15)
               t=t-15;
           for(i=0 ; i<t ; i++)
           {
               min_x++;
               min_y--;
           }
       }

  }
  public void setvalues_hr(int y)
    {
      if(hr > 0)
      {
          hr_x = hr_x + 5;
          hr_y = hr_y + 5;
        }
      if(hr > 1)
      {
          hr_x = hr_x + 5;
          hr_y = hr_y + 5;
      }

      if(hr > 2)
      {
          hr_x = hr_x + 5;
          hr_y = hr_y + 5;
      }

      if(hr > 3)
      {
          hr_x = hr_x - 5;
          hr_y = hr_y + 5;
      }

      if(hr > 4)
      {
          hr_x = hr_x - 5;
          hr_y = hr_y + 5;
      }

      if(hr > 5)
      {
          hr_x = hr_x - 5;
          hr_y = hr_y + 5;
      }

      if(hr > 6)
      {
          hr_x = hr_x - 5;
          hr_y = hr_y - 5;
      }

      if(hr > 7)
      {
          hr_x = hr_x - 5;
          hr_y = hr_y - 5;
      }

      if(hr > 8)
      {
          hr_x = hr_x - 5;
          hr_y = hr_y - 5;
      }


      if(hr > 9)
      {
          hr_x = hr_x + 5;
          hr_y = hr_y - 5;
      }

      if(hr > 10)
      {
          hr_x = hr_x + 5;
          hr_y = hr_y - 5;
      }

      if(hr > 11)
      {
          hr_x = hr_x + 5;
          hr_y = hr_y - 5;
      }
  }
}


