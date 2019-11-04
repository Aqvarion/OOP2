package BallGo;

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
        return "Ball{" +
                "(" + x +
                "," + y +
                "),speed=("+xDelta+","+yDelta+")}";
    }

    public static void main(String[] args) {
        Ball ball = new Ball(15,3,2,40,20);
        Container container = new Container(10,10,20,10);
        System.out.println(ball);
        System.out.println("Ball in container? "+container.collides(ball));
        System.out.println("Ball move");
        ball.move();
        System.out.println(ball);
        System.out.println("Ball in container? "+container.collides(ball));
    }
}
