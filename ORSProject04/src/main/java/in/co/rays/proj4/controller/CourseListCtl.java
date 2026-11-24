package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.model.CourseModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("CourseListCtl")
public class CourseListCtl extends BaseListCtl<CourseBean, CourseModel> {

	@Override
	public CourseBean populateBean(HttpServletRequest request) {
		return super.populateBean(request);
	}

	@Override
	protected String getView() {
		return ORSView.COURSE_LIST_CTL;
	}

	protected CourseModel getModel() {
		return new CourseModel();
	}

}
