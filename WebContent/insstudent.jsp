<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.wipro.student.main.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Student-status</title>
<link rel="stylesheet" href="stylesheet/style.css">
</head>
<body>
	<header>
		<h1>ABC School</h1>
	</header>
	<main>
		<h2>Student Management System</h2>
		<table>
		<tr>
			<th>Status</th>
		</tr>
		<tr>
			<td>
				<%
					StudentApp sa=new StudentApp();
					int roll=Integer.parseInt(request.getParameter("roll"));
					String name=request.getParameter("name");
					String std=request.getParameter("std");
					String dob=request.getParameter("dob");
					double fees=Double.parseDouble(request.getParameter("fees"));
					String status=sa.insert(roll, name, std, dob, fees);
					out.println(""+status);
				%>
			</td>
		</tr>
		</table>
	</main>
	<aside>
		<h2>Menu</h2>
		<ul>
			<li><a href="Menu.html">Home</a></li>
			<li><a href="insstudent.html" class="active">Insert Student</a></li>
			<li><a href="updstudent.html">Update Student</a></li>
			<li><a href="delstudent.html">Delete Student</a></li>
			<li><a href="viewstu.html">View a Student</a></li>
			<li><a href="viewall.jsp">View All Students</a></li>
		</ul>		
	</aside>		
</body>
</html>