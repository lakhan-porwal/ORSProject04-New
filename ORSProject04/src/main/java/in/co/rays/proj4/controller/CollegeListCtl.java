package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.model.CollegeModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/CollegeListCtl")
public class CollegeListCtl extends BaseListCtl<CollegeBean, CollegeModel> {

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
		return ORSView.COLLEGE_LIST_VIEW;
	}

	@Override
	protected CollegeModel getModel() {
		return new CollegeModel();
	}

}
