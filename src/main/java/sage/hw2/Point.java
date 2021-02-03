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
public class Point {
    private double xPosition;
    private double yPosition;
    
            
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
