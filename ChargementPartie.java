/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arthur
 */
public class ChargementPartie {
    
    private String nomFichier;
    private BufferedReader reader;
    
    public ChargementPartie(String nomFichier){
        this.nomFichier = nomFichier;
        this.reader = null;
    }
    
    public World chargerPartie(){
        String ligne = "";
        World monde = null;
        try {
            reader = new BufferedReader(new FileReader(nomFichier));
            monde = new World(Integer.parseInt(reader.readLine()));
            ligne = reader.readLine();
            while (ligne != null){
                traiteLigne(ligne, monde);
                ligne = reader.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChargementPartie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChargementPartie.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(ChargementPartie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return monde;
    }
    
    public void traiteLigne(String ligne, World monde){
        StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
        String type = "";
        Class classe = null;
        Object value = null;
        type = tokenizer.nextToken();
        if (type.toLowerCase().equals("joueur")){
            type = tokenizer.nextToken();
            try {
                classe = Class.forName("org.centrale.projet.objet."+type);
                Personnage elmt = (Personnage) classe.newInstance();
                while(tokenizer.hasMoreTokens()) {
                    while(classe.getSuperclass() != null){
                        for (Field field: classe.getDeclaredFields()){
                            field.setAccessible(true);
                            if (field.get(elmt).getClass().equals(Point2D.class)){
                                int x = Integer.parseInt(tokenizer.nextToken());
                                int y = Integer.parseInt(tokenizer.nextToken());
                                value = new Point2D(x,y);
                            }
                            else{
                                String token = tokenizer.nextToken();
                                try{
                                    value = Integer.parseInt(token);
                                } catch (NumberFormatException ex){
                                    value = token;
                                }
                            }
                            field.set(elmt, value);
                        }
                        classe = classe.getSuperclass();
                    }
                }
                monde.joueur.setPerso(elmt);

            } catch (InstantiationException ex) {
                Logger.getLogger(ChargementPartie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ChargementPartie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChargementPartie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                classe = Class.forName("org.centrale.projet.objet."+type);
                ElementDeJeu elmt = (ElementDeJeu) classe.newInstance();
                if (elmt instanceof Personnage){
                    elmt = (Personnage) classe.newInstance();
                }
                else if (elmt instanceof Monstre){
                    elmt = (Monstre) classe.newInstance();
                }
                else if (elmt instanceof NuageToxique){
                    elmt = (NuageToxique) classe.newInstance();
                }
                else if (elmt instanceof Potion){
                    elmt = (Potion) classe.newInstance();
                }
                else {
                    elmt = (ElementDeJeu) classe.newInstance();
                }
                while(tokenizer.hasMoreTokens()) {
                    while(classe.getSuperclass() != null){
                        for (Field field: classe.getDeclaredFields()){
                            field.setAccessible(true);
                            if (field.get(elmt).getClass().equals(Point2D.class)){
                                int x = Integer.parseInt(tokenizer.nextToken());
                                int y = Integer.parseInt(tokenizer.nextToken());
                                value = new Point2D(x,y);
                            }
                            else{
                                String token = tokenizer.nextToken();
                                try{
                                    value = Integer.parseInt(token);
                                } catch (NumberFormatException ex){
                                    value = token;
                                }
                            }
                            field.set(elmt, value);
                        }
                        classe = classe.getSuperclass();
                    }
                    if (elmt instanceof Personnage)
                    {
                        monde.personnages.add((Personnage) elmt);
                    }
                    else if (elmt instanceof Monstre)
                    {
                        monde.monstres.add((Monstre) elmt);
                    }
                    else if (elmt instanceof NuageToxique)
                    {
                        monde.nuagesToxiques.add((NuageToxique) elmt);
                    }
                    else if (elmt instanceof Potion)
                    {
                        monde.potions.add((Potion) elmt);
                    }
                }

            } catch (InstantiationException ex) {
                Logger.getLogger(ChargementPartie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ChargementPartie.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ChargementPartie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
