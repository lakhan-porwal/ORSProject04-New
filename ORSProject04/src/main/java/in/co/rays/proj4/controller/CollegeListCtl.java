package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.model.CollegeModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/CollegeListCtl")
public class CollegeListCtl extends BaseListCtl<CollegeBean, CollegeModel> {

	@Override
	public CollegeBean populateBean(HttpServletRequest request) {
		return super.populateBean(request);
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
