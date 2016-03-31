package DAO.implementDAO;

import java.util.Vector;
import objets_metiers.Emprunt;

public class ExamplaireDAO {
	private int id;
	private Vector<Emprunt> empruntsExamplaire = new Vector<Emprunt>();
	private OeuvreDAO oeuvresExamplaire;

	public ExamplaireDAO findById(int id) {
		throw new UnsupportedOperationException();
	}

	public ExamplaireDAO findOnReservation(int numReservation) {
		throw new UnsupportedOperationException();
	}

	public ExamplaireDAO find(OeuvreDAO oeuvre, int num_examplaire) {
		throw new UnsupportedOperationException();
	}

	public void setId(Object id) {
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return this.id;
	}
}