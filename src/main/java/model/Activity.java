package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import org.omg.CORBA.portable.InputStream;

import com.mysql.cj.jdbc.Blob;

public class Activity {
	@Override
	public String toString() {
		return "Activity [id=" + id + ", activityName=" + activityName + ", activityDate=" + activityDate
				+ ", activityLocation=" + activityLocation + "]";
	}

	private int id;
	private String activityName;
	private String activityDate;
	private String activityLocation;

	public Blob getActivityFile() {
		return activity_file;
	}

	public void setActivityFile(Blob activity_file) {
		this.activity_file = activity_file;
	}

	private Blob activity_file;

	// Constructors, getters, and setters

	public Activity() {
	}

	public Activity(int id, String activityName, String activityDate, String activityLocation, Blob activity_file)
			throws SQLException {
		this.id = id;
		this.activityName = activityName;
		this.activityDate = activityDate;
		this.activityLocation = activityLocation;
		this.activity_file = activity_file;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}

	public String getActivityLocation() {
		return activityLocation;
	}

	public void setActivityLocation(String activityLocation) {
		this.activityLocation = activityLocation;
	}
}
