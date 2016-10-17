/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/** Classe des paysans, qui est nécessaire dans notre jeu de role, on ne compte plus les cas d'utilisation d'un paysan. Incroyable
 *
 * @author Arthur
 */
public class Paysan extends Personnage {
    
     /**
     *
     * @param ptMana Point de Mana
     * @param pourcentageMag Pourcentage de Magie
     * @param pourcentageResistMag Pourcentage de resistance à la magie
     * @param degMag Degat max
     * @param distAttMax distance d'attaque maximale
     * @param nom Nom
     * @param ptPar Points de parade
     * @param ptV Point de vie
     * @param pA Pourcentage d'attaque
     * @param pP pourcentage de parade
     * @param dA distance d'attaque
     * @param pos position
     */
    public Paysan(int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, String nom, int ptV, int pA, int pP, int dA, int ptPar, Point2D pos) {
        super(ptMana, pourcentageMag, pourcentageResistMag, degMag, distAttMax, nom, ptV, pA, pP, dA, ptPar, pos);
    }

    public Paysan(Paysan perso) {
        super(perso);
    }

    public Paysan() {
        super();
    }

    @Override
    public void combattre(Creature adversaire){
        System.out.println("Je suis un paysan, je ne combat pas!");
    }
    
    public static Paysan paysanRand(){
        Paysan p = new Paysan();
        Random rand = new Random();
        
        p.ptMana = 0;
        p.pourcentageMag = 0;
        p.pourcentageResistMag = 0;
        p.degMag = 100;
        p.distAttMax = 0;
        p.ptVie = 5;
        p.pourcentageAtt = 0;
        p.pourcentagePar = 0;
        p.degAtt = 0;
        p.ptPar = 0;
        
        return p;
    }
    
    
}
