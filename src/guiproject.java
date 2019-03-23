import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.filechooser.FileFilter;

import javax.swing.JTextField;

import java.io.*;

//import java.io.*;
//import java.io.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.SwingConstants;

import java.io.*;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class guiproject {
  
	private JFrame frmEncryption;
	private JTextField textField;
	private JTextField textField_1;
    private JFileChooser fileChooser=new JFileChooser();
    private JFileChooser fs=new JFileChooser();
    JTextArea textArea = new JTextArea();
    JTextArea textArea_1 = new JTextArea();
    /**
	 * Launch the application.
	 */
    public class FileTypeFilter extends FileFilter {
        private String extension;
        private String description;
     
        public FileTypeFilter(String extension, String description) {
            this.extension = extension;
            this.description = description;
        }
        public boolean accept(File file) {
            if (file.isDirectory()) {
                return true;
            }
            return file.getName().endsWith(extension);
        }
     
        public String getDescription() {
            return description + String.format(" (*%s)", extension);
        }
    }
        public static void main(String[] args) {
		//JFileChooser fileChooser=new JfileChooser();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiproject window = new guiproject();
					window.frmEncryption.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guiproject() {
		  initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEncryption = new JFrame();
		frmEncryption.setFont(new Font("Impact", Font.PLAIN, 12));
		frmEncryption.setTitle("Encryption");
		frmEncryption.setBounds(100, 100, 882, 512);
		frmEncryption.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEncryption.getContentPane().setLayout(null);
		textArea.setBounds(10, -52, 492, 399);
		frmEncryption.getContentPane().add(textArea);
		JButton btnNewButton_1 = new JButton("open");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			 
				//fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				/*int result=*/fileChooser.showOpenDialog(null);
			  //  if(result==JFileChooser.APPROVE_OPTION)
			 //   {
			    	File SelectedFile=fileChooser.getSelectedFile();
			    	textField_1.setText(SelectedFile.getPath());
			  //  }
			 try{
			    FileReader fr=new FileReader(SelectedFile);
			    BufferedReader br=new BufferedReader(fr);
			    textArea.read(br,null);
			    br.close();
			 }catch(IOException e){ e.printStackTrace(); }
			
			}
		});
		btnNewButton_1.setBounds(738, 27, 89, 23);
		frmEncryption.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Encrypt");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\sahil\\workspace\\EYOW\\Res\\Button-Ok-icon.png"));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setForeground(new Color(139, 0, 139));
		btnNewButton.setFont(new Font("Papyrus", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "THis was the message i always wanted to give you but the text has been written in the file...");
				try{ FileWriter fwtemp=new FileWriter("D:\\docs\\VI sem\\project\\test1.txt"); //TEMP FILE
				    BufferedWriter bwtemp=new BufferedWriter(fwtemp);
				    bwtemp.write(textArea.getText());
				  bwtemp.close();
				//------------------------------------------------First Tranposition-----------------------------------------------------------------//			

					
				//*********************************************storing in matrix from a file*********************************************************//			
							
							FileReader fr=new FileReader("D:\\docs\\VI sem\\project\\test1.txt");
						    int count=0,k,row;
						    k=fr.read();
						    while(k!=-1){  count++; System.out.println(k + " " + count); k=fr.read();}
						 System.out.println("number of char " + count);   
						 fr.close();
						 row=count/5;
						 if(count%5!=0)row=row+1;
						    
							 
							 char mat[][]=new char[row][5];  
							 
						
						
							 
							
						
						FileReader fr2=new FileReader("D:\\docs\\VI sem\\project\\test1.txt");
						k=fr2.read();
						int ar[]=new int[count]; 
						int i=-1,j,arg=0;
						while(k!=-1)
						{ 
							i++;
							ar[i]=k;
							System.out.println("vakue of k 2nd time:" + k + " value of i " + i + " Element inserted " + ar[i]);   k=fr2.read(); 
					    }
					 for(i=0;i<count;i++)
						 System.out.println("Element of array" + ar[i]);
						System.out.println(row);
						for(i=0;i<row;i++)
						   {
							for(j=0;j<5;j++)
							  {
								if(arg<count)
									{
									 System.out.println("value of i :" + i + " value of j :" + j + " value of arg :" + arg); 
									 mat[i][j]=(char)ar[arg];
									 arg++;
									}
								else
								  { mat[i][j]='$'; }
							  }
						   }
						System.out.println();
						for(i=0;i<row;i++)
							   {
								for(j=0;j<5;j++)
								  {
									System.out.print(" " + mat[i][j]);
								  }
								System.out.println();
						    }
						fr2.close();

						//***********************************************************************************************************************************************//
						
						
						//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
						
						
						
						//************************************************************************use of key****************************************************************//	
				           
						 char mat2[][]=new char[row][5];  //ENCRYPTED MATRIX I
						int key[]=new int[5];//{3,0,4,1,2};
						// int ind[]={0,1,2,3,4};
						 char c[]=new char[5];
					 for(i=0;i<5;i++)
						 key[i]=Integer.parseInt(textField.getText(i,1))-1;
					
						 
						 
						 
						 for(i=0;i<row;i++)
					   {	 
						int l=0;
						for(j=0;j<5;j++)
						 { 
					     
					    		c[l]=mat[i][j];
					          l++;
						
						 }
					         char c2[]=new char[5]; 
					         for(j=0;j<5;j++)
					           c2[key[j]]=c[j]; 
					     for(j=0;j<5;j++)
					     System.out.println("Value in c2 " + c2[j]);
					    
					     
						   
					    	 l=0;
							for(j=0;j<5;j++)
						 	 { 
								System.out.println("value of i :" + i + " value of j :" + j + " value of l :" + l);
								mat2[i][j]=c2[l]; 
							  l++;
						 	 }
						   
					  }	
					 	
					System.out.println();
					for(i=0;i<row;i++)
					   {
						for(j=0;j<5;j++)
						  {
							System.out.print(" " + mat2[i][j]);
						  }
						System.out.println();
				  }
						
					
					//*******************************************************************************************************************************//	
						

					//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
					
					
					
					//********************************************************************changing rows into columns*****************************//
					
					     char mat3[][]=new char[5][row];  //ENCRYPTED MATRIX II
					     for(i=0;i<5;i++)
					    	 for(j=0;j<row;j++)
					    	 { mat3[i][j]=mat2[j][i]; }
					     for(i=0;i<5;i++)
					      {
					    	 for(j=0;j<row;j++)
					           { System.out.print(mat3[i][j] + " "); }
					    	 System.out.println();
					      }	 
					//****************************************************************************************************************************//
					
					
					 //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
					     
					 
					//********************************************************inserting encrypted text in file***********************************//      
						
					   FileWriter fw=new FileWriter("D:\\docs\\VI sem\\project\\temp.txt"); //TEMP FILE
					    BufferedWriter bw=new BufferedWriter(fw); 
					    for(i=0;i<5;i++)
					      {
					    	 for(j=0;j<row;j++)
					           { bw.write(mat3[i][j]); }
					    	// System.out.println();
					      }	 
					    bw.close();
					//**************************************************************************************************************************//     
				 
					    
				//------------------------------------------------------------------------------------------------------------------------------//		
				System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				//------------------------------------------------Second Transposition----------------------------------------------------------//
					    FileReader frII=new FileReader("D:\\docs\\VI sem\\project\\temp.txt");
					    int countII=0,kII,rowII;
					    kII=frII.read();
					    while(kII!=-1){  countII++; System.out.println(kII + " " + countII); kII=frII.read();}
					 System.out.println("number of char " + countII);   
					 frII.close();
					 rowII=countII/5;
					 if(countII%5!=0)rowII=rowII+1;
					    
						 
						 char matII[][]=new char[rowII][5];  
						 
					
					
						 
						
					
					FileReader fr2II=new FileReader("D:\\docs\\VI sem\\project\\temp.txt");
					kII=fr2II.read();
					int arII[]=new int[countII]; 
					int iII=-1,jII,argII=0;
					while(kII!=-1)
					{ 
						iII++;
						arII[iII]=kII;
						System.out.println("vakue of k 2nd time:" + kII + " value of i " + iII + " Element inserted " + arII[iII]);   kII=fr2II.read(); 
				    }
				 for(iII=0;iII<countII;iII++)
					 System.out.println("Element of array" + arII[iII]);
					System.out.println(rowII);
					for(iII=0;iII<rowII;iII++)
					   {
						for(jII=0;jII<5;jII++)
						  {
							if(argII<countII)
								{
								 System.out.println("value of i :" + iII + " value of j :" + jII + " value of arg :" + argII); 
								 matII[iII][jII]=(char)arII[argII];
								 argII++;
								}
							else
							  { mat[iII][jII]='$'; }
						  }
					   }
					System.out.println();
					for(iII=0;iII<rowII;iII++)
						   {
							for(jII=0;jII<5;jII++)
							  {
								System.out.print(" " + matII[iII][jII]);
							  }
							System.out.println();
					    }
					fr2II.close();

					//***********************************************************************************************************************************************//
					
					
					//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
					
					
					
					//************************************************************************use of key****************************************************************//	
				       
					 char mat2II[][]=new char[rowII][5];  //ENCRYPTED MATRIX I
					int keyII[]=key;//{3,0,4,1,2};
					// int ind[]={0,1,2,3,4};
					 char cII[]=new char[5];
				   
				for(iII=0;iII<rowII;iII++)
				   {	 
					int lII=0;
					for(jII=0;jII<5;jII++)
					 { 
				     
				    		cII[lII]=matII[iII][jII];
				          lII++;
					
					 }
				         char c2II[]=new char[5]; 
				         for(jII=0;jII<5;jII++)
				           c2II[keyII[jII]]=cII[jII]; 
				     for(jII=0;jII<5;jII++)
				     System.out.println("Value in c2 " + c2II[jII]);
				    
				     
					   
				    	 lII=0;
						for(jII=0;jII<5;jII++)
					 	 { 
							System.out.println("value of i :" + iII + " value of j :" + jII + " value of l :" + lII);
							mat2II[iII][jII]=c2II[lII]; 
						  lII++;
					 	 }
					   
				  }	
				 	
				System.out.println();
				for(iII=0;iII<rowII;iII++)
				   {
					for(jII=0;jII<5;jII++)
					  {
						System.out.print(" " + mat2II[iII][jII]);
					  }
					System.out.println();
				}
					

				//*******************************************************************************************************************************//	
					

				//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//



				//********************************************************************changing rows into columns*****************************//

				     char mat3II[][]=new char[5][rowII];  //ENCRYPTED MATRIX II
				     for(iII=0;iII<5;iII++)
				    	 for(jII=0;jII<rowII;jII++)
				    	 { mat3II[iII][jII]=mat2II[jII][iII]; }
				     for(iII=0;iII<5;iII++)
				      {
				    	 for(jII=0;jII<rowII;jII++)
				           { System.out.print(mat3II[iII][jII] + " "); }
				    	 System.out.println();
				      }	 
				//****************************************************************************************************************************//


				 //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//
				     
				 
				//********************************************************inserting encrypted text in file***********************************//      
					
				   FileWriter fwII=new FileWriter("D:\\docs\\VI sem\\project\\temp2.txt"); //TEMP FILE
				    BufferedWriter bwII=new BufferedWriter(fwII); 
				    for(iII=0;iII<5;iII++)
				      {
				    	 for(jII=0;jII<rowII;jII++)
				           { bwII.write(mat3II[iII][jII]); }
				    	// System.out.println();
				      }	 
				    bwII.close();
				//*******************************************************************************************************************************//
				    
				 //*****************************************reading file in JTextArea***********************************************************//
				    
				    FileReader frtemp2=new FileReader("D:\\docs\\VI sem\\project\\temp2.txt");
				    BufferedReader tempbr=new BufferedReader(frtemp2);
				   textArea_1.setText(null);
				    textArea_1.read(tempbr,null);
				    tempbr.close();
				   
				    //char tempar[]=new char[rowII*5];
				    //i=0;
				    //tempar[i]=(char)frtemp2.read();
				    //while(tempar[i]!=-1)
				      //{
				    	//System.out.print(tempar[i]);  
				         //i++;
				    	//tempar[i]=(char)frtemp2.read();
				    	
				   //   }
				    //String s=new String(tempar);
				    //System.out.print(s);
				    //textField_1.setText(s);
				    //frtemp2.close();
				    
				 //*****************************************************************************************************************************//   
					    
				//------------------------------------------------------------------------------------------------------------------------------//	    
					    
				  
				}
				catch(IOException e){ e.printStackTrace(); }
			//	catch(){}
                catch (NumberFormatException e) {
                	JOptionPane.showMessageDialog(null, "Please enter your key");
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadLocationException e) {
					JOptionPane.showMessageDialog(null, "Select a valid File");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		});
		btnNewButton.setBounds(675, 206, 152, 42);
		frmEncryption.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBackground(new Color(230, 230, 250));
		textField.setBounds(592, 175, 235, 20);
		frmEncryption.getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea_1.setBounds(220, 259, 607, 165);
		frmEncryption.getContentPane().add(textArea_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_1.setBounds(354, 28, 352, 20);
		frmEncryption.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblYourContent = new JLabel("Enter Your Key");
		lblYourContent.setForeground(Color.WHITE);
		lblYourContent.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblYourContent.setBounds(515, 177, 115, 17);
		frmEncryption.getContentPane().add(lblYourContent);
		
		JScrollPane scrollPaneV = new JScrollPane(textArea);
		scrollPaneV.setBounds(220, 61, 607, 103);
		scrollPaneV.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//JScrollPane scrollPane = new JScrollPane(textArea);
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		frmEncryption.getContentPane().add(scrollPaneV);
		
		JScrollPane scrollPane = new JScrollPane(textArea_1);
		scrollPane.setBounds(220, 308, 607, 123);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmEncryption.getContentPane().add(scrollPane);
		
		JButton btnNewButton_2 = new JButton("click to save your content");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				fs.setDialogTitle("Save File");
				//FileFilter f1=
				fs.setFileFilter(new FileTypeFilter(".txt","text file"));
				int result=fs.showSaveDialog(null);
				if(result==JFileChooser.APPROVE_OPTION)
				  {
					File fi=fs.getSelectedFile();
					try
					 {
						FileWriter fw=new FileWriter(fi);
					    fw.write(textArea_1.getText());
					    fw.close();
					 }catch(IOException e){e.printStackTrace();}
					
				  }
			}
		});
		btnNewButton_2.setBounds(619, 259, 208, 31);
		frmEncryption.getContentPane().add(btnNewButton_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 877, 21);
		frmEncryption.getContentPane().add(menuBar); 
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Help");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			//@Override
			public void mouseClicked(MouseEvent e) {
				
				try{	
					Runtime rt=Runtime.getRuntime();
					Process p=rt.exec("notepad " + "C:\\Users\\sahil\\workspace\\EYOW\\Res\\readme.txt");
				   }catch(Exception ex){ex.printStackTrace();}
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\sahil\\workspace\\EYOW\\Res\\WikiLeaks-Logo-Wallpaper.jpg"));
		lblNewLabel_1.setBounds(-21, -49, 1061, 505);
		frmEncryption.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel(" EYOW v1.0 - ENCRYPTION                                                                                                               Running..");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 11));
		lblNewLabel.setBounds(0, 456, 867, 17);
		frmEncryption.getContentPane().add(lblNewLabel);
		
		
		
		}
}