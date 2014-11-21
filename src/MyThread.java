import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MyThread implements Runnable {
	private JEditorPane editorPane;
	private JTextField txtUrl;
	private JTextArea txtrHeader;
	private Thread thread;
	private String threadName;
	private JTextArea tt;
	
	public MyThread(String threadName,JEditorPane editorPane,JTextField txtUrl,JTextArea txtrHeader,JTextArea tt){
		this.threadName = threadName;
		this.editorPane = editorPane;
		this.txtUrl = txtUrl;
		this.txtrHeader = txtrHeader;
		this.tt = tt;
	}
	
	public void run() {
		getLink();
		getHeader();
	}
	
	public void start ()
	   {
		  tt.append(threadName+" Creating Thread" +  "\n" );
	      if (thread == null)
	      {
	         thread = new Thread (this, threadName);
	         thread.start ();
	         tt.append(thread.getName()+" Starting Thread" +  "\n" );
	      }
	   }
	public void getLink(){
		try{
 		 	thread.sleep(1000);
 		 }
 		 catch(InterruptedException e){}
		 tt.append(thread.getName()+" Get Web" +"\n" );
		 try {
			 editorPane.setPage(txtUrl.getText());
		 }
		 catch (IOException e) {
			 editorPane.setContentType("text/html");
		   	 editorPane.setText("<html>Could not load "+txtUrl.getText()+" </html>");
		 }
		 
		
	}
	public void getHeader(){
		tt.append(thread.getName()+" Get Header" +"\n" );
		try{
 		 	thread.sleep(1000);
 		 }
 		 catch(InterruptedException e){}
		 try {
	            URLConnection conn = new URL(txtUrl.getText()).openConnection();
	            Map<String, List<String>> map = conn.getHeaderFields();
	            txtrHeader.append("Header for URL: "+txtUrl.getText()+ "\n");

	            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
	            	txtrHeader.append(entry.getKey() + " : " + entry.getValue()+"\n");
	            }
	            List<String> contentLength = map.get("Content-Length");
	 
	            if (contentLength == null) {
	            	txtrHeader.append("'Content-Length' doesn't present in Header!");
	            } else {
	                for (String header : contentLength) {
	                	txtrHeader.append("Content-Lenght: " + header);
	                }
	            }
	 
	        } catch (Exception e) {
	        	txtrHeader.append("Could not load header from "+txtUrl.getText());
	        }	
	}
}
