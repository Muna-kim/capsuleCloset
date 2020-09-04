<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<script src="https://kit.fontawesome.com/512fb7b03f.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	*{
	padding:0;
	margin:0;
	text-decoration: none;
    list-style: none;
    }

	.small-box{
	border:1px solid gray;
	width: 140px;
	height: 160px;
	float:left;
	margin-left:1px;
	margin-bottom:1px;
	}

	.after::after{
		clear:both;
		content:'';
		display:block;
	}
	#preview{
		width:100%;
		height:100%;
		display:block;
		max-width: 100%;
	}
	.bigBox{
		width:710px;
		
	}
	.small-box>img{
		width:100%;
		height:100%;
	}
	.file{
	display:none;
	}
	#icon-plus{
		font-size: 30px;
		margin-left: 54px;
		margin-top: 64px;
	}
	#icon-plus:hover{
		font-size: 35px;
		color: gray;
		cursor: pointer;
	}
</style>
<body>
 My Closet
 ${registerdate}
	 	<form method="post" action=""  enctype="multipart/form-data">
	 	<div class="bigBox">
		 	<div>Top</div>
		 	<div class="after">
			 	<c:forEach var="tmp" items="${fileTop}">
				 		<c:if test="${tmp.del=='N'}">
				 			<div class=small-box >
								<img src="<%=request.getContextPath()%>/resources/image${tmp.file}">
				        		<div class="preview"></div>
				 			</div>
				 		</c:if>
				 		
				 </c:forEach>
			 	
			 	<c:forEach begin="1" end="${closet.top-fileTop.size()}">
				 		<div class=small-box>
				 				<input type="file" class="file" name="file2" id="file" multiple>
				        		<div class="preview"></div>
				 				<i id="icon-plus" class="icon-plus fas fa-plus"></i>
				 		</div>
			 	</c:forEach>
			 	
		 	</div>
		 	
			
			
		 	<div>Bottom</div>
		 	<div class="after">
		 	
		 	<c:forEach var="tmp" items="${fileBottom}">
		 		<c:if test="${tmp.del=='N'}">
			 		<div class=small-box>
			 		<img src="<%=request.getContextPath()%>/resources/image${tmp.file}">
			        <div class="preview"></div></div>
			    </c:if>
			   
			</c:forEach>
			 	
		 	<c:forEach begin="1" end="${closet.bottom-fileBottom.size()}">
		 		<div class=small-box>
		 		<input type="file" class="file" name="file3" id="file" multiple>
		        <div class="preview"></div>
		 		<i id="icon-plus" class="icon-plus fas fa-plus"></i>
		 		</div>
		 	</c:forEach>
		 	</div>
		 	
		 	<div>Outer</div>
		 	<div class="after">
		 	<c:forEach var="tmp" items="${fileOuter}">
		 		<c:if test="${tmp.del=='N'}">
			 		<div class=small-box>
			 		<img src="<%=request.getContextPath()%>/resources/image${tmp.file}">
			        <div class="preview"></div>
			        </div>
			    </c:if>
			    
			    
			</c:forEach>
		 	
		 	<c:forEach begin="1" end="${closet.outer-fileOuter.size()}">
		 		<div class=small-box>
		 		<input type="file" class="file" name="file4" id="file" multiple>
		        <div class="preview"></div>
		 		<i id="icon-plus" class="icon-plus fas fa-plus"></i>
		        </div>
		 	</c:forEach>
		 	</div>
		 	
		 	<div>shoes</div>
		 	<div class="after">
		 	<c:forEach var="tmp" items="${fileShoes}">
		 		<c:if test="${tmp.del=='N'}">
			 		<div class=small-box>
			 		<img src="<%=request.getContextPath()%>/resources/image${tmp.file}">
			        <div class="preview"></div>
			        </div>
			    </c:if>
		        
			</c:forEach>
			 	
		 	<c:forEach begin="1" end="2">
		 		<div class=small-box>
		 		<input type="file" class="file" name="file5" id="file" multiple>
		        <div class="preview"></div>
		 		<i id="icon-plus" class="icon-plus fas fa-plus"></i>
		        </div>
		 	</c:forEach>
		 	</div>
		 </div>
		 	<button type="submit" class="btn btn-secondary">옷장 저장하기</button>
		 	<a href="<%=request.getContextPath()%>/myCloset3"><button type="button" class="btn btn-outline-secondary">내옷장보기</button></a>
	 </form>
 	<script type="text/javascript">
	  $(document).ready(function (e){
	    $("input[type='file']").change(function(e){
	
	      //div 내용 비워주기
	      $(this).next().empty();
	
	      var files = e.target.files;
	      var arr =Array.prototype.slice.call(files);
	      
	      //업로드 가능 파일인지 체크
	      for(var i=0;i<files.length;i++){
	        if(!checkExtension(files[i].name,files[i].size)){
	          return false;
	        }
	      }
	      preview(arr,$(this).next());
	      $(this).css('display','none')
	      if($(this).val() == ''){
		      $(this).next().next().css('display','block')
		  }else{
			    $(this).next().next().css('display','none')
		  }
		  
		      
	    });//file change
	    
	    function checkExtension(fileName,fileSize){
	
	      var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	      var maxSize = 20971520;  //20MB
	      
	      if(fileSize >= maxSize){
	        alert('파일 사이즈 초과');
	        $("input[type='file']").val("");  //파일 초기화
	        return false;
	      }
	      
	      if(regex.test(fileName)){
	        alert('업로드 불가능한 파일이 있습니다.');
	        $("input[type='file']").val("");  //파일 초기화
	        return false;
	      }
	      return true;
	    }
	    
	    function preview(arr,target){
	      arr.forEach(function(f){
	        
	        //파일명이 길면 파일명...으로 처리
	        var fileName = f.name;
	        if(fileName.length > 10){
	          fileName = fileName.substring(0,7)+"...";
	        }
	        
	        //div에 이미지 추가
	        var str = '<div style="width:100%;height:100%;display: inline-flex; padding: 0px; "><li>';
	        
	        //이미지 파일 미리보기
	        if(f.type.match('image.*')){
	          var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
	          reader.onload = function (e) { //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
	            //str += '<button type="button" class="delBtn" value="'+f.name+'" style="background: red">x</button><br>';
	            str += '<img src="'+e.target.result+'" title="'+f.name+'" width="100%" height="100%" />';
	            str += '</li></div>';
	            //$(str).appendTo('#preview');
		         target.append(str);
	          } 
	          reader.readAsDataURL(f);
	        }else{
	          str += '<img src="/resources/img/fileImg.png" title="'+f.name+'" width=100 height=100 />';
	          //$(str).appendTo(target);
	          target.append(str);

	        }
	      });//arr.forEach
	    }
	    $('.icon-plus').click(function(){
			$(this).prev().prev().click();
		})
	  });
		
		
	  
	</script>
 
</body>


</html>