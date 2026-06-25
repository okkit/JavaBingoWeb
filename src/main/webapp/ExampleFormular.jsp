<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--  Die Annotation unten entspricht einer import-Anweisung in Java.  
Die Klasse ExampleFormularBean wird hier im weiteren Java-Code gebraucht. -->

<%@page import="data.beans.ExampleFormularBean"%>

<!-- Die folgenden Zeilen sind pures Java-Code  -->
<!-- Java-Code kann in HTML-Text an jeder Stelle plaziert werden -->
<%
ExampleFormularBean bean = (ExampleFormularBean) session.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main class="quiz" aria-label="Example Formular">
		<form action="IndexServlet" method="post">
			<header class="topbar">Task</header>

			<div>
				<label for="title">Titel</label> 
				<input id="title" name="title" type="text"
					value="<%=bean.getTaskTitle()%>" /> <!-- Java-code -->
			</div>

			<div>
				<label for="description">Beschreibung</label>
				<textarea id="description" name="description">
				<%=bean.getTaskInfo()%>
				</textarea>
			</div>

			<div>
				<div>
					<label for="done">Erledigt</label> 
					<input id="done" name="done" type="checkbox"
						<%
						if (bean.isDone()) out.print("checked=\"yes\"");
						%> 
					/>
				</div>

				<button type="submit">Speichern</button>
			</div>

			<p>Platz für eine eventuelle Fehlermeldung</p>
		</form>
	</main>
</body>
</html>

