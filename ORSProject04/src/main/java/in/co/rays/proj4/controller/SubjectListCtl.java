package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.model.SubjectModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/SubjectListCtl")
public class SubjectListCtl extends BaseListCtl<SubjectBean, SubjectModel> {

	@Override
	public SubjectBean populateBean(HttpServletRequest request) {
		return super.populateBean(request);
	}

	@Override
	protected String getView() {
		return ORSView.SUBJECT_LIST_VIEW;
	}

	@Override
	protected SubjectModel getModel() {
		return new SubjectModel();
	}

}
