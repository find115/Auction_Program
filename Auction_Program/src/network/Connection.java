package network;
import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection extends Thread{
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;

	private int isConnection = 99;

	public Socket getSocket() {
		return socket;
	}

	public ObjectOutputStream getOut() {
		return out;
	}

	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}

	public ObjectInputStream getIn() {
		return in;
	}

	public void setIn(ObjectInputStream in) {
		this.in = in;
	}

	public Connection() {
//		if(socket.isConnected()) {
//			try {
//				out.writeObject(isConnection);
//				out.flush();
//				Thread.sleep(5000);
//			} catch (Exception e1) {
//				try {
//					System.out.println("connecntion 쓰레드 에러");
//					socket.close();
//				}catch(Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		}
	}
	

		
}
