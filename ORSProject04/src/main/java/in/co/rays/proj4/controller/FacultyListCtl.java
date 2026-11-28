package in.co.rays.proj4.controller;

import java.sql.Date;

import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.model.FacultyModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/FacultyListCtl")
public class FacultyListCtl extends BaseListCtl<FacultyBean, FacultyModel> {

	@Override
	public FacultyBean populateBean(HttpServletRequest request) {

		FacultyBean bean = new FacultyBean();

		bean.setCollegeId(Long.parseLong(request.getParameter("collegeId")));
		bean.setFirstName(request.getParameter("firstName"));
		bean.setLastName(request.getParameter("lastName"));
		bean.setEmail(request.getParameter("email"));
		bean.setMobileNo(request.getParameter("mobileNo"));
		bean.setAddress(request.getParameter("address"));
		bean.setGender(request.getParameter("gender"));
		bean.setDob(Date.valueOf(request.getParameter("dob")));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.FACULTY_LIST_VIEW;
	}

	protected FacultyModel getModel() {
		return new FacultyModel();
	}

}
