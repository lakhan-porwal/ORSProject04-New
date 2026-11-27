package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.model.MarksheetModel;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/MarksheetCtl")
public class MarksheetCtl extends BaseCtl<MarksheetBean, MarksheetModel> {

	@Override
	public void preload() {
		super.preload();
	}

	@Override
	public boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("rollNo"))) {
			pass = false;
			request.setAttribute("rollNo", "rollNo is required");
		}
		if (DataValidator.isNull(request.getParameter("studentId"))) {
			pass = false;
			request.setAttribute("studentId", "studentId is required");
		}
		if (DataValidator.isNull(request.getParameter("name"))) {
			pass = false;
			request.setAttribute("name", "name is required");
		}
		if (DataValidator.isNull(request.getParameter("physics"))) {
			pass = false;
			request.setAttribute("physics", "physics is required");
		}
		if (DataValidator.isNull(request.getParameter("chemistry"))) {
			pass = false;
			request.setAttribute("chemistry", "chemistry is required");
		}
		if (DataValidator.isNull(request.getParameter("maths"))) {
			pass = false;
			request.setAttribute("maths", "maths is required");
		}

		return pass;
	}

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
		return ORSView.MARKSHEET_VIEW;
	}

	@Override
	protected MarksheetModel getModel() {
		return new MarksheetModel();
	}

}
