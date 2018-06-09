public class Player {
    private Vector2 position;
    private Vector2 direction;
    public Player(Vector2 position, Vector2 direction){
        this.position = position;
        this.direction = direction;
    }

    public void move(String dir){
        switch(dir){
            case "left":
                position.x -= 1;
                direction.set(-1, 0);
                break;
            case "right":
                position.x += 1;
                direction.set(1, 0);
                break;
            case "down":
                position.y -= 1;
                direction.set(0, -1);
                break;
            case "up":
                position.y += 1;
                direction.set(0, 1);
                break;
        }
    }

    public void shoot(){
        GameState.getInstance().addBullet(new Bullet(this.position, this.direction));
    }

}
