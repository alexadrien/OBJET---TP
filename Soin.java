/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/** Potion qui ajoute de la Vie à un personnage
 *
 * @author Arthur
 */
public class Soin extends Potion {
    
    private int pointSoin;

    /**
     *
     * @param pointSoin Nombre de point de Soin qu'apporte la potion
     * @param pos Position de la potion
     */
    public Soin(int pointSoin, Point2D pos) {
        super(pos);
        this.pointSoin = pointSoin;
    }
    
    public Soin() {
        super();
        this.pointSoin = 0;
    }

    public int getPointSoin() {
        return pointSoin;
    }

    public void setPointSoin(int pointSoin) {
        this.pointSoin = pointSoin;
    }

    /**Fonction qui fait prendre la potion au personnage
     *
     * @param perso Personnage qui prend la potion
     */
    @Override
    public void estPris(Personnage perso){
        perso.setPtVie(perso.getPtVie() + pointSoin);
    }
    
}
