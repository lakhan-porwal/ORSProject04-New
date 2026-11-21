
package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.proj4.bean.MarksheetBean;
import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class MarksheetModel extends BaseModel<MarksheetBean> {

    @Override
    public long add(MarksheetBean bean)
            throws ApplicationException, DuplicateRecordException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        long pk = 0;

        MarksheetBean existBean = findByRollNo(bean.getRollNo());

        if (existBean != null) {
            throw new DuplicateRecordException("Marksheet already exists");
        }

        StudentModel smodel = new StudentModel();
        StudentBean sbean = smodel.findByPK(bean.getStudentId());

        if (sbean == null) {
            throw new ApplicationException("Student does not exist");
        }

        bean.setName(sbean.getFirstName() + " " + sbean.getLastName());

        try {
            conn = JDBCDataSource.getConnection();
            conn.setAutoCommit(false);

            pk = nextPK();

            pstmt = conn.prepareStatement(
                    "INSERT INTO ST_MARKSHEET "
                    + "(ID, ROLL_NO, STUDENT_ID, NAME, PHYSICS, CHEMISTRY, "
                    + "MATHS, CREATED_BY, MODIFIED_BY, CREATED_DATETIME, MODIFIED_DATETIME) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            pstmt.setLong(1, pk);
            pstmt.setString(2, bean.getRollNo());
            pstmt.setLong(3, bean.getStudentId());
            pstmt.setString(4, bean.getName());
            pstmt.setInt(5, bean.getPhysics());
            pstmt.setInt(6, bean.getChemistry());
            pstmt.setInt(7, bean.getMaths());
            pstmt.setString(8, bean.getCreatedBy());
            pstmt.setString(9, bean.getModifiedBy());
            pstmt.setTimestamp(10, bean.getCreatedDateTime());
            pstmt.setTimestamp(11, bean.getModifiedDateTime());

            pstmt.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                throw new ApplicationException(
                        "Marksheet add rollback exception: " + ex.getMessage());
            }

            throw new ApplicationException(
                    "Exception in adding Marksheet: " + e.getMessage());

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
    public void update(MarksheetBean bean)
            throws ApplicationException, DuplicateRecordException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        MarksheetBean existBean = findByRollNo(bean.getRollNo());

        if (existBean != null && existBean.getId() != bean.getId()) {
            throw new DuplicateRecordException("Marksheet already exists");
        }

        StudentModel smodel = new StudentModel();
        StudentBean sbean = smodel.findByPK(bean.getStudentId());
        
        if (sbean == null) {
            throw new ApplicationException("Student does not exist");
        }

        bean.setName(sbean.getFirstName() + " " + sbean.getLastName());

        try {
            conn = JDBCDataSource.getConnection();
            conn.setAutoCommit(false);

            pstmt = conn.prepareStatement(
                    "UPDATE ST_MARKSHEET SET ROLL_NO=?, STUDENT_ID=?, NAME=?, "
                    + "PHYSICS=?, CHEMISTRY=?, MATHS=?, "
                    + "MODIFIED_BY=?, MODIFIED_DATETIME=? WHERE ID=?");

            pstmt.setString(1, bean.getRollNo());
            pstmt.setLong(2, bean.getStudentId());
            pstmt.setString(3, bean.getName());
            pstmt.setInt(4, bean.getPhysics());
            pstmt.setInt(5, bean.getChemistry());
            pstmt.setInt(6, bean.getMaths());
            pstmt.setString(7, bean.getModifiedBy());
            pstmt.setTimestamp(8, bean.getModifiedDateTime());
            pstmt.setLong(9, bean.getId());

            pstmt.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                throw new ApplicationException(
                        "Marksheet update rollback exception: " + ex.getMessage());
            }

            throw new ApplicationException(
                    "Exception in updating Marksheet: " + e.getMessage());

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

    public MarksheetBean findByRollNo(String rollNo)
            throws ApplicationException {
        return findByUniqueColumn("ROLL_NO", rollNo);
    }

    @Override
    public String getTable() {
        return "st_marksheet";
    }

    @Override
    public MarksheetBean getBean() {
        return new MarksheetBean();
    }

    @Override
    public String getWhereClause(MarksheetBean bean) {

        StringBuffer sql = new StringBuffer();

        if (bean != null) {

            if (bean.getId() > 0) {
                sql.append(" AND ID = " + bean.getId());
            }

            if (bean.getRollNo() != null && bean.getRollNo().length() > 0) {
                sql.append(" AND ROLL_NO LIKE '" + bean.getRollNo() + "%'");
            }

            if (bean.getStudentId() > 0) {
                sql.append(" AND STUDENT_ID = " + bean.getStudentId());
            }

            if (bean.getName() != null && bean.getName().length() > 0) {
                sql.append(" AND NAME LIKE '" + bean.getName() + "%'");
            }
        }

        return sql.toString();
    }
}
