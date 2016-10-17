/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/** Creature, la super classe de toute les supers classes, celle qui gère tous les êtres qui bougent, ou qui ne bouge plus quand ils sont morts d'ailleurs... Non ce n'est pas triste, c'est WoE ! 
 *
 * @author Arthur
 */
public abstract class Creature implements Deplacable {
    
    //Attributs
    
    protected String nom;
    protected int ptVie;
    protected int pourcentageAtt;
    protected int pourcentagePar;
    protected int ptPar;
    protected int degAtt;
    protected Point2D pos;
    
    //Constructeurs
    
    /**Constructeur de Creature
     *
     * @param nom Nom
     * @param ptV Point de vie
     * @param pA Pourcentage d'attaque
     * @param pP Pourcentage de parade
     * @param dA Dégats d'attaque
     * @param ptPar Points de parade
     * @param pos Position
     */
    public Creature(String nom, int ptV, int pA, int pP, int dA, int ptPar, Point2D pos){
        this.nom = nom;
        this.ptVie = ptV;
        this.pourcentageAtt = pA;
        this.pourcentagePar = pP;
        this.degAtt = dA;
        this.ptPar = ptPar;
        this.pos = new Point2D(pos);
    }
    
    public Creature(Creature perso){
        this(perso.nom, perso.ptVie, perso.pourcentageAtt, perso.pourcentagePar, perso.degAtt, perso.ptPar, perso.pos);
    }
    
    public Creature(){
        this("",0,0,0,0,0,new Point2D());
    }
    
    //Getteurs / Setteurs
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    public int getPourcentagePar() {
        return pourcentagePar;
    }

    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }
    
    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }
    
    // Méthodes

    /**Fonction pour déplacer les créatures automatiquement
     *
     */
    
    @Override
    public void deplacer(){
        Random rand = new Random();
        Point2D newPos = new Point2D(this.pos.getX() + rand.nextInt(3)-1, this.pos.getY() + rand.nextInt(3)-1);
        while (!TestSeance2.monde.isFree(newPos)){
            newPos = new Point2D(this.pos.getX() + rand.nextInt(3)-1, this.pos.getY() + rand.nextInt(3)-1);
            newPos.setPosition(this.pos.getX() + rand.nextInt(3)-1, this.pos.getY() + rand.nextInt(3)-1); //Si la case n'est pas libre la créature cherche une autre position
        }
        this.pos.setPosition(newPos.getX(), newPos.getY());
        
        //On considère qu'une créature peut (et doit) se déplacer vers toutes les cases qui l'entourent et ceci de manière aléatoire.
    }
    
    public void affiche(){
        System.out.println(this.nom + ":\n" + " Points de Vie: " + this.ptVie + "\n" + " Position: (" + this.pos.getX() + "," + this.pos.getY() + ")");
    }
    
    public boolean lancerDe(int pourcentage){
        Random rand = new Random();
        return (rand.nextInt(100) + 1 <= pourcentage);
    }
    
    public void combattre(Creature adversaire){
        float d = this.getPos().distance(adversaire.getPos());
        if (d == 1){
            //Corps à corps
            if (this.lancerDe(this.pourcentageAtt)){
                System.out.println("Attaque réussie");
                if (adversaire.lancerDe(adversaire.pourcentagePar)){
                    adversaire.ptVie -= this.degAtt - adversaire.ptPar;
                    adversaire.ptVie = Math.max(0, adversaire.ptVie);
                }
                else{
                    adversaire.ptVie -= this.degAtt;
                    adversaire.ptVie = Math.max(0, adversaire.ptVie);
                }
            }
            else{
                System.out.println("Attaque ratée");
            }
        }
        else{
            System.out.println("Je ne peux pas attaquer si loin!");
        }
    }
    
}
