package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.model.SubjectModel;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/SubjectCtl")
public class SubjectCtl extends BaseCtl<SubjectBean, SubjectModel> {

	@Override
	public void preload() {
		super.preload();
	}

	@Override
	public boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			pass = false;
			request.setAttribute("name", "name is required");
		}

		if (DataValidator.isNull(request.getParameter("description"))) {
			pass = false;
			request.setAttribute("description", "description is required");
		}

		if (DataValidator.isNull(request.getParameter("courseId"))) {
			pass = false;
			request.setAttribute("courseId", "courseId is required");
		}

		return pass;
	}

	@Override
	public SubjectBean populateBean(HttpServletRequest request) {

		SubjectBean bean = new SubjectBean();

		bean.setName(request.getParameter("name"));
		bean.setDescription(request.getParameter("description"));
		bean.setCourseId(Long.parseLong(request.getParameter("courseId")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.SUBJECT_VIEW;
	}

	@Override
	protected SubjectModel getModel() {
		return new SubjectModel();
	}

}
