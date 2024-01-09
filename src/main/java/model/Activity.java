package model;

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

    // Constructors, getters, and setters

    public Activity() {
    }

    public Activity(int id, String activityName, String activityDate, String activityLocation) {
        this.id = id;
        this.activityName = activityName;
        this.activityDate = activityDate;
        this.activityLocation = activityLocation;
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
