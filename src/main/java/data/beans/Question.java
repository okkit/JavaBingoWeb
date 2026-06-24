/**
 * @author ValentinaTikko
 */
package data.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * The class represets a question object 
 */
public class Question extends Bean {
	
	private String text;
	private int score;
	/**
	 * Aggregation (Sammlung) der Instanzen der Klasse Answer, <br>
	 * bzw der Answer-Objekte.
	 */
	private List<Answer> answers = new ArrayList<Answer>();

	/**
	 * This constructor is essential for JSON-Mapping
	 */
	public Question() {
		super();
		answers = new ArrayList<Answer>();
	}

	// Konstruktor
	public Question(String text) {
		this();
		this.text = text;
	}

	public void addAnswer(String text, boolean correct) {
		addAnswer(new Answer(text, correct));
	}

	public void addAnswer(Answer answer) {
		if (answers == null)
			answers = new ArrayList<Answer>();
		answers.add(answer);
	}
	
	public String toString() {
		return text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	
//	public void setQuiz(Quiz quiz) {
//		this.quiz = quiz;
//	}
//
//	public Quiz getQuiz() {
//		return quiz;
//	}
}
