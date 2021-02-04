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
        //calculateCentroid();
        //calculateCircumventer();
        
    }
        
    private void calculateCentroid(){
        /*
        TODO make this
        erosh
        */
    }
    private void calculateCircumventer(){
        /*
        TODO make this 
        erosh
        */
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
