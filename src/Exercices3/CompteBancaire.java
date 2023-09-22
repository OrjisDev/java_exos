package Exercices3;

public class CompteBancaire {
    long idBanque;
    double argentCompte;

    CompteBancaire(long idBanque, double argentCompte){
        this.idBanque = idBanque;
        this.argentCompte = argentCompte;
    }

    public double consulterArgent(){
        return argentCompte;
    }

    public String depot(double sommeDeposee){
        argentCompte = argentCompte + sommeDeposee;
        return sommeDeposee + "€ ont bien étés déposés sur le compte !";
    }
    public String retrait(double sommeRetiree){
        if(argentCompte - sommeRetiree >= 0){
            argentCompte = argentCompte - sommeRetiree;
            return sommeRetiree + "€ ont bien étés retirés de votre compte !";
        }
        else{
            return "Vous n'avez pas les fonds nécessaires pour effectuer cette action";
        }
    }

    public String virement(double sommeVersee, CompteBancaire compteBeneficiaire){
        if(argentCompte - sommeVersee >= 0){
            argentCompte = argentCompte - sommeVersee;
            return compteBeneficiaire.depot(sommeVersee);

        }
        else{
            return "Vous n'avez pas les fonds nécessaires pour effectuer cette action";
        }
    }

}
