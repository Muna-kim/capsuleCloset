<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Others Closet</title>
</head>
<body>
<style>
	*{
	padding:0;
	margin:0;
	text-decoration: none;
    list-style: none;
    }

	.small-box{
	border:1px solid gray;
	width: 180px;
	height: 260px;
	float:left;
	margin-left:1px;
	margin-bottom:1px;
	}
	
	.small-box2{
	border:1px solid white;
	width: 178px;
	height:60px;
	margin-top:100px;
	}
	.small-box3{
	border:1px solid white;
	width: 88px;
	height:94px;
	float:left;
	display:block;
	}
	.img-box{
	margin-bottom: 5px;
	}

	.after::after{
		clear:both;
		content:'';
		display:block;

	}
	.bigBox{
		width:910px;
		height:100%;
		border: 1px solid white;
		
	}
	.small-box3 img{
		width:100%;
		height:100%;
	}
	
</style>
 My Closet
		<div class="after">
		 	<div class="bigBox">
			 		<c:forEach var="tmp" items="${closetVo}">
				 		<div class="small-box">
				 			<div class="img-box">
					 			<div class="small-box3 top">
					 				<a href="<%=request.getContextPath()%>/myCloset3?closetNum=${tmp.closetNum}">
					 				<c:forEach var="tmp2" items="${mainPhotoVoList}">
						 				<c:if test="${tmp.id==tmp2.id}">
						 					<c:forEach var="tmp3" items="${fileList}">
								 				<c:if test="${tmp2.mainTop==tmp3.fileTableNum}">
									 					<img src="<%=request.getContextPath()%>/resources/image${tmp3.file}">
								 				</c:if>
							 				</c:forEach>
						 				</c:if>
					 				</c:forEach>
					 				</a>
					 			</div>
					 			<div class="small-box3 outer">
					 				<a href="<%=request.getContextPath()%>/myCloset3?closetNum=${tmp.closetNum}">
						 				<c:forEach var="tmp2" items="${mainPhotoVoList}">
							 				<c:if test="${tmp.id==tmp2.id}">
							 					<c:forEach var="tmp3" items="${fileList}">
									 				<c:if test="${tmp2.mainOuter==tmp3.fileTableNum}">
										 					<img src="<%=request.getContextPath()%>/resources/image${tmp3.file}">
									 				</c:if>
								 				</c:forEach>
							 				</c:if>
						 				</c:forEach>
					 				</a>
					 			</div>
					 			<div class="after">
					 			</div>
					 			<div class="small-box3 bottom">
					 				<a href="<%=request.getContextPath()%>/myCloset3?closetNum=${tmp.closetNum}">
						 				<c:forEach var="tmp2" items="${mainPhotoVoList}">
							 				<c:if test="${tmp.id==tmp2.id}">
							 					<c:forEach var="tmp3" items="${fileList}">
									 				<c:if test="${tmp2.mainBottom==tmp3.fileTableNum}">
										 					<img src="<%=request.getContextPath()%>/resources/image${tmp3.file}">
									 				</c:if>
								 				</c:forEach>
							 				</c:if>
						 				</c:forEach>
					 				</a>
					 			</div>
					 			<div class="small-box3 shoes">
					 				<a href="<%=request.getContextPath()%>/myCloset3?closetNum=${tmp.closetNum}">
						 				<c:forEach var="tmp2" items="${mainPhotoVoList}">
							 				<c:if test="${tmp.id==tmp2.id}">
							 					<c:forEach var="tmp3" items="${fileList}">
									 				<c:if test="${tmp2.mainShoes==tmp3.fileTableNum}">
										 					<img src="<%=request.getContextPath()%>/resources/image${tmp3.file}">
									 				</c:if>
								 				</c:forEach>
							 				</c:if>
						 				</c:forEach>
					 				</a>
					 			</div>
				 			</div>
				 			
						 		<div class=small-box2 style="line-height:20px;">
						 			<a href="<%=request.getContextPath()%>/myCloset3?closetNum=${tmp.closetNum}" style="font-size:18px; font-weight:bold; color:black;"> ${tmp.title}</a>
						 			<div style="color:black; font-size:18px;"> ID: ${tmp.id} (목표:${tmp.setGoal})</div>
						 			<div style="font-size:15px; color:gray;"> ${tmp.registerdate}</div>
						 		</div>
				 		</div>
			 		</c:forEach>
		 	</div>
		</div>
</body>
</html>