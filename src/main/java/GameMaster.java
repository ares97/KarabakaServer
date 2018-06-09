public class GameMaster {
    GameState state;
    private static GameMaster instance = null;

    public static GameMaster getInstance(){
        if (instance == null){
            instance = new GameMaster();
        }
        return instance;
    }

    private GameMaster(){}

    public synchronized void dispatchMessage(String message, int index) throws IndexOutOfBoundsException{
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

    public boolean isEmpty(Vector2 position){
        boolean empty = Map.getInstance().isEmptyBlock(position);
        if(GameState.getInstance().isEmptyPlayer(position) == false){
            empty = false;
        }
        return empty;
    }

    public void update(){
        
    }

}
