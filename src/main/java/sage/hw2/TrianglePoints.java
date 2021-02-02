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
    
     public static void main(String[] args) {
        /*
         *to do write the input output
         */
        point point1 = new point(1,1);
        point point2 = new point(1,1);
        point point3 = new point(1,1);
        triangle triangle = new triangle(point1, point2, point3);
    }
  
}
