package frontend;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Informations 
{
	JFrame frmLogin2;
	
	public Informations() 
	{
		frmLogin2 = new JFrame();
		frmLogin2.setTitle("Informations \r\n");
		frmLogin2.setBounds(100, 100, 415, 380);
		frmLogin2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin2.getContentPane().setLayout(null);
		JLabel label1 = new JLabel("Réalisé par :");
		label1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label1.setBounds(10, 10, 100, 14);
		frmLogin2.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("EL HAOUCHI OTMANE");
		label2.setFont(new Font("Tahoma", Font.BOLD , 11));
		label2.setBounds(10, 30, 200, 14);
		frmLogin2.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("EL ASRI AYOUB");
		label3.setFont(new Font("Tahoma", Font.BOLD , 11));
		label3.setBounds(10, 50, 200, 14);
		frmLogin2.getContentPane().add(label3);
		
		JLabel label4 = new JLabel("AIT OMAR OUMAIMA");
		label4.setFont(new Font("Tahoma", Font.BOLD , 11));
		label4.setBounds(10, 70, 200, 14);
		frmLogin2.getContentPane().add(label4);
		
		JLabel label5 = new JLabel("Encadré par :");
		label5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label5.setBounds(290, 10, 100, 14);
		frmLogin2.getContentPane().add(label5);
		
		JLabel label6 = new JLabel("M. MOUMEN ANISS");
		label6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label6.setBounds(290, 30, 200, 14);
		frmLogin2.getContentPane().add(label6);
		
		JLabel label7 = new JLabel("Filière :");
		label7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label7.setBounds(290, 50, 100, 14);
		frmLogin2.getContentPane().add(label7);
		
		JLabel label8 = new JLabel("GENIE ELECTRIQUE");
		label8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label8.setBounds(290, 70, 200, 14);
		frmLogin2.getContentPane().add(label8);
		
		JLabel ensak = new JLabel();
		ensak.setIcon(new ImageIcon("LOGOS.png"));
		ensak.setBounds(130, -30, 300, 300);
		frmLogin2.getContentPane().add(ensak);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 167, 390, 2);
		frmLogin2.getContentPane().add(separator);
		
		JLabel label9 = new JLabel("Descriptif :");
		label9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label9.setBounds(10, 180, 100, 14);
		frmLogin2.getContentPane().add(label9);
		
		JLabel label10 = new JLabel("Réalisation d’un parking intelligent qui détecte les nombre des places");
		label10.setFont(new Font("Tahoma", Font.BOLD , 11));
		label10.setBounds(10, 200, 410, 14);
		frmLogin2.getContentPane().add(label10);
		
		JLabel label11 = new JLabel("en précisant les places vacantes et places occupées dans le Parking.");
		label11.setFont(new Font("Tahoma", Font.BOLD , 11));
		label11.setBounds(10, 215, 400, 14);
		frmLogin2.getContentPane().add(label11);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(10, 235, 390, 2);
		frmLogin2.getContentPane().add(separator2);
		
		JLabel label12 = new JLabel("Objectifs :");
		label12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		label12.setBounds(10, 245, 100, 14);
		frmLogin2.getContentPane().add(label12);
		
		JLabel label13 = new JLabel("1- Détermination de nombre de places vacantes et occupées.");
		label13.setFont(new Font("Tahoma", Font.BOLD , 11));
		label13.setBounds(10, 265, 410, 14);
		frmLogin2.getContentPane().add(label13);
		
		JLabel label14 = new JLabel("2- Ne pas gaspiller de temps dans la recherche d'une place vacante.");
		label14.setFont(new Font("Tahoma", Font.BOLD , 11));
		label14.setBounds(10, 280, 410, 14);
		frmLogin2.getContentPane().add(label14);
		
		JLabel label15 = new JLabel("3- Faciliter l'interaction entre le client et le parking.");
		label15.setFont(new Font("Tahoma", Font.BOLD , 11));
		label15.setBounds(10, 295, 410, 14);
		frmLogin2.getContentPane().add(label15);
		
		JSeparator separator3 = new JSeparator();
		separator3.setBounds(10, 315, 390, 2);
		frmLogin2.getContentPane().add(separator3);
		
		JLabel label16 = new JLabel("S7 - 2020/2021");
		label16.setFont(new Font("Tahoma", Font.BOLD, 13));
		label16.setBounds(150, 330, 200, 14);
		frmLogin2.getContentPane().add(label16);

		frmLogin2.setResizable(false);
		frmLogin2.setVisible(true);
		
	}
}
