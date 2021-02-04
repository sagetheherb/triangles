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

import java.util.Scanner;
import java.util.ArrayList; 


public class TrianglePoints {
    
     public static void main(String[] args) {
        System.out.println("This program will prompt the user for three points that form a ");
        System.out.println( "triangle and if it is not colinear it will calculate the triangle");
        System.out.println( "centroid, orthocenter and centroid. The program will then calculate ");
        System.out.println( "the value of the biggest distance between the points. Then two of ");
        System.out.println( "the points will be used to create a line that pass through them. ");
        System.out.println( "Then the third point distance to that line will be measured."); 
        
        Scanner in = new Scanner(System.in);
        
        ArrayList<Point> points = new ArrayList<>();
        int point_counter = 0;
        while (true){
           
            System.out.println("please enter a number for a point");
            double tempX = in.nextDouble();
            System.out.println("please enter a number for a point");
            double tempY = in.nextDouble();
            
            Point point = new Point(tempX, tempY);
            System.out.print(point.getX() + "x value");
            System.out.print(point.getY() + "y value");
            points.add(point);
            point_counter++;
            if(point_counter >= 3){
                break;
            }
         
        }
        Triangle triangle = new Triangle(points.get(0), points.get(1), points.get(2));
        if (triangle.isCollinear()){
            System.out.print("the points you have entered are colinear sorry");
            in.nextLine();
            System.exit(0);
        }

        System.out.print(triangle.getOrthocenter().getX() + "," + triangle.getOrthocenter().getY() + " is the orthocenter");
        in.nextLine();
        System.exit(0);
        
       
       
       
    }
  
  
}
