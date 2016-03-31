package objets_metiers;

import java.util.Date;
import java.util.Vector;

public class Usager {

    private int id;
    private String nom;
    private String prenom;
    private Date dateNais;
    private String sexe;
    private String adresse;
    private String tel;
    private Vector<Emprunt> empruntsUsager = new Vector<Emprunt>();
    private Vector<Reservation> reservationsUsager = new Vector<Reservation>();

    public Usager() {
    }

    public Usager(int id, String nom, String prenom, Date dateNais,
            String sexe, String adresse, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNais = dateNais;
        this.sexe = sexe;
        this.adresse = adresse;
        this.tel = tel;
    }

    public Usager(Usager usager) {
        this(usager.id, usager.nom, usager.prenom, usager.dateNais,
                usager.sexe, usager.adresse, usager.tel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNais() {
        return dateNais;
    }

    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

    public String getSexe() {
        return this.sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Usager find(String nom) {
        throw new UnsupportedOperationException();
    }

    public void ajouter(Usager usager) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "Usager{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom 
                + ", dateNais=" + dateNais + ", sexe=" + sexe + ", adresse=" 
                + adresse + ", tel=" + tel + '}';
    }

}
