<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="todo.joooahn.TodoDto" %>
<%
	List<TodoDto> todo = (ArrayList<TodoDto>)request.getAttribute("todo");
	String doingTag = (String)request.getAttribute("doingTag");	
	String doneTag = (String)request.getAttribute("doneTag");
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/mainStyle.css" type="text/css">
	</head>
	<body>
		<hedaer>
		  <div class="newTodo">
			  <a href="TodoFormServlet">새로운 TODO 등록</a>
		  </div>
		</hedaer>
		<section>
		  <div class="panel" id="todo">
		  	<div class="type">TODO</div>	
				  <c:forEach items="${todo}" var="item">
						<div class=item id="notSet">
							<div id=title>${item.title}</div>
							<div id=info>
											${item.regDate },
							      	${item.name},
							      	우선순위 ${item.sequence }
							</div>
							<img src="img/arrow.png" alt="arrow" onclick="evt()"/>
						</div>
						<script>document.querySelector('#notSet').id="${item.id}"</script>	
					</c:forEach>
				</div>
		  <div class="panel" id="doing">
				<div class="type">DOING</div>	
					  <c:forEach items="${doing}" var="item">
							<div class=item id="notSet">
								<div id=title>${item.title}</div>
								<div id=info>
												${item.regDate },
								      	${item.name},
								      	우선순위 ${item.sequence }
								</div>
								<img src="img/arrow.png" alt="arrow" onclick="evt()"/>
							</div>	
							<script>document.querySelector('#notSet').id="${item.id}"</script>	
						</c:forEach>
					</div>
		  </div>
		  <div class="panel" id="done">
			  <div class="type">DONE</div>	
					  <c:forEach items="${done}" var="item">
							<div class=item id="notSet">
								<div id=title>${item.title}</div>
								<div id=info>
												${item.regDate },
								      	${item.name},
								      	우선순위 ${item.sequence }
								</div>
							</div>
							<script>document.querySelector('#notSet').id="${item.id}"</script>		
						</c:forEach>
					</div>
		  </div>
		</section>
		<script>
			function evt(){
				alert(event.currentTarget.parentNode.id);
			}
		</script>
	</body>
</html>





