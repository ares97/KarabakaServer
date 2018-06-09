public class Player {
    private Vector2 position;
    private Vector2 direction;
    public Player(Vector2 position, Vector2 direction){
        this.position = position;
        this.direction = direction;
    }

    public void move(String dir){
        Vector2 newPosition = this.position;
        Vector2 newDirection = this.direction;
        switch(dir){
            case "left":
                newPosition.x -= 1;
                newDirection.set(-1, 0);
                break;
            case "right":
                newPosition.x += 1;
                newDirection.set(1, 0);
                break;
            case "down":
                newPosition.y -= 1;
                newDirection.set(0, -1);
                break;
            case "up":
                newPosition.y += 1;
                newDirection.set(0, 1);
                break;
        }

        if(GameMaster.getInstance().isEmpty(newPosition)){
            position = newPosition;
            direction = newDirection;
        }

    }

    public void shoot(){
        GameState.getInstance().addBullet(new Bullet(this.position, this.direction));
    }

    public Vector2 getPosition() {
        return position;
    }
}
