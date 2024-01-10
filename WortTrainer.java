package WortTrainer3;

import java.util.Random;

public class WortTrainer {
	private WortListe wortliste;
	private int randomIndex;
	private int antworten = 0;
	private int correct = 0;
	
	
	/**
	 * Constructor
	 * @param wortliste Wortliste
	 */
	public WortTrainer(WortListe wortliste) {
		if(wortliste != null) {
			this.wortliste = wortliste;
		}
	}
	
	public WortTrainer() {
		this.wortliste = new WortListe();
	}

	/**
	 * Sucht sich einen zufälligen WortEintrag aus der Liste zurück
	 * @return den zufällig ausgewählten Worteintrag
	 */
	public String getRandomWort() {
		boolean check = true;
		do {
			Random rn = new Random();
			randomIndex = rn.nextInt(wortliste.getLength() - 1);
			
			if(this.wortliste.getWortEintrag(randomIndex).toString() != null) {
				return this.wortliste.getWortEintrag(randomIndex).toString();			
			}
			check = true;
			
		} while(check = true);
		
		return "";
		
		
		
	}
	/**
	 * Gibt den aktuellen Worteintrag zurück
	 * @return den aktuellen Worteintrag
	 */
	public String aktuellerEintrag() {
		return this.wortliste.getWortEintrag(randomIndex).toString();
	}
	
	/**
	 * Vergleicht das aktuelle Wort mit dem übergebenen Wort, ob sie gleich sind, abhängig von Groß und Kleinschreibung
	 * @param wort übergebene Wort
	 * @return true or false
	 */
	public boolean check(String wort) {
		antworten++;
		if(this.wortliste.getWortEintrag(randomIndex).getWort().equals(wort)) {
			correct++;
			return true;
			
		}
		return false;
	}
	
	/**
	 * Vergleicht das aktuelle Wort mit dem übergebenen Wort, ob sie gleich sind unabhängig von Groß und Kleinschreibung
	 * @param wort übergebene Wort
	 * @return true or false
	 */
	public boolean checkIgnoreCase(String wort) {
		antworten++;
		if(this.wortliste.getWortEintrag(randomIndex).getWort().equalsIgnoreCase(wort)) {
			correct++;
			return true;
		}
		return false;
	}
	/**
	 * Abfragen und richtige antworten werden returned
	 * @return abfragen und richtige anworten
	 */
	public String getAntworten() {
		return "Anzahl Abfragen: "+antworten+", richtig davon: "+correct;
	}

	@Override
	public String toString() {
		return "WortTrainer [" + (wortliste != null ? "wortliste=" + wortliste + ", " : "") + "randomIndex=" + this.randomIndex + ", antworten=" + antworten + ", correct=" + correct + "]";
	}
	
	
}
