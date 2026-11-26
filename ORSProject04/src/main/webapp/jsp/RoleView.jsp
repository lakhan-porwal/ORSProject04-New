<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.RoleCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1>Add Role</h1>
		<h3 style="color: red"><%=ServletUtility.getErrorMessage(request)%></h3>
		<h3 style="color: green"><%=ServletUtility.getSuccessMessage(request)%></h3>
		<form action="<%=ORSView.ROLE_CTL%>" method="post">

			<table>

				<tr>
					<th>Name<span style="color: red">*</span></th>
					<td><input type="text" name="name" value=""
						placeholder="enter role name "></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></td>
				</tr>

				<tr>
					<th>Description<span style="color: red">*</span></th>
					<td><input type="text" name="description" value=""
						placeholder="enter role description"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("description", request)%></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=RoleCtl.OP_SAVE%>"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>