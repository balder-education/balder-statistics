package br.com.baldereducation.baldersatistics.model.domain;

public enum GenderType {
	MALE("M"), FEMALE("F");

	private String genderType;

	private GenderType(String genderType) {
		this.genderType = genderType;
	}

	public String getGenderType() {
		return genderType;
	}

	public void setGenderType(String genderType) {
		this.genderType = genderType;
	}

}
