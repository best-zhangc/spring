<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传图片</title>
</head>
<body>
		${errors}
		<form action="upload.do" method="post" enctype="multipart/form-data">
			<input type="file" name="file"/>
			<input type="submit" value="提交"/>
		</form>
		<hr/>
		<form action="uploads.do" method="post" enctype="multipart/form-data">
			<input type="file" name="file" /><br>
			<input type="file" name="file" />
			<input type="submit" value="提交">
		</form>
</body>
</html>