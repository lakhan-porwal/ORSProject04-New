package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.model.CourseModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/CourseListCtl")
public class CourseListCtl extends BaseListCtl<CourseBean, CourseModel> {

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
		return ORSView.COURSE_LIST_VIEW;
	}

	protected CourseModel getModel() {
		return new CourseModel();
	}

}
