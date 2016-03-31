package objets_metiers;

import java.util.Vector;
import objets_metiers.Examplaire;
import objets_metiers.Reservation;

public class Oeuvre {
	private int iD;
	private String titre;
	private String auteur;
	private String categorie;
	private int nbResa;
	private Vector<Examplaire> examplairesOeuvre = new Vector<Examplaire>();
	private Vector<Reservation> reservationsOeuvre = new Vector<Reservation>();

	public void ajouter(Oeuvre oeuvre) {
		throw new UnsupportedOperationException();
	}

	public Oeuvre find(String titre) {
		throw new UnsupportedOperationException();
	}

	public void getCategorie() {
		throw new UnsupportedOperationException();
	}

	public void setCategorie(Object categorie) {
		throw new UnsupportedOperationException();
	}

	public void getAuteur() {
		throw new UnsupportedOperationException();
	}

	public void setAuteur(Object auteur) {
		throw new UnsupportedOperationException();
	}

	public void getTitre() {
		throw new UnsupportedOperationException();
	}

	public void setTitre(Object titre) {
		throw new UnsupportedOperationException();
	}

	public int getNbResa() {
		return this.nbResa;
	}

	public void setNbResa(int nbResa) {
		this.nbResa = nbResa;
	}
}