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
public class triangle {
    private point point1;
    private point point2;
    private point point3;
    

    public triangle(point point1, point point2, point point3) {
        
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        
    }

    public point getPoint1() {
        return point1;
    }

    public point getPoint2() {
        return point2;
    }

    public point getPoint3() {
        return point3;
    }

   
    
}
