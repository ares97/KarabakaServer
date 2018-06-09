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
    private HashMap hashMap;
    private Integer currNumb = 0;

    public ReceiveDataTask()
    {
        init();
    }

    @Override
    public void run() {
        //gameMaster = GameMaster.getInstance();
        while (true)
        {
            try {
                DatagramSocket datagramSocket = new DatagramSocket(Const.RECEIVE_PORT);
                byte[] buffer = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buffer, 1024);
                datagramSocket.receive(dp);
                String str = new String(dp.getData(), 0, dp.getLength());
                InetAddress address= dp.getAddress();
                addElem(address.toString());
                //gameMaster.update(hashMap.get(address.toString()),str);
                datagramSocket.close();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void init()
    {
        //gameMaster = gameMaster = GameMaster.getInstance();
        this.hashMap = new HashMap<String,Integer>();
        this.currNumb = 0;
    }

    public void addElem(String ip)
    {
        if(hashMap.containsValue(ip))
            return;
        else {
            hashMap.put(ip, currNumb.intValue());
            currNumb++;
        }
    }

}
