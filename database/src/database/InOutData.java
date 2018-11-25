package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class InOutData {

	public InOutData(){
		try {
			ServerSocket ser=new ServerSocket(8891);
			while(true){
			Socket so=ser.accept();
			new Thread(new accp(so)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		InOutData da=new InOutData();
		
	}
	public class accp implements Runnable{
		Socket so1;
		public accp(Socket so){
			so1=so;
		}
		public void run(){
			try {
				String ev1,br1,yr1,sh1,rol,name,amt,flag,n;
				int no=0,am,n1,con=0;
				String[] abc={"Minute-it-to-win-it ","7 up 7 down ","Counter strike","NFS","FIFA'14","Pocket tanks","Snaphunt","Best Friends Forever","Rubic Cube","Nail Art","Battery","Candle Lighting ","Throw dice","Head-Tails","Locks & Keys","Dance (solo/group/staff)", "Singing (solo/group)","Photomania ","Take that Selfie" ,"Mr. & Miss. CESA","8 puzzle","Housie","Dubsmash","Mechatrons" ,"Robo Rugby","Technical Quiz ","Mock Placement ","Fastest Typing" ,"Blind Coding ","Laser Tag", "Linux workshop","Latex workshop","Box-cricket ","Blind Fold Cricket ","3-A side Football", "Football Freestyles","Table Tennis ","Throw Ball","Carrom","Chess","Tug of War","Badminton","Hoct n Hole (Hockey)","4×100 relay","Slam","Debate"};
				Arrays.sort(abc);
				String a1 ="";
				BufferedReader br=new BufferedReader(new InputStreamReader(so1.getInputStream()));
				while(true){
					con=0;
					no=0;
				do{
				n=br.readLine();
				ev1=br.readLine();
				name=br.readLine();
				br1=br.readLine();
				yr1=br.readLine();
				sh1=br.readLine();
				rol=br.readLine();
				amt=br.readLine();
				flag=br.readLine();
				
	
				am=Integer.parseInt(amt);
				System.out.println(ev1+"\t"+name+"\t"+br1+"\t"+yr1+"\t"+sh1+"\t"+rol+"\t"+amt+"\t"+flag);
				n1=Integer.parseInt(n);
				n1--;
				MongoClient mongoc = new MongoClient( "localhost" , 27017 );
				DB db=mongoc.getDB("cesa");
				DBCollection col=db.getCollection("ak"+ev1+br1+yr1+sh1);
				BasicDBObject where=new BasicDBObject();
				where.put("Name", name);
				where.put("Roll", rol);
				DBCursor cursor1 = col.find(where);
	        	while(cursor1.hasNext()) {
	        	    System.out.println(cursor1.next());
	        	    no=1;
	        	}
	        	if(no==0||(no==0&&am==0)){
	        		BasicDBObject ob=new BasicDBObject().append("Name", name).append("Roll", rol).append("Event",ev1).append("Amount", amt).append("Flag", flag);
	        		col.insert(ob);
	        	}
	        	else if(no==1&&am>0){
	        		String amt1 = null;
	        		cursor1=col.find(where);
	        		while(cursor1.hasNext()) {
	        			DBObject obj=(DBObject)cursor1.next();
	        			amt1=(String) obj.get("Amount");
	        			int anew=Integer.parseInt(amt1);
	        			anew=anew+Integer.parseInt(amt);
	        			amt1=anew+"";
	        			BasicDBObject newDocument = new BasicDBObject();
	        			newDocument.append("Name", name).append("Roll", rol).append("Event",ev1).append("Amount", amt1).append("Flag", flag);
	        			col.update(where, newDocument);
	        			no=0;
	        		}
	        		
	        	}
	        	else if(no==1&&am==0){
	        		con++;
	        		int p=Integer.parseInt(ev1);
	        		a1=a1+" "+abc[p];
	        		no=0;
	        	}
				}while(n1>0);
				System.out.println("The value of n1 is:-"+n);
				String a=so1.getInetAddress().toString();
				StringBuilder sb=new StringBuilder(a);
				sb.deleteCharAt(0);
				a=sb.toString();
				Socket s=new Socket(a,8800);
				
				PrintWriter pout=new PrintWriter(s.getOutputStream(),true);
				if(con==0){
				pout.println(con+"");
				}
				else{
					pout.println(con+"");
					pout.println(a1);
					a1="";
					con=0;
				}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
