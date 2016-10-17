/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;


/** Classe qui gère le plateau. On gère grace à cette classe le plateau avec tous les personnages dessus.
 *
 * @author Arthur
 */
public class World {
    
    public ArrayList<Personnage> personnages;
    public ArrayList<Monstre> monstres;
    public LinkedList<Potion> potions;
    public final int tailleMonde;
    public Joueur joueur;
    
    /** Constructeur de la classe, on y crée tous les personnages
     *
     */
    public World(){
        joueur = new Joueur();
        personnages = new ArrayList<>();
        monstres = new ArrayList<>();
        potions = new LinkedList<>();
        tailleMonde = 30;
    }
    
    /** Creation d'un monde de manière aléatoire. On place les personnages de manière aléatoire.
     *
     */
    public void creeMondeAlea(){
        Random rand = new Random();
        int nbArcher = rand.nextInt(10)+1;
        int nbPaysan = rand.nextInt(10)+1;
        int nbLapin = rand.nextInt(10)+1;
        int nbGuerrier = rand.nextInt(10)+1;
        int nbLoup = rand.nextInt(10)+1;
        int nbPotion = rand.nextInt(5)+1;
        
        for (int i=0; i<nbArcher; i++){
            personnages.add(Archer.archerRand());
            personnages.get(i).setNom("Archer" + i);
            personnages.get(i).setPos(new Point2D(-5,-5));
        }
        for (int i=0; i<nbPaysan; i++){
            personnages.add(Paysan.paysanRand());
            personnages.get(i+nbArcher).setNom("Paysan" + i);
            personnages.get(i+nbArcher).setPos(new Point2D(-5,-5));
        }
        for (int i=0; i<nbLapin; i++){
            monstres.add(new Lapin("Lapin" + i, 0,0,0,0,0,new Point2D(-5,-5)));
        }
        for (int i=0; i<nbGuerrier; i++){
            personnages.add(Guerrier.guerrierRand());
            personnages.get(i+nbArcher+nbPaysan).setNom("Guerrier" + i);
            personnages.get(i+nbArcher+nbPaysan).setPos(new Point2D(-5,-5));
        }
        for (int i=0; i<nbLoup; i++){
            monstres.add(new Loup("Loup" + i, 0,0,0,0,0,new Point2D(-5,-5)));
        }
        
        Point2D newPos = new Point2D(rand.nextInt(tailleMonde), rand.nextInt(tailleMonde));
        joueur.getPerso().setPos(newPos);
        for (Personnage perso : personnages){
            newPos.setPosition(rand.nextInt(tailleMonde), rand.nextInt(tailleMonde));
            while(!isGood(newPos)){
                newPos.setPosition(rand.nextInt(tailleMonde), rand.nextInt(tailleMonde));
            }
            perso.setPos(newPos);
        }
        for (Monstre monstre : monstres){
            newPos.setPosition(rand.nextInt(tailleMonde), rand.nextInt(tailleMonde));
            while(!isGood(newPos)){
                newPos.setPosition(rand.nextInt(tailleMonde), rand.nextInt(tailleMonde));
            }
            monstre.setPos(newPos);
        }
        
        for (int i=0; i<nbPotion; i++){
            newPos.setPosition(rand.nextInt(tailleMonde), rand.nextInt(tailleMonde));
            while(!isFree(newPos)){
                newPos.setPosition(rand.nextInt(tailleMonde), rand.nextInt(tailleMonde));
            }
            potions.add(new Soin(rand.nextInt(50), newPos));
        }
    }
    
    /** Affichage de la position de tous les personnages
     *
     */
    public void affiche(){
        System.out.println(joueur.getPerso().nom + " est en: (" + joueur.getPerso().getPos().getX() + "," + joueur.getPerso().getPos().getY() + ")");
        for (Personnage perso : personnages) {
            System.out.println(perso.nom + " est en: (" + perso.getPos().getX() + "," + perso.getPos().getY() + ")");
        }
        for (Monstre monstre : monstres) {
            System.out.println(monstre.nom + " est en: (" + monstre.getPos().getX() + "," + monstre.getPos().getY() + ")");
        }
        for (Potion potion : potions) {
            System.out.println("Il y a une potion en: (" + potion.getPos().getX() + "," + potion.getPos().getY() + ")");
        }
    }
    /** Affichage de la position de tous les personnages
     *
     */
    public void afficheGraph(){
        String[][] mat = new String[50][50];
        for (int x = 0; x<50; x++){
            for (int y=0; y<50; y++){
                mat[x][y] = "_";
            }
        }
        mat[joueur.getPerso().getPos().getX()][joueur.getPerso().getPos().getY()] = "\u001B[31m" + "J" + "\u001B[0m";
        for (Personnage perso : personnages) {
            if (perso.getPos().getX()<tailleMonde && perso.getPos().getX()>0 && perso.getPos().getY()<tailleMonde && perso.getPos().getY()>0){
                if (perso.getClass().equals(Archer.class)){
                    mat[perso.getPos().getX()][perso.getPos().getY()] = "A";
                }
                else if (perso.getClass().equals(Guerrier.class)){
                    mat[perso.getPos().getX()][perso.getPos().getY()] = "G";
                }
                else if (perso.getClass().equals(Paysan.class)){
                    mat[perso.getPos().getX()][perso.getPos().getY()] = "P";
                }
                else if (perso.getClass().equals(Mage.class)){
                    mat[perso.getPos().getX()][perso.getPos().getY()] = "M";
                }
            }
        }
        for (Monstre monstre : monstres) {
            if (monstre.getPos().getX()<tailleMonde && monstre.getPos().getX()>0 && monstre.getPos().getY()<tailleMonde && monstre.getPos().getY()>0){
                if (monstre.getClass().equals(Loup.class)){
                    mat[monstre.getPos().getX()][monstre.getPos().getY()] = "L";
                }
                else if (monstre.getClass().equals(Lapin.class)){
                    mat[monstre.getPos().getX()][monstre.getPos().getY()] = "l";
                }
            }
        }
        for (Potion potion : potions) {
            if (potion.getPos().getX()<tailleMonde && potion.getPos().getX()>0 && potion.getPos().getY()<tailleMonde && potion.getPos().getY()>0){
                mat[potion.getPos().getX()][potion.getPos().getY()] = "p";
            }
        }
        for (int y = 0; y<tailleMonde; y++){
            for (int x=0; x<tailleMonde; x++){
                System.out.print(mat[x][tailleMonde-1-y]+" ");
            }
            System.out.println();
        }
    }
    
    
    /** Fonction qui vérifie si la case sur laquel on pointe est libre et si il n'y a personne à moins de 3 cases
     *
     * @param pos Position que l'on veut tester
     * @return renvoie un booléen pour savoir si la case est libre et si il n'y a personne à moins de 3 cases
     */
    public boolean isGood(Point2D pos){
        boolean isFree = isFree(pos);
        boolean isGood = (joueur.getPerso().getPos().distance(pos) > 3);
        for (Personnage perso : personnages) {
            isGood = isGood && (perso.getPos().distance(pos) > 3);
        }
        for (Monstre monstre : monstres) {
            isGood = isGood && (monstre.getPos().distance(pos) > 3);
        }
        return isGood && isFree;
    }
    
    /** Fonction qui vérifie si la case sur laquel on pointe est libre
     *
     * @param pos Position que l'on veut tester
     * @return renvoie un booléen pour savoir si la case est libre
     */
    public boolean isFree(Point2D pos){
        boolean isFree = !pos.equals(joueur.getPerso().getPos());
        for (Personnage perso : personnages) {
            isFree = isFree && !pos.equals(perso.getPos());
        }
        for (Monstre monstre : monstres) {
            isFree = isFree && !pos.equals(monstre.getPos());
        }
        isFree = isFree && pos.getX()>0 && pos.getX()<tailleMonde && pos.getY()>0 && pos.getY()<tailleMonde;
        return isFree;
    }
    
    public void checkPotion(Personnage perso){
        for (Potion potion: potions){
            if (potion.getPos().equals(perso.getPos()))
            {
                potion.estPris(perso);
                System.out.println(perso.nom + " vient de prendre une potion!");
                perso.affiche();
                potions.remove(potion);
            }
        }
    }
    
    public void tourDeJeu(){
        joueur.jouer();
        checkPotion(joueur.getPerso());
        for(Personnage personnage: personnages){
            personnage.deplacer();
            checkPotion(personnage);
        }
        afficheGraph();
    }
    
}
