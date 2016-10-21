/**
*
*
*
*/
package aufgabe1_3;

/**
* Praktikum TIPM2, WS16-17
* Gruppe: Marvin Petersen (marvin.petersen@haw-hamburg.de),
* Sahin Tekes (sahin.tekes@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 1, Aufgabe 1.3
* Quellen: http://tinyurl.com/hm92uay
* */

/**
 * Klasse ElementenSucher um herauszzufinden, 
 * ob es sich beim ersten Element in einer Liste um eine Zahl handelt.
 * @author acc387
 *
 * @param <T>
 */

public abstract class ElementenSucher <T> extends Number {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Schaut ob das erste Element ein Number ist.
	 * @param liste
	 * @return
	 */
	public static boolean istErstesElementZahl(ArrayListe<?> liste){
		if(liste.getElement(0) instanceof Number){
			return true;
		}
		return false;
	}

}
