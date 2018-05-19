<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/messages_zh.js"></script>
</head>

<body>
	<div class="login-top"></div>
	<div class="login-area">
		<form id="userForm" action="${pageContext.request.contextPath}/user/toyz">
			<label> 姓&nbsp;&nbsp;名： </label> <input type="text" name="name" />
			<br>
			<label> 密&nbsp;&nbsp;码： </label> <input type="password"
				name="password" /> <input type="submit"  value="登录" />
			<br /> <b><font color="red" id="message"></font></b>
		</form>
	</div>
	<div class="login-copyright"></div>
</body>
<!-- <script type="text/javascript">
	//表单校验
	$(function() {
		$("#userForm").validate({
							rules : {
								name : "required",
								password : {required : true,minlength : 5}},
							messages : {
								name : "工号不能为空",
								password : {required : "请输入密码",minlength : "密码长度不能小于 5 个字母"
								}
							},
							submitHandler : function() {
								//提交Ajax
								 $.ajax({
											data : $("#userForm").serialize(),
											dataType : "text",
											type : "post",
											url : "${pageContext.request.contextPath}/user/login",
											success : function(rec) {
												if(rec=="0"){
													$("#message").html("用户名或密码错误");
												}else{
													location.href = "${pageContext.request.contextPath}/user/toindex"
												}	
											}
										}); 
							}
						});
	})
</script> -->
</html>
