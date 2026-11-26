<!DOCTYPE html>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.controller.CollegeCtl"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<div align="center">
		<h1>Add College</h1>

		<h3 style="color: red"><%=ServletUtility.getErrorMessage(request)%></h3>
		<h3 style="color: green"><%=ServletUtility.getSuccessMessage(request)%></h3>



		<form action="<%=ORSView.COLLEGE_CTL%>" method="post">

			<table>

				<tr>
					<th>Name <span style="color: red">*</span></th>
					<td><input type="text" name="name" value=""
						placeholder="enter college name"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></td>
				</tr>

				<tr>

					<th>address<span style="color: red">*</span></th>
					<td><input type="text" name="address" value=""
						placeholder="enter college address"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("address", request)%></td>

				</tr>

				<tr>

					<th>State<span style="color: red">*</span></th>
					<td><input type="text" name="state" value=""
						placeholder="enter college state"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("state", request)%></td>

				</tr>

				<tr>

					<th>City<span style="color: red">*</span></th>
					<td><input type="text" name="city" value=""
						placeholder="enter college city"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("city", request)%></td>

				</tr>

				<tr>

					<th>PhoneNo<span style="color: red">*</span></th>
					<td><input type="text" name="phoneNo" value=""
						placeholder="enter college PhoneNo"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("phoneNo", request)%></td>

				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=CollegeCtl.OP_SAVE%>"></td>
				</tr>


			</table>

		</form>

	</div>

</body>
</html>