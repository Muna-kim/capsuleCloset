<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Today's clothes</title>
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
	border: 1px solid white;
	width:281px;
	height:40px;
	margin-top:320px;
	margin-left:1px;

	}
	.coordinate{
		border:1px solid lightgray;
		width: 286px;
		height: 410px;
		margin-right:3px;
		margin-bottom: 3px;
		float:left;
		position:relative;
	}
	.coordinate:hover{
		border:2px solid lightpink;
		cursor: pointer;
	}
	.coordinate img{
		width:100%;
		height:100%;
	}
	.big-box{
	width: 900px;
	border:1px solid white;
	height:100%;
	}
	.after::after{
		clear:both;
		content:'';
		display:block;
	}
	.formClass{
		float:left;
	}
</style>
<body>
	My Today's clothes
	
	<div class="big-box after">
		<c:forEach var="tmp" items="${todaysClothesVo}">
			<c:if test="${user.id==tmp.id}">
				<form method="post" action="" class="formClass">
					<div class=coordinate>
						<input type="hidden" class="numToday" value="${tmp.numToday}" name="numToday">
						<c:forEach var="tmp2" items="${fileVo}">
							<c:if test="${tmp.todaystop==tmp2.fileTableNum}">
						 		<div class="small-box top">
						 			<input type="hidden" value="${tmp.todaystop}">
									<img src="<%=request.getContextPath()%>/resources/image${tmp2.file}">
								</div>
							 </c:if>
						 </c:forEach>
						 
						 <c:forEach var="tmp2" items="${fileVo}">
							 <c:if test="${tmp.todaysouter==tmp2.fileTableNum}">
						 		<div class="small-box outer">
						 			<input type="hidden" value="${tmp.todaysouter}">
						 			<img src="<%=request.getContextPath()%>/resources/image${tmp2.file}">
					 			</div>
					 		</c:if>
					 	</c:forEach>
					 	
					 	<c:forEach var="tmp2" items="${fileVo}">
							<c:if test="${tmp.todaysbottom==tmp2.fileTableNum}">
						 		<div class="small-box bottom">
						 			<input type="hidden" value="${tmp.todaysbottom}">
						 			<img src="<%=request.getContextPath()%>/resources/image${tmp2.file}">
					 			</div>
					 		</c:if>
						 </c:forEach>
					 			
					 	<c:forEach var="tmp2" items="${fileVo}">
							<c:if test="${tmp.todaysshoes==tmp2.fileTableNum}">
						 		<div class="small-box shoes">
						 			<input type="hidden" value="${tmp.todaysshoes}">
						 			<img src="<%=request.getContextPath()%>/resources/image${tmp2.file}">
					 			</div>
						 	 </c:if>
						 </c:forEach>
						 
				 		<div class="small-box2" style="line-height:20px;">
				 			<div>${tmp.todaysDate}</div>
				 			<div>${tmp.id}</div>
				 		</div>
				 		<button type="submit" class="btn btn-outline-secondary" type="submit">이 코디를 메인사진으로</button>
					</div>
				</form>
			</c:if>
		</c:forEach>
	 </div>
	 <div class="after"></div>
</body>

</html>