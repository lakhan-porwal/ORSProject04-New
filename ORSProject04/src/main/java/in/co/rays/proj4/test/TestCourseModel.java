package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.model.CourseModel;

public class TestCourseModel {

	public static CourseModel model = new CourseModel();

	public static void main(String[] args) {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testSearch();
	}

	private static void testAdd() {

		CourseBean bean = new CourseBean();

		bean.setName("Java");
		bean.setDescription("Java Programming");
		bean.setDuration("6 Months");

		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		bean.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));

		try {
			long pk = model.add(bean);
			System.out.println("Course added successfully. ID = " + pk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testUpdate() {

		CourseBean bean = new CourseBean();

		bean.setId(1);
		bean.setName("Advanced Java");
		bean.setDescription("Advanced Java Programming");
		bean.setDuration("8 Months");

		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		bean.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));

		try {
			model.update(bean);
			System.out.println("Course updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testDelete() {

		try {
			model.delete(1);
			System.out.println("Course deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testFindByPk() {

		CourseBean bean = model.findByPK(1);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getDuration());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDateTime());
			System.out.println(bean.getModifiedDateTime());

		} else {
			System.out.println("Course record not found");
		}
	}

	private static void testSearch() {

		CourseBean bean = new CourseBean();

		List<CourseBean> list = model.search(bean, 1, 5);

		Iterator<CourseBean> it = list.iterator();

		while (it.hasNext()) {

			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getDuration());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDateTime());
			System.out.println(bean.getModifiedDateTime());

			System.out.println("--------------------------------------");
		}
	}
}
