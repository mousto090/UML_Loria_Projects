package objets_metiers;

import java.util.Date;

public class Reservation {
	private int iD;
	private Date date;
	private Usager usagerReservation;
	private Oeuvre oeuvresReservation;

	public Reservation(Usager u, Oeuvre o, Date dateJour) {
		throw new UnsupportedOperationException();
	}

	public Reservation find() {
		throw new UnsupportedOperationException();
	}

	public void destroy() {
		throw new UnsupportedOperationException();
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}