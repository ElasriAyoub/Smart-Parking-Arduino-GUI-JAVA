package backend;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DrawnPanel extends JPanel 
{
	private static final long serialVersionUID = 8831595896454044895L;
	protected int value=0;
	protected void setValue(int value)
	{
		this.value = value;
	}
	
	public DrawnPanel()
	{
		this.setBackground( Color.WHITE );
		this.setPreferredSize( new Dimension( 650, 550 ) );	/* BEDDEL FIHADI 3LA WED SIZE DL WINDOW*/
	}
	
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, 200, 300);
    }	
	
}
