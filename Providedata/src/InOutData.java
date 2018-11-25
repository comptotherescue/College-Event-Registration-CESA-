

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class InOutData {

	public InOutData(){
		try {
			ServerSocket ser=new ServerSocket(8899);
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
				while(true){
				String ev1,br1,yr1,sh1,rol,name,flag,con="1";
				int no=0,am;
				BufferedReader br=new BufferedReader(new InputStreamReader(so1.getInputStream()));
			
				ev1=br.readLine();
				name=br.readLine();
				br1=br.readLine();
				yr1=br.readLine();
				sh1=br.readLine();
				rol=br.readLine();
				
			
			
				System.out.println(ev1+"\t"+name+"\t"+br1+"\t"+yr1+"\t"+sh1+"\t"+rol);
				String a=so1.getInetAddress().toString();
				StringBuilder sb=new StringBuilder(a);
				sb.deleteCharAt(0);
				a=sb.toString();
				Socket s=new Socket(a,8900);
				PrintWriter pout=new PrintWriter(s.getOutputStream(),true);
				
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
	        	if(no==0){
	        		pout.println("2");
	        	}
	        	else if(no==1){
	        		String amt1 = null;
	        		cursor1=col.find(where);
	        		while(cursor1.hasNext()) {
	        			DBObject obj=(DBObject)cursor1.next();
	        			String amt=(String)obj.get("Amount");
	        			amt1=(String) obj.get("Flag");
	        			pout.println(amt1);
	        			String amt2=br.readLine();
	        			if(amt2.equals("0")){
	        			BasicDBObject newDocument = new BasicDBObject();
	        			newDocument.append("Name", name).append("Roll", rol).append("Event",ev1).append("Amount",amt).append("Flag", amt2);
	        			col.update(where, newDocument);
	        			pout.println("0");
	        			}
	        			else{
	        				pout.println("1");
	        			}
	        			
	        		}
	        		
	        	}
	        	else{
	        		con="2";
	        	}
				
				
				
				pout.println(con);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
