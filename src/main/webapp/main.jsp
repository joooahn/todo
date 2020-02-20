<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		  <div class="panel">
		    <div class="type">
		       TODO
		    </div>
			  <c:forEach items="${todo}" var="item">
					${item }
				</c:forEach>
		  </div>
		  <div class="panel">
		    <div class="type">
		      DOING
		    </div>
		    <div class="item">
		      <div id="title">자바스크립트</div>
		      <div id="info">등록날짜</div>
		    </div>
		    <div class="item">
		      <div id="title">자바스크립트</div>
		      <div id="info">등록날짜</div>
		    </div>
		  </div>
		  <div class="panel">
		    <div class="type">
		      DONE
		    </div>
		    <div class="item">
		      <div id="title">자바스크립트</div>
		      <div id="info">등록날짜</div>
		    </div>
		    <div class="item">
		      <div id="title">자바스크립트</div>
		      <div id="info">등록날짜</div>
		    </div>
		  </div>
		</section>
	</body>
</html>





