<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.UserCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>

<body>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1>Add User</h1>

		<h3 style="color: red">
			<%=ServletUtility.getErrorMessage(request)%>
		</h3>

		<h3 style="color: green">
			<%=ServletUtility.getSuccessMessage(request)%>
		</h3>

		<form action="<%=ORSView.USER_CTL%>" method="post">

			<table>

				<tr>
					<th>First Name <span style="color: red">*</span></th>
					<td>
						<input type="text" name="firstName"
							placeholder="Enter first name">
					</td>
					<td style="color: red">
						<%=ServletUtility.getErrorMessage("firstName", request)%>
					</td>
				</tr>

				<tr>
					<th>Last Name <span style="color: red">*</span></th>
					<td>
						<input type="text" name="lastName"
							placeholder="Enter last name">
					</td>
					<td style="color: red">
						<%=ServletUtility.getErrorMessage("lastName", request)%>
					</td>
				</tr>

				<tr>
					<th>Login <span style="color: red">*</span></th>
					<td>
						<input type="text" name="login"
							placeholder="Enter login">
					</td>
					<td style="color: red">
						<%=ServletUtility.getErrorMessage("login", request)%>
					</td>
				</tr>

				<tr>
					<th>Password <span style="color: red">*</span></th>
					<td>
						<input type="password" name="password"
							placeholder="Enter password">
					</td>
					<td style="color: red">
						<%=ServletUtility.getErrorMessage("password", request)%>
					</td>
				</tr>

				<tr>
					<th>Confirm Password <span style="color: red">*</span></th>
					<td>
						<input type="password" name="confirmPassword"
							placeholder="Confirm password">
					</td>
					<td style="color: red">
						<%=ServletUtility.getErrorMessage("confirmPassword", request)%>
					</td>
				</tr>

				<tr>
					<th>Date of Birth <span style="color: red">*</span></th>
					<td>
						<input type="date" name="dob">
					</td>
					<td style="color: red">
						<%=ServletUtility.getErrorMessage("dob", request)%>
					</td>
				</tr>

				<tr>
					<th>Mobile Number <span style="color: red">*</span></th>
					<td>
						<input type="text" name="mobileNo"
							placeholder="Enter mobile number">
					</td>
					<td style="color: red">
						<%=ServletUtility.getErrorMessage("mobileNo", request)%>
					</td>
				</tr>

				<tr>
					<th>Role <span style="color: red">*</span></th>
					<td>
						<select name="roleId">
							<option value="">Select Role</option>
							<option value="1">Admin</option>
							<option value="2">Student</option>
							<option value="3">Faculty</option>
							<option value="4">Manager</option>
							<option value="5">Kiosk</option>
						</select>
					</td>
					<td style="color: red">
						<%=ServletUtility.getErrorMessage("roleId", request)%>
					</td>
				</tr>

				<tr>
					<th>Gender <span style="color: red">*</span></th>
					<td>
						<select name="gender">
							<option value="">Select Gender</option>
							<option value="Male">Male</option>
							<option value="Female">Female</option>
							<option value="Other">Other</option>
						</select>
					</td>
					<td style="color: red">
						<%=ServletUtility.getErrorMessage("gender", request)%>
					</td>
				</tr>

				<tr>
					<th></th>
					<td>
						<input type="submit" name="operation"
							value="<%=UserCtl.OP_SAVE%>">
					</td>
				</tr>

			</table>

		</form>

	</div>

</body>
</html>
