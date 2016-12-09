<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try {
	FileInputStream fstream = new FileInputStream(application.getRealPath("/WEB-INF/swagger.json"));
	out.println("/WEB-INF/swagger.json" + fstream);

} catch (Exception e1){
	out.println("Error1 : " + e1.getMessage());
	try {
	FileInputStream fstream = new FileInputStream(application.getRealPath("swagger.json"));
	out.println("/swagger.json" + fstream);
	} catch (Exception e2){
		out.println("Error2 : " + e2.getMessage());
	}

}
 %>

</body>
</html>