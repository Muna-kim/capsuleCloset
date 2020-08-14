<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="">
	<div class="form-group">
	  <label for="id">ID :</label>
	  <input type="text" class="form-control" id="id" name="id">
	</div>
	<div class="form-group">
	  <label for="pw">PASSWORD :</label>
	  <input type="password" class="form-control" id="pw" name="pw">
	</div>
	<button type="submit" class="btn btn-outline-secondary">LOGIN</button>
</form>
${user}
</body>
</html>