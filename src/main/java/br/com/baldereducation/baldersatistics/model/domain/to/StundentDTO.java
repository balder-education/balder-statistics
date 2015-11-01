package br.com.baldereducation.baldersatistics.model.domain.to;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.baldereducation.baldersatistics.model.domain.Student;

/**
 * This data transfer object contains the information of a single todo entry and
 * specifies validation rules that are used to ensure that only valid
 * information can be saved to the used database.
 * 
 * @author Rogério Fontes
 */
public final class StundentDTO {

	private String id;

	@Size(max = Student.MAX_LENGTH_DESCRIPTION)
	private String name;

	@NotEmpty
	@Size(max = Student.MAX_LENGTH_TITLE)
	private String email;

	private String code;
	private String cpf;
	private String rg;
	private String bornDate;
	private String registerNumber;
	private String genterType;

	public StundentDTO() {

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String description) {
		this.name = description;
	}

	public void setEmail(String title) {
		this.email = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
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

	@Override
	public String toString() {
		return String.format("StundentDTO[id=%s, name=%s, email=%s, code=%s]", this.id, this.name, this.email, this.code);
	}
}
