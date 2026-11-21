
package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.co.rays.proj4.bean.SubjectBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class SubjectModel extends BaseModel<SubjectBean> {

	@Override
	public long add(SubjectBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		long pk = nextPK();

		SubjectBean existBean = findByName(bean.getName());

		if (existBean != null) {
			throw new DuplicateRecordException("Subject already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();

			pstmt = conn.prepareStatement(
					"INSERT INTO ST_SUBJECT (ID, NAME, DESCRIPTION, COURSE_ID, CREATED_BY, MODIFIED_BY, CREATED_DATETIME, MODIFIED_DATETIME) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getDescription());
			pstmt.setLong(4, bean.getCourseId());
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDateTime());
			pstmt.setTimestamp(8, bean.getModifiedDateTime());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new ApplicationException("Exception in adding Subject: " + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk;
	}

	@Override
	public void update(SubjectBean bean) throws ApplicationException, DuplicateRecordException {

		Connection conn = null;
		PreparedStatement pstmt = null;

		SubjectBean existBean = findByName(bean.getName());

		if (existBean != null && existBean.getId() != bean.getId()) {
			throw new DuplicateRecordException("Subject already exists");
		}

		try {
			conn = JDBCDataSource.getConnection();

			pstmt = conn.prepareStatement(
					"UPDATE ST_SUBJECT SET NAME=?, DESCRIPTION=?, COURSE_ID=?, MODIFIED_BY=?, MODIFIED_DATETIME=? WHERE ID=?");

			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getDescription());
			pstmt.setLong(3, bean.getCourseId());
			pstmt.setString(4, bean.getModifiedBy());
			pstmt.setTimestamp(5, bean.getModifiedDateTime());
			pstmt.setLong(6, bean.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new ApplicationException("Exception in updating Subject: " + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public SubjectBean findByName(String name) throws ApplicationException {

		return findByUniqueColumn("NAME", name);
	}

	@Override
	public String getWhereClause(SubjectBean bean) {

		StringBuffer whereClause = new StringBuffer();

		if (bean.getId() > 0) {
			whereClause.append(" AND ID = " + bean.getId());
		}

		if (bean.getName() != null && bean.getName().length() > 0) {
			whereClause.append(" AND NAME LIKE '" + bean.getName() + "%'");
		}

		if (bean.getDescription() != null && bean.getDescription().length() > 0) {
			whereClause.append(" AND DESCRIPTION LIKE '" + bean.getDescription() + "%'");
		}

		if (bean.getCourseId() > 0) {
			whereClause.append(" AND COURSE_ID = " + bean.getCourseId());
		}

		return whereClause.toString();
	}

	@Override
	public String getTable() {
		return "ST_SUBJECT";
	}

	@Override
	public SubjectBean getBean() {
		return new SubjectBean();
	}
}
