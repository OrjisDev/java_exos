package Exercices3;

public class Client {
    String prenom;
    String nom;
    int age;
    long[] idsBanque;

    Client(String prenom, String nom, int age, long[] idsBanque){
        this.age = age;
        this.nom = nom;
        this.prenom = prenom;
        this.idsBanque = idsBanque;
    }
    public String getInfos(){
        return prenom+" "+nom+" "+age+" ans";
    }
    public long[] getIdsBanque(){
        return idsBanque;
    }
}
