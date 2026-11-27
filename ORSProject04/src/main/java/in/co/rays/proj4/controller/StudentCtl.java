package in.co.rays.proj4.controller;

import java.sql.Date;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.model.StudentModel;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/StudentCtl")
public class StudentCtl extends BaseCtl<StudentBean, StudentModel> {

	@Override
	public void preload() {
		super.preload();
	}

	@Override
	public boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("firstName"))) {
			pass = false;
			request.setAttribute("firstName", "firstName is required");
		}

		if (DataValidator.isNull(request.getParameter("lastName"))) {
			pass = false;
			request.setAttribute("lastName", "lastName is required");
		}

		if (DataValidator.isNull(request.getParameter("dob"))) {
			pass = false;
			request.setAttribute("dob", "dob is required");
		}

		if (DataValidator.isNull(request.getParameter("mobileNo"))) {
			pass = false;
			request.setAttribute("mobileNo", "mobileNo is required");
		}

		if (DataValidator.isNull(request.getParameter("email"))) {
			pass = false;
			request.setAttribute("email", "email is required");
		}

		if (DataValidator.isNull(request.getParameter("collegeId"))) {
			pass = false;
			request.setAttribute("collegeId", "collegeId is required");
		}

		if (DataValidator.isNull(request.getParameter("collegeName"))) {
			pass = false;
			request.setAttribute("collegeName", "collegeName is required");
		}

		return pass;
	}

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
		return ORSView.STUDENT_VIEW;
	}

	@Override
	protected StudentModel getModel() {
		return new StudentModel();
	}

}
