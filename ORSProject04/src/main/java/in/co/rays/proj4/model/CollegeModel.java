package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class CollegeModel extends BaseModel<CollegeBean> {

	@Override
	public long add(CollegeBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		long pk = 0;

		CollegeBean existBean = findByName(bean.getName());

		if (existBean != null) {
			throw new DuplicateRecordException("College already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			pk = nextPK();

			pstmt = conn.prepareStatement("INSERT INTO ST_COLLEGE "
					+ "(ID, NAME, ADDRESS, STATE, CITY, PHONE_NO, CREATED_BY, MODIFIED_BY, CREATED_DATETIME, MODIFIED_DATETIME) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getState());
			pstmt.setString(5, bean.getCity());
			pstmt.setString(6, bean.getPhoneNo());
			pstmt.setString(7, bean.getCreatedBy());
			pstmt.setString(8, bean.getModifiedBy());
			pstmt.setTimestamp(9, bean.getCreatedDateTime());
			pstmt.setTimestamp(10, bean.getModifiedDateTime());

			pstmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException ex) {
				throw new ApplicationException("College add rollback exception: " + ex.getMessage());
			}

			throw new ApplicationException("Exception in adding College: " + e.getMessage());

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
	public void update(CollegeBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		CollegeBean existBean = findByName(bean.getName());

		if (existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException("College already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement("UPDATE ST_COLLEGE SET NAME=?, ADDRESS=?, STATE=?, CITY=?, "
					+ "PHONE_NO=?, MODIFIED_BY=?, MODIFIED_DATETIME=? WHERE ID=?");

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getAddress());
			pstmt.setString(3, bean.getState());
			pstmt.setString(4, bean.getCity());
			pstmt.setString(5, bean.getPhoneNo());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getModifiedDateTime());
			pstmt.setLong(8, bean.getId());

			pstmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException ex) {
				throw new ApplicationException("College update rollback exception: " + ex.getMessage());
			}

			throw new ApplicationException("Exception in updating College: " + e.getMessage());

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

	public CollegeBean findByName(String name) throws ApplicationException {
		return findByUniqueColumn("NAME", name);
	}

	@Override
	public String getTable() {
		return "st_college";
	}

	@Override
	public CollegeBean getBean() {
		return new CollegeBean();
	}

	@Override
	public String getWhereClause(CollegeBean bean) {

		StringBuffer sql = new StringBuffer();

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" AND ID = " + bean.getId());
			}

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" AND NAME LIKE '" + bean.getName() + "%'");
			}

			if (bean.getAddress() != null && bean.getAddress().length() > 0) {
				sql.append(" AND ADDRESS LIKE '" + bean.getAddress() + "%'");
			}

			if (bean.getState() != null && bean.getState().length() > 0) {
				sql.append(" AND STATE LIKE '" + bean.getState() + "%'");
			}

			if (bean.getCity() != null && bean.getCity().length() > 0) {
				sql.append(" AND CITY LIKE '" + bean.getCity() + "%'");
			}

			if (bean.getPhoneNo() != null && bean.getPhoneNo().length() > 0) {
				sql.append(" AND PHONE_NO LIKE '" + bean.getPhoneNo() + "%'");
			}
		}

		return sql.toString();
	}
}
