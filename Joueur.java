/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Arthur
 */
public class Joueur {
    
    private Personnage perso;
    
    public Joueur(){
        perso = choosePerso();
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }
    
    private Personnage choosePerso(){
        Scanner user_input = new Scanner(System.in);
        System.out.print("Quelle type de personnage voulez vous?.. ");
        String typePerso;
        boolean ok = false;
        while(!ok){
            ok=true;
            //typePerso = user_input.next();
            typePerso = "Guerrier";
            switch(typePerso){
                case "Guerrier":
                    perso = Guerrier.guerrierRand();
                    break;
                case "Archer":
                    perso = Archer.archerRand();
                    break;
                case "Mage":
                    perso = Mage.mageRand();
                    break;
                case "Paysan":
                    perso = Paysan.paysanRand();
                    break;
                default:
                    System.out.println("Vous n'avez pas rentrer un bon type parmis Guerrier, Archer, Mage, Paysan");
                    ok=false;
                    break;
            }
        }
        
        System.out.print("Quelle nom de personnage voulez vous?.. ");
        //perso.nom = user_input.next();
        perso.nom = "Acube";
        perso.affiche();
        return perso;
    }
    
    public void seDeplace(){
        Scanner user_input = new Scanner(System.in);
        System.out.print("Déplacez vous en utilisant Z Q S D ou 0 puis Entrer: ");
        String choix;
        Point2D pos = new Point2D();
        boolean ok = false;
        while(!ok){
            ok=true;
            choix = user_input.next();
            pos = perso.getPos();
            switch(choix){
                case "z":
                    pos.translate(0,1);
                    break;
                case "q":
                    pos.translate(-1,0);
                    break;
                case "s":
                    pos.translate(0,-1);
                    break;
                case "d":
                    pos.translate(1,0);
                    break;
                case "0":
                    break;
                case "x":
                    throw new NumberFormatException();
                default:
                    System.out.println("Vous n'avez pas rentrer un déplacement correcte z,q,s,d");
                    ok=false;
                    break;
            }
            if(!pos.equals(perso.getPos()) && !TestSeance2.monde.isFree(pos)){
                ok=false;
                System.out.println("La case où vous voulez aller est occupée, réessayez!");
            }
        }
        perso.pos.setPosition(pos.getX(), pos.getY());
    }
    
    public ArrayList<Creature> peutCombattre(){
        ArrayList<Creature> listeProx = new ArrayList<>();
        for (Personnage personnage:TestSeance2.monde.personnages){
            if (personnage.getPos().distance(this.perso.getPos()) <= this.perso.distAttMax){
                listeProx.add(personnage);
            }
        }
        for (Monstre monstre:TestSeance2.monde.monstres){
            if (monstre.getPos().distance(this.perso.getPos()) <= this.perso.distAttMax){
                listeProx.add(monstre);
            }
        }
        return listeProx;
    }
    
    public void jouer(){
        Scanner user_input = new Scanner(System.in);
        ArrayList<Creature> listeProx = peutCombattre();
        if (listeProx.isEmpty()){
            System.out.println("Vous ne pouvez attaquer personne");
            seDeplace();
        }
        else{
            System.out.println("Vous pouvez attaquer:");
            int i=1;
            for (Creature creature: listeProx){
                System.out.println(i + ". " + creature.nom);
                i++;
            }
            System.out.println("\n0. Ou vous pouvez vous déplacer\nVotre choix?..");
            String choix = user_input.next();
            switch(choix){
                case "0":
                    seDeplace();
                    break;
                default:
                    this.perso.combattre(listeProx.get(Integer.parseInt(choix)-1));
                    if (listeProx.get(Integer.parseInt(choix)-1).ptVie <= 0){
                        if (TestSeance2.monde.personnages.contains(listeProx.get(Integer.parseInt(choix)-1))){
                            TestSeance2.monde.personnages.remove(listeProx.get(Integer.parseInt(choix)-1));
                        }
                        else if (TestSeance2.monde.monstres.contains(listeProx.get(Integer.parseInt(choix)-1))){
                            TestSeance2.monde.monstres.remove(listeProx.get(Integer.parseInt(choix)-1));
                        }
                    }
            }
        }
    }
    
}
