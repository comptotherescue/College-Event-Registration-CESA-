import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import javax.swing.JTextArea;


public class DataEntry implements Runnable{

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JButton b1,b2;
	private JTextArea a1;
	int ev1,br1,yr1,sh1,n=-1;;
	String name,rol,ip=null;
	Socket client=null;
	ServerSocket socket=null;
	int c=0;
	PrintWriter pout;
	
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
					if(client==null){
						JOptionPane.showMessageDialog(null, "Connect to server first!!");
					}
					else{
					name=t1.getText();
					rol=t2.getText();
					yr1=yr.getSelectedIndex();
					br1=br.getSelectedIndex();
					sh1=sh.getSelectedIndex();
					ev1=ev.getSelectedIndex();
					if(name.equals("")||rol.equals("")){
						JOptionPane.showMessageDialog(null, "You left out some Fields!!");
					}
					else{
					StringBuilder sb=new StringBuilder(rol);
					if(sb.charAt(0)=='0'){
						sb.deleteCharAt(0);
						rol=sb.toString();
					}
					
					
					
					int y=JOptionPane.showConfirmDialog(null, "Are you sure,you want to send the Data?");
					if(y==0){
					PrintWriter pout=new PrintWriter(client.getOutputStream(),true);
					pout.println(ev1+"");
					pout.println(name);
					pout.println(br1+"");
					pout.println(yr1+"");
					pout.println(sh1+"");
					pout.println(rol+"");
					
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
		b1.setBounds(661, 287, 117, 25);
		frame.getContentPane().add(b1);
		
		a1 = new JTextArea();
		a1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		a1.setBounds(548, 385, 324, 68);
		frame.getContentPane().add(a1);
		a1.setEditable(false);
		
		JButton b2 = new JButton("Clear");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				if(client==null){
					JOptionPane.showMessageDialog(null, "Connect to server first..");
				}
				else{
					c=1;
					ev.setSelectedIndex(0);
					yr.setSelectedIndex(0);
					br.setSelectedIndex(0);
					sh.setSelectedIndex(0);
					t1.setText("");
					t2.setText("");
					rol="";
					a1.setText("");
					
					if(n==0){
					pout.println("0");
					}
					else{
					pout.println("1");	
					}
					n=-1;
				}
			}
		});
		b2.setBounds(884, 403, 117, 25);
		frame.getContentPane().add(b2);
		
		JLabel lblNewLabel = new JLabel("-A PROJECT BY ADITYA KULKARNI BE COMP II SHIFT");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel.setBounds(36, 603, 369, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNextEntry = new JButton("Next Entry");
		btnNextEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c=0;
				pout.println("2");
				a1.setText("");
				ev.setSelectedIndex(0);
				yr.setSelectedIndex(0);
				br.setSelectedIndex(0);
				sh.setSelectedIndex(0);
				t1.setText("");
				t2.setText("");
				rol="";
			}
		});
		btnNextEntry.setBounds(884, 270, 117, 25);
		frame.getContentPane().add(btnNextEntry);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem ser1 = new JMenuItem("Connect to server");
		ser1.setBackground(Color.ORANGE);
		ser1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ip=JOptionPane.showInputDialog("Enter the IP:-");
				try {
					client = new Socket(ip,8899);
					JOptionPane.showMessageDialog(null, "Connected!");
					pout=new PrintWriter(client.getOutputStream(),true);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		menuBar.add(ser1);
		
		
		
		
	}
	
	public void run(){
		try {
			
			socket=new ServerSocket(8900);
			while(true){
				Socket so=socket.accept();
				
				BufferedReader br=new BufferedReader(new InputStreamReader(so.getInputStream()));
				String s=br.readLine();
				
				if(s.equals("1")){
					n=0;
				a1.setText("This user is a valid user!!");
				}
				else{
				a1.setText("There is no such Entry for this event!!");
				}
				
				String s2=br.readLine();
				if(s2.equals("0")){
					JOptionPane.showMessageDialog(null, "Removed successfully!!");
					a1.setText("");
				}
				else{
					JOptionPane.showMessageDialog(null, "Try another Entry");
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
