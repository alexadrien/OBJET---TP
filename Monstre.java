/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/** Classe des monstres, qui descend de créature. Ce sont les créatures les plus féroces, à tuer de préférence, ou alors à apprivoiser.
 *
 * @author Arthur
 */
public abstract class Monstre extends Creature{
    
    /** Constructeur de la classe
     *
     * @param nom Nom
     * @param ptV Point de vie
     * @param ptPar Points de parade
     * @param pA Pourcentage d'attaque
     * @param pP Pourcentage de parade
     * @param dA Dégats d'attaque
     * @param pos Position
     */
    public Monstre(String nom, int ptV, int pA, int pP, int dA, int ptPar, Point2D pos) {
        super(nom, ptV, pA, pP, dA, ptPar, pos);
    }

    public Monstre(Monstre perso) {
        super(perso);
    }

    public Monstre() {
        super();
    }
    
}
