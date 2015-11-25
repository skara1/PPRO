<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pridano</title>
</head>
<body>
	zprava pro vas, sire: ${success}
	<br/>
	<br/>
	vrat se, blbe <a href="<c:url value='/users/list' />"> zpatky k mame</a>
	<p>Bako kare cuca so kames gadzas flika</p>
	
</body>

</html>