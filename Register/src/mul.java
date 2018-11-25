import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;


public class mul {

	JFrame frame;
	Socket client;
	int n=0;
	private JTextField t1;
	private JTextField t2;
	int ev1,br1,yr1,sh1;
	String name,rol,amt;
	String flag="1";
	String abc[]={"1.3-A side Football,2.4×100 relay,3.7 up 7 down ,4.8 puzzle, 5.Badminton,6. Battery, 7.Best Friends Forever, 8.Blind Coding ,9.Blind Fold Cricket , 10.Box-cricket ,11. Candle Lighting ,12.Carrom, 13.Chess, 14.Counter strike,15.Dance (solo/group/staff), 16.Debate,17. Dubsmash,18.FIFA'14,19.Fastest Typing,20.Football Freestyles, 21.Head-Tails, 22.Hoct n Hole (Hockey), 23.Housie, 24.Laser Tag, 25.Latex workshop, 26.Linux workshop, 27.Locks & Keys, 28.Mechatrons, 29.Minute-it-to-win-it , 30.Mock Placement , 31.Mr. & Miss.CESA, 32.NFS, 33.Nail Art, 34.Photomania , 35.Pocket tanks, 36.Robo Rugby, 37.Rubic Cube, 38.Singing (solo/group), 39.Slam, 40.Snaphunt, 41.Table Tennis , 42.Take that Selfie, 43.Technical Quiz , 44.Throw Ball, 45.Throw dice, 46.Tug of War"};
	JCheckBox j1[]=new JCheckBox[46];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mul(Socket c1) {
		client=c1;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().setBackground(Color.ORANGE);
		Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0, 0, sc.width, sc.height);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txt1 = new JTextArea();
		txt1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		txt1.setText("1.3-A side Football\n2.4×100 relay\n3.7 up 7 down \n4.8 puzzle\n5.Badminton\n6. Battery\n7.Best Friends Forever \n8.Blind Coding \n9.Blind Fold Cricket  \n10.Box-cricket \n11.Candle Lighting \n12.Carrom \n13.Chess \n14.Counter strike\n15.Dance (solo/group/staff) \n16.Debate\n17.Dubsmash\n18.FIFA'14\n19.Fastest Typing\n20.Football Freestyles \n21.Head-Tails \n22.Hoct n Hole (Hockey) \n23.Housie \n24.Laser Tag \n25.Latex workshop \n26.Linux workshop \n27.Locks & Keys \n28.Mechatrons \n29.Minute-it-to-win-it  \n30.Mock Placement  \n31.Mr. & Miss.CESA \n32.NFS \n33.Nail Art \n34.Photomania  \n35.Pocket tanks\n36.Robo Rugby \n37.Rubic Cube \n38.Singing (solo/group) \n39.Slam \n40.Snaphunt \n41.Table Tennis  \n42.Take that Selfie \n43.Technical Quiz  \n44.Throw Ball \n45.Throw dice \n46.Tug of War");
		txt1.setBackground(Color.WHITE);
		txt1.setBounds(694, 12, 289, 689);		
		frame.getContentPane().add(txt1);
		
		t1 = new JTextField();
		t1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		t1.setBounds(173, 24, 223, 19);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		
		
		t2 = new JTextField();
		t2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		t2.setBounds(173, 106, 223, 19);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		
	
		
		JLabel l2 = new JLabel("Name of participant:-");
		l2.setBounds(12, 26, 157, 15);
		frame.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("Roll number:-");
		l3.setBounds(53, 108, 116, 15);
		frame.getContentPane().add(l3);
		
		final JComboBox sh = new JComboBox();
		sh.addActionListener(new ActionListener() {
			public void actionPerformed1(ActionEvent e) {
				sh1=sh.getSelectedIndex();
				
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		sh.addItem("I");
		sh.addItem("II");
		sh.setBounds(358, 66, 38, 24);
		frame.getContentPane().add(sh);
		
		final JComboBox br = new JComboBox();
		br.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				br1=br.getSelectedIndex();
				
			}
		});
		br.addItem("COMPUTER");
		br.addItem("ELECTRONICS");
		br.addItem("ELECTRICAL");
		br.addItem("E&TC");
		br.addItem("INSTRUMENTATION");
		br.addItem("IT");
		
		br.setBounds(173, 66, 113, 24);
		frame.getContentPane().add(br);
		
		final JComboBox yr = new JComboBox();
		yr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yr1=yr.getSelectedIndex();
		
			}
		});
		yr.addItem("FE");
		yr.addItem("SE");
		yr.addItem("TE");
		yr.addItem("BE");
		yr.setBounds(298, 66, 48, 24);
		frame.getContentPane().add(yr);
		
		JLabel l4 = new JLabel("Class:-");
		l4.setBounds(80, 71, 70, 15);
		frame.getContentPane().add(l4);
		
		
		
		JLabel label = new JLabel("-A PROJECT BY ADITYA KULKARNI BE COMP II SHIFT");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 10));
		label.setBounds(47, 600, 369, 47);
		frame.getContentPane().add(label);
		
		JCheckBox c1 = new JCheckBox("");
		c1.setBounds(665, 12, 21, 15);
		frame.getContentPane().add(c1);
		j1[0]=c1;
		
		JCheckBox c2 = new JCheckBox("");
		c2.setBounds(665, 26, 21, 17);
		frame.getContentPane().add(c2);
		j1[1]=c2;
		
		JCheckBox c3 = new JCheckBox("");
		c3.setBounds(665, 41, 21, 15);
		frame.getContentPane().add(c3);
		j1[2]=c3;
		
		JCheckBox c4 = new JCheckBox("");
		c4.setBounds(665, 55, 21, 19);
		frame.getContentPane().add(c4);
		j1[3]=c4;
		JCheckBox c5 = new JCheckBox("");
		c5.setBounds(665, 75, 21, 15);
		frame.getContentPane().add(c5);
		j1[4]=c5;
		JCheckBox c6 = new JCheckBox("");
		c6.setBounds(665, 89, 21, 15);
		frame.getContentPane().add(c6);
		j1[5]=c6;
		JCheckBox c7 = new JCheckBox("");
		c7.setBounds(665, 104, 21, 15);
		frame.getContentPane().add(c7);
		j1[6]=c7;
		JCheckBox c8 = new JCheckBox("");
		c8.setBounds(665, 120, 21, 15);
		frame.getContentPane().add(c8);
		j1[7]=c8;
		JCheckBox c9 = new JCheckBox("");
		c9.setBounds(665, 134, 21, 15);
		frame.getContentPane().add(c9);
		j1[8]=c9;
		JCheckBox c10 = new JCheckBox("");
		c10.setBounds(665, 148, 21, 15);
		frame.getContentPane().add(c10);
		j1[9]=c10;
		JCheckBox c11 = new JCheckBox("");
		c11.setBounds(665, 164, 21, 15);
		frame.getContentPane().add(c11);
		j1[10]=c11;
		JCheckBox c12 = new JCheckBox("");
		c12.setBounds(665, 179, 21, 15);
		frame.getContentPane().add(c12);
		j1[11]=c12;
		JCheckBox c13 = new JCheckBox("");
		c13.setBounds(665, 193, 21, 15);
		frame.getContentPane().add(c13);
		j1[12]=c13;
		JCheckBox c14 = new JCheckBox("");
		c14.setBounds(665, 206, 21, 15);
		frame.getContentPane().add(c14);
		j1[13]=c14;
		JCheckBox c15 = new JCheckBox("");
		c15.setBounds(665, 220, 21, 15);
		frame.getContentPane().add(c15);
		j1[14]=c15;
		JCheckBox c16 = new JCheckBox("");
		c16.setBounds(665, 236, 21, 15);
		frame.getContentPane().add(c16);
		j1[15]=c16;
		JCheckBox c17 = new JCheckBox("");
		c17.setBounds(665, 250, 21, 15);
		frame.getContentPane().add(c17);
		j1[16]=c17;
		JCheckBox c18 = new JCheckBox("");
		c18.setBounds(665, 266, 21, 15);
		frame.getContentPane().add(c18);
		j1[17]=c18;
		JCheckBox c19 = new JCheckBox("");
		c19.setBounds(665, 281, 21, 15);
		frame.getContentPane().add(c19);
		j1[18]=c19;
		JCheckBox c20 = new JCheckBox("");
		c20.setBounds(665, 298, 21, 15);
		frame.getContentPane().add(c20);
		j1[19]=c20;
		JCheckBox c21 = new JCheckBox("");
		c21.setBounds(665, 311, 21, 15);
		frame.getContentPane().add(c21);
		j1[20]=c21;
		JCheckBox c22 = new JCheckBox("");
		c22.setBounds(665, 327, 21, 15);
		frame.getContentPane().add(c22);
		j1[21]=c22;
		JCheckBox c23 = new JCheckBox("");
		c23.setBounds(665, 341, 21, 15);
		frame.getContentPane().add(c23);
		j1[22]=c23;
		JCheckBox c24 = new JCheckBox("");
		c24.setBounds(665, 358, 21, 15);
		frame.getContentPane().add(c24);
		j1[23]=c24;
		JCheckBox c25 = new JCheckBox("");
		c25.setBounds(665, 372, 21, 15);
		frame.getContentPane().add(c25);
		j1[24]=c25;
		JCheckBox c26 = new JCheckBox("");
		c26.setBounds(665, 389, 21, 15);
		frame.getContentPane().add(c26);
		j1[25]=c26;
		JCheckBox c27 = new JCheckBox("");
		c27.setBounds(665, 403, 21, 15);
		frame.getContentPane().add(c27);
		j1[26]=c27;
		JCheckBox c28 = new JCheckBox("");
		c28.setBounds(665, 419, 21, 15);
		frame.getContentPane().add(c28);
		j1[27]=c28;
		JCheckBox c29 = new JCheckBox("");
		c29.setBounds(665, 433, 21, 15);
		frame.getContentPane().add(c29);
		j1[28]=c29;
		JCheckBox c30 = new JCheckBox("");
		c30.setBounds(665, 450, 21, 15);
		frame.getContentPane().add(c30);
		j1[29]=c30;
		JCheckBox c31 = new JCheckBox("");
		c31.setBounds(665, 465, 21, 15);
		frame.getContentPane().add(c31);
		j1[30]=c31;
		JCheckBox c32 = new JCheckBox("");
		c32.setBounds(665, 480, 21, 15);
		frame.getContentPane().add(c32);
		j1[31]=c32;
		JCheckBox c33 = new JCheckBox("");
		c33.setBounds(665, 494, 21, 15);
		frame.getContentPane().add(c33);
		j1[32]=c33;
		JCheckBox c34 = new JCheckBox("");
		c34.setBounds(665, 509, 21, 15);
		frame.getContentPane().add(c34);
		j1[33]=c34;
		JCheckBox c35 = new JCheckBox("");
		c35.setBounds(665, 523, 21, 15);
		frame.getContentPane().add(c35);
		j1[34]=c35;
		JCheckBox c36 = new JCheckBox("");
		c36.setBounds(665, 538, 21, 15);
		frame.getContentPane().add(c36);
		j1[35]=c36;
		JCheckBox c37 = new JCheckBox("");
		c37.setBounds(665, 554, 21, 15);
		frame.getContentPane().add(c37);
		j1[36]=c37;
		JCheckBox c38 = new JCheckBox("");
		c38.setBounds(665, 567, 21, 15);
		frame.getContentPane().add(c38);
		j1[37]=c38;
		JCheckBox c39 = new JCheckBox("");
		c39.setBounds(665, 582, 21, 15);
		frame.getContentPane().add(c39);
		j1[38]=c39;
		JCheckBox c40 = new JCheckBox("");
		c40.setBounds(665, 596, 21, 15);
		frame.getContentPane().add(c40);
		j1[39]=c40;
		JCheckBox c41 = new JCheckBox("");
		c41.setBounds(665, 611, 21, 15);
		frame.getContentPane().add(c41);
		j1[40]=c41;
		JCheckBox c42 = new JCheckBox("");
		c42.setBounds(665, 628, 21, 15);
		frame.getContentPane().add(c42);
		j1[41]=c42;
		JCheckBox c43 = new JCheckBox("");
		c43.setBounds(665, 644, 21, 15);
		frame.getContentPane().add(c43);
		j1[42]=c43;
		JCheckBox c44 = new JCheckBox("");
		c44.setBounds(665, 660, 21, 15);
		frame.getContentPane().add(c44);
		j1[43]=c44;
		JCheckBox c45 = new JCheckBox("");
		c45.setBounds(665, 674, 21, 15);
		frame.getContentPane().add(c45);
		j1[44]=c45;
		JCheckBox c46 = new JCheckBox("");
		c46.setBounds(665, 686, 21, 15);
		frame.getContentPane().add(c46);
		j1[45]=c46;
		JButton b1 = new JButton("SUBMIT");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					if(client==null){
						JOptionPane.showMessageDialog(null, "Connect to server first!!");
					}
					else{
					name=t1.getText();
					amt="0";
					rol=t2.getText();
					sh1=sh.getSelectedIndex();
					if(name.equals("")||amt.equals("")||rol.equals("")){
						JOptionPane.showMessageDialog(null, "You left out some Fields!!");
					}
					else{
					StringBuilder sb=new StringBuilder(rol);
					if(sb.charAt(0)=='0'){
						sb.deleteCharAt(0);
						rol=sb.toString();
					}
					
					JTextField password = new JPasswordField();
					Object[] ob={password};
					int a=JOptionPane.showConfirmDialog(null, ob,"Enter the Secret code:-",JOptionPane.OK_CANCEL_OPTION);
					if(password.getText().equals("123qwe")){
					int y=JOptionPane.showConfirmDialog(null, "Are you sure,you want to send the Data?");
					if(y==0){
					
					PrintWriter pout=new PrintWriter(client.getOutputStream(),true);
					for(int i=0;i<46;i++){
						if(j1[i].isSelected()){
							n++;
						}
					}
						
						
						int i=0;
						while(n>0){
							if(j1[i].isSelected()){
					pout.println(n+"");		
					pout.println(i+"");
					pout.println(name);
					pout.println(br1+"");
					pout.println(yr1+"");
					pout.println(sh1+"");
					pout.println(rol+"");
					pout.println(amt);
					pout.println(flag);
					n--;
							}
							i++;
						
					}
					yr.setSelectedIndex(0);
					br.setSelectedIndex(0);
					sh.setSelectedIndex(0);
					t1.setText("");
					t2.setText("");
					for(int i1=0;i1<46;i1++){
						j1[i1].setSelected(false);
					}
					
				}			
					}
					else{
						JOptionPane.showMessageDialog(null, "Wrong Password try again..");
					}
					}
					}
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		b1.setBounds(1141, 650, 117, 25);
		frame.getContentPane().add(b1);
		
	}
}
