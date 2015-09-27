package ia_chess;

public class Position {
    protected int x;
    protected int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Position))
            return false;
        if (obj == this)
            return true;
        Position that = (Position)obj;
        return (this.x == that.x && this.y == that.y);
    }
}
