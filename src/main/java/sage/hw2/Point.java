
package sage.hw2;

//this class holds an x and y value for the triangle class.a dsaf
public class Point {
    private final double xPosition;
    private final double yPosition;

    // the constructor for the point object
    public Point(double x, double y) {
        this.xPosition  = x;
        this.yPosition = y;
    }
    public double getX(){
        return this.xPosition;
    }
    public double getY(){
        return this.yPosition;
    }
}
