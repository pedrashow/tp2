/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q7;

/**
 *
 * @author Beto
 */

public class Ponto {
    
    private double x; //coord x
    private double y; //coord y
    
    Ponto (double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setX (double x) {
        this.x = x;
    }
    
    public void setY (double y) {
        this.y = y;
    }
    
    public static double dist (Ponto p1, Ponto p2) {
        return Math.sqrt(Math.pow(p1.getX() - p1.getY(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }
}
