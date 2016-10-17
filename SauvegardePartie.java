/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
            writer.write("hey!");
        } catch (IOException ex) {
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
    
}
