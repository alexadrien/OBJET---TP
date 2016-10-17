/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**Un mage, le seul à pouvoir faire des attaques magiques.
 *
 * @author Arthur
 */
public class Mage extends Personnage {
    
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
    public Mage(int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, String nom, int ptV, int pA, int pP, int dA, int ptPar, Point2D pos) {
        super(ptMana, pourcentageMag, pourcentageResistMag, degMag, distAttMax, nom, ptV, pA, pP, dA, ptPar, pos);
    }

    public Mage(Mage perso) {
        super(perso);
    }

    public Mage() {
        super();
    }
    
    @Override
    public void combattre(Creature adversaire){
        if (this.ptMana > 0){
            if (this.lancerDe(this.pourcentageAtt)){
                System.out.println("Attaque réussie");
                adversaire.ptVie -= this.degMag;
            }
            else{
                System.out.println("Attaque ratée");
            }
            this.ptMana --;
        }
        else{
            float d = this.getPos().distance(adversaire.getPos());
            if (d == 1){
                //Corps à corps
                if (this.lancerDe(this.pourcentageAtt)){
                    if (adversaire.lancerDe(adversaire.pourcentagePar)){
                        adversaire.ptVie -= this.degAtt - adversaire.ptPar;
                        adversaire.ptVie = Math.max(0, adversaire.ptVie);
                    }
                    else{
                        adversaire.ptVie -= this.degAtt;
                        adversaire.ptVie = Math.max(0, adversaire.ptVie);
                    }
                }
            }
            else{
                System.out.println("Je ne peux plus attaquer!");
            }
        }
    }
    
    public static Mage mageRand(){
        Mage m = new Mage();
        Random rand = new Random();
        
        m.ptMana = rand.nextInt(40) + 10;
        m.pourcentageMag = rand.nextInt(50) + 30;
        m.pourcentageResistMag = rand.nextInt(50) + 30;
        m.degMag = rand.nextInt(25) + 10;
        m.distAttMax = 1;
        m.ptVie = rand.nextInt(40) + 10;
        m.pourcentageAtt = rand.nextInt(30) + 10;
        m.pourcentagePar = rand.nextInt(20) + 10;
        m.degAtt = rand.nextInt(40) + 10;
        m.ptPar = rand.nextInt(10) + 10;
        
        return m;
    }
}
