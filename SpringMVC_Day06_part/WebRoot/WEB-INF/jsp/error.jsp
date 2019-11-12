<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <c:url var="base" value="/"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
<link rel="stylesheet" type="text/css" href="${base}style.css">
</head>
<body>
	<!--异常处理  方法一： 使用SimpleMappingExceptionResolver-->
		<h6>发生了意外${message} ${exception}</h6>
</body>
</html>