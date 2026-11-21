package in.co.rays.proj4.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import in.co.rays.proj4.bean.UserBean;
import in.co.rays.proj4.model.UserModel;

public class TestUserModel {

	public static UserModel model = new UserModel();

	public static void main(String[] args) {

		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testSearch();
	}

	private static void testAdd() {

		UserBean bean = new UserBean();

		bean.setFirstName("Amit");
		bean.setLastName("Verma");
		bean.setLogin("amit123");
		bean.setPassword("12345");
		bean.setDob(new Date(System.currentTimeMillis()));
		bean.setMobileNo("9876543210");
		bean.setRoleId(2);
		bean.setUnSuccessfullLogin(0);
		bean.setGender("Male");

		bean.setLastLogin(new Timestamp(System.currentTimeMillis()));
		bean.setLock("No");
		bean.setRegisteredIP("127.0.0.1");
		bean.setLastLoginIP("127.0.0.1");

		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		bean.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));

		try {
			long pk = model.add(bean);
			System.out.println("User added successfully. ID = " + pk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testUpdate() {

		UserBean bean = new UserBean();

		bean.setId(1);
		bean.setFirstName("Rahul");
		bean.setLastName("Sharma");
		bean.setLogin("rahul123");
		bean.setPassword("12345");
		bean.setDob(new Date(System.currentTimeMillis()));
		bean.setMobileNo("9876543211");
		bean.setRoleId(2);
		bean.setUnSuccessfullLogin(0);
		bean.setGender("Male");

		bean.setLastLogin(new Timestamp(System.currentTimeMillis()));
		bean.setLock("No");
		bean.setRegisteredIP("127.0.0.1");
		bean.setLastLoginIP("127.0.0.1");

		bean.setCreatedBy("root");
		bean.setModifiedBy("root");
		bean.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		bean.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));

		try {
			model.update(bean);
			System.out.println("User updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testDelete() {

		try {
			model.delete(1);
			System.out.println("User deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testFindByPk() {

		UserBean bean = model.findByPK(1);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfullLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
			System.out.println(bean.getRegisteredIP());
			System.out.println(bean.getLastLoginIP());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDateTime());
			System.out.println(bean.getModifiedDateTime());

		} else {
			System.out.println("User record not found");
		}
	}

	private static void testSearch() {

		UserBean bean = new UserBean();

		List<UserBean> list = model.search(bean, 1, 5);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {

			bean = it.next();

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getDob());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getRoleId());
			System.out.println(bean.getUnSuccessfullLogin());
			System.out.println(bean.getGender());
			System.out.println(bean.getLastLogin());
			System.out.println(bean.getLock());
			System.out.println(bean.getRegisteredIP());
			System.out.println(bean.getLastLoginIP());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDateTime());
			System.out.println(bean.getModifiedDateTime());

			System.out.println("--------------------------------------");
		}
	}
}
