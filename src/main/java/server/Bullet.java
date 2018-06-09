package server;

public class Bullet {
    private Vector2 position;
    private Vector2 direction;
    public Bullet(Vector2 position, Vector2 direction) {
        this.position = position;
        this.direction = direction;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getDirection() {
        return direction;
    }
}
