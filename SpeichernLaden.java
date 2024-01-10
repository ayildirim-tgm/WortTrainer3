package WortTrainer3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *  Speichern und Laden Klassen
 */
public class SpeichernLaden {
	private String defaultpath = "src/WortTrainer3/";
	private String path = "";
	
	/**
	 * Default Constructor
	 */
	public SpeichernLaden() {
		
	}
	/**
	 * Speichern des Worttrainers an einem angegebenen Ort (Pfad)
	 * @param path
	 * @param wt
	 */
	public void savepath(String path, WortTrainer wt) {
		try {
			this.path = path;
			BufferedWriter writer = new BufferedWriter(new FileWriter(this.path));
			writer.write("[Statistik: "+ wt.getAntworten() + "], Eintrag: "+ wt.aktuellerEintrag());
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Laden einer Daten mittels angegebenen Pfad
	 * @param path Pfad
	 */
	/*
	 * String line;
			String all = "";
			while((line = reader.readLine()) != null) {
			    if (line.isEmpty()) {
			        break;
			    }
			    all += reader.readLine();
			}
	 */
	// Frage an Lehrer wie man multiple Lines of Code in einem lesen kann
	public void readpath(String path) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			
			System.out.println(reader.readLine());
			reader.close();
		}
		catch(IOException e) {
			System.out.println("Falscher Pfad");
		}
	}
	/**
	 * Ladet die Daten von der Worttrainer Datei im Default Standort
	 */
	public void readdefault() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(defaultpath + "Worttrainer.txt"));
			System.out.println(reader.readLine());
			reader.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	/**
	 * Speichert einen Worttrainer im Default Standort
	 * @param wt2 Worttrainer
	 */
	public void savedefault(WortTrainer wt2) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(defaultpath + "Worttrainer.txt"));
			writer.write("[Statistik: "+ wt2.getAntworten() + "], Eintrag: "+ wt2.aktuellerEintrag());
			writer.close();
		}catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
}