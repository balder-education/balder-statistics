package br.com.balder.baldersatistics.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractAssert;

import br.com.baldereducation.baldersatistics.model.domain.Student;

/**
 * @author Rogério Fontes
 */
public class StudentAssert extends AbstractAssert<StudentAssert, Student> {

    private StudentAssert(Student actual) {
        super(actual, StudentAssert.class);
    }

    public static StudentAssert assertThatTodo(Student actual) {
        return new StudentAssert(actual);
    }

    public StudentAssert hasDescription(String expectedDescription) {
        isNotNull();

        String actualDescription = actual.getName();
        assertThat(actualDescription).overridingErrorMessage("Expected description to be <%s> but was <%s>",
                expectedDescription, actualDescription).isEqualTo(expectedDescription);

        return this;
    }

    public StudentAssert hasId(String expectedId) {
        isNotNull();

        String actualId = actual.getId();
        assertThat(actualId).overridingErrorMessage("Expected id to be <%s> but was <%s>", expectedId, actualId)
                .isEqualTo(expectedId);

        return this;
    }

    public StudentAssert hasNoDescription() {
        isNotNull();

        String actualDescription = actual.getName();
        assertThat(actualDescription)
                .overridingErrorMessage("Expected description to be <null> but was <%s>", actualDescription).isNull();

        return this;
    }

    public StudentAssert hasNoId() {
        isNotNull();

        String actualId = actual.getId();
        assertThat(actualId).overridingErrorMessage("Expected id to be <null> but was <%s>", actualId).isNull();

        return this;
    }

    public StudentAssert hasTitle(String expectedTitle) {
        isNotNull();

        String actualTitle = actual.getEmail();
        assertThat(actualTitle)
                .overridingErrorMessage("Expected title to be <%s> but was <%s>", expectedTitle, actualTitle)
                .isEqualTo(expectedTitle);

        return this;
    }
}
