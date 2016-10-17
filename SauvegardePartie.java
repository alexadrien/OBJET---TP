/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arthur
 */
public class SauvegardePartie {
    
    private String nomFichier;
    private BufferedWriter writer;
    
    public SauvegardePartie(String nomFichier){
        this.nomFichier = nomFichier;
        writer = null;
    }
    
    public void sauvegarderPartie(World monde){
        try {
            writer = new BufferedWriter(new FileWriter(nomFichier));
            writer.write(monde.tailleMonde+"");
            writer.newLine();
            writer.write("Joueur ");
            writer.write(monde.joueur.getPerso().getClass().getSimpleName() + " ");
           
            Class classe = monde.joueur.getPerso().getClass();
            while(classe.getSuperclass()!=null){
                for (Field field: classe.getDeclaredFields()){
                    field.setAccessible(true);
                    if (field.get(monde.joueur.getPerso()).getClass().equals(Point2D.class)){
                        writer.write(((Point2D)field.get(monde.joueur.getPerso())).getX()+ " " + ((Point2D)field.get(monde.joueur.getPerso())).getY());
                    }
                    else{
                        writer.write(field.get(monde.joueur.getPerso()).toString()+" ");
                    }
                }
                classe = classe.getSuperclass();
            }
            for (Personnage perso : monde.personnages){
                writer.newLine();
                writer.write(getStringObj(perso));
            }
            for (Monstre monstre : monde.monstres){
                writer.newLine();
                writer.write(getStringObj(monstre));
            }
            for (Potion potion : monde.potions){
                writer.newLine();
                writer.write(getStringObj(potion));
            }
        } catch (IOException ex) {
            Logger.getLogger(SauvegardePartie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SauvegardePartie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SauvegardePartie.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if (writer!=null){
                    writer.flush();
                    writer.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SauvegardePartie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private String getStringObj(Object obj)
    {
        String s = "";
        s = s + obj.getClass().getSimpleName() + " ";
        Class classe = obj.getClass();
        while(classe.getSuperclass()!=null){
            for (Field field: classe.getDeclaredFields()){
                try {
                    field.setAccessible(true);
                    if (field.get(obj).getClass().equals(Point2D.class)){
                        s = s + ((Point2D)field.get(obj)).getX()+ " " + ((Point2D)field.get(obj)).getY();
                    }
                    else{
                        s = s + field.get(obj).toString() + " ";
                    }
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(SauvegardePartie.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(SauvegardePartie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            classe = classe.getSuperclass();
        }
        return s;
    }
}
