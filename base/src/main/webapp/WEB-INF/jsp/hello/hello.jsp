<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="resources/css/bootstrap/css/bootstrap.min.css"/	>
		<script src="resources/js/jquery/jquery-1.9.1.min.js"></script>
		
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h2>hello 목록화면</h2>
		<c:forEach items="${hellos}" var="hello">
			<c:out value="${hello.korean}"/>
			<c:out value="${hello.english}"/>
		</c:forEach>
		
	</body>
</html>
