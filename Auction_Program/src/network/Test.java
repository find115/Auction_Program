package network;

import java.net.InetAddress;
import java.net.Socket;

public class Test {
	public static void main(String[] args) {
		String address = "10.50.201.64";
		FileIo file = new FileIo();
		file.fileWriter_ServerAddress(address);
		System.out.println("¿Ï·á");
//		Client_Function function  = new Client_Function();
//		InetAddress inet = null;
//		int port = 50000;
//		Socket socket = null;
//		try {
//			inet = InetAddress.getByName("10.50.201.64");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		socket = function.socket_Creation(inet, port);
//		function = function.refresh_Client(socket);
	}
}
