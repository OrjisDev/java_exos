package Exercices3;

public class Ex3 {
    public static void main(String[] args){
        Utilisateur user = new Utilisateur("John","Cena",46,"Catcheur");
        System.out.println(user.presentation());
        Voiture voiture = new Voiture("Mercedes","Rouge",120);
        voiture.addVitesse(130);
        System.out.println(voiture.calculDistance(1.5));
        Rectangle rect = new Rectangle(2.8,2.1);
        System.out.println(rect.hypotenuse());
    }
}
