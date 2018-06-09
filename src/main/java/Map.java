import java.util.ArrayList;
import java.util.List;

public class Map {
    List<Boolean> walls;
    private static Map instance = null;
    public static Map getInstance(){
        if(instance == null){
            instance = new Map();
        }
        return instance;
    }
    private Map(){
        walls = new ArrayList<>();
    }
    public Boolean isEmptyBlock(Vector2 position){
        return walls.get(position.x * Const.BLOCK_SIZE + position.y) ? false : true;
    }
}
