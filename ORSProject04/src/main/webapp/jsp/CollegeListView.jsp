<!DOCTYPE html>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.bean.CollegeBean"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	List<CollegeBean> list = ServletUtility.getList(request);
	int pageNo = ServletUtility.getPageNo(request);
	int pageSize = ServletUtility.getPageSize(request);
	int index = (pageNo - 1) * pageSize + 1;
	Iterator<CollegeBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>


	<div align="center">

		<form action="<%=ORSView.COLLEGE_LIST_CTL%>" method="post">
			<input type="hidden" name="pageNo" value="<%=pageNo%>">

			<table>
				<tr>
					<th>Name</th>
					<td><input type="text" name="name" value=""
						placeholder="search by college name"></td>
					<td><input type="submit" name="operation"
						value="<%=CollegeCtl.OP_SEARCH%>"></td>
				</tr>
			</table>

			<table width="100%" border="1px">

				<tr>

					<th>S No.</th>
					<th>Name</th>
					<th>Address</th>
					<th>State</th>
					<th>City</th>
					<th>PhoneNo</th>

				</tr>

				<%
				while (it.hasNext()) {
					CollegeBean bean = it.next();
				%>

				<tr align="center">
					<td><%=index++%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getAddress()%></td>
					<td><%=bean.getState()%></td>
					<td><%=bean.getCity()%></td>
					<td><%=bean.getPhoneNo()%></td>

				</tr>
				<%
				}
				%>

			</table>

		</form>

	</div>

</body>
</html>