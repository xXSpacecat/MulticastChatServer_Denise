import java.net.*;

public class MulticastServer {

    public static void main(String[] args) throws Exception {


        //Deafault portnumber
        int portNumber = 1235;
        if (args.length >= 1) {

            portNumber = Integer.parseInt(args[0]);

        }

        //Create multicastsocket
        MulticastSocket serverMulticastSocket = new MulticastSocket(portNumber);
        System.out.println("MulticastSocket is created at port " + portNumber);

        //Determine the IP
        InetAddress group = InetAddress.getByName("225.4.5.6");

        //getByName - returns IP
        serverMulticastSocket.joinGroup(group);
        System.out.println("JoinGroup method is called...");
        boolean infinite = true;

        while (infinite) {

            byte buf[] = new byte[1024];
            DatagramPacket data = new DatagramPacket(buf, buf.length);
            serverMulticastSocket.receive(data);
            String msg = new String(data.getData()).trim();
            System.out.println("Message recieved from client = "+msg);


        }
        serverMulticastSocket.close();
    }

}
