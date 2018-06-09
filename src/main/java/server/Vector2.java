package server;

public class Vector2 {
    public int x, y;

    public Vector2(int x, int y){
        set(x, y);
    }

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Vector2 objVec = (Vector2)obj;
        return this.x == objVec.x && this.y == objVec.y;
    }
}
