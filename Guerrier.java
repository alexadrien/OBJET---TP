/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**Un guerrier, un vrai, c'est un personnage, c'est une creature, Il se bat, il se défend, il est indispensable
 *
 * @author Arthur
 */
public class Guerrier extends Personnage{
    
    /** constructeur de la classe
     *
     * @param ptMana Point de Mana
     * @param pourcentageMag Pourcentage de magie
     * @param pourcentageResistMag Pourcentage de resistance à la magie
     * @param degMag Degat maximal
     * @param distAttMax Dégats d'attaque maximale
     * @param nom Nom
     * @param ptV Point de vie
     * @param pA Pourcentage d'attaque
     * @param pP Pourcentage de parade
     * @param dA Dégats d'attaque
     * @param ptPar Points de parade
     * @param pos Position
     */
    public Guerrier(int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, String nom, int ptV, int pA, int pP, int dA, int ptPar, Point2D pos) {
        super(ptMana, pourcentageMag, pourcentageResistMag, degMag, distAttMax, nom, ptV, pA, pP, dA, ptPar, pos);
    }

    public Guerrier(Guerrier perso) {
        super(perso);
    }

    public Guerrier() {
        super();
    }
    
    public static Guerrier guerrierRand(){
        Guerrier g = new Guerrier();
        Random rand = new Random();
        
        g.ptMana = rand.nextInt(40) + 10;
        g.pourcentageMag = rand.nextInt(50) + 30;
        g.pourcentageResistMag = rand.nextInt(50) + 30;
        g.degMag = rand.nextInt(25) + 10;
        g.distAttMax = 1;
        g.ptVie = rand.nextInt(40) + 10;
        g.pourcentageAtt = rand.nextInt(30) + 10;
        g.pourcentagePar = rand.nextInt(20) + 10;
        g.degAtt = rand.nextInt(40) + 10;
        g.ptPar = rand.nextInt(10) + 10;
        
        return g;
    }
}
