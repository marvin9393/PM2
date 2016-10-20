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
* Verwendete Quellen: */
public class ElementenSucher <T> extends ArrayListe<Integer>{
	
	public ElementenSucher(Object[] elemente){
		super();
	}
	
	/**
	 * Schaut ob das erste Element ein Integer ist.
	 * @param liste
	 * @return
	 */
	public static boolean istErstesElementZahl(ArrayListe<?> liste){
		if(liste.getElement(0) instanceof Integer){
			return true;
		}
		return false;
	}

}
