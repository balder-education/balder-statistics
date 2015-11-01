package br.com.baldereducation.baldersatistics.model.domain;

import static br.com.baldereducation.baldersatistics.util.PreCondition.isTrue;
import static br.com.baldereducation.baldersatistics.util.PreCondition.notEmpty;
import static br.com.baldereducation.baldersatistics.util.PreCondition.notNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Rogério Fontes
 */
@Document(collection = "student")
public class Student {
	public static final int MAX_LENGTH_DESCRIPTION = 500;
	public static final int MAX_LENGTH_TITLE = 100;

	@Id
	private String id;
	@Field
	private String code;
	@Field
	private String name;
	@Field
	private String bornDate;
	@Field
	private String email;
	@Field
	private String cpf;
	@Field
	private String rg;
	@Field
	private String registerNumber;
	@Field
	private String genterType;
	@Field
	private int age;

	public Student() {
	}

	public Student(StudentBuilder builder) {
		this.name = builder.name;
		this.email = builder.email;
		this.bornDate = builder.bornDate;
		this.email = builder.email;
		this.cpf = builder.cpf;
		this.rg = builder.rg;
		this.registerNumber = builder.registerNumber;
		this.genterType = builder.genterType;
		this.code = builder.code;
		this.age = builder.age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getGenterType() {
		return genterType;
	}

	public void setGenterType(String genterType) {
		this.genterType = genterType;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format(
				"Todo[id=%s, name=%s, email=%s, bornDate=%s, cpf=%s, rg=%s, registerNumber=%s, genterType=%s, age=%]", this.id,
				this.name, this.email, this.bornDate, this.cpf, this.rg, this.registerNumber, this.genterType, this.age);
	}

	public static class StudentBuilder {
		private String name;
		private String code;
		private String email;
		private String cpf;
		private String rg;
		private String bornDate;
		private String registerNumber;
		private String genterType;
		private int age;

		public StudentBuilder(String name, String email, String code) {
			this.name = name;
			this.email = email;
			this.code = code;
		}

		public StudentBuilder personDocuments(String cpf, String rg) {
			this.cpf = cpf;
			this.rg = rg;
			return this;
		}
		
		public StudentBuilder age(int age) {
			this.age = age;
			return this;
		}

		public StudentBuilder bornDate(String bornDate) {
			this.bornDate = bornDate;
			return this;
		}

		public StudentBuilder registerNumber(String registerNumber) {
			this.registerNumber = registerNumber;
			return this;
		}

		public StudentBuilder genterType(String genterType) {
			this.genterType = genterType;
			return this;
		}

		public Student build() {
			Student build = new Student(this);
			build.checkNameAndEmail(build.getName(), build.getEmail());
			return build;
		}
	}

	private void checkNameAndEmail(String name, String email) {
		notNull(name, "Title cannot be null");
		notEmpty(email, "Title cannot be empty");
		isTrue(name.length() <= MAX_LENGTH_TITLE, "Title cannot be longer than %d characters", MAX_LENGTH_TITLE);

		if (name != null) {
			isTrue(name.length() <= MAX_LENGTH_DESCRIPTION, "Description cannot be longer than %d characters",
					MAX_LENGTH_DESCRIPTION);
		}
	}
}
