<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="StudentController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Name</th>
			 <th>Group</th>
			 <th>Turn</th>
			
		</tr>
		<c:forEach var="student" items="${students}">
		
		<tr>
			<td>
				<form action= "StudentController">
					<input type = "hidden" name = "id" value= "${student.id}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
			</td>
			<td> ${student.id}</td>
			<td> ${student.name}</td>
			<td> ${student.groupStudent}</td>
			<td> ${student.turn}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>
	<form action="StudentReport">
				
					<input type = "submit" name = "btn_reporte" value = "Reporte"/>
				</form>

</body>
</html>