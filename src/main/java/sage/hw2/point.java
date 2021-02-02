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
public class point {
    private int xPosition;
    private int yPosition;
    
            
    public point(int x, int y) {
        this.xPosition  = x; 
        this.yPosition = y;
    }
    public int getX(){
        return this.xPosition;
    }
    public int getY(){
        return this.yPosition;
    }
}
