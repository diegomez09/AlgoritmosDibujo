
package algoritmos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import javax.swing.JFrame;

public class Algoritmos extends JFrame{
    
    private int x0,y0,x1,y1,seleccion;    
    private BufferedImage buffer;    
    //private Graphics graPixel;
    
    Algoritmos(int x0, int y0, int x1, int y1, int seleccion){
        super("DFGG 17310120");
        this.x0 = x0;
        this.y0 = y0;        
        this.x1= x1;
        this.y1 = y1;
        this.seleccion = seleccion;
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(1000, 10, 600, 600);
        this.setVisible(true); 
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        //graPixel = (Graphics2D) buffer.createGraphics();        
    }
     
    
    public void putPixel(int x, int y, Color c){
        buffer.setRGB(0,0,c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);        
    }
    
    @Override
    public void paint(Graphics g){
        putPixel(50, 50, Color.RED);        
        //line(x0, y0, x1, y1, Color.RED);
        Color c = Color.RED;
        int x, y, diferencia_equis, diferencia_ye, p, incE, incNE, pasoRespecto, paso,i;
        if(seleccion == 1){        
        diferencia_equis = (x1 - x0);
        diferencia_ye = (y1 - y0);         
         if (diferencia_ye < 0) {
          diferencia_ye = -diferencia_ye; paso = -1;
        }
        else
        paso = 1;
        if (diferencia_equis < 0) { 
        diferencia_equis = -diferencia_equis; pasoRespecto = -1;
        }
        else
        pasoRespecto = 1;
        x = x0;
        y = y0;
        line( x0, y0, x0, y0, c);         
        if(diferencia_equis>diferencia_ye){
        p = 2*diferencia_ye - diferencia_equis;
        incE = 2*diferencia_ye;
        incNE = 2*(diferencia_ye-diferencia_equis);
        while (x != x1){
        x = x + pasoRespecto;
        if (p < 0){
        p = p + incE;
        }
        else {
        y = y + paso;
        p = p + incNE;
        }
        line( x, y, x, y,c);
        }
        }
        else{
        p = 2*diferencia_equis - diferencia_ye;
        incE = 2*diferencia_equis;
        incNE = 2*(diferencia_equis-diferencia_ye);
        while (y != y1){
        y = y + paso;
        if (p < 0){
        p = p + incE;
        }
        else {
        x = x + pasoRespecto;
        p = p + incNE;
        }
        line( x, y, x, y, c);
        }
            }
        }else{
             diferencia_equis = (x1 - x0);  
    diferencia_ye = (y1 - y0);  
    if(diferencia_equis>=diferencia_ye)  
           {  
        paso = diferencia_equis;  
    }  
    else  
           {  
        paso = diferencia_ye;  
    }  
    diferencia_equis = diferencia_equis/paso;  
    diferencia_ye = diferencia_ye/paso;  
    x = x0;  
    y = y0;  
    i = 1;  
    while(i<= paso)  
    {  
        putPixel(x, y, c);  
        x += diferencia_equis;  
        y += diferencia_ye;  
        i=i+1;  
    }  
        }
    }
    
    public void line (int x0, int y0, int x1, int y1, Color c){        
        int diferencia_equis = x1 - x0;
        int diferencia_ye = y1 - y0;        
        putPixel(x0, y0, c);        
        if(Math.abs(diferencia_equis) > Math.abs(diferencia_ye)){ 
            float m = (float) diferencia_ye / (float) diferencia_equis;            
            float b = y0 - m*x0;
            if(diferencia_equis < 0)
                diferencia_equis = -1;
            else
                diferencia_equis = 1;
            while(x0 != x1){
                x0 += diferencia_equis;
                y0 = Math.round(m*x0 + b);
                putPixel(x0, y0, c);
            }
        }
        else{
            if(diferencia_ye != 0){
                float m = (float) diferencia_equis / (float) diferencia_ye;                
                float b = x0 - m*y0;
                if(diferencia_ye < 0)
                    diferencia_ye = -1;
                else
                    diferencia_ye = 1;
                while(y0 != y1){
                    y0 += diferencia_ye;
                    x0 = Math.round(m*y0 + b);
                    putPixel(x0, y0, c);
                }
            }
        }
    }

    public static void main(String[] args) {
        int x0,y0,x1,y1,seleccion;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Ingrese x1:");
        x0 = myObj.nextInt();        
        System.out.println("Ingrese y1:");
        y0 = myObj.nextInt();
        System.out.println("Ingrese x2:");
        x1 = myObj.nextInt();
        System.out.println("Ingrese y2:");
        y1 = myObj.nextInt();    
        System.out.println("1) Bresenham\n2) DDA");
        seleccion = myObj.nextInt();    
        Algoritmos al = new Algoritmos(x0,y0,x1,y1,seleccion);                           
    }                  
}
