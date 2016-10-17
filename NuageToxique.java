/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
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

    public void combattre() {
        ArrayList<Creature> listeProx = peutCombattre();
        if (!listeProx.isEmpty()) {
            for (Creature creature : listeProx) {
                this.combattre(creature);
            }
        }
    }

    public void combattre(Creature c) {
        c.ptVie -= this.degAtt - c.ptPar;
        System.out.println(c.getNom() + " vient de se faire attaquer par un Nuage Toxique !");
    }

    @Override
    public void deplacer() {

        Random rand = new Random();
        Point2D newPos = new Point2D(this.pos.getX() + rand.nextInt(3) - 1, this.pos.getY() + rand.nextInt(3) - 1);
        while (!TestSeance2.monde.isFree(newPos)) {
            newPos.setPosition(this.pos.getX() + rand.nextInt(3) - 1, this.pos.getY() + rand.nextInt(3) - 1); //Si la case n'est pas libre la créature cherche une autre position
        }
        this.pos.setPosition(newPos.getX(), newPos.getY());
        //On considère qu'une créature peut (et doit) se déplacer vers toutes les cases qui l'entourent et ceci de manière aléatoire.

    }

    public ArrayList<Creature> peutCombattre() {
        ArrayList<Creature> listeProx = new ArrayList<>();
        if (this.getPos().distance(TestSeance2.monde.joueur.getPerso().getPos()) <= 1) {
            listeProx.add(TestSeance2.monde.joueur.getPerso());
        }
        for (Personnage personnage : TestSeance2.monde.personnages) {
            if (personnage.getPos().distance(this.getPos()) <= 1) {
                listeProx.add(personnage);
            }
        }
        for (Monstre monstre : TestSeance2.monde.monstres) {
            if (monstre.getPos().distance(this.getPos()) <= 1) {
                listeProx.add(monstre);
            }
        }
        return listeProx;
    }

}
