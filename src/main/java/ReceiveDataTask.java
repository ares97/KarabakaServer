import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by karol on 09.06.18.
 */
public class ReceiveDataTask implements Runnable {

    private GameMaster gameMaster;
    private UsersInformation usersInformation;

    public ReceiveDataTask(UsersInformation usersInformation) {
        this.usersInformation = usersInformation;
    }

    @Override
    public void run() {
        gameMaster = GameMaster.getInstance();
        while (true)
        {
            try {
                DatagramSocket datagramSocket = new DatagramSocket(Const.RECEIVE_PORT);
                byte[] buffer = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buffer, 1024);
                datagramSocket.receive(dp);
                String str = new String(dp.getData(), 0, dp.getLength());
                InetAddress address= dp.getAddress();
                usersInformation.addElem(address.toString());
                gameMaster.update(usersInformation.getUserNumber(address.toString()),str);
                datagramSocket.close();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
