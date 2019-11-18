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
<title>添加员工</title>
<script type="text/javascript" src="${base}/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${base}/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="${base}/css/bootstrap/bootstrap.min.css"/> 
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 offset-lg-5">
			
				<form action="addEmp.do" method="post" class="form-horizontal">
					<div class="form-group">
						<label for="empno">编号</label>
						<input type="text" id="empno" name="empno" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="ename">姓名</label>
						<input type="text" id="ename" name="ename" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="job">工作</label>
						<input type="text" id="job" name="job" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="mgr">上级</label>
						<input type="text" id="mgr" name="mgr" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="hiredate">入职日期</label>
						<input type="date" id="hiredate" name="hiredate" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="sal">薪水</label>
						<input type="text" id="sal" name="sal" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="comm">绩效奖金</label>
						<input type="text" id="comm" name=comm class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="deptno">部门</label>
						<input type="text" id="deptno" name="deptno" class="form-control" />
					</div>
					<input type="submit" class="form-control btn btn-primary" value="提交">
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>