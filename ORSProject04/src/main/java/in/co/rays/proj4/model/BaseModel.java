
package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.proj4.bean.BaseBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DatabaseException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public abstract class BaseModel<T extends BaseBean> {

	public abstract long add(T bean) throws ApplicationException, DuplicateRecordException;

	public abstract void update(T bean) throws ApplicationException, DuplicateRecordException;

	public abstract String getWhereClause(T bean);

	public abstract String getTable();

	public abstract T getBean();

	public Integer nextPK() throws DatabaseException {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM " + getTable());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				pk = rs.getInt(1);
			}

			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			throw new DatabaseException("Exception : Exception in getting PK");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return pk + 1;
	}

	public void delete(int id) throws DatabaseException {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM " + getTable() + " WHERE ID = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("Record deleted: " + i);

			pstmt.close();

		} catch (SQLException e) {

			JDBCDataSource.trnRollBack(conn);

			throw new DatabaseException("Exception : Exception in DELETE RECORD");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
	}

	public T findByPK(long pk) throws ApplicationException {

		Connection conn = null;
		T bean = null;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM " + getTable() + " WHERE ID = ?");

			pstmt.setLong(1, pk);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = getBean();
				bean.setResultSet(rs);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {

			throw new ApplicationException("Exception : Exception in getting record by PK");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;
	}

	public T findByUniqueColumn(String column, String value) throws ApplicationException {

		Connection conn = null;
		T bean = null;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn
					.prepareStatement("SELECT * FROM " + getTable() + " WHERE " + column + " = ?");

			pstmt.setString(1, value);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				bean = getBean();
				bean.setResultSet(rs);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {

			throw new ApplicationException("Exception : Exception in findByUniqueColumn");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return bean;
	}

	public List<T> search(T bean, int pageNo, int pageSize) throws ApplicationException {

		ArrayList<T> list = new ArrayList<T>();

		Connection conn = null;

		StringBuffer sql = new StringBuffer("SELECT * FROM " + getTable() + " WHERE 1=1");

		sql.append(getWhereClause(bean));

		if (pageSize > 0) {
			int offset = (pageNo - 1) * pageSize;
			sql.append(" LIMIT " + offset + ", " + pageSize);
		}

		System.out.println("SQL ===> " + sql);

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				T b = getBean();
				b.setResultSet(rs);
				list.add(b);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {

			throw new ApplicationException("Exception : Exception in search");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return list;
	}

	public List<T> list(int pageNo, int pageSize) throws ApplicationException {

		ArrayList<T> list = new ArrayList<T>();

		Connection conn = null;

		StringBuffer sql = new StringBuffer("SELECT * FROM " + getTable());

		if (pageSize > 0) {
			int offset = (pageNo - 1) * pageSize;
			sql.append(" LIMIT " + offset + ", " + pageSize);
		}

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				T bean = getBean();
				bean.setResultSet(rs);
				list.add(bean);
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {

			throw new ApplicationException("Exception : Exception in getting list of records");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		return list;
	}

	public List<T> list() throws ApplicationException {

		return list(0, 0);
	}
}
