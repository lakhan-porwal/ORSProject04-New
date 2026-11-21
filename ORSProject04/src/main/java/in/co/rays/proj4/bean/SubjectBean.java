package in.co.rays.proj4.bean;

import java.sql.ResultSet;

public class SubjectBean extends BaseBean {

	private String name;
	private String description;
	private long courseId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	@Override
	public String getValue() {
		return name;
	}

	@Override
	public void setResultSet(ResultSet rs) {
		super.setResultSet(rs);

		try {
			setName(rs.getString("NAME"));
			setDescription(rs.getString("DESCRIPTION"));
			setCourseId(rs.getLong("COURSE_ID"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
