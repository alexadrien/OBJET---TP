/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/** Potion qui ajoute du Mana à un personnage
 *
 * @author Arthur
 */
public class Mana extends Potion {
    
    private int pointMana;

    /**
     *
     * @param pointMana Nombre de point de Mana qu'apporte la potion
     * @param pos Position de la potion
     */
    public Mana(int pointMana, Point2D pos) {
        super(pos);
        this.pointMana = pointMana;
    }
    
    public Mana() {
        super();
        this.pointMana = 0;
    }

    public int getPointMana() {
        return pointMana;
    }

    public void setPointMana(int pointMana) {
        this.pointMana = pointMana;
    }

    /**Fonction qui fait prendre la potion au personnage
     *
     * @param perso Personnage qui prend la potion
     */
    public void estPris(Personnage perso){
        perso.setPtMana(perso.getPtMana() + pointMana);
    }
    
}
