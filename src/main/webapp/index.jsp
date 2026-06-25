<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styles.css" />
</head>
<body>

 <button class="duke-button" onclick="startApp()">
    <img src="duke-start.png" alt="Java Duke Start Button">
  </button>

  <script>
    function startApp() {
      alert("Start wurde gedrückt!");
    }
  </script>

	<h1>Halli hallo hier</h1>
	<form action="IndexServlet" method="post">
		<input type="submit" value="Submit zum IndexServlet" />
	</form>

</body>
</html>