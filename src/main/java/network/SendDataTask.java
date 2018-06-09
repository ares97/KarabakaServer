package network;

import constans.Const;
import server.GameMaster;
import server.UsersInformation;

import java.io.IOException;
import java.net.*;

/**
 * Created by karol on 09.06.18.
 */
public class SendDataTask implements Runnable {
    private GameMaster gameMaster;
    private UsersInformation usersInformation;

    public SendDataTask(UsersInformation usersInformation) {
        this.usersInformation = usersInformation;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                DatagramSocket ds = new DatagramSocket();
                String datagram = gameMaster.getDatagram();
                InetAddress ip1 = InetAddress.getByName(usersInformation.getUserIp(0));
                InetAddress ip2 = InetAddress.getByName(usersInformation.getUserIp(1));
                DatagramPacket dp = new DatagramPacket(datagram.getBytes(), datagram.length(), ip1, Const.SENDING_PORT);
                ds.send(dp);
                ds.close();
                DatagramSocket ds2 = new DatagramSocket();
                dp =  new DatagramPacket(datagram.getBytes(), datagram.length(), ip2, Const.SENDING_PORT);
                ds2.send(dp);
                ds2.close();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void init()
    {
        gameMaster = GameMaster.getInstance();
    }

}
