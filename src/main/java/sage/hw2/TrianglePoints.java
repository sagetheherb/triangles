/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sage.hw2;

/**
 * Triangle Points 
 * hw2
 * Java NetBeans IDE 12.2
 * @author Sage Elfanbaum and Erosh Boralugodage
 * CS4500 section 1
 * 2/8/2021
 * This program will prompt the user for three points that form a 
 * triangle and if it is not colinear it will calculate the triangle's
 * centroid, orthocenter and centroid. The program will then calculate 
 * the value of the biggest distance between the points. Then two of 
 * the points will be used to create a line that pass through them. 
 * Then the third point's distance to that line will be measured. 
 * TODO enter resources used to create program
 */

public class TrianglePoints {



    static double calCentroid(double a, double b, double c) {
        return ((a+b+c)/3);
    }




    // This function Perpendicular bisector slope
    static double perpendicularBiSectorSlope(double a_first, double a_second, double b_first, double b_second){

        //calculate slope from point to point from triangle
        //slope  = y2-y1/x2-x1

        double slopePoint2Point = (b_second-a_second)/(b_first-a_first);


        //slope of the line that contain the perpendicular bi sector passes through the mid point
        double slopePerpBiSec = -1/slopePoint2Point;

        return (slopePerpBiSec);

    }


    static double midpoint(double a_first, double b_first){
        double midPoint = (a_first+b_first)/2;  // (x1 + x2)/2

        return midPoint;
    }

    static double circumCenterCal(double m1, double m2, double x1, double y1,double x2, double y2){
        // equation for perpendicular bisector going through mid point of side1 (x1,y1) and circumcenter (X,Y)
        //  (Y-y1) = m1(X-x1)
        //   Y = m1(X-x1) + Y1

        // equation flor perpendicular bisector going through mid point of side2 (x2,y2) and circumcenter (X,Y)
        //  (Y-y2) = m1(X-x2)
        //   Y = m2(X-x2) + Y2

        //find the point of intersection of two lines
        // m1(X-x1) + y1  = m2(X-x2) + y2
        //X = (m1x1-m2x2 +Y2-y1)/(m1-m2)
        // Y = m1(X-x1)+Y1

        if (m1 == m2) {
            System.out.println("Parallel lines");
        }else{

         double circumXvalue = (m1*x1-m2*x2 +y2-y1)/(m1-m2);
         double circumYvalue = m1*(circumXvalue-x1) + y1;
           System.out.println(circumXvalue+ "," + circumYvalue);
        }

        return 0;
    }

     public static void main(String[] args) {
         double x1=3;
         double y1=2;

         double x2= 1 ;
         double y2= 4;

         double x3 = 5;
         double y3= 4;

         double centeroid_X = calCentroid(x1,x2,x3);
         double centeroid_Y = calCentroid(y1,y2,y3);

        System.out.println("Orthocenter coordinates: ("+ centeroid_X + "," +centeroid_Y +")" );


        //  calculating circumcenter of triangular
         System.out.println("Circumcenter calculating");


         double midPQX = midpoint(x1,x2);
         double midPQY = midpoint(y1,y2);
         double perpBiPQ= perpendicularBiSectorSlope(x1,y1,x2,y2);

         System.out.println("PQ midpoints (" +midPQX+ ", " + midPQY + " )");
         System.out.println("Perendicular bi to PQ " + perpBiPQ );

         double midQRX = midpoint(x2,x3);
         double midQRY = midpoint(y2,y3);
         double perpBiQR= perpendicularBiSectorSlope(x1,y1,x3,y3);

         System.out.println("QR midpoints (" +midQRX+ ", " + midQRY + " )");
         System.out.println("Perpendicular bi to QR " + perpBiQR );

         circumCenterCal(perpBiPQ,perpBiQR,midPQX,midPQY,midQRX,midQRY);



     }
  
}
