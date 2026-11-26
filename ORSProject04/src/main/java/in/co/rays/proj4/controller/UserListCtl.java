package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/UserListCtl")
public class UserListCtl extends BaseListCtl<UserBean, UserModel> {

	@Override
	public UserBean populateBean(HttpServletRequest request) {
		return super.populateBean(request);
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
