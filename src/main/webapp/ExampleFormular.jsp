<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--  Die Annotation unten entspricht einer import-Anweisung in Java.  
Die Klasse ExampleFormularBean wird hier im weiteren Java-Code gebraucht. -->

<%@page import="data.beans.ExampleFormularBean"%>
<%@page import="servlets.Constants"%>

<!-- Vorbereitungen treffen mit Java-Code unter Verwendung der Bean -->
<!-- Die Bean wurde im Servlet in der Session als Attribut abgelegt -->
<!-- Session-Attribute haben dieselbe Lebensdauer, wie die Session selbst -->
<!-- Java-Code kann in HTML-Text an jeder Stelle plaziert werden -->
<%
ExampleFormularBean bean = (ExampleFormularBean) session.getAttribute(Constants.ATTR_DATA);
String title = "";
String info = "";
boolean done = false;
if (bean != null) {
	title = bean.getTaskTitle();
	info = bean.getTaskInfo();
	done = bean.isDone();
}
Object msg = request.getAttribute(Constants.ATTR_MSG);
if (msg == null)
	msg = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main class="quiz" aria-label="Example Formular">
		<form action="ExampleFormular" method="get">
			<header class="topbar">Task</header>

			<div>
				<label for="title"><%=Constants.LABEL_HEADER%></label> 
				<input id="title" name="<%=Constants.PARAM_TITLE%>" type="text" value="<%=title%>" />
			</div>

			<div>
				<label for="description"><%=Constants.LABEL_TITLE%></label>
				<textarea id="description" name="<%=Constants.PARAM_INFO%>"><%=info%></textarea>
			</div>

			<div>
				<label for="done"><%=Constants.LABEL_DONE%></label> 
				<input id="done" name="<%=Constants.PARAM_DONE%>" type="checkbox" <%if (done) out.print("checked=\"on\"");%> />
			</div>
			<div>
				<button type="submit"><%=Constants.LABEL_SAVE%></button>
			</div>
			
		</form>
		
		<div>
			<button onclick="startNewTask()">Neuer Task</button>
		</div>
			<label id = "msg"><%=msg%></label>

<!-- Java script zum leeren der Eingabefelder -->
		<script>
			function startNewTask() {
				document.getElementById("title").value = "";
				document.getElementById("description").value = "";
				document.getElementById("done").checked = "";
				
				document.getElementById("msg").textContent = "";
				
			}
		</script>

	</main>
</body>
</html>

