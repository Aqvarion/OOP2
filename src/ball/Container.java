package ball;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public int getWidth() {
        return x2-x1;
    }

    public int getHeidth() {
        return y1-y2;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x+width;
        this.y2 =y-height;
    }

    @Override
    public String toString() {
        return "Container{" +
                "(" + x1 +
                "," + y1 +
                "), (" + x2 +
                "," + y2 +
                ")}";
    }

    public boolean collides(Ball ball){
        if(ball.getX()-ball.getRadius()>x1&ball.getX()+ball.getRadius()<x2&ball.getY()+ball.getRadius()<y1&ball.getY()-ball.getRadius()>y2)
            return true;
        return false;
    }


    public static void main(String[] args) {
        Ball ball = new Ball(15,3,2,40,20);
        Ball ball2 = new Ball(15,3,2,40,20);
        Container container = new Container(10,10,20,10);
        System.out.println("Ball1 "+ball);
        System.out.println("Ball2 "+ball2);
        System.out.println("Ball1 is equal to ball2 ? "+ball.equals(ball2));
        System.out.println("Ball in container? "+container.collides(ball));
        System.out.println("Ball move");
        ball.move();
        System.out.println(ball);
        System.out.println("Ball in container? "+container.collides(ball));
    }
}
