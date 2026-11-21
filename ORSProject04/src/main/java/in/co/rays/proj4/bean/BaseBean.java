package in.co.rays.proj4.bean;

import java.sql.ResultSet;
import java.sql.Timestamp;

public abstract class BaseBean implements DropdownListBean {

	protected long id;
	protected String createdBy;
	protected String modifiedBy;
	protected Timestamp createdDateTime;
	protected Timestamp modifiedDateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Timestamp getModifiedDateTime() {
		return modifiedDateTime;
	}

	public void setModifiedDateTime(Timestamp modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	public void setResultSet(ResultSet rs) {
		try {
			setId(rs.getLong("ID"));
			setCreatedBy(rs.getString("CREATED_BY"));
			setModifiedBy(rs.getString("MODIFIED_BY"));
			setCreatedDateTime(rs.getTimestamp("CREATED_DATETIME"));
			setModifiedDateTime(rs.getTimestamp("MODIFIED_DATETIME"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
