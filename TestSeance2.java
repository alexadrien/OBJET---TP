/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Scanner;


/**
 *
 * @author Arthur
 */
public class TestSeance2 {
    
    public static World monde;
    
    public static void main(String[] args)
    {
        Scanner user_input = new Scanner(System.in);
        System.out.println("Voulez-vous charger une partie? (o,n)");
        String rep = user_input.next();
        if (rep.equals("o"))
        {
            System.out.println("Nom du fichier.. ");
            rep = user_input.next();
            ChargementPartie chrgt = new ChargementPartie(rep);
            monde = chrgt.chargerPartie();
        }
        else
        {
            monde = new World();
            monde.creeMondeAlea();
        }
        monde.afficheGraph();
        //SauvegardePartie save = new SauvegardePartie("test.a");
        //save.sauvegarderPartie(monde);
        boolean notQuit = true;
        while(notQuit){
            notQuit = monde.tourDeJeu();
        }
        System.out.println("Fin de la partie");
        
    }
}
