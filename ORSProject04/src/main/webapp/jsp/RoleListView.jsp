<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.bean.RoleBean"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	List<RoleBean> list = ServletUtility.getList(request);
	int pageNo = ServletUtility.getPageNo(request);
	int pageSize = ServletUtility.getPageSize(request);
	int index = (pageNo - 1) * pageSize + 1;
	Iterator<RoleBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>


	<div align="center">

		<form action="<%=ORSView.ROLE_LIST_CTL%>" method="post">
			<input type="hidden" name="pageNo" value="<%=pageNo%>">

			<table>
				<tr>
					<th>Name</th>
					<td><input type="text" name="name" value=""
						placeholder="search by role name"></td>
					<th>Description</th>
					<td><input type="text" name="description" value=""
						placeholder="search by role description "></td>

					<td><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_SEARCH%>"></td>
				</tr>
			</table>

			<table width="100%" border="1px">

				<tr>

					<th>S No.</th>
					<th>Name</th>
					<th>Description</th>

				</tr>

				<%
				while (it.hasNext()) {
					RoleBean bean = it.next();
				%>

				<tr align="center">
					<td><%=index++%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getDescription()%></td>

				</tr>
				<%
				}
				%>

			</table>

		</form>

	</div>

</body>
</html>