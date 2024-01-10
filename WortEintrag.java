package WortTrainer3;

/**
 * Worttrainer
 * @author Ivan Milev
 * @version 08-09-2022
 *
 */
public class WortEintrag {
	private String wort;
	private String url;
	
	/**
	 * Der Konstruktor für den Worteintrag
	 * @param wortPara das übergebene Wort
	 * @param urlPara die übergebene URL
	 * @throws CustomException Exception die kommt wenn man eine falsche URL eingibt
	 */
	public WortEintrag(String wortPara, String urlPara) {
		
		// Checkt ob URL gültig ist, bei ja setzt er den Attribut wert zu dem parameter
		setUrl(urlPara);
		// Checkt ob Wort gültig ist, bei ja setzt er den Attribut wert zu dem parameter
		setWort(wortPara);
		
	}	
	/**
	 * Bekommt eine url im parameter und ueberprueft sie
	 * @param url die übergebene url
	 * @return true or false je nachdem ob die url richtige syntax hat oder nicht
	 */
	public static boolean checkURl(String url) {
		/**
		 * Url muss gleich/mehr als 11 Zeichen haben damit sie richtig sein kann
		 */
		if(url.length() >= 10) {
			// Schaut ob url mit http:// oder https:// beginnt
			if(!url.substring(0, 7).equals("http://") && url.substring(0, 8).equals("https://") == false) {
				return false;
			}
			// Geht bis zum ersten Punkt und schaut ob danach ein weiter folgt oder es das letzte zeichen im string ist
			for(int i = 0; i < url.length();i++) {
				if(url.charAt(i) == '.' && url.charAt(i + 1) == 'i' && i < url.length()) {
					return false;
				}
			}
			
			return true;
			
		}
		
		return false;
    }
	/**
	 * @return das wort
	 */
	public String getWort() {
		return wort;
	}
	/**
	 * @param wort das wort zum setzen
	 */
	public void setWort(String wort) {
		if(wort.length() >= 2) {
			this.wort = wort;
		}
		else {
			throw new IllegalArgumentException("Das Wort darf nicht weniger als 2 zeichen haben");
		}
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}
	/**
	 * @param url die url zum setzen
	 * @throws CustomException wenn die url falsch ist
	 */
	public void setUrl(String urlPara) {
		if(WortEintrag.checkURl(urlPara) == true) {
			this.url = urlPara;
		}
		else {
			throw new IllegalArgumentException("Die Url ist falsch eingegeben");
		}
	}
	/**
	 * Gibt alle Attribute als String zurück
	 */
	@Override
	public String toString() {
		return wort+";"+url;
	}
	
}
