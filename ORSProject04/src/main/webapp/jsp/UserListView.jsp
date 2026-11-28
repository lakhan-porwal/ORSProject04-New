<!DOCTYPE html>
<%@page import="in.co.rays.proj4.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	List<UserBean> list = ServletUtility.getList(request);
	int pageNo = ServletUtility.getPageNo(request);
	int pageSize = ServletUtility.getPageSize(request);
	int index = (pageNo - 1) * pageSize + 1;
	Iterator<UserBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>


	<div align="center">

		<form action="<%=ORSView.USER_LIST_CTL%>" method="post">
			<input type="hidden" name="pageNo" value="<%=pageNo%>">

			<table>
				<tr>
					<th>Name</th>
					<td><input type="text" name="firstName" value=""
						placeholder="search by user name"></td>
					<th>Login</th>
					<td><input type="email" name="login" value=""
						placeholder="search by user login "></td>

					<td><input type="submit" name="operation"
						value="<%=UserListCtl.OP_SEARCH%>"></td>
				</tr>
			</table>

			<table width="100%" border="1px">

				<tr>

					<th>S No.</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login Id</th>
					<th>MobileNo</th>
					<th>Gender</th>
					<th>DOB</th>

				</tr>

				<%
				while (it.hasNext()) {
					UserBean bean = it.next();
				%>

				<tr align="center">
					<td><%=index++%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getMobileNo()%></td>
					<td><%=bean.getGender()%></td>
					<td><%=bean.getDob()%></td>

				</tr>
				<%
				}
				%>

			</table>

		</form>

	</div>

</body>
</html>