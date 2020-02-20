<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="todo.joooahn.TodoDto" %>

<%
	List<TodoDto> todo = (List<TodoDto>)request.getAttribute("todo");
	List<TodoDto> doing = (List<TodoDto>)request.getAttribute("doing");
	List<TodoDto> done = (List<TodoDto>)request.getAttribute("done");
	
	String todoTag = "<div class=\"type\">TODO</div>";
	for(int i = 0; i < todo.size(); i++)
	{
		todoTag += "<div class=\"item\">"+
			      		 "<div id=\"title\">"+todo.get(i).getTitle()+"</div>"+
		      			 "<div id=\"info\">"+
				      		 "등록날짜:"+todo.get(i).getRegDate()+", "+
				      		 todo.get(i).getName()+", "+
				      		 todo.get(i).getSequence()+
			      		 "</div>"+
	    				 "</div>"	
	    				 ;
	}
	
	String doingTag = "<div class=\"type\">DOING</div>";
	for(int i = 0; i < doing.size(); i++)
	{
		doingTag += "<div class=\"item\">"+
			      		 "<div id=\"title\">"+doing.get(i).getTitle()+"</div>"+
		      			 "<div id=\"info\">"+
				      		 "등록날짜:"+doing.get(i).getRegDate()+", "+
				      			doing.get(i).getName()+", "+
				      			doing.get(i).getSequence()+
			      		 "</div>"+
	    				 "</div>"	
	    				 ;
	}
	
	String doneTag = "<div class=\"type\">DONE</div>";
	for(int i = 0; i < done.size(); i++)
	{
		doneTag += "<div class=\"item\">"+
			      		 "<div id=\"title\">"+done.get(i).getTitle()+"</div>"+
		      			 "<div id=\"info\">"+
				      		 "등록날짜:"+done.get(i).getRegDate()+", "+
				      		 done.get(i).getName()+", "+
				   				 done.get(i).getSequence()+
			      		 "</div>"+
	    				 "</div>"	
	    				 ;
	}
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





