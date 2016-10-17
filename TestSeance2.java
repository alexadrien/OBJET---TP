/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;


/**
 *
 * @author Arthur
 */
public class TestSeance2 {
    
    public static World monde;
    
    public static void main(String[] args)
    {
        
        monde = new World();
        monde.creeMondeAlea();
        monde.afficheGraph();
        while(true){
            monde.tourDeJeu();
        }
        //monde.affiche();
        
    }
}
