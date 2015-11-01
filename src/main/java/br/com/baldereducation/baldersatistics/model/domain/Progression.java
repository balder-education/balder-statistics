package br.com.baldereducation.baldersatistics.model.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "progression")
public class Progression {
	@Id
	private String id;
	@Field
	private String contentNumber;
	@Field
	private int progress;
	@Field
	private Date progressDate;
	@DBRef
	private Student student;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
