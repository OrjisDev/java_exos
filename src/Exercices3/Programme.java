package Exercices3;

public class Programme {
    public static void main(String[] args){
    CompteBancaire compte1 = new CompteBancaire(5,66);
    CompteBancaire compte2 = new CompteBancaire(6,34);
    compte2.virement(34,compte1);
    System.out.println(compte1.argentCompte);
    System.out.println(compte2.argentCompte);
    }
}
