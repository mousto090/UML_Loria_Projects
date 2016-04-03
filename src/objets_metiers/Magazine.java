package objets_metiers;

import BibalExceptions.ChampsControlExceptions;

public class Magazine extends Oeuvre {

    private int lending;

    public Magazine() {
    }
    
    public Magazine(String titre, String auteur, String categorie, int lending) {
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.lending = lending;
        this.nbResa = 0;
    }
    
    public Magazine(int id, String titre, String auteur, String categorie, int lending) {
        this(titre, auteur, categorie, lending);
        this.id = id;
        this.nbResa = 0;
    }

    public int getLending() {
        return this.lending;
    }

    public void setLending(int lending) throws ChampsControlExceptions {
        if (lending < 30) {
            throw new ChampsControlExceptions("La durée d'emprunt des Magazines "
                    + "doit être superieure ou égale à 30 jours");
        }
        this.lending = lending;
    }

    @Override
    public String toString() {
        return "MAGAZINE{" + super.toString() + "lending=" + lending + '}';
    }
    
    
}
