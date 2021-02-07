/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sage.hw2;

/**
 *
 * @author sagee
 */
public class Triangle {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point orthocenter;
    private Point centroid;
    private Point circumventer;
    

    public Triangle(Point pointA, Point pointB, Point pointC) {
        
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        calculateOrthocenter();
        calculateCentroid();
        calculateCircumventer();
        
    }
        
    private void calculateCentroid(){
        double x = (pointA.getX() + pointB.getX()+pointC.getX())/3;
        double y =(pointA.getY() + pointB.getY() + pointC.getY())/3;
        Point point = new Point(x, y);
        this.orthocenter = point;
    }
    private void calculateCircumventer(){
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

// equation flor perpendicular bisector going through mid point of side2 (x2,y2) and circumcenter (X,Y)
//  (Y-y2) = m1(X-x2)
//   Y = m2(X-x2) + Y2

//find the point of intersection of two lines
// m1(X-x1) + y1  = m2(X-x2) + y2
//X = (m1*x1-m2*x2 +Y2-y1)/(m1-m2)
// Y = m1*(X-x1)+Y1

        if (slopeAC == slopeBC) {
            System.out.println("Parallel lines");
        } else {

            double x = (slopePerpBiSecAC * midPointACX - slopePerpBiSecBC * midPointBCX + midPointBCY - midPointACY) / (slopePerpBiSecAC - slopePerpBiSecBC);
            double y = slopePerpBiSecAC * (x - midPointACX) + midPointACY;

            Point point = new Point(x,y);
            this.circumventer = point;
        }


    }
    private void calculateOrthocenter(){
       
        double slopeBC = (pointC.getY() - pointB.getY())/(pointC.getX() - pointB.getX());
        double slopeAC = (pointC.getY() - pointA.getY())/(pointC.getX() - pointA.getX());
        double slopeAB = (pointB.getY() - pointA.getY())/(pointB.getX() - pointA.getX());
        
        double slopeAD = -1.0/slopeBC; // -1/slope = perpendicular 
        double slopeCF = -1.0/slopeAB;
        
        double yInterceptAD = (pointA.getY() - (slopeAD * pointA.getX())); // b = y -mx
        double yInterceptCF = (pointC.getY() - (slopeCF * pointC.getX())); // b = y -mx
      
     
        double x = (yInterceptCF - yInterceptAD) / (slopeAD - slopeCF);
        double y = slopeAD * x + yInterceptAD;
        
        Point point = new Point(x,y);
        this.orthocenter = point;
        
       
    }
    public Point getOrthocenter(){
        
        return this.orthocenter;
        
    }
     public Point getCentroid(){
         
        return this.centroid;
        
    }
    public Point getCircumventer(){
        
        return this.circumventer;
    }
        
    public boolean isCollinear(){
        return false; 
        
    }
    public boolean isEquilateral(){
        return (this.centroid.getX() == this.circumventer.getX()
                && this.circumventer.getX() == this.orthocenter.getX()
                && this.centroid.getY() == this.circumventer.getY()
                && this.circumventer.getY() == this.orthocenter.getY());
               

    }

   
    
}
