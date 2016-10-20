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


/**
 * Implementierung einer eigenen ArrayListe mit einem generischen Datentyp 'T'
 * @author acc387
 *
 * @param <T> generischer Datentyp
 */
public class ArrayListe <T extends Comparable<T>>{
	
	/**
	 * Objektvariable die die Anzahl der Elemente speichert
	 */
	private int anzahlElemente;
	
	/**
	 * Objektvariable die verschiedene Objekte in einem Array speichert
	 */
	private Object[] elemente;
	
	/**
	 * Konstruktor erzeugt die Liste und setzt die Anzahl der Elemente auf 0.
	 */
	public ArrayListe(){
		elemente=new Object[0];
		anzahlElemente=0;
	}
	
	/**
	 * fügt ein element hinzu und vergroeßert das Array.
	 * @param element
	 */
	public void hinzufuegen(T element){
		anzahlElemente++;
		Object[] elementeKopie=new Object[anzahlElemente];
		for(int i=0;i<anzahlElemente-1;i++){
			elementeKopie[i]=elemente[i];
		}
		elemente=elementeKopie;
		elemente[anzahlElemente-1]=element;
	}
	
	/**
	 * Liefert ein Element zurueck vom Typ T an einer bestimmten Stelle index.
	 * @param index
	 * @return
	 */
	public T getElement(int index){
		if(index>=anzahlElemente){
			return null;
		}
		return (T)elemente[index];
	}
	
	/**
	 * loescht ein element und laesst die dahinterliegenden Elemente aufruecken
	 * @param index
	 */
	private void elementRueckeVor(int index){
		for(int m=index;m<anzahlElemente;m++){
			elemente[m]=elemente[m+1];
			}
		Object[] elementeKopie=new Object[anzahlElemente];
		for(int i=0;i<anzahlElemente;i++){
			elementeKopie[i]=elemente[i];
		}
		elemente=elementeKopie;
	}
	
	/**
	 * entferne ein bestimmtes Element aus dem Array und setzte alle dahinterliegenden
	 * ein Platz nach vorne.
	 * @param element
	 */
	public void entferne(T element){
		for(int i=0;i<anzahlElemente;i++){
			if(elemente[i].equals(element)){
				elemente[i]=null;
				anzahlElemente--;
				elementRueckeVor(i);
			}
		}
		
	}
	
	/**
	 * enfernt ein element an der stelle index
	 * @param index
	 */
	public void entferneElementAnIndex(int index){
		if(index>=anzahlElemente){
			throw new ArrayIndexOutOfBoundsException();
		}
		elemente[index]=null;
		anzahlElemente--;
		elementRueckeVor(index);
		
	}
	
	/**
	 * get AnzahlElemente
	 * @return
	 */
	public int getAnzahElemente(){
		return anzahlElemente;
	}
	
	/**
	 * implementiert die Darstellung der Liste
	 */
	public String toString(){
		String result="";
		for(int i=0;i<anzahlElemente-1;i++){
			result+=elemente[i]+", ";
		}
		result+=elemente[anzahlElemente-1];
		return result;
	}
	
	/**
	 * gibt uns das kleinste element in dem array zurueck.
	 * @return
	 */
	public T getKleinstesElement(){
		T min = (T)elemente[0];
		for(int i=0;i<anzahlElemente;i++){
			if(min.compareTo(getElement(i))>0){
				min=(T) elemente[i];
			}
		}
		return min;
	}
	
	

}
