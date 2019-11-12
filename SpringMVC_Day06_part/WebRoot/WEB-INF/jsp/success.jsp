<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:url var="base" value="/"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<link rel="stylesheet" type="text/css" href="${base}style.css">
</head>
<body>
	<h6>${user.name} 登录成功！</h6>
</body>
</html>