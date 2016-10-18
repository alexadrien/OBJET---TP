/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 coucou
 */
package org.centrale.projet.objet;

import java.util.Random;

/** Classe qui represente les Archers, type de personnage très puissant mais un peu lâche puisqu'il ne combat qu'à distance
 *
 * @author Arthur
 */
public class Archer extends Personnage {
    private int nbFleches;
    
    /** Constructeur de la classe Archer
     *
     * @param ptMana Point de Mana
     * @param pourcentageMag Pourcentage de magie
     * @param pourcentageResistMag Pourcentage de resitance à la magie
     * @param degMag degat maximum
     * @param distAttMax distance d'attaque maximale
     * @param nom Nom
     * @param ptV Points de vie
     * @param pA Pourcentage d'attaque
     * @param pP Pourcentage de parade
     * @param dA Dégats d'attaque
     * @param ptPar Points de parade
     * @param pos Position
     * @param nbF Nombre de flêches
     */
    public Archer(int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, String nom, int ptV, int pA, int pP, int dA, int ptPar, Point2D pos, int nbF) {
        super(ptMana, pourcentageMag, pourcentageResistMag, degMag, distAttMax, nom, ptV, pA, pP, dA, ptPar, pos);
        this.nbFleches = nbF;
    }

    public Archer(Archer perso) {
        super(perso);
        this.nbFleches = 0;
    }

    public Archer() {
        super();
        this.nbFleches = 0;
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    
    @Override
    public void combattre(Creature adversaire){
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
        else if (d > 1 && d < this.distAttMax){
            //à distance
            if (nbFleches >0){
                if (this.lancerDe(this.pourcentageAtt)){
                    System.out.println("Votre adversaire avait " + adversaire.ptVie + " points de vie");
                    adversaire.ptVie -= this.degAtt;
                    adversaire.ptVie = Math.max(0, adversaire.ptVie);
                    System.out.println("Votre adversaire a maintenant " + adversaire.ptVie + " points de vie");
                }
                else{
                    System.out.println("Vous avez raté votre tir!");
                }
                this.nbFleches --;
                System.out.println("Il vous reste " + nbFleches + " flèches");
            }
            else{
                System.out.println("Vous n'avez plus de flèche, dommage..");
            }
        }
        else{
            System.out.println("Je ne peux pas lancer si loin!");
        }
    }
    
    public static Archer archerRand(){
        Archer a = new Archer();
        Random rand = new Random();
        
        a.ptMana = rand.nextInt(40) + 10;
        a.pourcentageMag = rand.nextInt(50) + 30;
        a.pourcentageResistMag = rand.nextInt(50) + 30;
        a.degMag = rand.nextInt(25) + 10;
        a.distAttMax = rand.nextInt(10) + 3;
        a.ptVie = rand.nextInt(40) + 10;
        a.pourcentageAtt = rand.nextInt(70) + 20;
        a.pourcentagePar = rand.nextInt(20) + 10;
        a.degAtt = rand.nextInt(50) + 10;
        a.ptPar = rand.nextInt(10) + 10;
        a.nbFleches = 10;
        
        return a;
    }
}
