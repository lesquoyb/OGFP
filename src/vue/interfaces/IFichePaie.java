package vue.interfaces;

import modele.Employe;
import modele.FichePaie;
import controleur.CtrlCalculNet;
import controleur.CtrlRegle;
import controleur.CtrlSaisieCotisation;

public interface IFichePaie {
	
	public CtrlCalculNet getControleurCalculNet();
	
	public CtrlSaisieCotisation getControleurCotisation();
	
	public CtrlRegle getControleurRegle();

	public void refreshTabCotis();

	public void refreshTabRegle();
	
	public void setMontant(int index,double valeur);
	
	public FichePaie getFichePaie();
	
	public void setEmploye(Employe employe);
	
	public void setFichePaie(FichePaie fiche);

}

