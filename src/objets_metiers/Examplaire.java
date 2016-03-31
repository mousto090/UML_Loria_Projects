package objets_metiers;

import java.util.Vector;
import objets_metiers.Emprunt;

public class Examplaire {
	private int id;
	private Vector<Emprunt> empruntsExamplaire = new Vector<Emprunt>();
	private Oeuvre oeuvresExamplaire;

	public Examplaire findById(int id) {
		throw new UnsupportedOperationException();
	}

	public Examplaire findOnReservation(int numReservation) {
		throw new UnsupportedOperationException();
	}

	public Examplaire find(Oeuvre oeuvre, int num_examplaire) {
		throw new UnsupportedOperationException();
	}

	public void setId(Object id) {
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return this.id;
	}
}