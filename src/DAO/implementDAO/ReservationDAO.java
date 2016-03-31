package DAO.implementDAO;

import java.util.Date;

public class ReservationDAO {
	private int iD;
	private Date date;
	private UsagerDAO usagerReservation;
	private OeuvreDAO oeuvresReservation;

	public ReservationDAO(UsagerDAO u, OeuvreDAO o, Date dateJour) {
		throw new UnsupportedOperationException();
	}

	public ReservationDAO find() {
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