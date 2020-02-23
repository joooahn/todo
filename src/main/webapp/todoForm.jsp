<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/todoFormStyle.css" type="text/css">
</head>
<body>
  <header>
    할일 등록
  </header>
  <section>
    <form action="TodoAddServlet" method="post" accept-charset="UTF-8">
    <div class="container">
      <div id="title">
        어떤일인가요<br>
        <input type="text" name="inputTitle" id="inputTitle" maxlength="24"/><br>  
      </div>
      <div id="name">
        누가 할일인가요?<br>
        <input type="text" name="inputName" id="inputName" maxlength="24"/><br>
      </div>
      <div class="radio">
        우선순위를 선택하세요<br>
        <input type="radio" name="sequence" id="d1" value="1"/> 1순위
        <input type="radio" name="sequence" id="d2" value="2"/> 2순위
        <input type="radio" name="sequence" id="d3" value="3"/> 3순위
      </div>
      <div class="buttons">
        <input type="button" id="prev"  value="< 이전" onclick="history.back()"></input>
        <input type="submit" id="submit" value="제출"></input>
        <input type="reset" id="clear" value="내용지우기"></div>
      </div>
    </div>
    </form>
  </section>
</body>
</html>