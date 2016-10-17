/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/** Classe qui gère les points sur le plan. Avec une abscisse et une ordonnée
 *
 * @author Arthur
 */

public class Point2D {

    private int x;
    private int y;
    
    /** Creation d'un point a partir d'une abscisse et d'une ordonnée
     *
     * @param x
     * @param y
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
        this(0, 0);
    }

    public Point2D(Point2D unAutrePoint2D) {
        this(unAutrePoint2D.x, unAutrePoint2D.y);
    }

    public void affiche() {
        System.out.println("[" + this.x + ";" + this.y + "]");
    }
    
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public boolean equals(Point2D point2){
        //On test l'égalité entre 2 positions
        return (point2.getX() == this.x && point2.getY() == this.y);
    }
    
    /** Calcul la distance entre deux points
     *
     * @param point2 point dont on veut calculer la distance (par rapport au point porteur de la methode)
     * @return
     */
    public float distance(Point2D point2){
        return (float)Math.sqrt((point2.getX()-this.getX())*(point2.getX()-this.getX()) + (point2.getY()-this.getY())*(point2.getY()-this.getY()));
    }
    
    
}
