<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="data.beans.Question"%>
<%@page import="data.beans.Quiz"%>
<%
Quiz quiz = (Quiz) session.getAttribute("quiz");
Question quest = quiz.getQuestions().get(0);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>JavaBingo</title>
<link rel="stylesheet" href="styles.css" />
</head>
<body>
	<main class="quiz" aria-label="Quiz Mockup">
		<header class="topbar">
			<div>Frage 0/<%=quiz.getQuestions().size() %></div>
			<div class="score">
				<span>Richtig beantwortet</span> <span>8</span>
			</div>
		</header>

		<section class="question" aria-labelledby="question-title">
			<h1 id="question-title"><%=quest.getText() %>></h1>
		</section>

		<form class="answers">
			<label class="answer"> <input type="checkbox" name="answer"
				value="A" /> <span class="letter">A</span> <span
				class="answer-text">Text der 1. Antwort Quizfrage</span>
			</label> <label class="answer"> <input type="checkbox" name="answer"
				value="B" /> <span class="letter">B</span> <span
				class="answer-text">Text der 2. Antwort Quizfrage</span>
			</label> <label class="answer"> <input type="checkbox" name="answer"
				value="C" /> <span class="letter">C</span> <span
				class="answer-text">Text der 3. Antwort Quizfrage</span>
			</label> <label class="answer"> <input type="checkbox" name="answer"
				value="D" /> <span class="letter">D</span> <span
				class="answer-text">Text der 4. Antwort Quizfrage</span>
			</label>
		</form>

		<nav class="actions" aria-label="Quiz Aktionen">
			<button type="button">Richtige Antwort zeigen</button>
			<button type="button">Nächste Frage</button>
		</nav>
	</main>
</body>
</html>