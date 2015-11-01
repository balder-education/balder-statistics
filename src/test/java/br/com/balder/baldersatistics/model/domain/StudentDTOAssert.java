package br.com.balder.baldersatistics.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;

import br.com.baldereducation.baldersatistics.model.domain.to.StundentDTO;

/**
 * @author Rogério Fontes
 */
public class StudentDTOAssert extends AbstractAssert<StudentDTOAssert, StundentDTO> {

    private StudentDTOAssert(StundentDTO actual) {
        super(actual, StudentDTOAssert.class);
    }

    public static StudentDTOAssert assertThatStundentDTO(StundentDTO actual) {
        return new StudentDTOAssert(actual);
    }

    public StudentDTOAssert hasDescription(String expectedDescription) {
        isNotNull();

        String actualDescription = actual.getName();
        assertThat(actualDescription).overridingErrorMessage("Expected description to be <%s> but was <%s>",
                expectedDescription, actualDescription).isEqualTo(expectedDescription);

        return this;
    }

    public StudentDTOAssert hasId(String expectedId) {
        isNotNull();

        String actualId = actual.getId();
        assertThat(actualId).overridingErrorMessage("Expected id to be <%s> but was <%s>", expectedId, actualId)
                .isEqualTo(expectedId);

        return this;
    }

    public StudentDTOAssert hasNoDescription() {
        isNotNull();

        String actualDescription = actual.getName();
        assertThat(actualDescription)
                .overridingErrorMessage("expected description to be <null> but was <%s>", actualDescription).isNull();

        return this;
    }

    public StudentDTOAssert hasNoId() {
        isNotNull();

        String actualId = actual.getId();
        assertThat(actualId).overridingErrorMessage("Expected id to be <null> but was <%s>", actualId).isNull();

        return this;
    }

    public StudentDTOAssert hasTitle(String expectedTitle) {
        isNotNull();

        String actualTitle = actual.getEmail();
        assertThat(actualTitle)
                .overridingErrorMessage("Expected title to be <%s> but was <%s>", expectedTitle, actualTitle)
                .isEqualTo(expectedTitle);

        return this;
    }
}
