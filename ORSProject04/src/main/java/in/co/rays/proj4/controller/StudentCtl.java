package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.model.StudentModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("StudentCtl")
public class StudentCtl extends BaseCtl<StudentBean, StudentModel> {

	@Override
	public void preload() {
		super.preload();
	}

	@Override
	public boolean validate(HttpServletRequest request) {
		return super.validate(request);
	}

	@Override
	public StudentBean populateBean(HttpServletRequest request) {
		return super.populateBean(request);
	}

	@Override
	protected String getView() {
		return ORSView.STUDENT_CTL;
	}

	@Override
	protected StudentModel getModel() {
		return new StudentModel();
	}

}
