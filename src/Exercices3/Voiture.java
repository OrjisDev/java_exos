package Exercices3;

public class Voiture {
    private String marque;
    private String couleur;
    private int vitesse;

    Voiture(String marque, String couleur, int vitesse){
        this.marque = marque;
        this.couleur = couleur;
        this.vitesse = vitesse;
    }

    public void addVitesse(int newVitesse){
        vitesse = newVitesse;
    }

    public double calculDistance(double temps){
        //Entrée : Temps en H
        //Sortie : Distance en KM
        return (vitesse*temps);
    }

}

