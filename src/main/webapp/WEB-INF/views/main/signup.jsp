<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form method="post" action="<%=request.getContextPath()%>/signup">
	<div class="form-group">
	  <label for="id">ID :</label>
	  <div>
	  
	  <input type="text" class="form-control" id="id" name="id">
	  </div>
	</div>
	
	<div class="form-group">
	  <label for="pw">PASSWORD :</label>
	  <input type="password" class="form-control" id="pw" name="pw">
	</div>
	<div class="form-group">
	  <label for="pw2">PASSWORD check :</label>
	  <input type="password" class="form-control" id="pw2" name="pw2">
	</div>
	<div class="form-group">
	  <label for="gender">GENDER:</label>
	  <select class="form-control" id="gender" name="gender">
	    <option>MALE</option>
	    <option>FEMALE</option>
	  </select>
	</div>
	<div class="form-group">
	  <label for="name">NAME :</label>
	  <input type="text" class="form-control" id="name" name="name">
	</div>	
	<div class="form-group">
	  <label for="phoneNum">PHONE NUM:</label>
	  <input type="text" class="form-control" id="phoneNum" name="phoneNum">
	</div>
	<div class="form-group">
	  <label for="email">EMAIL :</label>
	  <input type="email" class="form-control" id="email" name="email">
	</div>
	<button type="submit" class="btn btn-outline-secondary">submit</button>
</form>
