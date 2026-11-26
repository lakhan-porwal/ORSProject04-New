<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1>Add Faculty</h1>
		<h3 style="color: red"><%=ServletUtility.getErrorMessage(request)%></h3>
		<h3 style="color: green"><%=ServletUtility.getSuccessMessage(request)%></h3>

		<form action="<%=ORSView.FACULTY_CTL%>" method="post">

			<table>

				<tr>
					<th>College Name<span style="color: red">*</span></th>
					<td><select name="collegeId">
							<option value="">-- Select College --</option>
							<option value="1">Rays Technologies</option>
							<option value="2">IPS Academy</option>
							<option value="3">Medicaps University</option>
							<option value="4">Acropolis Institute</option>
							<option value="5">IET DAVV</option>
							<option value="6">SAGE University</option>
							<option value="7">Prestige Institute</option>
							<option value="8">Chameli Devi Group</option>
							<option value="9">Oriental University</option>
							<option value="10">Malwa Institute</option>
							<option value="11">Rays Technologies Updated</option>
					</select></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("collegeId", request)%>
					</td>
				</tr>

				<tr>

					<th>FirstName<span style="color: red">*</span></th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter Faculty firstName"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("firstName", request)%></td>

				</tr>

				<tr>

					<th>LastName<span style="color: red">*</span></th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter Faculty lastName"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("lastName", request)%></td>

				</tr>

				<tr>

					<th>Email<span style="color: red">*</span></th>
					<td><input type="email" name="email" value=""
						placeholder="enter Faculty email"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></td>

				</tr>

				<tr>

					<th>MobileNo<span style="color: red">*</span></th>
					<td><input type="text" name="mobileNo" value=""
						placeholder="enter Faculty mobileNo"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("mobileNo", request)%></td>

				</tr>

				<tr>

					<th>Address<span style="color: red">*</span></th>
					<td><input type="text" name="address" value=""
						placeholder="enter Faculty address"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("address", request)%></td>

				</tr>

				<tr>
					<th>Gender<span style="color: red">*</span></th>
					<td><select name="gender">
							<option value="">-- Select Gender --</option>
							<option value="Male">Male</option>
							<option value="Female">Female</option>
							<option value="Other">Other</option>
					</select></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("gender", request)%>
					</td>
				</tr>

				<tr>

					<th>DOB<span style="color: red">*</span></th>
					<td><input type="date" name="dob" value=""
						placeholder="enter Faculty dob"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("dob", request)%></td>

				</tr>

				<tr>

					<th></th>
					<td><input type="submit" name="operation"
						value="<%=FacultyCtl.OP_SAVE%>"></td>

				</tr>

			</table>

		</form>

	</div>

</body>
</html>