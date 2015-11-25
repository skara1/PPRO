<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Pridani noveho uzivatele</title>
<style>
	.error { color: #ff0000; }
</style>

</head>

<body>

	<h2>Registracni formular</h2>
 
	<form:form method="POST" modelAttribute="user">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="firstName">Jmeno: </label> </td>
				<td><form:input path="firstName" id="firstName"/></td>
				<td><form:errors path="firstName" cssClass="error"/></td>
		    </tr>
		    
			<tr>
				<td><label for="lastName">Prijmeni: </label> </td>
				<td><form:input path="lastName" id="lastName"/></td>
				<td><form:errors path="lastName" cssClass="error"/></td>
		    </tr>		    
		    
	    
			<tr>
				<td><label for="birthDate">Ma narozeniny: </label> </td>
				<td><form:input path="birthDate" id="birthDate"/></td>
				<td><form:errors path="birthDate" cssClass="error"/></td>
		    </tr>

			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Updatovati"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Registrovati"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Padej zpatky, smejde <a href="<c:url value='/users/' />"> na seznam lidi</a>
</body>
</html>