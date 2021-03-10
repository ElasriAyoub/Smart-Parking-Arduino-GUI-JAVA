package frontend;
import backend.JavaLog;
import gnu.io.CommPortIdentifier;

import java.awt.EventQueue;
import java.util.Enumeration;

public class SmartParking 
{
	public static void main(String arg[]) throws Exception
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					Authentification window = new Authentification();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		JavaLog.debug("Ports found:");
		@SuppressWarnings("unchecked")
		Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();
		
		while(ports.hasMoreElements())
		{
			CommPortIdentifier port = ports.nextElement(); 
			JavaLog.debug("\tPORT: "+port.getName());
		}
		
		JavaLog.debug( "Starting console..." );
	 }		
}