package br.com.baldereducation.baldersatistics.model.domain.to;

import java.util.Date;

/**
 * This data transfer object contains the information of a single todo entry and
 * specifies validation rules that are used to ensure that only valid
 * information can be saved to the used database.
 * 
 * @author Rogério Fontes
 */
public final class ProgressionDTO {

	private String id;
	private String contentNumber;
	private int progress;
	private Date progressDate;
	private String studentCode;

	public ProgressionDTO() {

	}

	public String getId() {
		return id;
	}

	public String getContentNumber() {
		return contentNumber;
	}

	public void setContentNumber(String contentNumber) {
		this.contentNumber = contentNumber;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public Date getProgressDate() {
		return progressDate;
	}

	public void setProgressDate(Date progressDate) {
		this.progressDate = progressDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

}
