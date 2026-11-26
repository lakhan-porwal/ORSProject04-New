package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.model.CourseModel;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/CourseCtl")
public class CourseCtl extends BaseCtl<CourseBean, CourseModel> {

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
		if (DataValidator.isNull(request.getParameter("duration"))) {
			pass = false;
			request.setAttribute("duration", "duration is required");
		}

		return pass;
	}

	@Override
	public CourseBean populateBean(HttpServletRequest request) {

		CourseBean bean = new CourseBean();

		bean.setName(request.getParameter("name"));
		bean.setDescription(request.getParameter("description"));
		bean.setDuration(request.getParameter("duration"));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.COURSE_VIEW;
	}

	@Override
	protected CourseModel getModel() {
		return new CourseModel();
	}

}
