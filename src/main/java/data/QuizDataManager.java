package data;

import java.util.List;

import data.beans.Question;
import data.beans.Quiz;

/**
 * Bestimmt, welche Methoden die Klassen zu implementieren haben, die sich um
 * das Besorgen der Daten zu einem Quiz kümmern.<br>
 * Projekt-Setting: Alle Klassen, die sich um das Besorgen der Daten kümmern,
 * MÜSSEN dieses Interface implementieren!
 */
public interface QuizDataManager {
	
	public Quiz getQuiz();
	public List<Quiz> getQuizList();
	public Question getQuestion(int i);

}
