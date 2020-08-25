<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Closet</title>
</head>
<body>
My Closet
	<c:if test="${user!=null}">
		<form method="post" action="" id="setForm">
			<div class="group1">
			  <label for="setGoal">목표설정하기:</label>
			  <select class="form-control" id="setGoal" name="setGoal">
			    <option>60</option>
			    <option>50</option>
			    <option>40</option>
			    <option>30</option>
			  </select>
			<button type="button" class="btn btn-outline-secondary btn-goal">next</button>
			</div>
	
			<div class="group2">
			  <label for="title">Title:</label>
			  <input type="text" class="form-control" id="title" name="title">
			  <label for="goal">Goal:</label>
			  <input type="number" class="form-control" id="goal" value="setGoal" readonly>
			  <label for="top">Top:</label>
			  <input type="number" class="form-control" id="top" name="top">
			  <label for="bottom">Bottom:</label>
			  <input type="number" class="form-control" id="bottom" name="bottom">
			  <label for="outer">Outer:</label>
			  <input type="number" class="form-control" id="outer" name="outer">
			  <label for="shoes">Shoes:</label>
			  <input type="number" class="form-control" id="shoes" name="shoes">
			  <button type="button" class="btn btn-outline-secondary btn-sum">Add All</button></br>
			  <label for="sum">Sum:</label>
			  <input type="number" class="form-control" id="sum" name="sum" readonly>
			  <button type="submit" class="btn btn-outline-secondary">next</button>
			</div>
		</form>
	</c:if>
		
		<c:if test="${user==null}">
			<div id="havetoLogin">
			로그인 정보가 없습니다.
			로그인 후에 다시 시도해 주세요.
			</div>
		</c:if>
		
		
		<script>
			$(".group2").css('display','none');
			$(".btn-goal").click(function(){
				$("#goal").val($("#setGoal").val())
				$(".group1").css('display','none');
				$(".group2").css('display','block');
				})
			$(".btn-sum").click(function(){
				var top=$("#top").val();
				var bottom=$("#bottom").val();
				var outer=$("#outer").val();
				var shoes=$("#shoes").val();
				$("#sum").val(parseInt(top)+parseInt(bottom)+parseInt(outer)+parseInt(shoes));
				})	
			$('#setForm').submit(function(){
				var goal=$("#setGoal").val();
				var sum=$("#sum").val();
				if(goal==sum){
					return true;
					}
				else{
					alert('목표로 설정한 옷의 개수와 , 입력한옷들의 합의 값이 같지 않습니다')
					return false;
					}
			})
		</script>
</body>

</html>