package backend;
import java.awt.Color;
import java.awt.Graphics;

public class ButtonsPanel extends DrawnPanel
{
	private static final long serialVersionUID = -7494831192161401876L;
	
	@Override
    public void paintComponent(Graphics g) 
	{
    	super.paintComponent(g);
        System.out.println(value);
        boolean b1 = (value&0x00F)!=0;
        g.setColor( b1?Color.red:Color.green );
        g.fillRect(90, 75-20, 110, 180);
        g.setColor( Color.BLACK );
        g.drawRect(90, 75-20, 110, 180);
        
        boolean b2 = (value&0x0F0)!=0;
        g.setColor( b2?Color.red:Color.green );
        g.fillRect(270, 75-20, 110, 180);
        g.setColor( Color.BLACK );
        g.drawRect(270, 75-20, 110, 180);

        boolean b3 = (value&0xF00)!=0;
        g.setColor( b3?Color.red:Color.green );
        g.fillRect(450, 75-20, 110, 180);
        g.setColor( Color.BLACK );
        g.drawRect(450, 75-20, 110, 180);
        
        g.setColor(Color.black);
        g.fillRect(0, 235, 700, 115);

        g.setColor(Color.yellow);
        g.fillRect(65, 288, 25, 10);
        g.setColor(Color.yellow);
        g.fillRect(115, 288, 25, 10);
        g.setColor(Color.yellow);
        g.fillRect(165, 288, 25, 10);
        g.setColor(Color.yellow);
        g.fillRect(215, 288, 25, 10);
        g.setColor(Color.yellow);
        g.fillRect(265, 288, 25, 10);
        g.setColor(Color.yellow);
        g.fillRect(315, 288, 25, 10);
        g.setColor(Color.yellow);
        g.fillRect(365, 288, 25, 10);
        g.setColor(Color.yellow);
        g.fillRect(415, 288, 25, 10);
        g.setColor(Color.yellow);
        g.fillRect(465, 288, 25, 10);
        g.setColor(Color.yellow);
        g.fillRect(515, 288, 25, 10);
        g.setColor(Color.yellow);
        g.fillRect(565, 288, 25, 10);
     
        boolean b4 = (value&0xF000)!=0;
        g.setColor( b4?Color.red:Color.green );
        g.fillRect(90, 350, 110, 180);
        g.setColor( Color.BLACK );
        g.drawRect(90, 350, 110, 180);
        
        boolean b5 = (value&0xF0000)!=0;
        g.setColor( b5?Color.red:Color.green );
        g.fillRect(270, 350, 110, 180);
        g.setColor( Color.BLACK );
        g.drawRect(270, 350, 110, 180);

        boolean b6 = (value&0xF00000)!=0;
        g.setColor( b6?Color.red:Color.green );
        g.fillRect(450, 350, 110, 180);
        g.setColor( Color.BLACK );
        g.drawRect(450, 350, 110, 180);

        boolean s1 = (value&0xF000000)!=0;
        g.setColor( s1?Color.green:Color.red );
        g.fillOval(600, 370, 20, 20);
        g.setColor( Color.BLACK );
        g.drawOval(600, 370, 20, 20);
        
        g.setColor( s1?Color.black:Color.gray );
        g.fillRect(605, 235, 10, 115);

        boolean s2 = (value&0xF0000000)!=0;
        g.setColor( s2?Color.green:Color.red );
        g.fillOval(35, 200, 20, 20);
        g.setColor( Color.BLACK );
        g.drawOval(35, 200, 20, 20);

        g.setColor( s2?Color.black:Color.gray );
        g.fillRect(40, 235, 10, 115);      
    }	
}
