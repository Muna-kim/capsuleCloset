<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Today's clothes</title>
</head>
<style>
	.small-box{
	border:1px solid gray;
	width: 140px;
	height: 160px;
	float:left;
	margin-left:1px;
	margin-bottom:1px;
	}
	.small-box2{
	border: 1px solid green;
	width:281px;
	height:40px;
	margin-top:320px;
	margin-left:1px;

	}
	.coordinate{
		border:1px solid lightgray;
		width: 284px;
		height: 362px;
		margin-right:3px;
		float:left;
		position:relative;
	}
	.coordinate img{
		width:100%;
		height:100%;
	}
	.big-box{
	width: 900px;
	height:100%;
	border:1px solid yellow;
	}
	.after::after{
		clear:both;
		content:'';
		display:block;
	}
</style>
<body>
	Today's clothes
	<div class=big-box>
		<c:forEach var="tmp" items="${todaysClothesVo}">
			<c:forEach var="tmp2" items="${fileVo}">
				<c:if test="${tmp.todyastop==tmp2.fileTableNum}">
					<div class=coordinate>
					 		<div class="small-box top"><input type="hidden" value="${tmp.todaystop}">
					 		</div>
					 		<div class="small-box outer"><input type="hidden" value="${tmp.todaysbottom}"></div>
					 		<div class="small-box bottom"><input type="hidden" value="${tmp.todaysouter}"></div>
					 		<div class="small-box shoes"><input type="hidden" value="${tmp.todaysshoes}"></div>
					 		<div class="small-box2" style="line-height:20px;">
					 			<div>${tmp.todaysDate}</div>
					 			<div>${tmp.id}</div>
					 		</div>
					 </div>
				 </c:if>
			 </c:forEach>
		</c:forEach>
	 </div>
	 <div class="after"></div>
</body>
</html>