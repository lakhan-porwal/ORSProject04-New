package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;
import in.co.rays.proj4.util.DataValidator;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/UserCtl")
public class UserCtl extends BaseCtl<UserBean, UserModel> {

	@Override
	public void preload() {
		super.preload();
	}

	@Override
	public boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("firstName"))) {
			pass = false;
			request.setAttribute("firstName", "First Name is required");
		}

		if (DataValidator.isNull(request.getParameter("lastName"))) {
			pass = false;
			request.setAttribute("lastName", "Last Name is required");
		}

		if (DataValidator.isNull(request.getParameter("login"))) {
			pass = false;
			request.setAttribute("login", "Login is required");
		}

		if (DataValidator.isNull(request.getParameter("password"))) {
			pass = false;
			request.setAttribute("password", "Password is required");
		}

		if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
			pass = false;
			request.setAttribute("confirmPassword", "Confirm Password is required");
		}

		if (DataValidator.isNull(request.getParameter("dob"))) {
			pass = false;
			request.setAttribute("dob", "Date of Birth is required");
		}

		if (DataValidator.isNull(request.getParameter("mobileNo"))) {
			pass = false;
			request.setAttribute("mobileNo", "Mobile Number is required");
		}

		if (DataValidator.isNull(request.getParameter("roleId"))) {
			pass = false;
			request.setAttribute("roleId", "Role is required");
		}

		if (DataValidator.isNull(request.getParameter("gender"))) {
			pass = false;
			request.setAttribute("gender", "Gender is required");
		}

		return pass;
	}

	@Override
	public UserBean populateBean(HttpServletRequest request) {

		UserBean bean = new UserBean();

		bean.setFirstName(request.getParameter("firstName"));
		bean.setLastName(request.getParameter("lastName"));
		bean.setLogin(request.getParameter("login"));
		bean.setPassword(request.getParameter("password"));
		bean.setConfirmPassword(request.getParameter("confirmPassword"));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
		bean.setMobileNo(request.getParameter("mobileNo"));
		bean.setRoleId(DataUtility.getLong(request.getParameter("roleId")));
		bean.setGender(request.getParameter("gender"));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.USER_VIEW;
	}

	@Override
	protected UserModel getModel() {
		return new UserModel();
	}
}
