/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe qui descend des monstre, et pourtant celle la représente peut-etre le
 * plus mignon des monstres puisqu'il s'agit d'un lapin. Mais attention, cela
 * reste un monstre puisq'on peut lui taper dessus.
 *
 * @author Arthur
 */
public class Lapin extends Monstre {

    /**
     * constructeur de la classe
     *
     * @param nom Nom
     * @param ptV Point de vie
     * @param ptPar Points de parade
     * @param pA Pourcentage d'attaque
     * @param pP Pourcentage de parade
     * @param dA Dégats d'attaque
     * @param pos Position
     */
    public Lapin(String nom, int ptV, int pA, int pP, int dA, int ptPar, Point2D pos) {
        super(nom, ptV, pA, pP, dA, ptPar, pos);
    }

    public Lapin(Lapin perso) {
        super(perso);
    }

    public Lapin() {
        super();
    }

    @Override
    public void combattre(Creature adversaire) {
        //System.out.println("Je suis un lapin, je ne combat pas!");
    }

    public static Lapin lapinRand() {
        Lapin l = new Lapin();

        l.ptVie = 8;

        return l;
    }

}
