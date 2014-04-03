package modele;

import modele.exception.ExceptionChampVide;
import modele.exception.brut.ExceptionBrutNegatif;
import modele.exception.brut.ExceptionBrutString;
import outils.Outils;


public class Brut {

	
	/**
	 * Retourne true si la chaine peut être convertie en un brut valide
	 * @param brut
	 * @throws ExceptionBrutNegatif 
	 * @throws ExceptionBrutString 
	 * @throws ExceptionChampVide 
	 */
	public static boolean isValid(String brut) throws ExceptionBrutNegatif, ExceptionBrutString, ExceptionChampVide{

		String temp = brut.replaceAll("\\s", "");
		if(temp.equals("")){
			throw new ExceptionChampVide();
		}
		if ( ! Outils.isDouble(temp)  ){
			throw new ExceptionBrutString();
		}
		double saisieDouble = Double.parseDouble(temp);		
		return isValid(saisieDouble);
	}
	
	/**
	 * retourne true si le nombre est un brut valide.
	 * @param brut
	 * @throws ExceptionBrutNegatif
	 * 			dans le cas ou le brut n'est pas bon 
	 */
	public static boolean isValid(double brut) throws ExceptionBrutNegatif{
		
		if ( brut <= 0){
			throw new ExceptionBrutNegatif();
		}
		return true;
	}
}
