public class Player {
    Vector2 position;
    void move(String action){
        switch(action){
            case "left":
                position.x -= 1;
                break;
            case "right":
                position.x += 1;
                break;
            case "down":
                position.y -= 1;
                break;
            case "up":
                position.y += 1;
                break;
        }
    }
}
