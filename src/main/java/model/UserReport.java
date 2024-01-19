package model;

public class UserReport {
	private int id;
	private String email;
	private int electricity_consumption;
	private int water_consumption;
	private int recycle_consumption;
	public UserReport() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getElectricity_consumption() {
		return electricity_consumption;
	}
	public void setElectricity_consumption(int electricity_consumption) {
		this.electricity_consumption = electricity_consumption;
	}
	public int getWater_consumption() {
		return water_consumption;
	}
	public void setWater_consumption(int water_consumption) {
		this.water_consumption = water_consumption;
	}
	public int getRecycle_consumption() {
		return recycle_consumption;
	}
	public void setRecycle_consumption(int recycle_consumption) {
		this.recycle_consumption = recycle_consumption;
	}
	
}
