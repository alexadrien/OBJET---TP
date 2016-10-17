/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Arthur
 */
public abstract class Potion extends Objet {

    public Potion(Point2D pos) {
        super(pos);
    }

    public Potion() {
    }
    
    public abstract void estPris(Personnage perso);
    
}
