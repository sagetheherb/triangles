package sage.hw2;

// the triangle object holds the input points and calculates the rest of the points and the euler line
public class Triangle {
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private Point orthocenter;
    private Point centroid;
    private Point circumcenter;
    private String eulerLine;

    // this is the constructer that takes in input and calulates the three points and the euler line
    public Triangle(Point pointA, Point pointB, Point pointC) {

        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        calculateOrthocenter();
        calculateCentroid();
        calculateCircumcenter();
        calculateEulerLine();

    }

    private void calculateCentroid(){   // this will calulate the centroid

        /*
        TODO make this
        erosh
        extra comment for thing
        */

    }

    private void calculateCircumcenter(){   // this will calulate the circumcenter

        /*
        TODO make this
        erosh
        */

    }
    private void calculateOrthocenter(){   // this will calulate the orthocenter

        double slopeBC = (pointC.getY() - pointB.getY())/(pointC.getX() - pointB.getX()); //y2-y1/x2-x1
        double slopeAB = (pointB.getY() - pointA.getY())/(pointB.getX() - pointA.getX());//y2-y1/x2-x1

        double slopeAD = -1.0/slopeBC; // -1/slope = perpendicular
        double slopeCF = -1.0/slopeAB; // -1/slope = perpendicular

        double yInterceptAD = (pointA.getY() - (slopeAD * pointA.getX())); // b = y -mx
        double yInterceptCF = (pointC.getY() - (slopeCF * pointC.getX())); // b = y -mx


        double x = (yInterceptCF - yInterceptAD) / (slopeAD - slopeCF); // x value of the orthocenter
        double y = slopeAD * x + yInterceptAD;// y value of the orthocenter

        Point orthocenter = new Point(x,y);
        this.orthocenter = orthocenter;


    }
    private void calculateEulerLine(){

    }

    public Point getOrthocenter(){

        return this.orthocenter;

    }

    public Point getCentroid(){

        return this.centroid;

    }

    public Point getCircumventer(){

        return this.circumcenter;
    }

    public String getEulerLine(){

        return this.eulerLine;

    }

    public boolean isCollinear(){
        return false;

    }
    public boolean isEquilateral(){
        //to do make this work (round the numbers)
        return (this.centroid.getX() == this.circumcenter.getX()
                && this.circumcenter.getX() == this.orthocenter.getX()
                && this.centroid.getY() == this.circumcenter.getY()
                && this.circumcenter.getY() == this.orthocenter.getY());


    }



}