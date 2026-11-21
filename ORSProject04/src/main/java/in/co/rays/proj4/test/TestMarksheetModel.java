package in.co.rays.proj4.test;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.model.MarksheetModel;

public class TestMarksheetModel {

	public static MarksheetModel model = new MarksheetModel();

	public static void main(String[] args) {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testSearch();
	}

	private static void testAdd() {

		MarksheetBean bean = new MarksheetBean();

		bean.setRollNo("101");
		bean.setStudentId(1);
		bean.setPhysics(80);
		bean.setChemistry(75);
		bean.setMaths(90);

		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		bean.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));

		try {
			long pk = model.add(bean);
			System.out.println("Marksheet added successfully. ID = " + pk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testUpdate() {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(1);
		bean.setRollNo("101");
		bean.setStudentId(1);
		bean.setPhysics(85);
		bean.setChemistry(80);
		bean.setMaths(95);

		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		bean.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));

		try {
			model.update(bean);
			System.out.println("Marksheet updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testDelete() {

		try {
			model.delete(1);
			System.out.println("Marksheet deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testFindByPk() {

		MarksheetBean bean = model.findByPK(1);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getStudentId());
			System.out.println(bean.getName());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDateTime());
			System.out.println(bean.getModifiedDateTime());

		} else {
			System.out.println("Marksheet record not found");
		}
	}

	private static void testSearch() {

		MarksheetBean bean = new MarksheetBean();

		List<MarksheetBean> list = model.search(bean, 1, 5);

		Iterator<MarksheetBean> it = list.iterator();

		while (it.hasNext()) {

			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getStudentId());
			System.out.println(bean.getName());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDateTime());
			System.out.println(bean.getModifiedDateTime());

			System.out.println("--------------------------------------");
		}
	}
}
