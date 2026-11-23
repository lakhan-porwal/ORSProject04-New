
package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.proj4.bean.RoleBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class RoleModel extends BaseModel<RoleBean> {

    public long add(RoleBean bean)
            throws ApplicationException, DuplicateRecordException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        long pk = 0;
        
        RoleBean existBean = findByName(bean.getName());
        
        if(existBean != null) {
        	throw new DuplicateRecordException("Role name already exist");
        }

        try {
            conn = JDBCDataSource.getConnection();

            pk = nextPK();

            pstmt = conn.prepareStatement(
                "INSERT INTO ST_ROLE "
                + "(ID, NAME, DESCRIPTION, CREATED_BY, MODIFIED_BY, CREATED_DATETIME, MODIFIED_DATETIME) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)");

            pstmt.setLong(1, pk);
            pstmt.setString(2, bean.getName());
            pstmt.setString(3, bean.getDescription());
            pstmt.setString(4, bean.getCreatedBy());
            pstmt.setString(5, bean.getModifiedBy());
            pstmt.setTimestamp(6, bean.getCreatedDateTime());
            pstmt.setTimestamp(7, bean.getModifiedDateTime());

            pstmt.executeUpdate();

        } catch (Exception e) {
            throw new ApplicationException("Exception in adding Role: " + e.getMessage());
        } finally {
            JDBCDataSource.closeConnection(conn);
        }

        return pk;
    }

    public void update(RoleBean bean)
            throws ApplicationException, DuplicateRecordException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        RoleBean existBean = findByName(bean.getName());

        if (existBean != null && existBean.getId() != bean.getId()) {
            throw new DuplicateRecordException("Role already exists");
        }

        try {
            conn = JDBCDataSource.getConnection();

            pstmt = conn.prepareStatement(
                "UPDATE ST_ROLE SET NAME=?, DESCRIPTION=?, "
                + "MODIFIED_BY=?, MODIFIED_DATETIME=? WHERE ID=?");

            pstmt.setString(1, bean.getName());
            pstmt.setString(2, bean.getDescription());
            pstmt.setString(3, bean.getModifiedBy());
            pstmt.setTimestamp(4, bean.getModifiedDateTime());
            pstmt.setLong(5, bean.getId());

            pstmt.executeUpdate();

        } catch (Exception e) {
            throw new ApplicationException("Exception in updating Role: " + e.getMessage());
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
    }

    public RoleBean findByName(String name) {
        return findByUniqueColumn("NAME", name);
    }

    @Override
    public String getWhereClause(RoleBean bean) {

        StringBuffer sql = new StringBuffer();

        if (bean.getId() > 0) {
            sql.append(" AND ID = " + bean.getId());
        }

        if (bean.getName() != null && bean.getName().length() > 0) {
            sql.append(" AND NAME LIKE '" + bean.getName() + "%'");
        }

        if (bean.getDescription() != null && bean.getDescription().length() > 0) {
            sql.append(" AND DESCRIPTION LIKE '" + bean.getDescription() + "%'");
        }

        return sql.toString();
    }

    @Override
    public String getTable() {
        return "ST_ROLE";
    }

    @Override
    public RoleBean getBean() {
        return new RoleBean();
    }
}
