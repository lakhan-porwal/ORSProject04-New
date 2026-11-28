package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.model.MarksheetModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/MarksheetListCtl")
public class MarksheetListCtl extends BaseListCtl<MarksheetBean, MarksheetModel> {

	@Override
	public MarksheetBean populateBean(HttpServletRequest request) {

		MarksheetBean bean = new MarksheetBean();

		bean.setRollNo(request.getParameter("rollNo"));
		bean.setStudentId(Long.parseLong(request.getParameter("studentId")));
		bean.setName(request.getParameter("name"));
		bean.setPhysics(Integer.parseInt(request.getParameter("physics")));
		bean.setChemistry(Integer.parseInt(request.getParameter("chemistry")));
		bean.setMaths(Integer.parseInt(request.getParameter("maths")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.MARKSHEET_LIST_VIEW;
	}

	@Override
	protected MarksheetModel getModel() {
		return new MarksheetModel();
	}

}
