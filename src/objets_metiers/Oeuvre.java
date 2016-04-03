package objets_metiers;

import BibalExceptions.ChampsControlExceptions;
import java.util.Vector;

public abstract class Oeuvre {

    protected int id;
    protected String titre;
    protected String auteur;
    protected String categorie;
    protected int nbResa;
    protected Vector<Examplaire> examplairesOeuvre = new Vector<>();
    protected Vector<Reservation> reservationsOeuvre = new Vector<>();

    public void ajouter(Oeuvre oeuvre) {
        throw new UnsupportedOperationException();
    }

    public Oeuvre find(String titre) {
        throw new UnsupportedOperationException();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws ChampsControlExceptions {
        if (id <= 0) {
            throw new ChampsControlExceptions("Identifiant Oeuvre non valide !");
        }
        this.id = id;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setCategorie(String categorie) throws ChampsControlExceptions {
        if (null != categorie) {
            if (categorie.length() < 3) {
                throw new ChampsControlExceptions("Le nom de la catégorie doit contenir "
                        + "au moins 3 caractères");
            }
        } else {
            throw new ChampsControlExceptions("Merci de saisir une catégorie ");
        }
        this.categorie = categorie;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public void setAuteur(String auteur) throws ChampsControlExceptions {
        if (null != auteur) {
            if (auteur.length() < 3) {
                throw new ChampsControlExceptions("Le nom de l'auteur doit avoir "
                        + "au moins 3 caractères");
            }
        } else {
            throw new ChampsControlExceptions("Merci de saisir un nom ");
        }
        this.auteur = auteur;
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) throws ChampsControlExceptions {
        if (null != titre) {
            if (titre.length() < 3) {
                throw new ChampsControlExceptions("Le titre doit avoir "
                        + "au moins 3 caractères");
            }
        } else {
            throw new ChampsControlExceptions("Merci de saisir le titre de l'oeuvre ");
        }
        this.titre = titre;
    }

    public int getNbResa() {
        return this.nbResa;
    }

    public void setNbResa(int nbResa) {
        this.nbResa = nbResa;
    }

    @Override
    public String toString() {
        return "id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", categorie=" + categorie + ", nbResa=" + nbResa + " ";
    }

    

    
    
}
