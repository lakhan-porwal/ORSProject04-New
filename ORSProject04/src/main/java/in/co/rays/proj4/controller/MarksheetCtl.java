package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.model.MarksheetModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("/MarksheetCtl")
public class MarksheetCtl extends BaseCtl<MarksheetBean, MarksheetModel> {

	@Override
	public void preload() {
		super.preload();
	}

	@Override
	public boolean validate(HttpServletRequest request) {
		return super.validate(request);
	}

	@Override
	public MarksheetBean populateBean(HttpServletRequest request) {
		return super.populateBean(request);
	}

	@Override
	protected String getView() {
		return ORSView.MARKSHEET_VIEW;
	}

	@Override
	protected MarksheetModel getModel() {
		return new MarksheetModel();
	}

}
