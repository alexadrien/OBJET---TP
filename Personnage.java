/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/** Classe des personnages. En gros c'est tous les personnages qui ont deux jambes et qui tiennent dessus.
 *
 * @author Arthur
 */
public abstract class Personnage extends Creature{
    
    //Attributs
    
    protected int ptMana;
    protected int pourcentageMag;
    protected int pourcentageResistMag;
    protected int degMag;
    protected int distAttMax;
    
    //Constructeurs
    
    /** Constructeurs de la classe
     *
     * @param ptMana Point de mana
     * @param pourcentageMag pourcentage de magie
     * @param pourcentageResistMag pourcentage de resistance à la magie
     * @param degMag  degat max
     * @param distAttMax distance d'attaque maximale
     * @param nom Nom
     * @param ptV point de vie
     * @param pA pourcentage d'attaque
     * @param pP pourcentage de parade
     * @param dA distance d'attaque
     * @param pos position
     */
    public Personnage(int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, String nom, int ptV, int pA, int pP, int dA, int ptPar, Point2D pos) {
        super(nom, ptV, pA, pP, dA, ptPar, pos);
        this.ptMana = ptMana;
        this.pourcentageMag = pourcentageMag;
        this.pourcentageResistMag = pourcentageResistMag;
        this.degMag = degMag;
        this.distAttMax = distAttMax;
    }

    public Personnage(Personnage perso) {
        super(perso);
        this.ptMana = perso.ptMana;
        this.pourcentageMag = perso.pourcentageMag;
        this.pourcentageResistMag = perso.pourcentageResistMag;
        this.degMag = perso.degMag;
        this.distAttMax = perso.distAttMax;
    }

    public Personnage() {
        super();
        this.ptMana = 0;
        this.pourcentageMag = 0;
        this.pourcentageResistMag = 0;
        this.degMag = 0;
        this.distAttMax = 0;
    }
    
    //Getteurs / Setteurs

    public int getPtMana() {
        return ptMana;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }


    public int getPourcentageMag() {
        return pourcentageMag;
    }

    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
    }

    public int getDegMag() {
        return degMag;
    }

    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

}
