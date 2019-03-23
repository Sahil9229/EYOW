import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.text.BadLocationException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Decrpt {

	private JFrame frmDecryption;
	private JTextField textField;
	private JTextField textField_1;

	JTextArea textArea = new JTextArea();
	JTextArea textArea_1 = new JTextArea();
	private JFileChooser fileChooser=new JFileChooser();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Decrpt window = new Decrpt();
					window.frmDecryption.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Decrpt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDecryption = new JFrame();
		frmDecryption.setTitle("Decryption");
		frmDecryption.setBounds(100, 100, 533, 576);
		frmDecryption.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDecryption.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(143, 32, 223, 20);
		frmDecryption.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Open");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*int result=*/fileChooser.showOpenDialog(null);
				  //  if(result==JFileChooser.APPROVE_OPTION)
				 //   {
				    	File SelectedFile=fileChooser.getSelectedFile();
				    	textField.setText(SelectedFile.getPath());
				  //  }
				 try{
				    FileReader fr=new FileReader(SelectedFile);
				    BufferedReader br=new BufferedReader(fr);
				    textArea.read(br,null);
				    br.close();
				 }catch(IOException e){ e.printStackTrace(); }
			}
		});
		btnNewButton.setBounds(388, 31, 89, 23);
		frmDecryption.getContentPane().add(btnNewButton);
		
		
		textArea.setBounds(10, 225, 61, 20);
		frmDecryption.getContentPane().add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(352, 195, 125, 20);
		frmDecryption.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter the key");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(253, 198, 89, 14);
		frmDecryption.getContentPane().add(lblNewLabel);
		
		//JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(143, 352, 344, 141);
		frmDecryption.getContentPane().add(textArea_1);
		
		JButton btnNewButton_1 = new JButton("Decrypt");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{ FileWriter fwtemp=new FileWriter("D:\\docs\\VI sem\\project\\Dtest1.txt"); //TEMP FILE
			    BufferedWriter bwtemp=new BufferedWriter(fwtemp);
			    bwtemp.write(textArea.getText());
			  bwtemp.close();
//----------------------------------------------FirstTranspositionDecrypt------------------------------------------------------------//				

 //*********************************************Storing in Matrix form from a file***************************************************//

			  FileReader fr=new FileReader("D:\\docs\\VI sem\\project\\Dtest1.txt");
			    int count=0,k,row;
			    k=fr.read();
			    while(k!=-1){  count++; System.out.println(k + " " + count); k=fr.read();}
			 System.out.println("number of char " + count);   
			 fr.close();
			 row=count/5;
			 if(count%5!=0)row=row+1;
			    
				 
				 char mat[][]=new char[row][5];  
				 
			
			
				 
				
			
			FileReader fr2=new FileReader("D:\\docs\\VI sem\\project\\Dtest1.txt");
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
			for(i=0;i<5;i++)
			   {
				for(j=0;j<row;j++)
				  {
					if(arg<count)
						{
						 System.out.println("value of i :" + i + " value of j :" + j + " value of arg :" + arg); 
						 mat[j][i]=(char)ar[arg];
						 arg++;
						}
					else
					  { mat[j][i]='$'; }
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
			  
			  
			  
			  
			  
//**********************************************************************************************************************************//

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

//************************************************************************use of key****************************************************************//			
			 char mat2[][]=new char[row][5];  //ENCRYPTED MATRIX I
				int key[]=new int[5];//{3,0,4,1,2};
				 int ind[]={0,1,2,3,4};
				 char c[]=new char[5];
			 for(i=0;i<5;i++)
				 key[i]=Integer.parseInt(textField_1.getText(i,1))-1;
			int tmp,tmp1;
			 for(i=0;i<5;i++)
				 for(j=i+1;j<5;j++)
				  {
					 if(key[i]>key[j])
						 {
						  tmp=key[i];
						  tmp1=ind[i];
						  key[i]=key[j];
						  ind[i]=ind[j];
						  key[j]=tmp;
						  ind[j]=tmp1;
						 
						 }
				  }
			 for(i=0;i<5;i++)
                        System.out.print(key[i]+1 + " ");
			 System.out.println();          
			 for(i=0;i<5;i++)
			 System.out.print(ind[i]+1 + " ");	 
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
			           c2[ind[j]]=c[j]; 
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
			 System.out.print("Values in mat2");	
			System.out.println();
			for(i=0;i<row;i++)
			   {
				for(j=0;j<5;j++)
				  {
					System.out.print(" " + mat2[i][j]);
				  }
				System.out.println();
		  }
			 
			
//*************************************************************************************************************************************************//			
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//			
			
//**************************************************************Writing m2 Row wise in a file***********************************************//
			
			 FileWriter fw=new FileWriter("D:\\docs\\VI sem\\project\\Dtemp.txt"); //TEMP FILE
			    BufferedWriter bw=new BufferedWriter(fw); 
			    for(i=0;i<row;i++)
			      {
			    	 for(j=0;j<5;j++)
			           { bw.write(mat2[i][j]); }
			    	// System.out.println();
			      }	 
			    bw.close();		
			
//******************************************************************************************************************************************/			
			
			
//-----------------------------------------------------------------------------------------------------------------------------------//			  

System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				
//----------------------------------------------------------------------Second Transposition Decryption---------------------------------------------//

FileReader frII=new FileReader("D:\\docs\\VI sem\\project\\Dtemp.txt");
int countII=0,kII,rowII;
kII=frII.read();
while(kII!=-1){  countII++; System.out.println(kII + " " + countII); kII=frII.read();}
System.out.println("number of char " + countII);   
frII.close();
rowII=countII/5;
if(countII%5!=0)rowII=rowII+1;

 
 char matII[][]=new char[rowII][5];  
 


 


FileReader fr2II=new FileReader("D:\\docs\\VI sem\\project\\Dtemp.txt");
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
for(iII=0;iII<5;iII++)
{
for(jII=0;jII<rowII;jII++)
  {
	if(argII<countII)
		{
		 System.out.println("value of i :" + iII + " value of j :" + jII + " value of arg :" + argII); 
		 matII[jII][iII]=(char)arII[argII];
		 argII++;
		}
	else
	  { matII[jII][iII]='$'; }
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







//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//

//************************************************************************use of key****************************************************************/			

char mat2II[][]=new char[rowII][5];  //ENCRYPTED MATRIX I
int keyII[]=new int[5];//{3,0,4,1,2};
 int indII[]={0,1,2,3,4};
 char cII[]=new char[5];
for(iII=0;iII<5;iII++)
 keyII[iII]=Integer.parseInt(textField_1.getText(iII,1))-1;
int tmpII,tmp1II;
for(iII=0;iII<5;iII++)
 for(jII=iII+1;jII<5;jII++)
  {
	 if(keyII[iII]>keyII[jII])
		 {
		  tmpII=keyII[iII];
		  tmp1II=indII[iII];
		  keyII[iII]=keyII[jII];
		  indII[iII]=indII[jII];
		  keyII[jII]=tmpII;
		  indII[jII]=tmp1II;
		 
		 }
  }
for(iII=0;iII<5;iII++)
        System.out.print(keyII[iII]+1 + " ");
System.out.println();          
//for(iII=0;iII<5;i++)
//System.out.print(indII[iII]+1 + " ");	 

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
       c2II[indII[jII]]=cII[jII]; 
 for(jII=0;jII<5;jII++)
 System.out.println("Value in c2 " + c2II[jII]);

 
   
	 lII=0;
	for(jII=0;jII<5;jII++)
 	 { 
		System.out.println("value of i :" + iII + " value of j :" + jII + " value of l :" + lII);
		if(c2II[lII]=='$'){ mat2II[iII][jII]=' '; }
		else{ mat2II[iII][jII]=c2II[lII]; }
	  lII++;
 	 }
   
}	
System.out.print("Values in mat2II");	
System.out.println();
for(iII=0;iII<rowII;iII++)
{
for(jII=0;jII<5;jII++)
  {
	System.out.print(" " + mat2II[iII][jII]);
  }
System.out.println();
}


//*************************************************************************************************************************************************/			
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX//			

//**************************************************************Writing m2 Row wise in a file***********************************************/

FileWriter fwII=new FileWriter("D:\\docs\\VI sem\\project\\Dtemp2.txt"); //TEMP FILE
BufferedWriter bwII=new BufferedWriter(fwII); 
for(iII=0;iII<row;iII++)
  {
	 for(jII=0;jII<5;jII++)
       { bwII.write(mat2II[iII][jII]); }
	// System.out.println();
  }	 
bwII.close();		

//******************************************************************************************************************************************/			


//*****************************************reading file in JTextArea***********************************************************/

FileReader frtemp2II=new FileReader("D:\\docs\\VI sem\\project\\Dtemp2.txt");
BufferedReader tempbrII=new BufferedReader(frtemp2II);
textArea_1.setText(null);
textArea_1.read(tempbrII,null);
tempbrII.close();
//******************************************************************************************************************************/

//-------------------------------------------------------------------------------------------------------------------------------------------------//
				
				}catch(IOException e){ e.printStackTrace(); }
			//	catch(){}
                catch (NumberFormatException e) { JOptionPane.showMessageDialog(null, "Please enter your key");
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadLocationException e) {JOptionPane.showMessageDialog(null, "Select a valid File");
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_1.setBounds(317, 226, 160, 23);
		frmDecryption.getContentPane().add(btnNewButton_1);
		
		
	
		
		JButton btnNewButton_2 = new JButton("Save Your Content");
		btnNewButton_2.setBounds(279, 260, 198, 23);
		frmDecryption.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(78, 70, 399, 114);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmDecryption.getContentPane().add(scrollPane);
		
		
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		scrollPane_1.setBounds(78, 326, 399, 164);
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frmDecryption.getContentPane().add(scrollPane_1);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 517, 21);
		frmDecryption.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Help");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try{	
					Runtime rt=Runtime.getRuntime();
					Process p=rt.exec("notepad " + "C:\\Users\\sahil\\workspace\\EYOW\\Res\\readme.txt");
				   }catch(Exception ex){ex.printStackTrace();}
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\sahil\\workspace\\EYOW\\Res\\cluster-mapping.jpg"));
		lblNewLabel_1.setBounds(0, 0, 517, 517);
		frmDecryption.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" EYOW v1.0 - DECRYPTION                                                      Running..");
		lblNewLabel_2.setFont(new Font("SimSun", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(0, 517, 517, 20);
		frmDecryption.getContentPane().add(lblNewLabel_2);
		}}