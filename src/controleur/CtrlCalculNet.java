package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Cotisation;
import modele.Employe;
import modele.ListeVariable;
import modele.Operateur;
import modele.Regle;
import modele.Variable;
import modele.exception.condition.ExceptionComparaisonString;
import modele.exception.variable.ExceptionVariableInexistante;
import outils.Outils;
import vue.interfaces.IPrincipale;

/**
 * Calcule le net à partir du brut et des cotisations à appliquer.
 *
 */
public class CtrlCalculNet implements ActionListener {


	private IPrincipale vue;
	private ListeVariable listeVar;
	private CtrlSaisieCotisation ctrCotis;
	private CtrlRegle ctrRegle;
	private CtrlSaisieBrut ctrBrut;

	public CtrlCalculNet(){
		listeVar = new ListeVariable();
	}
	
	
	/**
	 * Calcule le montant d'une cotisation par rapport à un salaire brut
	 * @param brut
	 * @param cotisation
	 * @return
	 */
	private double calculMontantCotisation(double brut, Cotisation cotisation ) {
		
		if (!cotisation.isSupprime()) {
			return (brut*cotisation.getTaux());
		}
		return 0;
	}


	public CtrlSaisieCotisation getCtrCotis() {
		return ctrCotis;
	}


	public void setCtrCotis(CtrlSaisieCotisation ctrCotis) {
		this.ctrCotis = ctrCotis;
	}


	public CtrlRegle getCtrRegle() {
		return ctrRegle;
	}


	public void setCtrRegle(CtrlRegle ctrRegle) {
		this.ctrRegle = ctrRegle;
	}


	public void setListeVar(ListeVariable listeVar) {
		this.listeVar = listeVar;
	}


	/**
	 * Calcule le salaire net.
	 * @param brut
	 * @return
	 * @throws ExceptionComparaisonString 
	 * @throws ExceptionVariableInexistante 
	 */
	private double calculDuNet() throws ExceptionVariableInexistante, ExceptionComparaisonString {
		
		for (Cotisation c : ctrCotis.getListe().getCotisations()){
				String nom = c.getNom();
				double taux = c.getTaux();
				listeVar.ajouter(nom, String.valueOf(taux));	
		}
		
		for ( Regle r : ctrRegle.getListe().getRegles()){
			if ((!r.isSupprime()) && (! r.equals(new Regle()))){
				if ( estRespectee(r)){
					listeVar.ajouter(r.getAction().getVariable().toString(), String.valueOf(r.getAction().getValeur()) );
				}
			}
		}

		double brut = Double.parseDouble(listeVar.get("Brut"));
		double net = brut;
		for (int i =0; i < ctrCotis.getListe().getCotisations().size(); i++){
			Cotisation temp = ctrCotis.getListe().getCotisations().get(i).cloner();
			temp.setTaux(Double.parseDouble(listeVar.get(temp.getNom())));
			double montant = calculMontantCotisation(brut, temp);
			vue.getFichePaie().setMontant(i	, montant);
			net = net- montant;
		}
		return net;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		ctrBrut.actionPerformed(e);
		try {
			if (ctrBrut.getEmploye() != null){
				double brut = Double.parseDouble(vue.getBrut());
				listeVar.ajouter("Brut", String.valueOf(brut));
				listeVar.ajouter("statut", vue.getPanBrut().getStatut());
				try {
					double net = calculDuNet();
					vue.setNet(net);
					vue.getFichePaie().setEmploye(new Employe(vue.getPanBrut().getNom(),vue.getPanBrut().getPrenom(),vue.getPanBrut().getStatut(),Double.parseDouble(vue.getPanBrut().getBrut()),net));

				} catch (ExceptionVariableInexistante | ExceptionComparaisonString e1) {
					vue.getPanBrut().erreur(e1.getMessage());
				}
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		}
	}


	public void setVue(IPrincipale vue){
		this.vue = vue;
		ctrCotis = vue.getPanCotisation().getControleur();
		ctrRegle = vue.getPanRegle().getControleur();
		ctrBrut = vue.getPanBrut().getControleur();
	}
	
	
	
	/**
	 * Indique si une règle est respecté ou non.
	 * @param r
	 * @return
	 * @throws ExceptionVariableInexistante 
	 * @throws ExceptionComparaisonString 
	 */
	public boolean estRespectee(Regle r) throws  ExceptionVariableInexistante, ExceptionComparaisonString{
		Variable variable = r.getCondition().getVariable();
		Variable variableAModifier = r.getAction().getVariable();
		Operateur operateur = r.getCondition().getOperateur();
		String valeurATester = r.getCondition().getValeurTest();
		
		if (  ! listeVar.contientClef(variable.toString()) || ! listeVar.contientClef(variableAModifier.toString()) ){
			throw new ExceptionVariableInexistante();
		}
		else{
			String valeurAssocieeVariable = listeVar.get(variable.toString());

			if (!Outils.isDouble(valeurAssocieeVariable) && ! operateur.equals(new Operateur("="))){
				throw new ExceptionComparaisonString();
			}
			
		return operateur.resultatOperation(valeurAssocieeVariable,valeurATester);
		
		}
	}

}
