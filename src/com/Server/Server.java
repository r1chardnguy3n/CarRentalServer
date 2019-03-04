package com.Server;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Server extends JFrame {
	
	private JTextField userText;
	private JTextArea serverWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	
	ArrayList<VehicleData> vehicleData;
	
	public static void main(String[] args) {
		
		Server s1 = new Server();
		s1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s1.startServer();
		
	}
	
	//constructor
		public Server(){
			super("Douglas Car Rental Server");
			
			userText = new JTextField();
			userText.setEditable(true);
			userText.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						sendMessage(event.getActionCommand());
						userText.setText("");
					}
				}
			);
			add(userText, BorderLayout.NORTH);
			serverWindow = new JTextArea();
			add(new JScrollPane(serverWindow));
			setSize(500, 500); //Sets the window size
			setVisible(true);
			
			
			serverWindow.setBackground(Color.black);
			serverWindow.setForeground(Color.green);
			
		}
		
		public void startServer(){
			try{
				server = new ServerSocket(6789, 100); //6789 is a dummy port for testing, this can be changed. The 100 is the maximum people waiting to connect.
				while(true){
					try{
						//Trying to connect and have conversation
						waitForConnection();
						setupStreams();
						whileChatting();
					}catch(EOFException eofException){
						showMessage("\n Server ended the connection! ");
					} finally{
						closeConnection(); //Changed the name to something more appropriate
					}
				}
			} catch (IOException ioException){
				ioException.printStackTrace();
			}
		}
		//wait for connection, then display connection information
		private void waitForConnection() throws IOException{
			showMessage(" Server has started. Waiting for client to connect... \n");
			connection = server.accept();
			showMessage(" Now connected to " + connection.getInetAddress().getHostName());
		}
		
		//get stream to send and receive data
		private void setupStreams() throws IOException{
			output = new ObjectOutputStream(connection.getOutputStream());
			output.flush();
			
			input = new ObjectInputStream(connection.getInputStream());
			
			showMessage("\n Streams are now setup \n");
		}
		
		//during the chat conversation
		private void whileChatting() throws IOException{
			
			//database connection
			try {
				//connection to database
				Class.forName("com.mysql.jdbc.Driver");
				String usr = "root";
				String psw = "";
				String url = "jdbc:mysql://localhost:3306/douglas_car_rental_server";
				Connection myConn = DriverManager.getConnection(url, usr, psw);
				
				//statement
				Statement myState = myConn.createStatement();
				
				//Execute SQL query
				ResultSet myResult = myState.executeQuery("select * from vehicle");
				
				//Process results
				//array
				vehicleData = new ArrayList<>();
				while (myResult.next()) {
					String make 	= myResult.getString("Make"		);
					String model 	= myResult.getString("Model"	);
					String year 	= myResult.getString("Year"		);
					String type 	= myResult.getString("Type"	    );
					vehicleData.add(new VehicleData(make,model,year,type));
				}
			}
			catch(Exception exc) {
				exc.printStackTrace();
			}
			
			String message = " Retrieving Database.... \n " ;
			sendMessage(message);
			ableToType(true);
			for(int i = 0; i < vehicleData.size(); i++) {
				sendMessage(vehicleData.get(i).getYear	() 	+ " " +  
							vehicleData.get(i).getMake	() 	+ " " +
							vehicleData.get(i).getModel	() 	+ " : " +
							vehicleData.get(i).getType	() 	+ "\n");
			
			}
			
			do{
				try{
					message = (String) input.readObject();
					showMessage("\n" + message);
				}catch(ClassNotFoundException classNotFoundException){
					showMessage("The user has sent an unknown object!");
				}
			}while(!message.equals("CLIENT - END"));

		}
		
		public void closeConnection(){
			showMessage("\n Closing Connections... \n");
			//ableToType(false);
			try{
				output.close(); //Closes the output path to the client
				input.close(); //Closes the input path to the server, from the client.
				connection.close(); //Closes the connection between you can the client
			}catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
		
		//Send a mesage to the client
		private void sendMessage(String message){
			try{
				output.writeObject(message);
				output.flush();
				showMessage("\nSERVER -" + message);
			}catch(IOException ioException){
				serverWindow.append("\n ERROR: CANNOT SEND MESSAGE, PLEASE RETRY");
			}
		}
		
		//update chatWindow
		private void showMessage(final String text){
			SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						serverWindow.append(text);
					}
				}
			);
		}
		
		
		private void ableToType(final boolean tof){
			SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						userText.setEditable(tof);
					}
				}
			);
		}
		
	
	

}
