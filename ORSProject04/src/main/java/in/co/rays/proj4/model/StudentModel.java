
package in.co.rays.proj4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.proj4.bean.CollegeBean;
import in.co.rays.proj4.bean.StudentBean;
import in.co.rays.proj4.exception.ApplicationException;
import in.co.rays.proj4.exception.DuplicateRecordException;
import in.co.rays.proj4.util.JDBCDataSource;

public class StudentModel extends BaseModel<StudentBean> {

    @Override
    public long add(StudentBean bean)
            throws ApplicationException, DuplicateRecordException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        long pk = 0;

        StudentBean existBean = findByEmailId(bean.getEmail());

        if (existBean != null) {
            throw new DuplicateRecordException("Student already exists");
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

            String sql = "INSERT INTO ST_STUDENT "
                    + "(ID, COLLEGE_ID, COLLEGE_NAME, FIRST_NAME, LAST_NAME, "
                    + "DATE_OF_BIRTH, MOBILE_NO, EMAIL, CREATED_BY, MODIFIED_BY, "
                    + "CREATED_DATETIME, MODIFIED_DATETIME) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, pk);
            pstmt.setLong(2, bean.getCollegeId());
            pstmt.setString(3, bean.getCollegeName());
            pstmt.setString(4, bean.getFirstName());
            pstmt.setString(5, bean.getLastName());
            pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
            pstmt.setString(7, bean.getMobileNo());
            pstmt.setString(8, bean.getEmail());
            pstmt.setString(9, bean.getCreatedBy());
            pstmt.setString(10, bean.getModifiedBy());
            pstmt.setTimestamp(11, bean.getCreatedDateTime());
            pstmt.setTimestamp(12, bean.getModifiedDateTime());

            pstmt.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                throw new ApplicationException(
                        "Student add rollback exception: " + ex.getMessage());
            }

            throw new ApplicationException(
                    "Exception in adding Student: " + e.getMessage());

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
    public void update(StudentBean bean)
            throws ApplicationException, DuplicateRecordException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        StudentBean existBean = findByEmailId(bean.getEmail());

        if (existBean != null && existBean.getId() != bean.getId()) {
            throw new DuplicateRecordException("Student already exists");
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

            String sql = "UPDATE ST_STUDENT SET "
                    + "COLLEGE_ID=?, COLLEGE_NAME=?, FIRST_NAME=?, LAST_NAME=?, "
                    + "DATE_OF_BIRTH=?, MOBILE_NO=?, EMAIL=?, "
                    + "MODIFIED_BY=?, MODIFIED_DATETIME=? WHERE ID=?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, bean.getCollegeId());
            pstmt.setString(2, bean.getCollegeName());
            pstmt.setString(3, bean.getFirstName());
            pstmt.setString(4, bean.getLastName());
            pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
            pstmt.setString(6, bean.getMobileNo());
            pstmt.setString(7, bean.getEmail());
            pstmt.setString(8, bean.getModifiedBy());
            pstmt.setTimestamp(9, bean.getModifiedDateTime());
            pstmt.setLong(10, bean.getId());

            pstmt.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                throw new ApplicationException(
                        "Student update rollback exception: " + ex.getMessage());
            }

            throw new ApplicationException(
                    "Exception in updating Student: " + e.getMessage());

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

    public StudentBean findByEmailId(String email)
            throws ApplicationException {
        return findByUniqueColumn("EMAIL", email);
    }

    @Override
    public String getWhereClause(StudentBean bean) {

        StringBuffer sql = new StringBuffer();

        if (bean != null) {

            if (bean.getId() > 0) {
                sql.append(" AND ID = " + bean.getId());
            }

            if (bean.getCollegeId() > 0) {
                sql.append(" AND COLLEGE_ID = " + bean.getCollegeId());
            }

            if (bean.getCollegeName() != null
                    && bean.getCollegeName().length() > 0) {
                sql.append(" AND COLLEGE_NAME LIKE '"
                        + bean.getCollegeName() + "%'");
            }

            if (bean.getFirstName() != null
                    && bean.getFirstName().length() > 0) {
                sql.append(" AND FIRST_NAME LIKE '"
                        + bean.getFirstName() + "%'");
            }

            if (bean.getLastName() != null
                    && bean.getLastName().length() > 0) {
                sql.append(" AND LAST_NAME LIKE '"
                        + bean.getLastName() + "%'");
            }

            if (bean.getMobileNo() != null
                    && bean.getMobileNo().length() > 0) {
                sql.append(" AND MOBILE_NO LIKE '"
                        + bean.getMobileNo() + "%'");
            }

            if (bean.getEmail() != null
                    && bean.getEmail().length() > 0) {
                sql.append(" AND EMAIL LIKE '"
                        + bean.getEmail() + "%'");
            }
        }

        return sql.toString();
    }

    @Override
    public String getTable() {
        return "st_student";
    }

    @Override
    public StudentBean getBean() {
        return new StudentBean();
    }
}
