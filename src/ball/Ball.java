package ball;

public class Ball {
    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float)(speed*Math.cos(direction));
        this.yDelta = (float)(speed*Math.sin(direction));;
    }

    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move(){
        this.x+=xDelta;
        this.y+=yDelta;
    }

    public void reflectHorizontal(){
        this.yDelta=-yDelta;
    }

    public void reflectVertical(){
        this.xDelta=-xDelta;
    }

    @Override
    public String toString() {
        return "{" +
                "(" + x +
                "," + y +
                "),speed=("+xDelta+","+yDelta+")}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return Float.compare(ball.x, x) == 0 &&
                Float.compare(ball.y, y) == 0 &&
                radius == ball.radius &&
                Float.compare(ball.xDelta, xDelta) == 0 &&
                Float.compare(ball.yDelta, yDelta) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 17;
        result = prime*result+Float.floatToIntBits(x);
        result = prime*result+Float.floatToIntBits(y);
        result = prime*result+radius;
        result = prime*result+Float.floatToIntBits(xDelta);
        result = prime*result+Float.floatToIntBits(yDelta);
        return result;
    }
}
