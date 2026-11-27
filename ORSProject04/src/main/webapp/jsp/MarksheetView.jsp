<%@page import="in.co.rays.proj4.util.ServletUtility"%>
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
		<h1>Add Marksheet</h1>
		<h3 style="color: red"><%=ServletUtility.getErrorMessage(request)%></h3>
		<h3 style="color: green"><%=ServletUtility.getSuccessMessage(request)%></h3>

		<form action="<%=ORSView.MARKSHEET_CTL%>" method="post">

			<table>

				<th>RollNo<span style="color: red">*</span></th>
				<td><input type="number" name="rollNo" value=""
					placeholder="enter Marksheet RollNo"></td>
				<td style="color: red"><%=ServletUtility.getErrorMessage("rollNo", request)%></td>

				</tr>

				<tr>

					<th>StudentId<span style="color: red">*</span></th>
					<td><input type="text" name="studentId" value=""
						placeholder="enter Marksheet studentId"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("studentId", request)%></td>

				</tr>

				<tr>

					<th>Name<span style="color: red">*</span></th>
					<td><input type="text" name="name" value=""
						placeholder="enter Marksheet name"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></td>

				</tr>

				<tr>

					<th>Physics<span style="color: red">*</span></th>
					<td><input type="number" name="physics" value=""
						placeholder="enter physics marks"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("physics", request)%></td>

				</tr>

				<tr>

					<th>Chemistry<span style="color: red">*</span></th>
					<td><input type="number" name="chemistry" value=""
						placeholder="enter chemistry marks"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("chemistry", request)%></td>

				</tr>

				<tr>

					<th>Maths<span style="color: red">*</span></th>
					<td><input type="number" name="maths" value=""
						placeholder="enter Maths marks"></td>
					<td style="color: red"><%=ServletUtility.getErrorMessage("maths", request)%></td>

				</tr>

				<tr>

					<th></th>
					<td><input type="submit" name="operation"
						value="<%=MarksheetCtl.OP_SAVE%>"></td>

				</tr>

			</table>

		</form>

	</div>

</body>
</html>