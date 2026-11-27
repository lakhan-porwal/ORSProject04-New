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
		<h1>Add Student</h1>
		<h3 style="color: red"><%=ServletUtility.getErrorMessage(request)%></h3>
		<h3 style="color: green"><%=ServletUtility.getSuccessMessage(request)%></h3>


		<form action="<%=ORSView.STUDENT_CTL%>" method="post">

			<table>

				<tr>
					<th>FirstName<span style="color: red">*</span></th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter student firstName"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("firstName", request)%></td>
				</tr>

				<tr>
					<th>LastName<span style="color: red">*</span></th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter student lastName"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("lastName", request)%></td>
				</tr>

				<tr>
					<th>DOB<span style="color: red">*</span></th>
					<td><input type="date" name="dob" value=""
						placeholder="enter student dob"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("dob", request)%></td>
				</tr>

				<tr>
					<th>MobileNo<span style="color: red">*</span></th>
					<td><input type="number" name="mobileNo" value=""
						placeholder="enter student mobileNo"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("mobileNo", request)%></td>
				</tr>

				<tr>
					<th>Email<span style="color: red">*</span></th>
					<td><input type="email" name="email" value=""
						placeholder="enter student email"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></td>
				</tr>

				<tr>
					<th>CollegeId<span style="color: red">*</span></th>
					<td><input type="text" name="collegeId" value=""
						placeholder="enter student collegeId"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("collegeId", request)%></td>
				</tr>

				<tr>
					<th>CollegeName<span style="color: red">*</span></th>
					<td><input type="text" name="collegeName" value=""
						placeholder="enter student collegeName"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("collegeName", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=StudentCtl.OP_SAVE%>"></td>
				</tr>


			</table>

		</form>

	</div>


</body>
</html>