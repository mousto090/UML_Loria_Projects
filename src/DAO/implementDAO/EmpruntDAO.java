package DAO.implementDAO;

import java.util.Date;

public class EmpruntDAO {
	private int iD;
	private Date dateEmprunt;
	private Date dateRetourPrevu;
	private Date dateRetourEffective;
	private UsagerDAO usagerEmprunt;
	private ExamplaireDAO examplairesEmprunt;

	public EmpruntDAO(OeuvreDAO o, ExamplaireDAO e, Date dateJour) {
		throw new UnsupportedOperationException();
	}

	public void find(UsagerDAO usager, int examplaire, OeuvreDAO oeuvre) {
		throw new UnsupportedOperationException();
	}

	public EmpruntDAO find(UsagerDAO usager, ExamplaireDAO examplaire) {
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