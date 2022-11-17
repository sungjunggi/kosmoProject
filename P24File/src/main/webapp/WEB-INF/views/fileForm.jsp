<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FileUpload</title>
</head>
<body>
	<form action="uploading" method="post" enctype="multipart/form-data">
		파일: <input type = "file" name = "filename"><br/>
		<input type="submit" value="업로드">
	</form>
</body>
</html>