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
 * asdf
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

        ArrayList<Point> points = new ArrayList<>(); //the array that holds the points that the user inputs
        int point_counter = 0;
        //this loop takes in three points from the user
        while (true){
            try { // makes sure the input is a double 
                double tempX = 0.0; //holds the value that the user inputs
                double tempY = 0.0; //holds the value that the user inputs
                System.out.println(" please enter a number for a point");
                tempX = in.nextDouble();
                System.out.println(" please enter a number for a point");
                tempY = in.nextDouble();
                Point point = new Point(tempX, tempY); //One point the user inputs
                System.out.println(point.getX() + " x value");
                System.out.println(point.getY() + " y value");
                points.add(point);
                point_counter++;

            }

            catch(Exception InputMismatchException) {
                System.out.println(" please enter a decimal number i.e. 1.2");
                in.next();
            }

            if(point_counter >= 3){
                break;
            }

        }
        // the triangle object holds the input points and calculates the rest of the points and the euler line
        Triangle triangle = new Triangle(points.get(0), points.get(1), points.get(2));
        if (triangle.isCollinear()){
            System.out.print("the points you have entered are colinear sorry");
            in.nextLine();
            System.exit(0);
        }

        System.out.print(triangle.getOrthocenter().getX() + "," + triangle.getOrthocenter().getY() + " is the orthocenter");
        //System.out.print(triangle.getCircumventer().getX() + "," + triangle.getCircumventer().getY() + " is the circumventer");
        //System.out.print(triangle.getCentroid().getX() + "," + triangle.getCentroid().getY() + " is the centroid");
        //System.out.print(triangle.getEulerLine());
        in.nextLine();
        System.exit(0);

    }


}