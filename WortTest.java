package WortTrainer3;

public class WortTest {
	public static void main(String[] args) {
		//Testing von WortEintrag
		WortEintrag we = null;
		WortEintrag we2 = null;
		WortEintrag we3 = null;
		
		try {
			we = new WortEintrag("Apfel", "https://apfel.at");
			System.out.println(we.toString());
			
			we2 = new WortEintrag("Baum", "http://baum.at");
			System.out.println(we2.toString());
			
			we3 = new WortEintrag("Banane", "htt://banane.at");
			System.out.println(we3.toString());
			
		} catch (IllegalArgumentException e) {
			System.out.println("Ein Fehler ist aufgetreten bei der eingabe von einem WortEintrag(in dem Fall we3)");
		}
		
		// Testing von Wortliste
		WortListe wl = new WortListe();
		wl.addWort("Baum", "https://baum.at");
		wl.addWort("Auto", "https://auto.at");
		
		// WortEintrag 3 wird hier nicht geprinted weil es "null" ist
		System.out.println();
		System.out.println(wl.toString());
		System.out.println();
		
		// Löscht den WortEintrag Baum von der Liste
		wl.loeschWortEintrag("Baum");
		System.out.println(wl.toString());
		System.out.println("Der WortEintrag von Baum wurde jetzt gelöscht");
		System.out.println();
		
		// Testen für die WortTrainer klasse
		wl.addWort("Baum", "https://baum.at");
		wl.addWort("Hund", "https://hund.at");
		
		
		System.out.println(wl.toString());
		System.out.println();
		
		// Erstellt jetzt den zufälligen WortEintrag aus der Liste
		WortTrainer wt = new WortTrainer(wl);
		wt.getRandomWort();
		System.out.println("Der zufällig ausgewählte WortEintrag ist derzeit "+ wt.aktuellerEintrag() +"\n");
		
		// Überprüft ob das zufällige Wort mit dem parameter gleich ist um herauszufinden was das zufällige Wort war
		if(wt.checkIgnoreCase("baum")) {
			System.out.println("Das zufällige Wort war baum");
		}
		else if(wt.checkIgnoreCase("auto")) {
			System.out.println("Das zufällige Wort war auto");
		}
		else if(wt.checkIgnoreCase("hund")) {
			System.out.println("Das zufällige Wort war hund");
		}
		else if(wt.checkIgnoreCase("wort")) {
			System.out.println("Das zufällige Wort war wort");
		}
		System.out.println("");	
		System.out.println(wt.getAntworten());
		SpeichernLaden sl = new SpeichernLaden();
		
		// Speichert den übergebenen Worttrainer in die statistics Datei
		sl.savepath("src/WortTrainer3/statistics.txt", wt);
		System.out.println("Mit readpath liest er den Inhalt der txt Datei");
		sl.readpath("src/WortTrainer3/statistics.txt");
		sl.readpath("src/WortTrainer3/error.txt");
		
		
		System.out.println("");
		WortTrainer wt2 = new WortTrainer(wl);
		SpeichernLaden sl1 = new SpeichernLaden();
		wt2.getRandomWort();
		System.out.println(wt2.aktuellerEintrag());
		wt2.checkIgnoreCase("hund");
		wt2.checkIgnoreCase("baum");
		wt2.checkIgnoreCase("wort");
		wt2.checkIgnoreCase("auto");

		sl1.savedefault(wt2);
		sl1.readdefault();
		
	}
}
