<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 <c:url var="base" value="/"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN FORM</title>
<link rel="stylesheet" type="text/css" href="${base}style.css">
</head>
<body>
	<h6>${message}</h6>
	<form action="${base}login/login-action1.form" method="post">
		<div>
			<h2>登录login-ation1.form</h2>
			<p><label>用户</label><input type="text" name="name"/></p>
			<p><lable>密码</lable><input type="password" name="pwd"/></p>
			<h3><input type="submit" value="登录" /></h3>
		</div>
	</form>
	
	<form action="${base}login/login-action2.form" method="post">
		<div>
			<h2>登录login-ation2.form</h2>
			<p><label>用户</label><input type="text" name="name"/></p>
			<p><lable>密码</lable><input type="password" name="pwd"/></p>
			<h3><input type="submit" value="登录" /></h3>
		</div>
	</form>
	
	<form action="${base}login/login-action3.form" method="post">
		<div>
			<h2>登录login-ation3.form</h2>
			<p><label>用户</label><input type="text" name="name"/></p>
			<p><lable>密码</lable><input type="password" name="pwd"/></p>
			<h3><input type="submit" value="登录" /></h3>
		</div>
	</form>
	
	<form action="${base}login/login-action4.form" method="post">
		<div>
			<h2>登录login-ation4.form</h2>
			<p><label>用户</label><input type="text" name="name"/></p>
			<p><lable>密码</lable><input type="password" name="pwd"/></p>
			<h3><input type="submit" value="登录" /></h3>
		</div>
	</form>
	
	<form action="${base}login/login-action5.form" method="post">
		<div>
			<h2>登录login-ation5.form</h2>
			<p><label>用户</label><input type="text" name="name"/></p>
			<p><lable>密码</lable><input type="password" name="pwd"/></p>
			<h3><input type="submit" value="登录" /></h3>
		</div>
	</form>
	
	<form action="${base}login/login-action6.form" method="post">
		<div>
			<h2>登录login-ation6.form</h2>
			<p>${next}</p>
			<p><label>用户</label><input type="text" name="name" value="${name}"/></p>
			<p><lable>密码</lable><input type="password" name="pwd"/></p>
			<h3><input type="submit" value="登录" /></h3>
		</div>
	</form>
	
</body>
</html>