/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/** Monstre féroce et dominant, le loup. Créature de la nuit 
 *
 * @author Arthur
 */
public class Loup extends Monstre{
    
    /** Constructeur de la classe
     *
     * @param nom Nom
     * @param ptPar Points de parade
     * @param ptV Point de vie
     * @param pA Pourcentage d'attaque
     * @param pP Pourcentage de parade
     * @param dA Dégats d'attaque
     * @param pos Position
     */
    public Loup(String nom, int ptV, int pA, int pP, int dA, int ptPar, Point2D pos) {
        super(nom, ptV, pA, pP, dA, ptPar, pos);
    }

    public Loup(Loup perso) {
        super(perso);
    }

    public Loup() {
        super();
    }
    
    
    
}
