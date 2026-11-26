package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.model.SubjectModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/SubjectCtl")
public class SubjectCtl extends BaseCtl<SubjectBean, SubjectModel> {

	@Override
	public void preload() {
		super.preload();
	}

	@Override
	public boolean validate(HttpServletRequest request) {
		return super.validate(request);
	}

	@Override
	public SubjectBean populateBean(HttpServletRequest request) {
		return super.populateBean(request);
	}

	@Override
	protected String getView() {
		return ORSView.SUBJECT_VIEW;
	}

	@Override
	protected SubjectModel getModel() {
		return new SubjectModel();
	}

}
