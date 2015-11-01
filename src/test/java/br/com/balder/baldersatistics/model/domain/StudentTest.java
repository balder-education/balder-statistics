package br.com.balder.baldersatistics.model.domain;

import org.junit.Test;

import br.com.balder.baldersatistics.util.StringTestUtil;
import br.com.baldereducation.baldersatistics.model.domain.Student;

/**
 * @author Rogério Fontes
 */
public class StudentTest {

    private static final String EMAIL = "email";
    private static final String NAME = "name";

    private static final int MAX_LENGTH_NAME = 120;
    private static final int MAX_LENGTH_EMAIL = 100;

    private static final String UPDATED_DESCRIPTION = "updatedDescription";
    private static final String UPDATED_TITLE = "updatedTitle";

    @Test(expected = NullPointerException.class)
    public void build_NameAndEmailIsNull_ShouldThrowException() {
        // Student.getBuilder().nameAndEmail(null,
        // null).description(DESCRIPTION).build();
     //   Student.getBuilder().nameAndEmail(null, null).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void build_TitleIsEmpty_ShouldThrowException() {
        // Student.getBuilder().title("").description(DESCRIPTION).build();
      //  Student.getBuilder().nameAndEmail("", "").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void build_TitleIsTooLong_ShouldThrowException() {
        String tooLongName = StringTestUtil.createStringWithLength(MAX_LENGTH_NAME + 1);
        String tooLongEmail = StringTestUtil.createStringWithLength(MAX_LENGTH_EMAIL + 1);
        // Student.getBuilder().title(tooLongTitle).description(DESCRIPTION).build();
      //  Student.getBuilder().nameAndEmail(tooLongName, tooLongEmail).build();
    }

    /*
     * @Test public void
     * build_WithoutDescription_ShouldCreateNewTodoEntryWithCorrectTitle() {
     * Student build = Student.getBuilder().title(TITLE).build();
     * 
     * StudentAssert.assertThatTodo(build).hasNoId().hasTitle(TITLE).
     * hasNoDescription(); }
     * 
     * @Test public void
     * build_WithTitleAndDescription_ShouldCreateNewTodoEntryWithCorrectTitleAndDescription
     * () { Student build =
     * Student.getBuilder().title(TITLE).description(DESCRIPTION).build();
     * 
     * StudentAssert.assertThatTodo(build).hasNoId().hasTitle(TITLE).
     * hasDescription(DESCRIPTION); }
     * 
     * @Test public void
     * build_WithMaxLengthTitleAndDescription_ShouldCreateNewTodoEntryWithCorrectTitleAndDescription
     * () { String maxLengthTitle =
     * StringTestUtil.createStringWithLength(MAX_LENGTH_TITLE); String
     * maxLengthDescription =
     * StringTestUtil.createStringWithLength(MAX_LENGTH_DESCRIPTION);
     * 
     * Student build = Student.getBuilder().title(maxLengthTitle).description(
     * maxLengthDescription).build();
     * 
     * StudentAssert.assertThatTodo(build).hasNoId().hasTitle(maxLengthTitle).
     * hasDescription(maxLengthDescription); }
     * 
     * @Test(expected = NullPointerException.class) public void
     * update_TitleIsNull_ShouldThrowException() { Student updated =
     * Student.getBuilder().title(TITLE).description(DESCRIPTION).build();
     * 
     * updated.update(null, UPDATED_DESCRIPTION); }
     * 
     * @Test(expected = IllegalArgumentException.class) public void
     * update_TitleIsEmpty_ShouldThrowException() { Student updated =
     * Student.getBuilder().title(TITLE).description(DESCRIPTION).build();
     * 
     * updated.update("", UPDATED_DESCRIPTION); }
     * 
     * @Test(expected = IllegalArgumentException.class) public void
     * update_TitleIsTooLong_ShouldThrowException() { Student updated =
     * Student.getBuilder().title(TITLE).description(DESCRIPTION).build();
     * 
     * String tooLongTitle =
     * StringTestUtil.createStringWithLength(MAX_LENGTH_TITLE + 1);
     * updated.update(tooLongTitle, UPDATED_DESCRIPTION); }
     * 
     * @Test(expected = IllegalArgumentException.class) public void
     * update_DescriptionIsTooLong_ShouldThrowException() { Student updated =
     * Student.getBuilder().title(TITLE).description(DESCRIPTION).build();
     * 
     * String tooLongDescription =
     * StringTestUtil.createStringWithLength(MAX_LENGTH_DESCRIPTION + 1);
     * updated.update(UPDATED_TITLE, tooLongDescription); }
     * 
     * @Test public void
     * update_DescriptionIsNull_ShouldUpdateTitleAndDescription() { Student
     * updated =
     * Student.getBuilder().title(TITLE).description(DESCRIPTION).build();
     * 
     * updated.update(UPDATED_TITLE, null);
     * 
     * StudentAssert.assertThatTodo(updated).hasTitle(UPDATED_TITLE).
     * hasNoDescription(); }
     * 
     * @Test public void
     * update_MaxLengthTitleAndDescription_ShouldUpdateTitleAndDescription() {
     * Student updated =
     * Student.getBuilder().title(TITLE).description(DESCRIPTION).build();
     * 
     * String maxLengthTitle =
     * StringTestUtil.createStringWithLength(MAX_LENGTH_TITLE); String
     * maxLengthDescription =
     * StringTestUtil.createStringWithLength(MAX_LENGTH_DESCRIPTION);
     * 
     * updated.update(maxLengthTitle, maxLengthDescription);
     * 
     * StudentAssert.assertThatTodo(updated).hasTitle(maxLengthTitle).
     * hasDescription(maxLengthDescription); }
     */}
