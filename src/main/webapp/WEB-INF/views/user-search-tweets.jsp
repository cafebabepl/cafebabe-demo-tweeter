<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Wyszukiwanie tweetów</title>
</head>
<body>
	<!-- formularz wyszukiwania -->
	<center>
	<form action="<c:url value="/user/search-tweets" />" method="post">
		<input type="text" name="title" /><br />
		<button type="submit">Szukaj</button>
	</form>
	</center>
	
	<!-- wyniki wyszukiwania -->
	<c:forEach items="${tweets}" var="tweet">
		<p>
			<i><c:out value="${tweet.title}" /></i><br />
			<c:out value="${tweet.text}" />
		</p>
	</c:forEach>
</body>
</html>