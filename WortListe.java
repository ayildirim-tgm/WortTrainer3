package WortTrainer3;

import java.util.Arrays;

public class WortListe {
	private WortEintrag[] worteintrag = new WortEintrag[1];
	
	/**
	 * Constructor
	 * @param we einen WortEintrag der platz 0 im array einnimmt, 
	 * @param size größe des arrays
	 */
	public WortListe() {
		WortEintrag wort = new WortEintrag("Wort", "https://wort.at");
		worteintrag[0] = wort;
	}
	
	/**
	 * Fuegt ein Wort zum array hinzu
	 * @param we worteintrag
	 * @return
	 */
	public void addWort(String wort, String url) {
		
		// Macht eine Kopie die um eins größer ist als das vorige
		
		WortEintrag[] temp = Arrays.copyOf(worteintrag, worteintrag.length + 1);
		worteintrag = temp;
		for(int i = 0; i < this.worteintrag.length; i++) {
			if(worteintrag[i] == null) {
				WortEintrag worteintrag = new WortEintrag(wort, url);
				temp[i] = worteintrag;
				break;
			}	 
		}
		
	}
	/**
	 * get objekt worteintrag aus dem array
	 * @param index
	 * @return
	 */
	public WortEintrag getWortEintrag(int index) {
		
		if(index > this.worteintrag.length || index < 0) {
			throw new IllegalArgumentException("Der übergebene Index existiert nicht");
		}
		
		return this.worteintrag[index];
		
		
	}
	/**
	 * Löscht ein Wort aus dem Array
	 * @param wort das übergebene Wort
	 * @return ob es funktioniert hat oder nicht
	 */
	public boolean loeschWortEintrag(String wort) {
		if(wort.length() >= 2) {
			for(int i = 0; i < this.worteintrag.length;i++) {
				if(this.worteintrag[i] != null && this.worteintrag[i].getWort().equals(wort)) {
					this.worteintrag[i] = null;
					return true;
				}
			}
		}
		else {
			throw new IllegalArgumentException("Das Wort muss mehr als 2 zeichen haben");
		}
		
		
		return false;
	}
	/**
	 * Alle Worteinträge aus dem Array werden ausgegeben
	 */
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < this.worteintrag.length;i++) {
			if(this.worteintrag[i] != null) {
				s += this.worteintrag[i].toString();
				if(i < this.worteintrag.length - 1) {
					s += "\n";
				}
				
			}
		}
		return s;
	}
	/**
	 * Gibt die Länge vom array zurück
	 * @return länge vom array
	 */
	public int getLength() {
		return worteintrag.length;
	}
	
}
