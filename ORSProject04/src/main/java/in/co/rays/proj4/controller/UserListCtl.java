package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;
import in.co.rays.proj4.util.DataUtility;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/UserListCtl")
public class UserListCtl extends BaseListCtl<UserBean, UserModel> {

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
		return ORSView.USER_LIST_VIEW;
	}

	@Override
	protected UserModel getModel() {
		return new UserModel();
	}

}
