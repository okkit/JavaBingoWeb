/**
 * @author ValentinaTikko
 */
package data.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * The class represets a quiz object 
 */
public class Quiz extends Bean{
	
	private String title;
	private List<Question> questions;
	
	/**
	 * This constructor is essential for JSON-Mapping
	 */
	public Quiz() {
		super();
	}

	public Quiz(String title) {
		super();
		this.title = title;
	}
	
	public void addQuestion(String text) {		
		addQuestion(new Question(text));
	}
	
	public void addQuestion(Question question) {		
		if (questions == null)
			questions = new ArrayList<Question>();
		questions.add(question);
	}
	
	public boolean hasQuestion(Question quest) {
		System.out.println(quest);
		if (questions == null)
			return false;
		for (Question question : questions) {
			System.out.println(question);
		}
		return questions.contains(quest);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
