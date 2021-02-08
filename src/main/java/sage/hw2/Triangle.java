package sage.hw2;

import java.lang.Math;
import java.util.Scanner;

// the triangle object holds the input points and calculates the rest of the points and the euler line
public class Triangle {
    Scanner in = new Scanner(System.in);
    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private Point orthocenter;
    private Point centroid;
    private Point circumcenter;
    private String eulerLine;
    private double eulerLineToCircumcenter;
    private double percentageError;

    // this is the constructor that takes in input and calulates the three points and the euler line
    public Triangle(Point pointA, Point pointB, Point pointC) {

        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;

        if(isCollinear()){
            System.out.println("ERROR: The points you have entered are collinear so the points cannot be found ");
            in.nextLine();
            System.exit(0);
        }
        else{
            calculateOrthocenter();
            calculateCentroid();
            calculateCircumcenter();
            calculateEulerLine();
        }
        //TODO round these

    }

    private void calculateCentroid(){   // this will calulate the centroid

        double x = (pointA.getX() + pointB.getX()+pointC.getX())/3; //TODO comment this
        double y =(pointA.getY() + pointB.getY() + pointC.getY())/3;
        Point point = new Point(x, y);
        this.centroid = point;

    }
    // This function Perpendicular bisector slope
    private void calculateCircumcenter(){   // this will calulate the circumcenter

        //calculate slope from point to point from triangle
        //slope  = y2-y1/x2-x1
        double slopeBC = (pointC.getY() - pointB.getY()) / (pointC.getX() - pointB.getX()); //slope BC
        double slopeAC = (pointC.getY() - pointA.getY()) / (pointC.getX() - pointA.getX()); //Slope AC


        //slope of the line that contain the perpendicular bi sector passes through the mid point
        double slopePerpBiSecBC = -1 / slopeBC;
        double slopePerpBiSecAC = -1 / slopeAC;

        //calculate mid point from point to point BC
        double midPointBCX = (pointB.getX() +pointC.getX())/2;
        double midPointBCY = (pointB.getY() +pointC.getY())/2;

        //calculate mid point from point to point AC
        double midPointACX = (pointA.getX() +pointC.getX())/2;
        double midPointACY = (pointA.getY() +pointC.getY())/2;


        // equation for perpendicular bisector going through mid point of side1 (x1,y1) and circumcenter (X,Y)
        //  (Y-y1) = m1(X-x1)
        //   Y = m1(X-x1) + Y1

        // equation for perpendicular bisector going through mid point of side2 (x2,y2) and circumcenter (X,Y)
        //  (Y-y2) = m1(X-x2)
        //   Y = m2(X-x2) + Y2

        //find the point of intersection of two lines
        // m1(X-x1) + y1  = m2(X-x2) + y2
        //X = (m1*x1-m2*x2 +Y2-y1)/(m1-m2)
        // Y = m1*(X-x1)+Y1

        if (slopeAC == slopeBC) {
            System.out.println("Parallel lines");
            System.exit(0);
        } else {

            double x = (slopePerpBiSecAC * midPointACX - slopePerpBiSecBC * midPointBCX + midPointBCY - midPointACY) / (slopePerpBiSecAC - slopePerpBiSecBC);
            double y = slopePerpBiSecAC * (x - midPointACX) + midPointACY;

            Point point = new Point(x,y);
            this.circumcenter = point;
        }


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

        double slopeEulerLine = (this.orthocenter.getY() - this.centroid.getY())/(this.orthocenter.getX() - this.centroid.getX()); //y2-y1/x2-x1
        double yInterceptEulerLine = (this.orthocenter.getY() - (slopeEulerLine * this.orthocenter.getX()));
        this.eulerLine = ("Y = " + slopeEulerLine + " X + " + yInterceptEulerLine);

        //D = | Ax + By + C|/squareroot of A^2 + B^2
        //D = | (-1 * this.circumcenter.getY()) + (slopeEulerLine * this.circumcenter.getX()) + yInterceptEulerLine | / SqurRoot ((-1^2) + (slopeEulerLine * X)
        this.eulerLineToCircumcenter = Math.abs((-1 * this.circumcenter.getY()) + (slopeEulerLine * this.circumcenter.getX()) + yInterceptEulerLine) /(Math.sqrt((-1 * -1) + (slopeEulerLine * slopeEulerLine)));

        //D = squareroot of (x2 - x1)^2 + (y2 -y1)^2 is the distance between points
        double distanceBetweenOrthocenterAndCentroid = Math.sqrt(Math.pow(this.orthocenter.getX() - this.centroid.getX(), 2)/(Math.pow(this.orthocenter.getY() - this.centroid.getY(), 2)));

        this.percentageError = 100 * Math.round((this.eulerLineToCircumcenter / distanceBetweenOrthocenterAndCentroid) * 100.00) / 100.00;

    }

    public Point getOrthocenter(){

        return this.orthocenter;

    }

    public Point getCentroid(){

        return this.centroid;

    }

    public Point getCircumcenter(){

        return this.circumcenter;
    }

    public String getEulerLine(){

        return this.eulerLine;

    }
    public double getPercentageError(){

        return this.percentageError;

    }
    public double getEulerLineToCircumcenter(){

        return this.eulerLineToCircumcenter;

    }


    public boolean isCollinear(){
        //using the formula = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2) to find if it is collinear

        double collinear = (pointA.getX() * (pointB.getY()) - pointC.getY())
                            + (pointB.getX() * (pointC.getY()) - pointA.getY())
                            + (pointC.getX() * (pointA.getY()) - pointB.getY());

        return collinear == 0;

    }
    public boolean isEquilateral(){
                //if all of the points are in the same place then it is an equilateral triangle.
        return (this.centroid.getX() == this.circumcenter.getX()
                && this.circumcenter.getX() == this.orthocenter.getX()
                && this.centroid.getY() == this.circumcenter.getY()
                && this.circumcenter.getY() == this.orthocenter.getY());


    }



}