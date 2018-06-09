package server;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameState {

    private List<Player> players;
    private List<Bullet> bullets;
    private static GameState instance = null;

    public static GameState getInstance(){
        if (instance == null){
            instance = new GameState();
        }
        return instance;
    }

    private GameState(){
        players = new ArrayList<>();
        bullets = new LinkedList<>();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void addBullet(Bullet bullet){
        bullets.add(bullet);
    }

    public boolean isEmptyPlayer(Vector2 position){
        for (Player player: players) {
            if(player.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }

}
