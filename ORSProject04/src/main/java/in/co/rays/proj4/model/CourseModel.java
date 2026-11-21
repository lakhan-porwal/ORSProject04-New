package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.proj4.bean.CourseBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class CourseModel extends BaseModel<CourseBean> {

	@Override
	public long add(CourseBean bean)
			throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		long pk = 0;

		CourseBean existBean = findByName(bean.getName());

		if (existBean != null) {
			throw new DuplicateRecordException("Course already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			pk = nextPK();

			pstmt = conn.prepareStatement(
					"INSERT INTO ST_COURSE "
					+ "(ID, NAME, DESCRIPTION, DURATION, CREATED_BY, MODIFIED_BY, CREATED_DATETIME, MODIFIED_DATETIME) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getDuration());
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDateTime());
			pstmt.setTimestamp(8, bean.getModifiedDateTime());

			pstmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException ex) {
				throw new ApplicationException(
						"Course add rollback exception: " + ex.getMessage());
			}

			throw new ApplicationException(
					"Exception in adding Course: " + e.getMessage());

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
	public void update(CourseBean bean)
			throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		CourseBean existBean = findByName(bean.getName());

		if (existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException("Course already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(
					"UPDATE ST_COURSE SET NAME=?, DESCRIPTION=?, DURATION=?, "
					+ "MODIFIED_BY=?, MODIFIED_DATETIME=? WHERE ID=?");

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getDescription());
			pstmt.setString(3, bean.getDuration());
			pstmt.setString(4, bean.getModifiedBy());
			pstmt.setTimestamp(5, bean.getModifiedDateTime());
			pstmt.setLong(6, bean.getId());

			pstmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException ex) {
				throw new ApplicationException(
						"Course update rollback exception: " + ex.getMessage());
			}

			throw new ApplicationException(
					"Exception in updating Course: " + e.getMessage());

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

	public CourseBean findByName(String name) throws ApplicationException {
		return findByUniqueColumn("NAME", name);
	}

	@Override
	public String getWhereClause(CourseBean bean) {

		StringBuffer sql = new StringBuffer();

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" AND ID = " + bean.getId());
			}

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" AND NAME LIKE '" + bean.getName() + "%'");
			}

			if (bean.getDescription() != null && bean.getDescription().length() > 0) {
				sql.append(" AND DESCRIPTION LIKE '" + bean.getDescription() + "%'");
			}

			if (bean.getDuration() != null && bean.getDuration().length() > 0) {
				sql.append(" AND DURATION LIKE '" + bean.getDuration() + "%'");
			}
		}

		return sql.toString();
	}

	@Override
	public String getTable() {
		return "st_course";
	}

	@Override
	public CourseBean getBean() {
		return new CourseBean();
	}
}
