package outils;

public class Outils {

	private static String[] listeCaractereInterdit = {"&", "~", "#", ",", "\\{", "\\}", "\\[", "\\]", "\\(", "\\)", "\\`", "¤", "$", "£", "^", "\\¨", "\\|" };
	public static String[] listeStatuts ={"cadre","ouvrier","profession intermediaire"};

	public static boolean contientCaracInterdit(String chaine){
		String temp = chaine.replaceAll("\\s", "");
		for(String s : listeCaractereInterdit){
			String[] test = temp.split(s);
			if (test.length>=2 || temp.equals(s) || test[0].length() < temp.length()){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isStatut(String valeur){
		for (String s : listeStatuts){
			if (valeur.equals(s)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Test si une expression est un entier.
	 * @param chaine
	 * @return
	 * 			true ou false.
	 */
	public static boolean isInteger(String chaine){
		
		try{
			Integer.parseInt(chaine);
		}
		catch (Exception e){
			return false;
		}
		return true;
	}
	
	/**
	 *  Test si une expression est un double.
	 * @param chaine
	 * @return
	 * 			true ou false.
	 */
	public static boolean isDouble(String chaine){
		try{
			Double.parseDouble(chaine);
		}
		catch (Exception e){
			return false;
		}
		return true;
	}
}
