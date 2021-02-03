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
    static int calCentroid(int a, int b, int c) {
        return ((a+b+c)/3);
    }
     public static void main(String[] args) {
         int x1=2;
         int y1=3;

         int x2=-1;
         int y2= 9;

         int x3 = 6;
         int y3= -4;

         int centeroid_X = calCentroid(x1,x2,x3);
         int centeroid_Y = calCentroid(y1,y2,y3);

         System.out.println("Orthocenter coordinates: ("+ centeroid_X + "," +centeroid_Y +")" );


     }
  
}
