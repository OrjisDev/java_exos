package Exercices3;

public class Rectangle {

    public double longeur;
    public double largeur;

    Rectangle(double longeur, double largeur){
        this.longeur = longeur;
        this.largeur = largeur;
    }

    public double calculSurface(){
        return  longeur*largeur;
    }

    public double hypotenuse(){
        return Math.sqrt((longeur*longeur)+(largeur*largeur));
    }

}
