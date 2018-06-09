public class GameMaster {
    GameState state;
    private GameMaster instance = null;
    public GameMaster getInstance(){
        if (instance == null){
            instance = new GameMaster();
        }
        return instance;
    }
    private GameMaster(){};
    void update(int index, String message) throws IndexOutOfBoundsException{
        switch(message){
            case "moveUp":

                break;
            case "moveDown":

                break;
            case "moveLeft":

                break;
            case "moveRight":

                break;
            case "shoot":

                break;

        }
    }

}
