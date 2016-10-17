/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author Arthur
 */
public class Objet extends ElementDeJeu{
    
    protected Point2D pos;

    public Objet(Point2D pos) {
        this.pos = new Point2D(pos);
    }

    public Objet() {
        this.pos = new Point2D();
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }
    
    public void placementRandom(){
        int N=20;
        Random rand = new Random();
        Point2D newPos = new Point2D(rand.nextInt(N), rand.nextInt(N));
        while (!TestSeance2.monde.isGood(newPos)){
            newPos.setPosition(rand.nextInt(N), rand.nextInt(N));
        }
        this.pos.setPosition(newPos.getX(), newPos.getY());
    }
    
}
