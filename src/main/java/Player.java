public class Player {
    Vector2 position;
    void move(String direction){
        switch(direction){
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
