package Exercices3;

public class Utilisateur {
    private String prenom;
    private String nom;
    private int age;
    private String metier;

    Utilisateur(String prenom, String nom, int age, String metier){
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.metier = metier;
    }

    public String getPrenom(){
        return prenom;
    }

    public String presentation(){
        return "Bonjour je suis "+prenom+" "+nom+" j'ai "+age+" ans mon métier est "+metier+".";
    }

}
