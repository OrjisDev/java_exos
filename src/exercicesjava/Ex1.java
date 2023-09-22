package exercicesjava;

import java.util.Random;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args){
        //
        System.out.println("Exercice 1 : \n\r");
        String test = "Bonjour tout le monde !";
        System.out.println(test);
        String reverse = "";
        for (int i = 0; i < test.length(); i++) {
            reverse = reverse + test.charAt(test.length() - 1 - i);
        }
        System.out.println(reverse);
        //
        System.out.println("\n\rExercice 2 : ");
        String output = "";
        int largeur = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un caractère :");
        String str = sc.nextLine();
        System.out.println("Entre une hauteur : ");
        int hauteur = sc.nextInt();
        System.out.println("Ton charactère est : "+str+" et ta hauteur est : "+hauteur);
        while (hauteur>0){
            String line = "\n\r";
            for(int y = hauteur-1; y>0; y-- ){
                line = line + " ";
            }
            for(int i = largeur; i>0; i--){
                line = line + str;
            }
            largeur = largeur +2;
            output = output + line;
            hauteur--;
        }
        System.out.println(output);
        //
        System.out.println("\n\rExercice 3 : ");
        System.out.println("La somme des nombres de 1 à 10 000 est de : " + (10000*(10000+1))/2);
        //
        System.out.println("\n\rExercice 4 :");
        System.out.println("Entrez un nombre : ");
        int nbr = sc.nextInt();
        if (nbr%2 != 0){
            System.out.println("Le nombre "+nbr+" est impair");
        }
        else{
            System.out.println("Le nombre "+nbr+" est pair");
        }
        //
        System.out.println("\n\rExercice 5:");
        Random rnd = new Random();
        int rng = rnd.nextInt(100);
        System.out.println("Trouve le nombre entre 0 et 100");
        int guess = -1;
        int tentatives =0;
        while(guess != rng){
            guess = sc.nextInt();
            if(guess < rng){
                System.out.println("Trop Petit !");
            }
            if(guess > rng){
                System.out.println("Trop Grand !");
            }
            tentatives++;
        }
        System.out.println("Bravo, tu as trouvé en "+tentatives+" tentatives !");
        //
    }
}
