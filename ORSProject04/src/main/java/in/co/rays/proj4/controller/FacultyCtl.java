package in.co.rays.proj4.controller;

import java.sql.Date;

import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.model.FacultyModel;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/FacultyCtl")
public class FacultyCtl extends BaseCtl<FacultyBean, FacultyModel> {

	@Override
	public void preload() {
		super.preload();
	}

	@Override
	public boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("collegeId"))) {
			pass = false;
			request.setAttribute("collegeId", "College is required");
		}

		if (DataValidator.isNull(request.getParameter("firstName"))) {
			pass = false;
			request.setAttribute("firstName", "First Name is required");
		}

		if (DataValidator.isNull(request.getParameter("lastName"))) {
			pass = false;
			request.setAttribute("lastName", "Last Name is required");
		}

		if (DataValidator.isNull(request.getParameter("email"))) {
			pass = false;
			request.setAttribute("email", "Email is required");
		}

		if (DataValidator.isNull(request.getParameter("mobileNo"))) {
			pass = false;
			request.setAttribute("mobileNo", "Mobile No is required");
		}

		if (DataValidator.isNull(request.getParameter("address"))) {
			pass = false;
			request.setAttribute("address", "Address is required");
		}

		if (DataValidator.isNull(request.getParameter("gender"))) {
			pass = false;
			request.setAttribute("gender", "Gender is required");
		}

		if (DataValidator.isNull(request.getParameter("dob"))) {
			pass = false;
			request.setAttribute("dob", "DOB is required");
		}

		return pass;
	}

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
		return ORSView.FACULTY_VIEW;
	}

	@Override
	protected FacultyModel getModel() {
		return new FacultyModel();
	}

}
