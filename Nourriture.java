/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe abstraire Nourriture qui rassemble tout ce qui se mange
 *
 * @author Acube
 */
public class Nourriture extends Objet {

    protected String nom;
    protected int intensite;
    protected String attributTouche;
    protected boolean bienoumal;
    protected int duree;

    public Nourriture(String nom, int intensite, String attributTouche, boolean bienoumal, int duree, Point2D pos) {
        this.nom = nom;
        this.intensite = intensite;
        this.attributTouche = attributTouche;
        this.bienoumal = bienoumal;
        this.duree = duree;
        this.pos = pos;
    }

    public void avaler(Creature c) throws IllegalArgumentException, IllegalAccessException, SecurityException {
        try {
            System.out.println(c.getNom().concat(" vient d'avaler ").concat(this.nom));
            Class cls = c.getClass();
            Class supercls = cls.getSuperclass();
            Class supersupercls = supercls.getSuperclass();

            Field monfield = supersupercls.getDeclaredField(this.attributTouche);
            Object attribut = monfield.get(c);
            String mot = "";
            if (bienoumal && attribut.getClass().getTypeName().equals("java.lang.Integer")) {
                //ajout
                attribut = (int) attribut + this.intensite;
                monfield.set(c, attribut);
                mot = "gagné ";

            } else if (attribut.getClass().getTypeName().equals("java.lang.Integer")) {
                //retranche
                attribut = (int) attribut - this.intensite;
                monfield.set(c, attribut);

                mot = "perdu ";
            }
            System.out.println(c.getNom().concat(" a ").concat(mot).concat(Integer.toString(this.intensite)).concat(" unité(s) de ").concat(this.attributTouche).concat(" grace à ").concat(this.nom));
        } catch (NoSuchFieldException ex) {
            Class cls = c.getClass();
            Class supercls = cls.getSuperclass();
            Class supersupercls = supercls.getSuperclass();

            Field monfield;
            try {
                monfield = supercls.getDeclaredField(this.attributTouche);
                Object attribut = monfield.get(c);
                String mot = "";
                if (bienoumal && attribut.getClass().getTypeName().equals("java.lang.Integer")) {
                    //ajout
                    attribut = (int) attribut + this.intensite;
                    monfield.set(c, attribut);
                    mot = "gagné ";

                } else if (attribut.getClass().getTypeName().equals("java.lang.Integer")) {
                    //retranche
                    attribut = (int) attribut - this.intensite;
                    monfield.set(c, attribut);

                    mot = "perdu ";
                }
                System.out.println(c.getNom().concat(" a ").concat(mot).concat(Integer.toString(this.intensite)).concat(" unité(s) de ").concat(this.attributTouche).concat(" grace à ").concat(this.nom));
            } catch (NoSuchFieldException ex1) {
                Logger.getLogger(Nourriture.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public void annuler(Creature c) throws IllegalArgumentException, IllegalAccessException, SecurityException {
        System.out.println(c.getNom().concat(" ne ressent plus les effets causées par ").concat(this.nom));
        try {
            Class cls = c.getClass();
            Class supercls = cls.getSuperclass();
            Class supersupercls = supercls.getSuperclass();

            Field monfield = supersupercls.getDeclaredField(this.attributTouche);
            Object attribut = monfield.get(c);
            String mot = "";
            if (bienoumal && attribut.getClass().getTypeName().equals("java.lang.Integer")) {
                //ajout
                attribut = (int) attribut + this.intensite;
                monfield.set(c, attribut);
                mot = "gagné ";

            } else if (attribut.getClass().getTypeName().equals("java.lang.Integer")) {
                //retranche
                attribut = (int) attribut - this.intensite;
                monfield.set(c, attribut);
                mot = "perdu ";
            }
        } catch (NoSuchFieldException ex) {
            Class cls = c.getClass();
            Class supercls = cls.getSuperclass();
            Class supersupercls = supercls.getSuperclass();

            Field monfield;
            try {
                monfield = supercls.getDeclaredField(this.attributTouche);
                Object attribut = monfield.get(c);
                String mot = "";
                if (bienoumal && attribut.getClass().getTypeName().equals("java.lang.Integer")) {
                    //ajout
                    attribut = (int) attribut + this.intensite;
                    monfield.set(c, attribut);
                    mot = "gagné ";

                } else if (attribut.getClass().getTypeName().equals("java.lang.Integer")) {
                    //retranche
                    attribut = (int) attribut - this.intensite;
                    monfield.set(c, attribut);
                    mot = "perdu ";
                }
            } catch (NoSuchFieldException ex1) {
                Logger.getLogger(Nourriture.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

}
