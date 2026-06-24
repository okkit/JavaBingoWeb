/**
 * @author ValentinaTikko
 */
package data.beans;

/**
 * Die Klasse beschreibt das Objekt Answer.
 */
public class Answer extends Bean{
	
	private String text;
	private boolean correct;
	
	/**
	 * This constructor is essential for JSON-Mapping
	 */
	public Answer() {
		super();
	}

	/**
	 * Konstruiert eine Instanz der Klasse.<br>
	 * Initialisiert das Feld text anhand des Parameters.<br>
	 * Uninitialisert haben: <br>
	 * das Feld text den wert null, das Feld correct den Wert false.
	 * 
	 * @param text
	 */
	public Answer(String text) {
		super();
		this.text = text;
	}

	/**
	 * Konstruiert eine Instanz der Klasse.<br>
	 * Initialisiert die Felder text und correct anhand der Parameter.
	 * 
	 * @param text
	 * @param correct
	 */
	public Answer(String text, boolean correct) {
		super();
		this.text = text;
		this.correct = correct;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
}
