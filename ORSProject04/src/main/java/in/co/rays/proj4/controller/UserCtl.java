package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("UserCtl")
public class UserCtl extends BaseCtl<UserBean, UserModel> {

	@Override
	public void preload() {
		super.preload();

	}

	@Override
	public boolean validate(HttpServletRequest request) {
		return super.validate(request);
	}

	@Override
	public UserBean populateBean(HttpServletRequest request) {
		return super.populateBean(request);
	}

	@Override
	protected String getView() {

		return ORSView.USER_CTL;
	}

	@Override
	protected UserModel getModel() {

		return new UserModel();
	}

}
