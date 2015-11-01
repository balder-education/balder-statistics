package br.com.balder.baldersatistics.model.domain;

import br.com.baldereducation.baldersatistics.model.domain.to.StundentDTO;

/**
 * @author Rogério Fontes
 */
public class StudentDTOBuilder {

    private String id;
    private String name;
    private String email = "NOT_IMPORTANT";

    public StudentDTOBuilder() {

    }

    public StudentDTOBuilder name(String name) {
        this.name = name;
        return this;
    }

    public StudentDTOBuilder id(String id) {
        this.id = id;
        return this;
    }

    public StudentDTOBuilder emal(String email) {
        this.email = email;
        return this;
    }

    public StundentDTO build() {
        StundentDTO dto = new StundentDTO();

        dto.setName(name);
        dto.setId(id);
        dto.setEmail(email);

        return dto;
    }
}
