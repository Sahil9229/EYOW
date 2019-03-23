import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.MouseMotionAdapter;


public class First {

	private JFrame frmEyowV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First window = new First();
					window.frmEyowV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public First() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEyowV = new JFrame();
		frmEyowV.setTitle("EYOW v1.0");
		frmEyowV.setBounds(100, 100, 746, 408);
		frmEyowV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEyowV.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Encrypt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try{	
				frmEyowV.dispose();
				guiproject genc=new guiproject();
				genc.main(null);
			}catch(Exception e){ e.printStackTrace();}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\sahil\\workspace\\EYOW\\Res\\Apps-preferences-desktop-cryptography-icon (2).png"));
		btnNewButton.setBounds(33, 81, 148, 69);
		frmEyowV.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Decrypt");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmEyowV.dispose();
				Decrpt dpct=new Decrpt();
				dpct.main(null);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\sahil\\workspace\\EYOW\\Res\\Actions-dialog-ok-apply-icon (1).png"));
		btnNewButton_1.setBounds(33, 181, 148, 69);
		frmEyowV.getContentPane().add(btnNewButton_1);
		 
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 730, 21);
		frmEyowV.getContentPane().add(menuBar); 
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		
		
		mntmHelp.addMouseListener(new MouseAdapter() {
		//	@Override
			public void mouseClicked(MouseEvent arg0) {
			try{	
				Runtime rt=Runtime.getRuntime();
				Process p=rt.exec("notepad " + "C:\\Users\\sahil\\workspace\\EYOW\\Res\\readme.txt");
			   }catch(Exception e){e.printStackTrace();}
			}
		});
		menuBar.add(mntmHelp);
		
		JLabel lblNewLabel_1 = new JLabel(" EYOW v1.0                                                                                                    Running..");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(0, 353, 730, 16);
		frmEyowV.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sahil\\workspace\\EYOW\\Res\\tech_banner.jpg"));
		lblNewLabel.setBounds(0, 0, 730, 357);
		frmEyowV.getContentPane().add(lblNewLabel);
		
		
		
		
	}
}