package principal;

import vue.FenetrePrincipale;
import vue.interfaces.IPrincipale;
import controleur.CtrlCalculNet;

public class Lance {

	public static void main(String[] args) {
		CtrlCalculNet controleurNet = new CtrlCalculNet();
		IPrincipale vue = new FenetrePrincipale("OGFP 2014",controleurNet);
		//controleurNet.setVue(vue);
	}
}
