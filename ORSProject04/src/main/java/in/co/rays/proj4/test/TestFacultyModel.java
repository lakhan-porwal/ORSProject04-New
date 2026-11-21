package in.co.rays.proj4.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.model.FacultyModel;

public class TestFacultyModel {

	public static FacultyModel model = new FacultyModel();

	public static void main(String[] args) {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testSearch();
	}

	private static void testAdd() {

		FacultyBean bean = new FacultyBean();

		bean.setCollegeId(1);
		bean.setFirstName("Rahul");
		bean.setLastName("Sharma");
		bean.setEmail("rahul@gmail.com");
		bean.setMobileNo("9876543210");
		bean.setAddress("Indore");
		bean.setGender("Male");
		bean.setDob(new Date(System.currentTimeMillis()));

		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		bean.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));

		try {
			long pk = model.add(bean);
			System.out.println("Faculty added successfully. ID = " + pk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testUpdate() {

		FacultyBean bean = new FacultyBean();

		bean.setId(1);
		bean.setCollegeId(1);
		bean.setFirstName("Amit");
		bean.setLastName("Verma");
		bean.setEmail("amit@gmail.com");
		bean.setMobileNo("9876543211");
		bean.setAddress("Bhopal");
		bean.setGender("Male");
		bean.setDob(new Date(System.currentTimeMillis()));

		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		bean.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));

		try {
			model.update(bean);
			System.out.println("Faculty updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testDelete() {

		try {
			model.delete(1);
			System.out.println("Faculty deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testFindByPk() {

		FacultyBean bean = model.findByPK(1);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getEmail());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getAddress());
			System.out.println(bean.getGender());
			System.out.println(bean.getDob());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDateTime());
			System.out.println(bean.getModifiedDateTime());

		} else {
			System.out.println("Faculty record not found");
		}
	}

	private static void testSearch() {

		FacultyBean bean = new FacultyBean();

		List<FacultyBean> list = model.search(bean, 1, 5);

		Iterator<FacultyBean> it = list.iterator();

		while (it.hasNext()) {

			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getEmail());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getAddress());
			System.out.println(bean.getGender());
			System.out.println(bean.getDob());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDateTime());
			System.out.println(bean.getModifiedDateTime());

			System.out.println("--------------------------------------");
		}
	}
}
