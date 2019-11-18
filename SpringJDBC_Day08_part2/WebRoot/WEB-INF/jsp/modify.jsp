<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="base" value="/"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>员工修改</title>

<script type="text/javascript" src="${base}/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${base}/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="${base}/css/bootstrap/bootstrap.min.css"/> 


</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 offset-lg-5">
			
				<form action="update.do" method="post" class="form-horizontal">
					<input type="hidden" value="${emp.empno}" name="empno">				
					<div class="form-group">
						<label for="ename">姓名</label>
						<input type="text" class="form-control" name="ename" id="ename" value="${emp.ename}"/>
					</div>
					
					<div class="form-group">
						<label for="job">工作</label>
						<input type="text" class="form-control" name="job" id="job" value="${emp.job}"/>
					</div>
					
					<div class="form-group">
						<label for="mgr">上级</label>
						<input type="text" class="form-control" name="mgr" id="mgr" value="${emp.mgr}"/>
					</div>
					
					<div class="form-group">
						<label for="hiredate">入职日期</label>
						<input type="date" class="form-control" name="hiredate" id="hiredate" value="${emp.hiredate}"/>
					</div>
					
					<div class="form-group">
						<label for="sal">薪水</label>
						<input type="text" class="form-control" name="sal" id="sal" value="${emp.sal}"/>
					</div>
					
					<div class="form-group">
						<label for="comm">绩效奖金</label>
						<input type="text" class="form-control" name="comm" id="comm" value="${emp.comm}"/>
					</div>
					
					<div class="form-group">
						<label for="deptno">部门</label>
						<input type="text" class="form-control" name="deptno" id="deptno" value="${emp.deptno}"/>
					</div>
					<input type="submit" class="form-control btn btn-primary" value="提交">
				</form>
				
			</div>
		</div>	
	</div>
</body>
</html>