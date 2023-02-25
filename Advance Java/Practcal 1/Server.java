import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String... args) throws Exception {
        ServerSocket srs = new ServerSocket(6765);
        Socket skt = new Socket();
        while (true) {
            skt = srs.accept();
            DataInputStream dis = new DataInputStream(skt.getInputStream());
            DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
            Mythread m = new Mythread(skt, dis, dos);
            m.start();
        }
    }
}

class Mythread extends Thread {
    DataInputStream dis;
    DataOutputStream dos;
    Socket skt;

    Mythread(Socket skt, DataInputStream dis, DataOutputStream dos) {
        this.skt = skt;
        this.dis = dis;
        this.dos = dos;
    }

    public void run() {
        String recieved;
        String tosend;
        while (true) {
            try {
                dos.writeUTF("INPUT STRING : ");
                recieved = (String) dis.readUTF();
                if (recieved.equals("EXIT")) {
                    this.skt.close();
                    break;
                }
                int i = recieved.length();
                dos.writeUTF("" + i);
            } catch (Exception e) {
            }
        }
    }
}
