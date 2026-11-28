package in.co.rays.proj4.controller;

import java.sql.Date;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.model.StudentModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/StudentListCtl")
public class StudentListCtl extends BaseListCtl<StudentBean, StudentModel> {

	@Override
	public StudentBean populateBean(HttpServletRequest request) {

		StudentBean bean = new StudentBean();

		bean.setFirstName(request.getParameter("firstName"));
		bean.setLastName(request.getParameter("lastName"));
		bean.setDob(Date.valueOf(request.getParameter("dob")));
		bean.setMobileNo(request.getParameter("mobileNo"));
		bean.setEmail(request.getParameter("email"));
		bean.setCollegeId(Long.parseLong(request.getParameter("collegeId")));
		bean.setCollegeName(request.getParameter("collegeName"));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.STUDENT_LIST_VIEW;
	}

	@Override
	protected StudentModel getModel() {
		return new StudentModel();
	}

}
