package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.model.RoleModel;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/RoleCtl")
public class RoleCtl extends BaseCtl<RoleBean, RoleModel> {

	@Override
	public void preload() {
		super.preload();
	}

	@Override
	public boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			pass = false;
			request.setAttribute("name", "role name is required");
		}
		if (DataValidator.isNull(request.getParameter("description"))) {
			pass = false;
			request.setAttribute("description", "description is required");
		}

		return pass;
	}

	@Override
	public RoleBean populateBean(HttpServletRequest request) {

		RoleBean bean = new RoleBean();

		bean.setName(request.getParameter("name"));
		bean.setDescription(request.getParameter("description"));

		return bean;
	}

	@Override
	protected String getView() {

		return ORSView.ROLE_VIEW;
	}

	@Override
	protected RoleModel getModel() {

		return new RoleModel();
	}

}
