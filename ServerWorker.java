package com.Nishu.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

// thread==worker
// worker needs a job to perform
// for job we give runnable
// Once job is created by runnable so write the job logic inside a run function
// Assign a job to thread/Worker

public class ServerWorker extends Thread{
	 private Socket clientSocket;
	 private InputStream in;
	 private OutputStream out;
	 private Server server;
	 public ServerWorker(Socket clientSocket, Server server) throws IOException{
		 this.server=server;
		 this.clientSocket=clientSocket;
		 in=clientSocket.getInputStream(); // Client Data read
		 out= clientSocket.getOutputStream(); // Client Data write
	     System.out.println("New Client comes");
	 }
	 
	@Override
	public void run() {
		// read data from the client and broadcast the data to all
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
	    String line;
	    try {
	    while(true) {
	    	
				line=br.readLine(); // needs \n
				System.out.println("Line read..."+line);
				if(line.equalsIgnoreCase("quit")) {
					break; // Client chat end
				}
				// out.write(line.getBytes()); // Client send
		        // Broadcast to all
				for(ServerWorker serverWorker :server.workers) {
					line=line+"\n";
					serverWorker.out.write(line.getBytes());
				}
	    } 
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
	    }
	    finally {
	    	try {
	    	if(br!=null) {
	    		br.close();
	    	}
	    	if(in!=null) {
	    		in.close();
	    	}
	    	if(out!=null) {
	    		out.close();
	    	}
	    	if(clientSocket!=null) {
	    		clientSocket.close();
	    	}
	    	}catch(Exception ex) {
	    		ex.printStackTrace();
	    	}
	    }
		
	}
}