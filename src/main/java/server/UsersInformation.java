package server;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by karol on 09.06.18.
 */
public class UsersInformation {

    private HashMap hashMap;
    private Integer currNumb = 0;

    public UsersInformation()
    {
        init();
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

    public int getUserNumber(String ip)
    {
        return (int)hashMap.get(ip);
    }

    public void init()
    {
        this.hashMap = new HashMap<String,Integer>();
        this.currNumb = 0;
    }

    public String getUserIp(int playerNumb)
    {
        Set<String>keySet = hashMap.keySet();
        for(String s:keySet)
        {
            if((int)hashMap.get(s)==playerNumb)
            {
                return s;
            }
        }
    }

}
