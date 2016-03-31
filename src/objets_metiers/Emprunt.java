package objets_metiers;

import java.util.Date;

public class Emprunt {
	private int iD;
	private Date dateEmprunt;
	private Date dateRetourPrevu;
	private Date dateRetourEffective;
	private Usager usagerEmprunt;
	private Examplaire examplairesEmprunt;

	public Emprunt(Oeuvre o, Examplaire e, Date dateJour) {
		throw new UnsupportedOperationException();
	}

	public void find(Usager usager, int examplaire, Oeuvre oeuvre) {
		throw new UnsupportedOperationException();
	}

	public Emprunt find(Usager usager, Examplaire examplaire) {
		throw new UnsupportedOperationException();
	}

	public Date getDateRetourEffective() {
		return this.dateRetourEffective;
	}

	public void setDateRetourEffective(Date dateRetourEffective) {
		this.dateRetourEffective = dateRetourEffective;
	}

	public Date getDateEmprunt() {
		return this.dateEmprunt;
	}

	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	public Date getDateRetourPrevu() {
		return this.dateRetourPrevu;
	}

	public void setDateRetourPrevu(Date dateRetourPrevu) {
		this.dateRetourPrevu = dateRetourPrevu;
	}
}