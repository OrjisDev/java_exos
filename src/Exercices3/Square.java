package Exercices3;

import Exercices3.Rectangle;

public class Square extends Rectangle {
    Square(double longeur, double largeur) {
        super(longeur, largeur);
    }

    @Override
    public double calculSurface() {
        return longeur*longeur;
    }
}
