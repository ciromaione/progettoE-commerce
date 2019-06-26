<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
<p><%=request.getAttribute("msg") %> <a href="<%=request.getAttribute("target") %>"><%=request.getAttribute("msglink") %></a></p>
</body>
</html>