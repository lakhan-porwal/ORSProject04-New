package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.FacultyBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class FacultyModel extends BaseModel<FacultyBean> {

	@Override
	public long add(FacultyBean bean)
			throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		long pk = 0;

		FacultyBean existBean = findByEmail(bean.getEmail());

		if (existBean != null) {
			throw new DuplicateRecordException("Faculty already exists");
		}

		CollegeModel cmodel = new CollegeModel();
		CollegeBean cbean = cmodel.findByPK(bean.getCollegeId());

		if (cbean == null) {
			throw new ApplicationException("College does not exist");
		}

		bean.setCollegeName(cbean.getName());

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			pk = nextPK();

			pstmt = conn.prepareStatement(
					"INSERT INTO ST_FACULTY "
					+ "(ID, COLLEGE_ID, COLLEGE_NAME, FIRST_NAME, LAST_NAME, EMAIL, "
					+ "MOBILE_NO, ADDRESS, GENDER, DATE_OF_BIRTH, CREATED_BY, "
					+ "MODIFIED_BY, CREATED_DATETIME, MODIFIED_DATETIME) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			pstmt.setLong(1, pk);
			pstmt.setLong(2, bean.getCollegeId());
			pstmt.setString(3, bean.getCollegeName());
			pstmt.setString(4, bean.getFirstName());
			pstmt.setString(5, bean.getLastName());
			pstmt.setString(6, bean.getEmail());
			pstmt.setString(7, bean.getMobileNo());
			pstmt.setString(8, bean.getAddress());
			pstmt.setString(9, bean.getGender());
			pstmt.setDate(10, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(11, bean.getCreatedBy());
			pstmt.setString(12, bean.getModifiedBy());
			pstmt.setTimestamp(13, bean.getCreatedDateTime());
			pstmt.setTimestamp(14, bean.getModifiedDateTime());

			pstmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException ex) {
				throw new ApplicationException(
						"Faculty add rollback exception: " + ex.getMessage());
			}

			throw new ApplicationException(
					"Exception in adding Faculty: " + e.getMessage());

		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			JDBCDataSource.closeConnection(conn);
		}

		return pk;
	}

	@Override
	public void update(FacultyBean bean)
			throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		FacultyBean existBean = findByEmail(bean.getEmail());

		if (existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException("Faculty already exists");
		}

		CollegeModel cmodel = new CollegeModel();
		CollegeBean cbean = cmodel.findByPK(bean.getCollegeId());

		if (cbean == null) {
			throw new ApplicationException("College does not exist");
		}

		bean.setCollegeName(cbean.getName());

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(
					"UPDATE ST_FACULTY SET COLLEGE_ID=?, COLLEGE_NAME=?, "
					+ "FIRST_NAME=?, LAST_NAME=?, EMAIL=?, MOBILE_NO=?, "
					+ "ADDRESS=?, GENDER=?, DATE_OF_BIRTH=?, "
					+ "MODIFIED_BY=?, MODIFIED_DATETIME=? WHERE ID=?");

			pstmt.setLong(1, bean.getCollegeId());
			pstmt.setString(2, bean.getCollegeName());
			pstmt.setString(3, bean.getFirstName());
			pstmt.setString(4, bean.getLastName());
			pstmt.setString(5, bean.getEmail());
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setString(7, bean.getAddress());
			pstmt.setString(8, bean.getGender());
			pstmt.setDate(9, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(10, bean.getModifiedBy());
			pstmt.setTimestamp(11, bean.getModifiedDateTime());
			pstmt.setLong(12, bean.getId());

			pstmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException ex) {
				throw new ApplicationException(
						"Faculty update rollback exception: " + ex.getMessage());
			}

			throw new ApplicationException(
					"Exception in updating Faculty: " + e.getMessage());

		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			JDBCDataSource.closeConnection(conn);
		}
	}

	public FacultyBean findByEmail(String email)
			throws ApplicationException {
		return findByUniqueColumn("EMAIL", email);
	}

	@Override
	public String getWhereClause(FacultyBean bean) {

		StringBuffer sql = new StringBuffer();

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" AND ID = " + bean.getId());
			}

			if (bean.getCollegeId() > 0) {
				sql.append(" AND COLLEGE_ID = " + bean.getCollegeId());
			}

			if (bean.getCollegeName() != null && bean.getCollegeName().length() > 0) {
				sql.append(" AND COLLEGE_NAME LIKE '" + bean.getCollegeName() + "%'");
			}

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" AND FIRST_NAME LIKE '" + bean.getFirstName() + "%'");
			}

			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" AND LAST_NAME LIKE '" + bean.getLastName() + "%'");
			}

			if (bean.getEmail() != null && bean.getEmail().length() > 0) {
				sql.append(" AND EMAIL LIKE '" + bean.getEmail() + "%'");
			}

			if (bean.getMobileNo() != null && bean.getMobileNo().length() > 0) {
				sql.append(" AND MOBILE_NO LIKE '" + bean.getMobileNo() + "%'");
			}

			if (bean.getAddress() != null && bean.getAddress().length() > 0) {
				sql.append(" AND ADDRESS LIKE '" + bean.getAddress() + "%'");
			}

			if (bean.getGender() != null && bean.getGender().length() > 0) {
				sql.append(" AND GENDER = '" + bean.getGender() + "'");
			}
		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_faculty";
	}

	@Override
	public FacultyBean getBean() {
		return new FacultyBean();
	}
}
