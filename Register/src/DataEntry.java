import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class DataEntry implements Runnable{

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	int ev1,br1,yr1,sh1;
	String name,rol,amt,ip=null;
	private JTextField t3;
	String flag="1";
	Socket client=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataEntry window = new DataEntry();
					Thread t=new Thread(window);
					t.start();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataEntry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.DARK_GRAY);
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		frame.getContentPane().setBackground(Color.ORANGE);
		Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0, 0, sc.width, sc.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		t1 = new JTextField();
		t1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		t1.setBounds(605, 141, 223, 19);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		
		
		t2 = new JTextField();
		t2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		t2.setBounds(605, 234, 223, 19);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		
		t3 = new JTextField();
		t3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		t3.setText("0");
		t3.setBounds(605, 276, 223, 19);
		frame.getContentPane().add(t3);
		t3.setColumns(10);
		
		String[] events={"Minute-it-to-win-it ","7 up 7 down ","Counter strike","NFS","FIFA'14","Pocket tanks","Snaphunt","Best Friends Forever","Rubic Cube","Nail Art","Battery","Candle Lighting ","Throw dice","Head-Tails","Locks & Keys","Dance (solo/group/staff)", "Singing (solo/group)","Photomania ","Take that Selfie" ,"Mr. & Miss. CESA","8 puzzle","Housie","Dubsmash","Mechatrons" ,"Robo Rugby","Technical Quiz ","Mock Placement ","Fastest Typing" ,"Blind Coding ","Laser Tag", "Linux workshop","Latex workshop","Box-cricket ","Blind Fold Cricket ","3-A side Football", "Football Freestyles","Table Tennis ","Throw Ball","Carrom","Chess","Tug of War","Badminton","Hoct n Hole (Hockey)","4×100 relay","Slam","Debate"};
		Arrays.sort(events);
		final JComboBox ev = new JComboBox(events);
		ev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ev1=ev.getSelectedIndex();
			
			}
		});
		
		 
						
		ev.setBounds(605, 81, 223, 24);
		frame.getContentPane().add(ev);
		
		JLabel l1 = new JLabel("Event name:-");
		l1.setBounds(484, 86, 103, 15);
		frame.getContentPane().add(l1);
		
		JLabel l2 = new JLabel("Name of participant:-");
		l2.setBounds(432, 143, 157, 15);
		frame.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("Roll number:-");
		l3.setBounds(473, 236, 116, 15);
		frame.getContentPane().add(l3);
		
		final JComboBox sh = new JComboBox();
		sh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sh1=sh.getSelectedIndex();
				
			}
		});
		sh.addItem("I");
		sh.addItem("II");
		sh.setBounds(790, 190, 38, 24);
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
		
		br.setBounds(605, 190, 113, 24);
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
		yr.setBounds(730, 190, 48, 24);
		frame.getContentPane().add(yr);
		
		JLabel l4 = new JLabel("Class:-");
		l4.setBounds(519, 195, 70, 15);
		frame.getContentPane().add(l4);
		
		JButton b1 = new JButton("SUBMIT");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					if(ip==null){
						JOptionPane.showMessageDialog(null, "Connect to server first!!");
					}
					else{
					name=t1.getText();
					amt=t3.getText();
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
					pout.println("1");
					pout.println(ev1+"");
					pout.println(name);
					pout.println(br1+"");
					pout.println(yr1+"");
					pout.println(sh1+"");
					pout.println(rol+"");
					pout.println(amt);
					pout.println(flag);
					ev.setSelectedIndex(0);
					yr.setSelectedIndex(0);
					br.setSelectedIndex(0);
					sh.setSelectedIndex(0);
					t1.setText("");
					t2.setText("");
					t3.setText("");
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
		b1.setBounds(657, 329, 117, 25);
		frame.getContentPane().add(b1);
		
		JLabel l5 = new JLabel("Amount:-");
		l5.setBounds(503, 278, 70, 15);
		frame.getContentPane().add(l5);
		
		JLabel label = new JLabel("-A PROJECT BY ADITYA KULKARNI BE COMP II SHIFT");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 10));
		label.setBounds(47, 600, 369, 47);
		frame.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("Multiple Entries");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(client==null){
					JOptionPane.showMessageDialog(null, "Please connect to server first!!");
				}
				else{
				mul window = new mul(client);
				window.frame.setVisible(true);
				}
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(0, 23, 178, 25);
		frame.getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem ser1 = new JMenuItem("Connect to server");
		ser1.setBackground(Color.ORANGE);
		ser1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ip=JOptionPane.showInputDialog("Enter the IP:-");
				try {
					client = new Socket(ip,8891);
					JOptionPane.showMessageDialog(null, "Connected!!");
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(null,e);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		menuBar.add(ser1);
		
		
		
		
	}
	
	public void run(){
		try {
			
			ServerSocket socket=new ServerSocket(8800);
			while(true){
				Socket so=socket.accept();
		
				BufferedReader br=new BufferedReader(new InputStreamReader(so.getInputStream()));
				String s=br.readLine();

				int s1=Integer.parseInt(s);
				System.out.println(s);
				if(s1>0){
				
				JOptionPane.showMessageDialog(null, "This is more than once he/she is participating amount should not be 0!! For Events:-"+br.readLine());
				}
				else{
				JOptionPane.showMessageDialog(null, "Got that Entry!!");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
