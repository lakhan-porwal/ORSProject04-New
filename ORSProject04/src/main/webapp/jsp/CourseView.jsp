<!DOCTYPE html>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1>Add Course</h1>
		<h3 style="color:red"><%=ServletUtility.getErrorMessage(request) %></h3>
		<h3 style="color:green"><%=ServletUtility.getSuccessMessage(request)%></h3>

		<form action="<%=ORSView.COURSE_CTL%>" method="post">

			<table>

				<tr>
					<th>Name<span style="color: red">*</span></th>
					<td><input type="text" name="name" value=""
						placeholder="enter course name "></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></td>
				</tr>

				<tr>
					<th>Description<span style="color: red">*</span></th>
					<td><input type="text" name="description" value=""
						placeholder="enter course description"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("description", request)%></td>
				</tr>

				<tr>
					<th>Duration<span style="color: red">*</span></th>
					<td><input type="text" name="duration" value=""
						placeholder="enter course duration"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("duration", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=CourseCtl.OP_SAVE%>"></td>
				</tr>

			</table>

		</form>

	</div>

</body>
</html>