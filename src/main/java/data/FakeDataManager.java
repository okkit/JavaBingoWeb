package data;

import java.util.List;

import data.beans.Answer;
import data.beans.Question;
import data.beans.Quiz;

public class FakeDataManager implements QuizDataManager {

	@Override
	public Quiz getQuiz() {

		Quiz quiz = createJavaQuiz();
		return quiz;
	}

	private Quiz createJavaQuiz() {

		Quiz java = new Quiz("Java");

		// Frage 0
		Question quest = new Question("Welche Variable wird mit dem Keyword static deklariert?");
		java.addQuestion(quest);

		Answer ans = new Answer("Lokale Variable", false);
		quest.addAnswer(ans);
		ans = new Answer("Instanzariable", false);
		quest.addAnswer(ans);
		ans = new Answer("Laufvariable", false);
		quest.addAnswer(ans);
		ans = new Answer("Klassenvariable", true);
		quest.addAnswer(ans);
//		quest.setInfo(
//				"Um eine statische Variable verwenden zu können braucht man keine Instanz der Klasse.");

		// Frage 1
		quest = new Question(
				"Welches Keyword wird bei der Deklaration einer Methode verwendet, die keinen Returnwert zurückgibt?");
		java.addQuestion(quest);

		quest.addAnswer(new Answer("private", false));
		quest.addAnswer(new Answer("stacic", false));
		quest.addAnswer(new Answer("void", true));
		quest.addAnswer(new Answer("String", false));
//		quest.setInfo(
//				"Bei der Deklaration einer Methode muss der Datentyp des Rückgabewertes benannt werden.");

		// Frage 2
		quest = new Question("Was wird mit einem Konstruktor konstruiert?");
		java.addQuestion(quest);

		quest.addAnswer(new Answer("Klasse", false));
		quest.addAnswer(new Answer("Instanz", true));
		quest.addAnswer(new Answer("Methode", false));
		quest.addAnswer(new Answer("Feld", false));
//		quest.setInfo("new Constructor()");

		return java;
	}

	@Override
	public List<Quiz> getQuizList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question getQuestion(int i) {
		return getQuiz().getQuestions().get(i);
	}
}
