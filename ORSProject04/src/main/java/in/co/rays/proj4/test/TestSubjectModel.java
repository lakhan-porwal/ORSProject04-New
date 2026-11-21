package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.model.SubjectModel;

public class TestSubjectModel {

	public static SubjectModel model = new SubjectModel();

	public static void main(String[] args) {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testSearch();

	}

	private static void testAdd() {

		SubjectBean bean = new SubjectBean();

		bean.setName("Java Programming");
		bean.setDescription("Core Java Subject");
		bean.setCourseId(1);

		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		bean.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));

		try {
			long pk = model.add(bean);
			System.out.println("Subject added successfully. ID = " + pk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testUpdate() {

		SubjectBean bean = new SubjectBean();

		bean.setId(1);
		bean.setName("Advanced Java");
		bean.setDescription("Advanced Java Programming");
		bean.setCourseId(1);

		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		bean.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));

		try {
			model.update(bean);
			System.out.println("Subject updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testDelete() {

		try {
			model.delete(1);
			System.out.println("Subject deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testFindByPk() {

		SubjectBean bean = model.findByPK(1);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDateTime());
			System.out.println(bean.getModifiedDateTime());

		} else {
			System.out.println("Subject record not found");
		}
	}

	private static void testSearch() {

		SubjectBean bean = new SubjectBean();

		List<SubjectBean> list = model.search(bean, 1, 5);

		Iterator<SubjectBean> it = list.iterator();

		while (it.hasNext()) {

			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getDescription());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDateTime());
			System.out.println(bean.getModifiedDateTime());

			System.out.println("--------------------------------------");
		}
	}
}
