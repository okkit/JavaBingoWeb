<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--  Die folgenden Annotationen entsprechen einer import-Anweisung in Java.  
Die Klassen Quiz und Question werden hier im weiteren Java-Code gebraucht. -->
<%@page import="java.util.List"%>
<%@page import="data.beans.Quiz"%>
<%@page import="data.beans.Question"%>
<%@page import="data.beans.Answer"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>JavaBingo</title>

<!-- Hier werden Styles verwendet, die in der  styles.css definiert sind-->
<link rel="stylesheet" href="styles.css" />
</head>

<!-- Die folgenden Zeilen sind pures Java-Code  -->
<!-- Java-Code kann in HTML-Text an jeder Stelle plaziert werden -->
<%
Quiz quiz = (Quiz) session.getAttribute("quiz");
Question quest = quiz.getQuestions().get(0);
int questCount = quiz.getQuestions().size();
int currentQuest = 0;
/* List<Answer> answers = quest.getAnswers(); */
%>

<%
int current_index = 0;

String indexParam = request.getParameter("index");
if (indexParam != null) {
	current_index = Integer.parseInt(indexParam);
}

int next_index = current_index + 1;

if (next_index >= quiz.getQuestions().size()) {
	next_index = 0; // oder Quiz beenden
}

Question question = quiz.getQuestions().get(current_index);
List<Answer> answers = question.getAnswers();
%>
<body>
	<main class="quiz" aria-label="Quiz Mockup">
		<header class="topbar">
			<div>
				Frage
				<%=current_index + 1%>/<%=quiz.getQuestions().size()%>
			</div>
			<!-- Java-Code um die Anzahl der Fragen zu ermittel -->
			<div class="score">
				<span>Richtig beantwortet</span> <span>8</span>
			</div>
		</header>

		<section class="question" aria-labelledby="question-title">
			<h1 id="question-title"><%=quest.getText()%>
			</h1>
		</section>



		<form class="answers">
			<%
			for (int i = 0; i < answers.size(); i++) {
				boolean correct = answers.get(i).isCorrect();
			%>
			<label class="answer" data-correct="<%=correct%>"> <input type="checkbox" name="answer"
				value="<%=i%>" /> <span class="letter"><%=i%>. </span> <span id="answer-<%=i%>"
				class="answer-text"><%=answers.get(i).getText()%></span>
			</label>
			<%
			}
			%>

		</form>

		<nav class="actions" aria-label="Quiz Aktionen">
			<button type="button" id="show-answer">Richtige Antwort zeigen</button>
			<!-- <button type="button" >Nächste Frage</button> -->
			<%
			boolean lastQuestion = current_index >= quiz.getQuestions().size() - 1;
			%>
			<%
			if (lastQuestion) {
			%>
			<a class="button next-button" href="index.jsp"> Quiz beenden </a>
			<%
			} else {
			%>
			<a class="button next-button" href="Question.jsp?index=<%=current_index + 1%>"> Nächste Frage </a>
			<%
			}
			%>
		</nav>
	</main>

	<script>
		document.addEventListener("DOMContentLoaded", function() {
			const showAnswerButton = document.querySelector("#show-answer");

			showAnswerButton.addEventListener("click", function() {
				const answerLabels = document.querySelectorAll(".answer");

				answerLabels.forEach(function(label) {
					if (label.dataset.correct === "true") {
						label.classList.add("correct-answer");
					}
				});
			});
		});
	</script>
</body>
</html>