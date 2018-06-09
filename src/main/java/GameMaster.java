public class GameMaster {
    GameState state;
    private GameMaster instance = null;

    public GameMaster getInstance(){
        if (instance == null){
            instance = new GameMaster();
        }
        return instance;
    }

    private GameMaster(){}

    public synchronized void update(int index, String message) throws IndexOutOfBoundsException{
        Player currentPlayer;
        try{
            currentPlayer = state.getPlayers().get(index);
        }
        catch(IndexOutOfBoundsException ex){
            return;
        }
        switch(message){
            case "move_up":
                currentPlayer.move("up");
                break;
            case "move_down":
                currentPlayer.move("down");
                break;
            case "move_left":
                currentPlayer.move("left");
                break;
            case "move_right":
                currentPlayer.move("right");
                break;
            case "shoot":
                currentPlayer.shoot();
                break;

        }
    }

}
