<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Zapisz użytkownika</title>
</head>
<body>
	<c:url value="/user/save" var="action" />
	<form:form method="post" modelAttribute="user" action="${action}">
		<form:hidden path="id" />
		<table>
			<tr>
				<td><form:label path="firstName">Imię</form:label></td>
				<td><form:input path="firstName" title="Imię" /></td>
				<td><form:errors path="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Nazwisko</form:label></td>
				<td><form:input path="lastName" title="Nazwisko" /></td>
				<td><form:errors path="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" title="Email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Zapisz" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>