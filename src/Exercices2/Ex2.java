package Exercices2;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Ex2 {
    public static void main(String[] args){
        //
        System.out.println("\n\rExercice 1 :");
        System.out.println("Insère une phrase : ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] mots = input.split("\\s+");
        int nbmots = mots.length;
        System.out.println("Il y a : "+ nbmots+" mots dans ta phrase !");
        //
        System.out.println("\n\rExercice 2:");
        System.out.println("Saisis ce que tu veux : ");
        String content = sc.nextLine();

        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write(content);
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        //
        System.out.println("\n\rExercice 3 :");
        String path = sc.nextLine();
        String output = "";
        try{
            FileReader reader = new FileReader(path);
            int data = reader.read();
            while (data != -1){
                System.out.print((char)data);
                output = output + ((char)data);
                data = reader.read();
            }
            reader.close();
            System.out.println(output);
            String[] words = output.split("\\s+");
            int nbm = words.length;
            System.out.println("Il y a : "+ nbm+" mots dans ton fichier");

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }


        //


    }
}
