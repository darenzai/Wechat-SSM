<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js">
</script>

<meta charset="Utf-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.hostelId}</td>
            <br>
               
        </tr>
    </c:forEach>	
</body>
</html>