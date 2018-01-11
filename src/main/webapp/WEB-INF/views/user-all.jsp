<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Lista wszystkich użytkowników</title>
</head>
<body>
	<h2>Użytkownicy</h2>
	<table>
		<thead>
			<tr align="center">
				<td>Imię</td>
				<td>Nazwisko</td>
				<td>Email</td>
				<td>Akcja</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value = "${user.firstName}"/></td>
					<td><c:out value = "${user.lastName}"/></td>
					<td><c:out value = "${user.email}" default="brak"/></td>
					<td>
						<a href="<c:url value="/user/${user.id}/tweets"/>">Tweety</a>
						<a href="<c:url value="/user/delete/${user.id}"/>">Usuń</a>
						<a href="<c:url value="/user/edit/${user.id}"/>">Edytuj</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>