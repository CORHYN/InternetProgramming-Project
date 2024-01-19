package model;

public class CheckBoxForm {
	private String email;
	private String[] selectedValues;

	public CheckBoxForm() {
	}

	public String[] getSelectedValues() {
		return selectedValues;
	}

	public void setSelectedValues(String[] selectedValues) {
		this.selectedValues = selectedValues;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

