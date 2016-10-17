/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author Acube
 */
public class NuageToxique extends Objet implements Deplacable, Combattant {
    
    protected int pourcentageAtt;
    protected int degAtt;
    
    public NuageToxique(Point2D pos) {
        super(pos);
        this.pourcentageAtt = 50;
        this.degAtt = 10;
    }

    public NuageToxique() {
        this(new Point2D());
    }
    
    
    @Override
    public void combattre(Creature c){
        float d = this.getPos().distance(c.getPos());
        if (d == 1){
            //Corps à corps
            if (c.lancerDe(this.pourcentageAtt)){
                System.out.println("Un nuage toxique vient d'attaquer ".concat(c.getNom()));
                if (c.lancerDe(c.pourcentagePar)){
                    c.ptVie -= this.degAtt - c.ptPar;
                    c.ptVie = Math.max(0, c.ptVie);
                }
                else{
                    c.ptVie -= this.degAtt;
                    c.ptVie = Math.max(0, c.ptVie);
                }
            }
        }
    }
    
    @Override
    public void deplacer(){
        Random rand = new Random();
        Point2D newPos = new Point2D(this.pos.getX() + rand.nextInt(3)-1, this.pos.getY() + rand.nextInt(3)-1);
        while (!TestSeance2.monde.isGood(newPos)){
            newPos.setPosition(this.pos.getX() + rand.nextInt(3)-1, this.pos.getY() + rand.nextInt(3)-1); //Si la case n'est pas libre la créature cherche une autre position
        }
        this.pos.setPosition(newPos.getX(), newPos.getY());
        //On considère qu'une créature peut (et doit) se déplacer vers toutes les cases qui l'entourent et ceci de manière aléatoire.

    }
}
