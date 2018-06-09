import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

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
                InetAddress ip = InetAddress.getByName(usersInformation.);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }

    private void init()
    {
        gameMaster = GameMaster.getInstance();
    }

}
