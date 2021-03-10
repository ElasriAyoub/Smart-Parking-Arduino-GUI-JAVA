package backend;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frontend.Informations;

public class Console extends JFrame implements SerialPortEventListener, MouseListener, WindowListener, ComponentListener 
{
	private static final long serialVersionUID = 6206875506469171849L;
	
	SerialPort serialPort;
	
	private JLabel ensak;
	
	private JPanel      mainPanel;
	private JPanel		buttonsPanel;
	private JPanel		centerPanel;
	private JPanel		titlesPanel;
	
	private JButton  button1;
	private JButton  button2;

	private DrawnPanel buttonsinPanel;
	
	private InputStream    serialIn;
	private BufferedReader serialReader;

	public Console()
	{
		super("Smart Parking");
		ensak = new JLabel();
		ensak.setIcon(new ImageIcon("LOGOS.png"));
		ensak.setBounds(0, 0, 50, 50);
      
		mainPanel    = new JPanel(new BorderLayout());
		buttonsPanel = new JPanel(new GridLayout(1, 2, 0, 0));
		titlesPanel  = new JPanel(new GridLayout(1, 4, 0, 0));
		centerPanel  = new JPanel(new GridLayout(1, 3, 0, 0));

		buttonsinPanel     = new ButtonsPanel();
		
		button1 = new JButton("Informations");
		button2 = new JButton("Disconnect");
		buttonsPanel.add(button1);
		
		buttonsPanel.add(new MLabel("Smart Parking"));
		buttonsPanel.add(button2);
		
		titlesPanel.add(ensak);
		titlesPanel.add(new MLabel("Project: Smart Parking"));
		centerPanel.add(buttonsinPanel);	
		
		mainPanel.add(titlesPanel,  BorderLayout.PAGE_START);
		mainPanel.add(centerPanel,  BorderLayout.CENTER);
		mainPanel.add(buttonsPanel, BorderLayout.PAGE_END);
		
		button1.addMouseListener(this);
		button2.addMouseListener(this);
		this.addComponentListener(this);
		this.addWindowListener(this);
		this.addMouseListener(this);
		
		this.addComponentListener(this);
		this.addWindowListener(this);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setContentPane(mainPanel);
		this.pack();
		this.setResizable(false);
	}
	
	
	public void begin() throws Exception
	{
		this.setVisible(true);
		CommPortIdentifier port = CommPortIdentifier.getPortIdentifier("COM3"); 
        CommPort commPort = port.open(this.getClass().getName(),2000);
        serialPort = (SerialPort) commPort;
        serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
		serialIn=serialPort.getInputStream();
		//serialOut=serialPort.getOutputStream();
		serialReader = new BufferedReader( new InputStreamReader(serialIn) );
        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);
	}

	
	public void serialEvent(SerialPortEvent e) 
	{
		JavaLog.debug("serialEvent: "+e.toString());
		try {
			String line = serialReader.readLine();
			JavaLog.debug("READ from serial: "+line);
			if(line.startsWith("SS:") && line.length()==14){
				visualization( line );
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	private void visualization(String line)
	{
		String[] values = line.split(":");
		int buttons       = Integer.parseInt(values[1],16);
		buttonsinPanel.setValue(buttons);
		buttonsinPanel.repaint();
	}
	
	
	 public void windowOpened(WindowEvent e)       {}
	 public void windowClosed(WindowEvent e)       {}
	 public void windowIconified(WindowEvent e)    {}
	 public void windowDeiconified(WindowEvent e)  {}
	 public void windowActivated(WindowEvent e)    {}
	 public void windowDeactivated(WindowEvent e)  {}
	 public void windowClosing(WindowEvent e)      {
		JavaLog.debug("windowClosing: "+e);
		if(e.getComponent()==this){
			JavaLog.debug("Closing port");
			System.exit(1);
		}
	}
	 public void componentShown(ComponentEvent e)  {}
	 public void componentHidden(ComponentEvent e) {}
	 public void componentResized(ComponentEvent e){}
	 public void componentMoved(ComponentEvent e)  {}
	 public void mouseClicked(MouseEvent e)    {}
		public void mousePressed(MouseEvent e)  {}
		public void mouseEntered(MouseEvent e)  {}
		public void mouseExited(MouseEvent e)   {}
		public void mouseReleased(MouseEvent e) {
		JavaLog.debug("mouseReleased: "+e);
		
		if(e.getComponent() == button1){
			JavaLog.debug("Button 1 released");
			new Informations();   
		}
		if(e.getComponent() == button2){
			JavaLog.debug("Button 2 released");
			System.exit(0);
		}
	}
}
