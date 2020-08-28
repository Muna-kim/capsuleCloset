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
	.small-box>img{
	border:1px solid white;
	width: 178px;
	height:198px;
	float:none;
	}
	.small-box2{
	border:1px solid white;
	width: 178px;
	height:60px;
	float:none;
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
</style>
 My Closet
		<div class="after">
		 	<div class="bigBox">
			 		<c:forEach var="tmp" items="${closetVo}">
				 		<div class=small-box>
				 			<img src="">
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