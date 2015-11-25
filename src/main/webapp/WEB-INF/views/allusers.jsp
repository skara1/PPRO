<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Všichni uživatelé</title>
</head>


<body>
	<h2>Všichni uživatelé</h2>	
	<table>
		<tr>
			<td>Jmeno</td>
			<td>Prijmeni</td>
			<td>Narozeniny</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
			<td>${user.birthDate}</td>
			
			
			<td><a href="<c:url value='/users/edit-${user.id}-user' />">E</a></td>
			
			<td><a href="<c:url value='/users/delete-${user.id}-user' />">D</a></td>
			
			</tr> 
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/users/new' />">Add New</a>
</body>
</html>