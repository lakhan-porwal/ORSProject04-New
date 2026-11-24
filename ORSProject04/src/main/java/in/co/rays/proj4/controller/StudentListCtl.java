package in.co.rays.proj4.controller;

import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.model.StudentModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

@WebServlet("StudentListCtl")
public class StudentListCtl extends BaseListCtl<StudentBean, StudentModel> {

	@Override
	public StudentBean populateBean(HttpServletRequest request) {
		return super.populateBean(request);
	}

	@Override
	protected String getView() {
		return ORSView.STUDENT_LIST_CTL;
	}

	@Override
	protected StudentModel getModel() {
		return new StudentModel();
	}

}
