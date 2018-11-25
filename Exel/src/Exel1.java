import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;

import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import javax.swing.JProgressBar;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;


public class Exel1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exel1 window = new Exel1();
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
	public Exel1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATED FILE SUCCESSULLY!!");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(65, 98, 276, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("-A PROJECT BY ADITYA KULKARNI BE COMP II SHIFT");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 10));
		label.setBounds(12, 213, 305, 47);
		frame.getContentPane().add(label);
		
	
		
		
		try {
			int i;
			String[] br1={"COMPUTER","ELECTRONICS","ELECTRICAL","E&TC","INSTRUMENTATION","IT"};
			String[] yr1={"FE","SE","TE","BE"};
			String[] sh1={"I","II"};
			String[] ev1={"Minute-it-to-win-it ","7 up 7 down ","Counter strike","NFS","FIFA'14","Pocket tanks","Snaphunt","Best Friends Forever","Rubic Cube","Nail Art","Battery","Candle Lighting ","Throw dice","Head-Tails","Locks & Keys","Dance (solo/group/staff)", "Singing (solo/group)","Photomania ","Take that Selfie" ,"Mr. & Miss. CESA","8 puzzle","Housie","Dubsmash","Mechatrons" ,"Robo Rugby","Technical Quiz ","Mock Placement ","Fastest Typing" ,"Blind Coding ","Laser Tag", "Linux workshop","Latex workshop","Box-cricket ","Blind Fold Cricket ","3-A side Football", "Football Freestyles","Table Tennis ","Throw Ball","Carrom","Chess","Tug of War","Badminton","Hoct n Hole (Hockey)","4×100 relay","Slam","Debate"};
			Arrays.sort(ev1);
			String fileName="cesa.xls";
		    WritableWorkbook workbook;
			workbook = Workbook.createWorkbook(new File(fileName));
		   WritableSheet sheet=workbook.createSheet("Sheet1", 0);
		    Label l1=new Label(0,0,"Name");
		    sheet.addCell(l1);
		    Label l2=new Label(1,0,"Branch");
		    sheet.addCell(l2);
		    Label l3=new Label(2,0,"Year");
		    sheet.addCell(l3);
		    Label l4=new Label(3,0,"Shift");
		    sheet.addCell(l4);
		    Label l5=new Label(4,0,"Roll");
		    sheet.addCell(l5);
		    Label l6=new Label(5,0,"Event");
		    sheet.addCell(l6);
		    Label l7=new Label(6,0,"Amount");
		    sheet.addCell(l7);
		    MongoClient mon=new MongoClient();
		    DB db=mon.getDB("cesa");
		    
		    int a,b,c,d;
		    a=b=c=d=0;
		    i=1;
		    while(a<46&&b<6&&c<4&&d<2){
		    	DBCollection col=db.getCollection("ak"+a+b+c+d);
		    	DBCursor cursor1=col.find();
		    	
		    	while(cursor1.hasNext()) {
		    		DBObject obj=(DBObject)cursor1.next();
        			String name=(String)obj.get("Name");
		    		 Label l8=new Label(0,i,name);
		 		    sheet.addCell(l8);
		 		     
		 		   Label l9=new Label(1,i,br1[b]);
		 		    sheet.addCell(l9);
		 		    
		 		   Label l10=new Label(2,i,yr1[c]);
		 		    sheet.addCell(l10);
		 		    
		 		   Label l11=new Label(3,i,sh1[d]);
		 		    sheet.addCell(l11);
		 		    
		 		 
		 		    String roll=(String)obj.get("Roll"); 
		 		   Label l12=new Label(4,i,roll);
		 		    sheet.addCell(l12);
		 		    
		 		   String ev=(String)obj.get("Event");
		 		   int e=Integer.parseInt(ev);
		 		   Label l13=new Label(5,i,ev1[e]);
		 		    sheet.addCell(l13);
		 		    
		 		   String amt=(String)obj.get("Amount"); 
		 		   Label l14=new Label(6,i,amt);
		 		    sheet.addCell(l14);
		 		    i++;
	        	}
		    	if(d%2==0){
		    		d=1;
		    	}
		    	else{
		    		d=0;
		    		c++;
		    		
		    		if(c%4==0){
		    			c=0;
		    			b++;
		    			if(b%6==0){
		    			b=0;
		    			a++;
		    			}
		    			
		    			
		    		}
		    	}
		    }
		    mon.close();
		    workbook.write();
		    workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(WriteException e1){
			e1.printStackTrace();
		}
	
	}
}
