import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Scanner sc = new Scanner(System.in);

    public static void main(String... args) throws Exception {
        Socket skt = new Socket("localhost", 6765);
        DataInputStream dis = new DataInputStream(skt.getInputStream());
        DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
        while (true) {
            String recieved;
            String tosend;
            System.out.println(dis.readUTF());
            System.out.print(">> ");
            tosend = sc.nextLine();
            dos.writeUTF(tosend);
            if (tosend.equals("EXIT")) {
                System.out.println("CONNECTION IS GETTING CLOSED	");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                skt.close();
                System.out.println("CONNECTION TERMINATED	");
                break;
            }
            recieved = dis.readUTF();
            System.out.println(recieved);
        }
        dis.close();
        dos.close();
    }
}
