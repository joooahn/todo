<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="todo.joooahn.TodoDto" %>

<%
	String todoTag = (String)request.getAttribute("todoTag");
	String doingTag = (String)request.getAttribute("doingTag");	
	String doneTag = (String)request.getAttribute("doneTag");
%>


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="style.css" type="text/css">
	</head>
	<body>
		<hedaer>
		  <div class="newTodo">
			  <a href="TodoFormServlet">새로운 TODO 등록</a>
		  </div>
		</hedaer>
		<section>
		  <div class="panel" id="todo">	
		  </div>
		  <script type="text/javascript">
		 		document.querySelector('#todo').innerHTML = '<%=todoTag%>';
		  </script>
		  <div class="panel" id="doing">
			<script type="text/javascript">
		 		document.querySelector('#doing').innerHTML = '<%=doingTag%>';
		 	</script>
		  </div>
		  <div class="panel" id="done">
		  <script type="text/javascript">
		 		document.querySelector('#done').innerHTML = '<%=doneTag%>';
		 	</script>
		  </div>
		</section>
	</body>
</html>





