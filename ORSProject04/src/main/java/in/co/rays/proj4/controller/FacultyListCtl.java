package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.model.FacultyModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("FacultyListCtl")
public class FacultyListCtl extends BaseListClt<FacultyBean, FacultyModel> {

	@Override
	public FacultyBean populateBean(HttpServletRequest request) {
		return super.populateBean(request);

	}

	@Override
	protected String getView() {
		return ORSView.FACULTY_LIST_CTL;
	}

	protected FacultyModel getModel() {
		return new FacultyModel();
	}

}
