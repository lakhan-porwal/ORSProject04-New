package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.model.CollegeModel;
import in.co.rays.proj4.util.DataValidator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/CollegeCtl")
public class CollegeCtl extends BaseCtl<CollegeBean, CollegeModel> {

	@Override
	public void preload() {
		super.preload();
	}

	@Override
	public boolean validate(HttpServletRequest request) {

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			pass = false;
			request.setAttribute("name", "name is required");
		}
		if (DataValidator.isNull(request.getParameter("address"))) {
			pass = false;
			request.setAttribute("address", "address is required");
		}
		if (DataValidator.isNull(request.getParameter("state"))) {
			pass = false;
			request.setAttribute("state", "state is required");
		}
		if (DataValidator.isNull(request.getParameter("city"))) {
			pass = false;
			request.setAttribute("city", "city is required");
		}
		if (DataValidator.isNull(request.getParameter("phoneNo"))) {
			pass = false;
			request.setAttribute("phoneNo", "phoneNo is required");
		}

		return pass;
	}

	@Override
	public CollegeBean populateBean(HttpServletRequest request) {

		CollegeBean bean = new CollegeBean();

		bean.setName(request.getParameter("name"));
		bean.setAddress(request.getParameter("address"));
		bean.setState(request.getParameter("state"));
		bean.setCity(request.getParameter("city"));
		bean.setPhoneNo(request.getParameter("phoneNo"));

		return bean;
	}

	@Override
	protected String getView() {
		return ORSView.COLLEGE_VIEW;
	}

	@Override
	protected CollegeModel getModel() {
		return new CollegeModel();
	}

}
