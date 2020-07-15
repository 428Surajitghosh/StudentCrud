<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.wipro.student.main.*" import="com.wipro.student.bean.*" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Student- Status</title>
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
			<th>RollNo</th>
			<th>Student Name</th>
			<th>Standard</th>
			<th>Date of Birth</th> 
			<th>Fees</th>
		</tr>
		<tr>
	`	<%
			StudentApp sa=new StudentApp();
			int r=Integer.parseInt(request.getParameter("roll"));
			ArrayList<StudentBean> ar=new ArrayList<StudentBean>();
			ar=sa.viewstu(r);
		%>
		<td>
			<%
				int r1=ar.get(0).getRoll();
				out.println(""+r1);
			%>			
		</td>
		<td>
			<%
				String n=ar.get(0).getName();
				out.println(""+n);
			%>
		</td>
		<td>
			<%
				String s=ar.get(0).getStd();
				out.println(""+s);
			%>
		</td>
		<td>
			<%
				String d=ar.get(0).getDob();
				out.println(""+d);
			%>
		</td>
		<td>
			<%
				double f=ar.get(0).getFees();
				out.println(""+f);
			%>
		</td>
		</tr>
		</table>
	</main>
	<aside>
		<h2>Menu</h2>
		<ul>
			<li><a href="Menu.html">Home</a></li>
			<li><a href="insstudent.html">Insert Student</a></li>
			<li><a href="updstudent.html">Update Student</a></li>
			<li><a href="delstudent.html">Delete Student</a></li>
			<li><a href="viewstu.html"  class="active">View a Student</a></li>
			<li><a href="viewall.jsp">View All Students</a></li>
		</ul>		
	</aside>
</body>
</html>