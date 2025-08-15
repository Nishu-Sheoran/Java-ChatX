package com.Nishu.chatapp.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.Nishu.chatapp.utils.ConfigReader;

public class Server {
	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers = new ArrayList<>(); // contains all the client sockets
	public Server() throws IOException {
		int PORT= Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server start and waiting for clients to come");
		handleClientRequest();
	}
	
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket=serverSocket.accept(); // HandShaking
			// per client per thread
			ServerWorker serverWorker = new ServerWorker(clientSocket, this); // Creating a new worker/thread
		    workers.add(serverWorker);
			serverWorker.start();
			}
	}
	/* Single client */
	/*
	public Server() throws IOException {
		int PORT= Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server started and waiting for the client connection..");
	    Socket socket=serverSocket.accept(); // HandShaking
	    System.out.println("Client joins the server");
	    InputStream in= socket.getInputStream(); // read bytes from the network
	    byte arr[] = in.readAllBytes();
	    String str = new String(arr); // Bytes convert into String
	    System.out.println("Meassage Received from the client \n"+ str);
	    in.close();
	    socket.close();
	}
	*/

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        Server server = new Server();
	}

}
