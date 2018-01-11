<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Dodaj tweeta</title>
</head>
<body>
	<c:url value="/tweet/save" var="action" />
	<form:form method="post" modelAttribute="tweet" action="${action}">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><form:label path="user">Użytkownik</form:label></td>
				<td><form:select path="user.id" items="${users}" itemValue="id" itemLabel="lastName"></form:select></td>
				<td></td>
			</tr>
			<tr>
				<td><form:label path="title">Tytuł</form:label></td>
				<td><form:input path="title" title="Tytuł" /></td>
				<td><form:errors path="title" /></td>
			</tr>
			<tr>
				<td><form:label path="text">Treść</form:label></td>
				<td><form:input path="text" title="Treść" /></td>
				<td><form:errors path="text" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Zapisz" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>